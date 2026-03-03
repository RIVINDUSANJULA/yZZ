import javax.swing.*;

public class Main {
  public static void main(String[] args) {
    System.out.println("Starting Screen Blocker - Step 2");

    ScreenBlocker blocker = new ScreenBlocker();

    // Show the blocker
    blocker.showBlocker();

    // Timer to close the blocker after 5 seconds (for this prototype step)
    Timer timer = new Timer(5000, e -> {
      blocker.dispose();
      System.exit(0);
    });
    timer.setRepeats(false);
    timer.start();
  }
}
