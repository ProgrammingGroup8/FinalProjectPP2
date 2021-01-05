package figures;

import java.awt.*;

public abstract class Shape {
    String name;
    Point p;
    Color color;
    int width;
    int height;
    boolean isFilled;

    public Shape(){

    }

    public Shape(Point p, Color color, int width, int height, boolean isFilled) {
        this.p = p;
        this.color = color;
        this.width = width;
        this.height = height;
        this.isFilled = isFilled;
    }

    void setName(String name){
        this.name = name;
    }

}
