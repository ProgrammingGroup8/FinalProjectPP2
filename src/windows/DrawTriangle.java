package windows;

import javax.swing.*;

import java.awt.*;

public class DrawTriangle extends JPanel
{
    Color color;
    int a,b;
    public DrawTriangle(Color color, int a, int b)
    {
        this.color = color;
        this.a =a;
        this.b=b;
    }

    public void paint(Graphics g)
    {
        super.paint(g);

        //All triangle corner x coordinate
        int[]x={(int)(Math.random()*25)+a,(int)(Math.random()*60)+a,(int)(Math.random()*40)+a};

        //All triangle corner y coordinate
        int[]y={(int)(Math.random()*20)+b,(int)(Math.random()*35)+b,(int)(Math.random()*40)+b};

        g.setColor(color);
        g.drawPolygon(x,y,3);
        //Draw triangle in JPanel
        g.fillPolygon(x,y,3);

    }



}
