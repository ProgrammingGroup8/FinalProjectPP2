package figures;

import javax.swing.*;
import java.awt.*;

public class Circle extends Shape {

  public Circle(Boolean isFilled, Color color, Point point, int width, int height){
    super(point,color,width,height,isFilled);
    setName("circle");
  }
}
