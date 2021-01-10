package windows;


import figures.Shape;
import service.GeneratorService;
import service.ShapeService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyWindow extends JFrame implements ActionListener {

    private JPanel leftPanel;
    private JPanel rightPanel;
    private String path;
    private Boolean isGenerateClicked = false;
    private Boolean isClearClicked = false;
    private Boolean isOpenClicked = false;
    private int numberOfFigures = 0;
    private  List<Shape> toBeSaved=null;
    private List<Shape> shapes = new ArrayList<>();
    private JButton generateButton;
    private JButton clearButton;
    private JButton btCountUp;
    private JButton btCountDown;
    private JTextField edt1;
    private int count = 0;


    public MyWindow() {
        init();
    }

    public MyWindow(String title) {

        super(title);
        init();
    }

    private void init() {
        initMenuBar();
        initializeComponents();
    }

    private void initMenuBar() {


        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("FILE");

        mb.add(m1);

        JMenuItem comp2 = new JMenuItem("Open");
        JMenuItem comp3 = new JMenuItem("Save as");
        JMenuItem comp4 = new JMenuItem("Exit");
        m1.add(comp2);
        m1.add(comp3);
        m1.add(comp4);

        for (int i = 0; i < m1.getItemCount(); i++) {
            m1.getItem(i).addActionListener(this);
        }

        this.setJMenuBar(mb);
    }

    private void initializeComponents() {
        Container rootCont = this.getContentPane();
        rootCont.setBackground(Color.red);
        rootCont.setLayout(new BorderLayout());
        leftPanel = new JPanel();
        leftPanel.setBackground(Color.green);
        leftPanel.setLayout(new GridBagLayout());

        generateButton = new JButton("Generate");
        clearButton = new JButton("Clear");
        btCountUp = new JButton("+");
        btCountDown = new JButton("-");

        generateButton.addActionListener(this);
        clearButton.addActionListener(this);

        btCountUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (count < 50)
                    ++count;
                edt1.setText(count + "");
            }
        });

        btCountDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (count != 0)
                    count--;
                edt1.setText(count + "");
            }
        });


        edt1 = new JTextField("0", 10);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3, 3, 3, 3);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;

        gbc.gridy = 0;
        leftPanel.add(generateButton, gbc);

        gbc.gridy = 1;
        leftPanel.add(clearButton, gbc);

        gbc.gridy = 2;
        leftPanel.add(edt1, gbc);

        gbc.gridy = 3;
        leftPanel.add(btCountUp, gbc);

        gbc.gridy = 4;
        leftPanel.add(btCountDown, gbc);


        rootCont.add(leftPanel, BorderLayout.WEST);

        rightPanel = new JPanel();
        rightPanel.setBackground(Color.white);
        rootCont.add(rightPanel, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            switch (e.getActionCommand().trim()) {
                case "Generate":
                    if (!shapes.isEmpty()){
                        int reply = JOptionPane.showConfirmDialog(this, "Current figures will be removed. Are you sure?", "Be Careful!", JOptionPane.YES_NO_OPTION);
                            if (reply == JOptionPane.YES_OPTION){
                                drawRandomFigures(edt1.getText());
                            }

                    }else {
                        drawRandomFigures(edt1.getText());
                    }




                    break;
                case "Clear":
                    isClearClicked = true;
                    repaint();
                    break;
            }
        }

        if (e.getSource() instanceof JMenuItem) {
            JFileChooser fc = new JFileChooser();

            switch (e.getActionCommand().trim()) {
                case "Open":
                    int res = fc.showOpenDialog(this);
                    if (res == JFileChooser.APPROVE_OPTION) {
                        isOpenClicked = true;
                        isClearClicked = false;
                        isGenerateClicked = false;
                        path = fc.getSelectedFile().getPath();
                        paint(getGraphics());

                    }
                    break;
                case "Save as":
                    int save = fc.showSaveDialog(this);
                    if (save == JFileChooser.APPROVE_OPTION) {
                        if (fc.getSelectedFile().exists()) {
                            JOptionPane.showMessageDialog(this, "It is already existed, do you want to save it?");
                        }
                        try {
                            ShapeService.saveShapes(fc.getSelectedFile().getAbsolutePath(),toBeSaved);
                            path = fc.getSelectedFile().getAbsolutePath();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                    break;
                case "Exit":
                    if (!shapes.isEmpty()){
                        int reply = JOptionPane.showConfirmDialog(this, "Current figures will not be saved. Are you sure?", "Be Careful!", JOptionPane.YES_NO_OPTION);
                        if (reply == JOptionPane.YES_OPTION){
                            System.exit(0);
                        }

                    }else {
                        System.exit(0);
                    }

                    break;

            }
        }
    }

    private void drawRandomFigures(String number) {
        isGenerateClicked = true;
        isClearClicked = false;
        isOpenClicked = false;

        numberOfFigures = Integer.parseInt(number);
        repaint();


    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (!isClearClicked) {
            GeneratorService generatorService = new GeneratorService();
            if (isGenerateClicked) {
                shapes = generatorService.generateFigures(numberOfFigures);
                toBeSaved = shapes;
                //FileRead.reading(new File("src/shapes_50.txt"));
                //generator.generateFigures(numberOfFigures);
            } else if (isOpenClicked) {
                shapes = ShapeService.readShapes(new File(path));
            }
            Graphics gr = rightPanel.getGraphics();
            for (Shape shape : shapes) {
                if (shape.getName().equals("rectangle")) {
                    gr.setColor(Color.RED);
                    gr.setColor(shape.getColor());
                    gr.drawRect(shape.getP().getX(), shape.getP().getY(), shape.getWidth(), shape.getHeight());
                    if (shape.isFilled()) {
                        gr.fillRect(shape.getP().getX(), shape.getP().getY(), shape.getWidth(), shape.getHeight());
                    }
                }
                if (shape.getName().equals("circle")) {
                    gr.setColor(shape.getColor());
                    gr.drawOval(shape.getP().getX(), shape.getP().getY(), shape.getWidth(), shape.getHeight());
                    if (shape.isFilled()) {
                        gr.fillOval(shape.getP().getX(), shape.getP().getY(), shape.getWidth(), shape.getHeight());
                    }
                }

                if (shape.getName().equals("triangle")) {
                    DrawTriangle dt = new DrawTriangle(shape.getColor(), shape.getP().getX(), shape.getP().getY());
                    // dt.setLocation(shape.getP().getX(),shape.getP().getY());
                    dt.paint(gr);
                    dt.setVisible(true);
                }
            }

        }
    }
}





