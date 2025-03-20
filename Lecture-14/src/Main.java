import service.DynamicTaskManager;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(DynamicTaskManager::new);
    }
}