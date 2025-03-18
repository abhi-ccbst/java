import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Main {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Swing App");
        jFrame.setSize(300, 200);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JTextField jTextField = new JTextField(20);
//        JLabel label = new JLabel("Hello, Swing!");
//        jFrame.add(label);
        JButton south = new JButton("Submit");
        south.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Entered texts: " + jTextField.getText());
            }
        });
        JPanel panel = new JPanel();
        panel.add(jTextField);
        panel.add(south);
        jFrame.add(panel);

//        jFrame.setLayout(new BorderLayout());
//        JButton north = new JButton("NORTH");
//        north.addActionListener(new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Button Clicked! (NORTH)");
//            }
//        });
//        jFrame.add(north, BorderLayout.NORTH);
//
//        JButton south = new JButton("SOUTH");
//        south.addActionListener(new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Button Clicked! (SOUTH)");
//            }
//        });
//        jFrame.add(south, BorderLayout.SOUTH);
//
//        JButton east = new JButton("EAST");
//        east.addActionListener(new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Button Clicked! (EAST)");
//            }
//        });
//        jFrame.add(east, BorderLayout.EAST);
//
//        JButton west = new JButton("WEST");
//        west.addActionListener(new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Button Clicked! (WEST)");
//            }
//        });
//        jFrame.add(west, BorderLayout.WEST);
//
//        JButton center = new JButton("CENTER");
//        center.addActionListener(new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Button Clicked! (CENTER)");
//            }
//        });
//        jFrame.add(center, BorderLayout.CENTER);
        jFrame.setVisible(true);
    }
}

//FlowLayout	Places components in a row (default for JPanel)
//BorderLayout	Divides into North, South, East, West, Center (default for JFrame)
//GridLayout	Creates a grid of components
//BoxLayout	Stacks components vertically/horizontally
//GridBagLayout	Advanced layout with precise control