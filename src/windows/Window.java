package windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener {

    private JPanel leftPanel;
    private JPanel centerPanel;

    private JButton button1;
    private JButton button2;

    private JTextField edt1;
    private JTextField edt2;

    private boolean isBtnClicked = false;

    public Window() {
        init();
    }

    public Window(String title) {
        super(title);
        init();
    }

    private void init() {
        initMenuBar();
        initializeComponents();
    }

    private void initMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");

        JMenuItem newItem = new JMenuItem("New");
//        newItem.addActionListener(this);
        fileMenu.add(newItem);

        fileMenu.add(new JMenuItem(("Open")));
        fileMenu.add(new JMenuItem(("Save")));
        fileMenu.add(new JMenuItem(("Exit")));

        for (int i = 0; i < fileMenu.getItemCount(); i++) {
            fileMenu.getItem(i).addActionListener(this);
        }

        menuBar.add(fileMenu);
        this.setJMenuBar(menuBar);
    }

    private void initializeComponents() {
        Container rootCont = this.getContentPane();
        rootCont.setBackground(Color.lightGray);
        rootCont.setLayout(new BorderLayout());

        leftPanel = new JPanel();
        leftPanel.setBackground(Color.blue);
        leftPanel.setLayout(new GridBagLayout());

        button1 = new JButton("Generate");
        button2 = new JButton("Clear");

//        button1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Button 1 is clicked!");
//            }
//        });
//
//        button2.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Button 2 is clicked!");
//            }
//        });
        button1.addActionListener(this);
        button2.addActionListener(this);

        edt1 = new JTextField("This is a text field");
        edt2 = new JTextField("Demo");

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
        leftPanel.add(edt2, gbc);

        rootCont.add(leftPanel, BorderLayout.WEST);

        centerPanel = new JPanel();
        centerPanel.setBackground(Color.green);
        rootCont.add(centerPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        System.out.println("A button clicked");
//        System.out.println(e.getSource());

        if (e.getSource() instanceof JButton) {
//            System.out.println("A button is clicked");

            switch (e.getActionCommand().trim()) {
                case "Button":
                    JOptionPane.showMessageDialog(this,
                            "Button is clicked!");
                    break;
                case "Another Button":
                    edt1.setText("Another button is click!");
                    showSomeDrawing();
                    break;
            }

        }

        if (e.getSource() instanceof JMenuItem) {
//            System.out.println("A menu item is clicked");

            JFileChooser fc = new JFileChooser(
                    "C:\\Users\\ADA-PC\\Documents\\ADA\\2020-21-FALL\\Programming Principles 2\\CSCI1202-10195\\code");

            switch (e.getActionCommand().trim()) {
                case "New":
                    break;
                case "Open":
                    int res = fc.showOpenDialog(null);
                    if(res == JFileChooser.APPROVE_OPTION){
                        System.out.println(fc.getSelectedFile().getAbsolutePath());
                    }
                    break;
                case "Save":
                    int resSave = fc.showSaveDialog(this);

                    if(resSave == JFileChooser.APPROVE_OPTION){
                        if(fc.getSelectedFile().exists()){
                            JOptionPane.showConfirmDialog(this, "File will be cleared! Are you sure?");
                        }
//                        System.out.println(fc.getSelectedFile().getAbsolutePath());
                    }
                    break;
                case "Exit":
                    break;
            }
        }
    }

    private void showSomeDrawing(){
        isBtnClicked = true;

        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.drawPolygon(new int[]{300,600,500}, new int[]{400,200,500}, 3);

        if(isBtnClicked){
            Graphics gr = centerPanel.getGraphics();

            gr.drawRect(50,50,50,50);
            gr.setColor(Color.GREEN);

//            gr.setColor(Color.white);
//            gr.drawRect(100, 50, 200,200);
//
//            gr.setColor(new Color(255, 50, 50));
//            gr.fillOval(20, 100, 50,50);
        }
    }


}





