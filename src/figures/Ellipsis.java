package figures;

import java.awt.*;

public class Ellipsis extends Shape {

    public Ellipsis(Boolean isFilled, Color color, Point point, int width, int height){
        super(point,color,width,height,isFilled);
        setName("ellipsis");
    }
}
