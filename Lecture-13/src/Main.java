import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Form");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(5, 5, 5, 5); // Padding

        JLabel label = new JLabel("Username: ");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        frame.add(label, gridBagConstraints);

        JTextField textField = new JTextField(15);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        frame.add(textField, gridBagConstraints);

        JLabel password = new JLabel("password: ");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        frame.add(password, gridBagConstraints);

        JPasswordField passField = new JPasswordField(15);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        frame.add(passField, gridBagConstraints);

        JButton button = new JButton("Login");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = GridBagConstraints.CENTER;
        frame.add(button, gridBagConstraints);


        button.addActionListener(e -> {
            System.out.println("UserName: " + textField.getText());
            System.out.println("passWord: " + Arrays.toString(passField.getPassword()));
            textField.setText("");
            passField.setText("");
            button.setEnabled(false);
            JOptionPane.showMessageDialog(frame, "Login Success!");
            button.setEnabled(true);
        });

        frame.setVisible(true);

    }
}