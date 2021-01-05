package service;

import figures.Figure;
import figures.Point;
import figures.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Generator  extends JFrame {

   public void generateFigures(int number){
       for (int i = 0; i < number ; i++) {
          // paintFigure();
       }
   }

    public static void main(String[] args) {
        Random rnd = new Random(500);

        for (int i = 0; i < 15 ; i++) {
            System.out.println((int) (Math.random()*1.5));
        }
    }

   public Color randomColor(){
       Random rnd = new Random();
       float r = rnd.nextFloat();
       float g = rnd.nextFloat();
       float b = rnd.nextFloat();
       return new Color(r, g, b);
   }

    public Point randomPoint(){
        return new figures.Point((int) (Math.random() * 500),(int) (Math.random() * 500));

    }
    public int randomLenght(){
        return (int) (Math.random() * 50);

    }

    public Rectangle randomRectangle(){
        return new Rectangle((int) (Math.random() * 1.5) != 0, randomColor(),randomPoint(), (int) (Math.random() * 50), (int) (Math.random() * 50));
    }

}
