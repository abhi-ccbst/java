package service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class ToDoListApp {
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskField;
    private JCheckBox importantCheckBox;

    public ToDoListApp() {

        JFrame frame = new JFrame("TO-DO list");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
//BorderLayout	Divides into North, South, East, West, Center (default for JFrame)

        initializeComponents(frame);
        this.loadTasksFromFile();
        frame.setVisible(true);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Performing saving to file");
            Runnable saveTasksToFile = this::saveTasksToFile;
            saveTasksToFile.run();
        }));
    }

    private void initializeComponents(JFrame frame) {
        JPanel inputPanel = new JPanel();
        taskField = new JTextField(20);
        JButton button = new JButton("Add Task");
        importantCheckBox = new JCheckBox("Important");
        inputPanel.add(taskField);
        inputPanel.add(button);
        inputPanel.add(importantCheckBox);

        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        JScrollPane listScrollPane = new JScrollPane(taskList);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        //FlowLayout	Places components in a row (default for JPanel)
        JButton removeButton = new JButton("Remove Task");
        JButton cleanButton = new JButton("Clean Task");
        buttonPanel.add(removeButton);
        buttonPanel.add(cleanButton);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(listScrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        addEventHandlers(button, removeButton, cleanButton);
    }

    private void addEventHandlers(JButton addButton, JButton removeButton, JButton cleanButton) {
        addButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText().trim();
                if (!task.isEmpty()) {
                    if (importantCheckBox.isSelected()) {
                        task = task  +" *";
                    }
                    taskListModel.addElement(task);
                    taskField.setText("");
                }
            }
        });

        removeButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedOption = taskList.getSelectedIndex();
                if (selectedOption != -1) {
                    taskListModel.remove(selectedOption);
                }
            }
        });

        cleanButton.addActionListener(e -> {
                taskListModel.clear();
        });
    }

    private void saveTasksToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("tasks.txt"))){
            for (int i = 0; i < taskListModel.size(); i++) {
                writer.write(taskListModel.getElementAt(i));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void loadTasksFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("tasks.txt"))){
            String task;
            while((task = reader.readLine()) != null) {
                taskListModel.addElement(task);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}


//FlowLayout	Places components in a row (default for JPanel)
//BorderLayout	Divides into North, South, East, West, Center (default for JFrame)
//BoxLayout	    Stacks components vertically/horizontally

//GridLayout	Creates a grid of components
//GridBagLayout	Advanced layout with precise control  **