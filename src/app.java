import figures.Circle;
import figures.Figure;
import service.Generator;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class app {

    public static void main(String[] args) {
        Generator gn = new Generator();
        gn.generateFigures(15).forEach(System.out::println);
    }

}
