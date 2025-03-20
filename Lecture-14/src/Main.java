import service.DynamicTaskManager;
import service.FadingButtonEffect;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(DynamicTaskManager::new);
        SwingUtilities.invokeLater(FadingButtonEffect::new);
    }
}