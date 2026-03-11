package com.yzz.ui;

import javax.swing.*;
import java.awt.*;

public class ScreenBlocker extends JFrame {
    private JFrame frame;

    public ScreenBlocker() {
        SwingUtilities.invokeLater(this::initGUI);
    }

    private void initGUI() {
        frame = new JFrame();

        // No title bar and borders
        frame.setUndecorated(true);


        // Above other windows
        frame.setAlwaysOnTop(true);


        frame.getContentPane();
        frame.setLayout(new GridBagLayout());

        //DEMO
        JLabel label = new JLabel("zYYyyyy");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 36));
        frame.add(label);

        // Full screen
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
        SwingUtilities.invokeLater(() -> {  // Schedule -- put it in a queue and run it as soon as the Event Dispatch Thread is free
            if (frame != null) {            // Windows Eist???
                frame.setVisible(false);
            }
        });
    }

    public void dispose() {
        SwingUtilities.invokeLater(() -> {
            if (frame != null) {
                frame.dispose(); // DONE - Take Memory, Destory Resources - Clean UP
            }
        });
    }
}
