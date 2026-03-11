package yzz.app;

import com.yzz.ui.ScreenBlocker;
import javax.swing.*;
import java.awt.*;

public class Main {
  private static ScreenBlocker blocker;

  public static void main(String[] args) {
    System.out.println("Starting Screen Blocker");


    //Firebase
      FileInputStream serviceAccount =
              new FileInputStream("path/to/serviceAccountKey.json");

      FirebaseOptions options = new FirebaseOptions.Builder()
              .setCredentials(GoogleCredentials.fromStream(serviceAccount))
              .build();

      FirebaseApp.initializeApp(options);


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
