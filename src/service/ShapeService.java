package service;

import figures.Circle;
import figures.Point;
import figures.Rectangle;
import figures.Shape;
import figures.Triangle;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShapeService {
    static List<Shape> list = new ArrayList<>();

    public static List<String> dataRenderer(List<Shape> list){
        List<String> lines  = new ArrayList<>();
        for(Shape s : list){
            String ln = String.format("%s;(%d,%d,%d);%s;%s;%s;%s;%s",
                    s.getName(),s.getColor().getRed(),s.getColor().getGreen(),s.getColor().getBlue(),
                    s.isFilled() ?"T": "F",s.getP().getX(),s.getP().getY(),s.getWidth(),s.getHeight());
            lines.add(ln);
        }
        return lines;
    }

    public static void saveShapes(String path,List<Shape> shapes) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));

        dataRenderer(shapes).forEach(e-> {
            try {
                writer.write(e);
                writer.newLine();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        writer.close();
    }
    public static List<Integer> RGBrenderer(String s) {
        s = s.substring(1, s.length() - 1);
        String[] rgb = s.split(",", 3);
        return Arrays.stream(rgb).map(Integer::parseInt).collect(Collectors.toList());
    }
    public static List<Shape> readShapes(File path){
        try {

            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            Scanner scan = new Scanner(fr);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] pair = line.split(";", 7);
                switch (pair[0]) {
                    case "rectangle":
                        list.add(new Rectangle(pair[2].equals("T"), new Color(RGBrenderer(pair[1]).get(0), RGBrenderer(pair[1]).get(1), RGBrenderer(pair[1]).get(2)),
                                new figures.Point(Integer.parseInt(pair[3]), Integer.parseInt(pair[4])), Integer.parseInt(pair[5]), Integer.parseInt(pair[6])));
                        break;

                    case "oval":
                    case "ellipse":
                        list.add(new Circle(pair[2].equals("T"), new Color(RGBrenderer(pair[1]).get(0), RGBrenderer(pair[1]).get(1), RGBrenderer(pair[1]).get(2)),
                                new figures.Point(Integer.parseInt(pair[3]), Integer.parseInt(pair[4])), Integer.parseInt(pair[5]), Integer.parseInt(pair[6])));
                        break;

                    case "triangle":
                        list.add(new Triangle(pair[2].equals("T"), new Color(RGBrenderer(pair[1]).get(0), RGBrenderer(pair[1]).get(1), RGBrenderer(pair[1]).get(2)),
                                new Point(Integer.parseInt(pair[3]), Integer.parseInt(pair[4])), Integer.parseInt(pair[5]), Integer.parseInt(pair[6])));
                        break;
                }


            }
            fr.close();
            br.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        return list;
    }
}
