import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Screen Blocker - Step 1");
        
        // Run GUI creation on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            createAndShowBlocker();
        });
    }

    private static void createAndShowBlocker() {
        JFrame frame = new JFrame();
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
        
        frame.setVisible(true);
        
        // Timer to close the blocker after 5 seconds (for this first prototype step)
        Timer timer = new Timer(5000, e -> {
            frame.dispose();
            System.exit(0);
        });
        timer.setRepeats(false);
        timer.start();
    }
}
