import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TaskManager extends JFrame {
    private DefaultTableModel model;
    private JTable table;
    private JTextField textField;
    private JComboBox<String> priorityBox;

    public TaskManager() {
        setTitle("Task Manager");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        model = new DefaultTableModel(new Object[] {"Task", "Priority", "Status"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        textField = new JTextField(15);
        priorityBox = new JComboBox<>();
        priorityBox.addItem("Low");
        priorityBox.addItem("Medium");
        priorityBox.addItem("High");
        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Task");
        JButton markButton = new JButton("Mark Complete");


        panel.add(new Label("Task:"));
        panel.add(textField);
        panel.add(new JLabel("Priority:"));
        panel.add(priorityBox);
        panel.add(addButton);
        panel.add(deleteButton);
        panel.add(markButton);

        add(panel, BorderLayout.SOUTH); //Bottom
        addButton.addActionListener(e -> addTask());
        deleteButton.addActionListener(e -> deleteTask());
        markButton.addActionListener(e -> markTask());

        setVisible(true);
    }

    private void addTask() {
        String task = textField.getText();
        String priority = (String) priorityBox.getSelectedItem();
        if (!task.isEmpty()) {
            model.addRow(new String[] {task, priority, "Pending"});
            textField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Task cannot be empty!");
        }
    }

    private void deleteTask() {
        int index = table.getSelectedRow();
        if (index!= -1) {
            model.removeRow(index);
        } else {
            JOptionPane.showMessageDialog(this, "Select a task to delete!");
        }
    }

    private void markTask() {
        int index = table.getSelectedRow();
        if (index != -1) {
            model.setValueAt("Complete", index, 2);
        } else{
            JOptionPane.showMessageDialog(this, "Select a task to mark as completed!");
        }
    }

}
