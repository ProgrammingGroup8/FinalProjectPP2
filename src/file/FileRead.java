package file;


import figures.Shape;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileRead {
//    public static void main(String[] args) {
//        ArrayList<String> list = new ArrayList<>();
//        reading(new File("shapes_50.txt"));
// .
//    }
   static  ArrayList<String> list = new ArrayList<>();
    public static List<String> reading(File path) {
        try {

            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            Scanner scan = new Scanner(fr);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] pair = line.split(";", 6);
                System.out.println(pair[1]);

                list.add(pair[0]);
                list.add(pair[1]);
                list.add(pair[2]);
                list.add(pair[3]);
                list.add(pair[4]);
                list.add(pair[5]);
//                System.out.println(list.get(1));
//                System.out.println(list.get(2));
//                for (String a : pair) System.out.println(a);
                //               System.out.println(scan.nextLine());

            }
            fr.close();
            br.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return list;

    }

    public static void main(String[] args) {
       // reading(new File("src/shapes_50.txt")).forEach(System.out::println);
        System.out.println( reading(new File("src/shapes_50.txt")));
    }
}