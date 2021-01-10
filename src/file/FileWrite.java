package file;

import figures.Shape;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWrite {

    public void write(String path, List<Shape> list) throws IOException {
        List<String> lines  = new ArrayList<>();
        for(Shape s : list){
            String ln = String.format("%s;(%d,%d,%d);%s;%s;%s;%s;%s",
                    s.getName(),s.getColor().getRed(),s.getColor().getGreen(),s.getColor().getBlue(),
                    s.isFilled() ?"T": "F",s.getP().getX(),s.getP().getY(),s.getWidth(),s.getHeight());
            lines.add(ln);
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(path));

        lines.forEach(e-> {
            try {
                writer.write(e);
                writer.newLine();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        writer.close();

    }
}
