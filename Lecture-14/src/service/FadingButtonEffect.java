package service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public class FadingButtonEffect {


    public FadingButtonEffect() {
        JFrame frame = new JFrame("Button Animation");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        JButton animatedButton = new JButton("Hover Me");
        frame.add(animatedButton);
        Timer fadeOutTimer = new Timer(30, null);
        fadeOutTimer.addActionListener(new ActionListener() {
            float alpha = 1.0f;
            @Override
            public void actionPerformed(ActionEvent e) {
                alpha -= 0.05f;
                if (alpha <= 0.5f) {
                    fadeOutTimer.stop();
                }
                animatedButton.setForeground(new Color(0, 0, 0, (int) (alpha * 255)));
            }
        });

        animatedButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fadeOutTimer.start();
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                animatedButton.setForeground(Color.BLACK);
            }
        });
        frame.setVisible(true);
    }
}
