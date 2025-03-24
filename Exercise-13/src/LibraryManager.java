import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.Vector;

public class LibraryManager extends JFrame {
    private DefaultTableModel model;
    private JTable table;
    private JTextField titleField, authorField;
    private JComboBox<String> genreBox;
    private static final String FILE_NAME = "library_data.ser";

    public LibraryManager() {
        setTitle("Library Management System");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Table Model
        model = new DefaultTableModel(new Object[]{"Title", "Author", "Genre", "Status"}, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Input Panel
        JPanel inputPanel = new JPanel(new FlowLayout());
        titleField = new JTextField(10);
        authorField = new JTextField(10);
        genreBox = new JComboBox<>(new String[]{"Fiction", "Non-Fiction", "Science", "History"});
        JButton addButton = new JButton("Add Book");
        JButton editButton = new JButton("Edit Book");
        JButton deleteButton = new JButton("Delete Book");
        JButton statusButton = new JButton("Toggle Borrowed");

        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Author:"));
        inputPanel.add(authorField);
        inputPanel.add(new JLabel("Genre:"));
        inputPanel.add(genreBox);
        inputPanel.add(addButton);
        inputPanel.add(editButton);
        inputPanel.add(deleteButton);
        inputPanel.add(statusButton);

        add(inputPanel, BorderLayout.SOUTH);

        // Menu Bar for Saving and Loading
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem loadItem = new JMenuItem("Load");
        fileMenu.add(saveItem);
        fileMenu.add(loadItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        // Button Actions
        addButton.addActionListener(e -> addBook());
        editButton.addActionListener(e -> editBook());
        deleteButton.addActionListener(e -> deleteBook());
        statusButton.addActionListener(e -> toggleBorrowedStatus());
        saveItem.addActionListener(e -> saveData());
        loadItem.addActionListener(e -> loadData());
    }

    private void addBook() {
        String title = titleField.getText();
        String author = authorField.getText();
        String genre = (String) genreBox.getSelectedItem();
        if (!title.isEmpty() && !author.isEmpty()) {
            model.addRow(new Object[]{title, author, genre, "Available"});
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Title and Author cannot be empty!");
        }
    }

    private void editBook() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            model.setValueAt(titleField.getText(), selectedRow, 0);
            model.setValueAt(authorField.getText(), selectedRow, 1);
            model.setValueAt(genreBox.getSelectedItem(), selectedRow, 2);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Select a book to edit!");
        }
    }

    private void deleteBook() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            model.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Select a book to delete!");
        }
    }

    private void toggleBorrowedStatus() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String status = model.getValueAt(selectedRow, 3).toString();
            model.setValueAt(status.equals("Available") ? "Borrowed" : "Available", selectedRow, 3);
        } else {
            JOptionPane.showMessageDialog(this, "Select a book to change status!");
        }
    }

    private void saveData() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            Vector<Vector<Object>> dataVector = new Vector<>();

            // Convert raw Vector<Vector> to Vector<Vector<Object>>
            for (Vector<?> row : model.getDataVector()) {
                dataVector.add(new Vector<>(row));
            }

            out.writeObject(dataVector);
            JOptionPane.showMessageDialog(this, "Data Saved Successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error Saving Data: " + e.getMessage());
        }
    }


    private void loadData() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            Object obj = in.readObject();

            if (obj instanceof Vector) {
                @SuppressWarnings("unchecked")
                Vector<Vector<Object>> dataVector = (Vector<Vector<Object>>) obj;

                model.setRowCount(0);
                for (Vector<Object> row : dataVector) {
                    model.addRow(row.toArray());
                }
            }

            JOptionPane.showMessageDialog(this, "Data Loaded Successfully!");
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Error Loading Data: " + e.getMessage());
        }
    }



    private void clearFields() {
        titleField.setText("");
        authorField.setText("");
        genreBox.setSelectedIndex(0);
    }
}
