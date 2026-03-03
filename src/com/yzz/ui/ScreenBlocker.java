package com.yzz.ui;

import javax.swing.*;
import java.awt.*;

public class ScreenBlocker {
    private JFrame frame;

    public ScreenBlocker() {
        // Run GUI creation on the Event Dispatch Thread
        SwingUtilities.invokeLater(this::initGUI);
    }

    private void initGUI() {
        frame = new JFrame();
        frame.setUndecorated(true); // Remove title bar and borders
        frame.setAlwaysOnTop(true); // Keep it above other windows

        // Set background color to black
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(new GridBagLayout());

        JLabel label = new JLabel("Take a deep breath and rest your eyes...");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 36));
        frame.add(label);

        // Make the frame full screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(0, 0, screenSize.width, screenSize.height);
    }

    public void showBlocker() {
        SwingUtilities.invokeLater(() -> {
            if (frame != null) {
                frame.setVisible(true);
            }
        });
    }

    public void hideBlocker() {
        SwingUtilities.invokeLater(() -> {
            if (frame != null) {
                frame.setVisible(false);
            }
        });
    }

    public void dispose() {
        SwingUtilities.invokeLater(() -> {
            if (frame != null) {
                frame.dispose();
            }
        });
    }
}
