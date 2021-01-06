package windows;



import figures.Shape;
import service.Generator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextHitInfo;
import java.util.List;

public class MyWindow extends JFrame implements ActionListener {

    private JPanel leftPanel;
    private JPanel rightPanel;

    private JButton button1;
    private JButton button2;
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
        JMenuItem comp1 = new JMenuItem("New");

        JMenuItem comp2 = new JMenuItem("Open");
        JMenuItem comp3 = new JMenuItem("Save as");
        JMenuItem comp4 = new JMenuItem("Exit");
        m1.add(comp1);
        m1.add(comp2);
        m1.add(comp3);
        m1.add(comp4);

        for (int i = 0; i < m1.getItemCount(); i++) {
            m1.getItem(i).addActionListener(this);
        }

        this.setJMenuBar(mb);

/*      JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        this.setJMenuBar(menuBar);*/
    }

    private void initializeComponents() {
        Container rootCont = this.getContentPane();
        rootCont.setBackground(Color.red);
        rootCont.setLayout(new BorderLayout());
        leftPanel = new JPanel();
        leftPanel.setBackground(Color.green);
        leftPanel.setLayout(new GridBagLayout());

        button1 = new JButton("Generate");
        button2 = new JButton("Clear");
        btCountUp = new JButton("+");
        btCountDown = new JButton("-");

        button1.addActionListener(this);
        button2.addActionListener(this);

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
        System.out.println("Metn budur "+edt1.getText());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3, 3, 3, 3);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;

        gbc.gridy = 0;
        leftPanel.add(button1, gbc);

        gbc.gridy = 1;
        leftPanel.add(button2, gbc);

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
                    ShowSomeDrawing(edt1.getText());
                    break;
                case "Clear":
                    rightPanel.removeAll();
                    repaint();

                    break;
            }
        }

        if (e.getSource() instanceof JMenuItem) {
            System.out.println("A menu is clicked");
            JFileChooser fc = new JFileChooser("C:\\Users\\sadig\\Desktop\\2020 FALL\\PP2");

            switch (e.getActionCommand().trim()) {
                case "New":
                    break;
                case "Open":
                    //    JFileChooser fc = new JFileChooser("C:\\Users\\sadig\\Desktop\\2020 FALL\\PP2");

                    int res = fc.showOpenDialog(this);
                    if (res == JFileChooser.APPROVE_OPTION) {
                        System.out.println(fc.getSelectedFile().getAbsolutePath());
                    }
                    break;
                case "Save as":
                    int save = fc.showSaveDialog(this);
                    if (save == JFileChooser.APPROVE_OPTION) {
                        if (fc.getSelectedFile().exists()) {
                            JOptionPane.showMessageDialog(this, "It is already existed, do you want to save it?");
                        }
                        System.out.println(fc.getSelectedFile().getAbsolutePath());
                    }
                    break;
                case "Exit":

                    //this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    System.exit(0);
                    break;

            }
        }
    }

    private void ShowSomeDrawing(String number) {

        Generator generator = new Generator();
        List<Shape> shapes = generator.generateFigures(Integer.parseInt(number));
        Graphics gr = rightPanel.getGraphics();
        for (int i = 0; i < Integer.parseInt(number); i++) {
            gr.setColor(shapes.get(i).getColor());
            gr.drawRect(shapes.get(i).getP().getX(), shapes.get(i).getP().getY(), shapes.get(i).getWidth(), shapes.get(i).getHeight());
            if (shapes.get(i).isFilled()){
                gr.fillRect(shapes.get(i).getP().getX(), shapes.get(i).getP().getY(), shapes.get(i).getWidth(), shapes.get(i).getHeight());
            }

        }

    }
    private void clearScreen(){

    }
}





