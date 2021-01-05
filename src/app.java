import figures.Circle;
import figures.Figure;
import service.Generator;
import windows.MyWindow;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class app {

    public static void main(String[] args) {
        Generator gn = new Generator();
        gn.generateFigures(10).forEach(System.out::println);
        System.out.println("end");

        MyWindow window = new MyWindow("Drawer");
        //window.setTitle("Another one");

        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(500, 500);
        window.setMinimumSize(new Dimension(150, 150));
        window.setLocationRelativeTo(null);
        window.setVisible(true);

//        window.setResizable(false);


        window.getContentPane().setBackground(Color.RED);


    }

}
