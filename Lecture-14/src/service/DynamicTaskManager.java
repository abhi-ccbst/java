package service;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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

    private final String filepath = "tasks.txt";

    public DynamicTaskManager() {
        JFrame frame = new JFrame("Task Manager");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        taskListModel = new DefaultListModel<>();
        taskDueDates = new HashMap<>();
        loadTasksFromFile();

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
                SpinnerDateModel model = new SpinnerDateModel();
                JSpinner timeSpinner = new JSpinner(model);
                JSpinner.DateEditor editor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
                timeSpinner.setEditor(editor);
                int option = JOptionPane.showConfirmDialog(frame, timeSpinner, "Select Due Time", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    LocalTime selectedTime = LocalTime.parse(editor.getFormat().format(timeSpinner.getValue()), DateTimeFormatter.ofPattern("HH:mm"));
                    LocalDateTime dueDateTime = LocalDateTime.of(LocalDate.now(), selectedTime);
                    addtask(task, dueDateTime); //Default 3 min will be added as timer
                    taskInput.setText("");
                    return;
                }
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

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Performing saving to file");
            Runnable saveTasksToFile = this::saveTasksToFile;
            saveTasksToFile.run();
        }));
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

    private void saveTasksToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))){
            for (int i = 0; i < taskListModel.size(); i++) {
                writer.write(taskListModel.getElementAt(i));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void loadTasksFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))){
            String task;
            while((task = reader.readLine()) != null) {
                taskListModel.addElement(task);
                String time = task.substring(task.indexOf("Due: ") + 5, task.indexOf(")"));
                LocalDateTime localDateTime = LocalDateTime.parse(time);
                taskDueDates.put(task, localDateTime);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}