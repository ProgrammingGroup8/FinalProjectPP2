package figures;

import java.awt.*;

public class Triangle extends Shape {
    public Triangle(Boolean isFilled, Color color, Point point, int width, int height){
        super(point,color,width,height,isFilled);
        setName("triangle");
    }
}
