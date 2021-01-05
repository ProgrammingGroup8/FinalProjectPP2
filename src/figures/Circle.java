package figures;

import javax.swing.*;
import java.awt.*;

public class Circle extends JPanel implements Shape {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // draw the rectangle here
        g.drawOval(p.x,p.y,width,height);
    }
}
