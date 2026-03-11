package yzz.app;

import com.yzz.ui.ScreenBlocker;
import javax.swing.*;
import java.awt.*;

public class Main {
  private static ScreenBlocker blocker;

  public static void main(String[] args) {
    System.out.println("Starting Screen Blocker");

    blocker = new ScreenBlocker();

      blocker.showBlocker();

      int delay = 5000;

      Timer timer = new Timer(delay, e -> {
          blocker.dispose();
          System.exit(0);
      });
      timer.setRepeats(false);
      timer.start();
      return;

  }

}
