import figures.Circle;
import figures.Figure;
import windows.Window;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class app {
    public static void main(String[] args) {
        Window window = new Window("Demo Java GUI");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        window.setSize(new Dimension(600, 450));
        window.setMinimumSize(new Dimension(100, 100));
        window.setLocation(new Point(450, 100));

        window.setVisible(true);

    }
}
