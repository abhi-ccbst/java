package service;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class DynamicTaskManager {
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskInput;
    private Map<String, LocalDateTime> taskDueDates;
    private boolean isAlertActive = false;

    public DynamicTaskManager() {
        JFrame frame = new JFrame("Task Manager");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        taskListModel = new DefaultListModel<>();
        taskDueDates = new HashMap<>();
        addtask("Finish Java Project", LocalDateTime.now().plusMinutes(2));
        addtask("Submit Report", LocalDateTime.now().plusSeconds(10));

        taskList = new JList<>(taskListModel);
        frame.add(new JScrollPane(taskList), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        taskInput = new JTextField(15);
        JButton addButton = new JButton("Add Task");
        JButton removeButton = new JButton("Remove Task");

        panel.add(taskInput, BorderLayout.CENTER);
        panel.add(addButton, BorderLayout.EAST);
        panel.add(removeButton, BorderLayout.SOUTH);

        frame.add(panel, BorderLayout.SOUTH);
        addButton.addActionListener(e -> {
            String task = taskInput.getText().trim();
            if (!task.isEmpty()){
                addtask(task, LocalDateTime.now().plusMinutes(3)); //Default 3 min will be added as timer
                taskInput.setText("");
            }
        });

        removeButton.addActionListener(e -> {
            int index = taskList.getSelectedIndex();
            if (index > -1) {
                String selectedTask = taskListModel.get(index);
                taskListModel.remove(index);
                taskDueDates.remove(selectedTask);
            }
        });
        this.startDeadlineChecker();
    }


    private void addtask(String task, LocalDateTime time) {
        String taskWithDate = task + " (Due: " + time + ")";
        taskListModel.addElement(taskWithDate);
        taskDueDates.put(taskWithDate, time);
    }

    private void startDeadlineChecker() {
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                SwingUtilities.invokeLater(() -> checkForExpiringTasks());
            }
        }, 0 , 1000);
    }


    private void checkForExpiringTasks() {
        if (isAlertActive)
            return;
        LocalDateTime localDateTime = LocalDateTime.now();
        for(String task: taskDueDates.keySet()) {
            LocalDateTime dueDate = taskDueDates.get(task);
            if (dueDate.equals(localDateTime) || dueDate.isBefore(localDateTime)) {
                isAlertActive = true;
                int response = JOptionPane.showConfirmDialog(null,
                        "Task " + task + " is due. Do you want to remove it?",
                        "Task Due Alert",
                        JOptionPane.OK_CANCEL_OPTION);

                if (response==JOptionPane.OK_OPTION) {
                    taskListModel.removeElement(task);
                    taskDueDates.remove(task);
                } else {
                    LocalDateTime newLocalDateTime = LocalDateTime.now().plusMinutes(3);
                    String newTask = task.split(" \\(Due")[0];
                    taskDueDates.remove(task);
                    taskDueDates.put(newTask, newLocalDateTime);
                    int index = taskListModel.indexOf(task);
                    if (index != -1) {
                        taskListModel.set(index, newTask + " (Due: " + newLocalDateTime + ")");
                    }
                }
                isAlertActive = false;
            }
        }
    }
}

/**
 * 1. Add a file to save and load a data.
 * 2. Take a time from user input as an option part
 * 3. And Use that time to manage the alerts
 * */
