package service;

import figures.*;
import figures.Point;
import figures.Rectangle;
import figures.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator extends JFrame {

    public List<Shape> generateFigures(int number) {
        List<Shape> figureList = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            switch (Figure.randomFigure()) {
                case Circle:
                    figureList.add(randomCircle());
                    break;
                case Triangle:
                    figureList.add(randomTriangle());
                    break;
                case Rectangle:
                    figureList.add(randomRectangle());
                    break;
                case Ellipsis:
                    figureList.add(randomEllipsis());
                    break;

            }
        }
        return figureList;
    }


    public Color randomColor() {
        Random rnd = new Random();
        float r = rnd.nextFloat();
        float g = rnd.nextFloat();
        float b = rnd.nextFloat();
        return new Color(r, g, b);
    }

    public Point randomPoint() {
        return new figures.Point((int) (Math.random() * 500), (int) (Math.random() * 500));

    }

    public int randomLenght() {
        return (int) (Math.random() * 50);

    }

    public Rectangle randomRectangle() {
        return new Rectangle((int) (Math.random() * 1.5) != 0, randomColor(), randomPoint(), (int) (Math.random() * 50), (int) (Math.random() * 50));
    }

    public Triangle randomTriangle() {
        return new Triangle((int) (Math.random() * 1.5) != 0, randomColor(), randomPoint(), (int) (Math.random() * 50), (int) (Math.random() * 50));
    }

    public Circle randomCircle() {
        return new Circle((int) (Math.random() * 1.5) != 0, randomColor(), randomPoint(), (int) (Math.random() * 50), (int) (Math.random() * 50));
    }

    public Ellipsis randomEllipsis() {
        return new Ellipsis((int) (Math.random() * 1.5) != 0, randomColor(), randomPoint(), (int) (Math.random() * 50), (int) (Math.random() * 50));
    }

}
