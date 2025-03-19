import service.DownloadSimulator;
import service.ToDoListApp;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ToDoListApp::new);
//        SwingUtilities.invokeLater(DownloadSimulator::new);

    }
}