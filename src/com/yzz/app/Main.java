package com.yzz.app;

import com.yzz.ui.ScreenBlocker;
import javax.swing.*;
import java.awt.*;

public class Main {
  private static ScreenBlocker blocker;

  public static void main(String[] args) {
    System.out.println("Starting Screen Blocker");

    // Initialize the ScreenBlocker
    blocker = new ScreenBlocker();

    // Setup System Tray
    if (!SystemTray.isSupported()) {
      System.err.println("System tray is not supported on this platform!");
      // Fallback for now: Just show it once and exit
      blocker.showBlocker();
      Timer timer = new Timer(5000, e -> {
        blocker.dispose();
        System.exit(0);
      });
      timer.setRepeats(false);
      timer.start();
      return;
    }

    // Run tray initialization on EDT
    SwingUtilities.invokeLater(Main::setupSystemTray);
  }

  private static void setupSystemTray() {
    SystemTray tray = SystemTray.getSystemTray();

    // Create a simple blank icon for now (or a small colored square)
    Image iconImage = createTrayIconImage();

    PopupMenu popup = new PopupMenu();
    MenuItem exitItem = new MenuItem("Exit");
    exitItem.addActionListener(e -> {
      blocker.dispose();
      System.exit(0);
    });

    popup.add(exitItem);

    TrayIcon trayIcon = new TrayIcon(iconImage, "yZZ Screen Blocker", popup);
    trayIcon.setImageAutoSize(true);

    try {
      tray.add(trayIcon);
      System.out.println("System tray icon added successfully.");
    } catch (AWTException e) {
      System.err.println("TrayIcon could not be added.");
    }
  }

  // Creates a simple 16x16 red square image to serve as our tray icon
  private static Image createTrayIconImage() {
    java.awt.image.BufferedImage img = new java.awt.image.BufferedImage(16, 16,
        java.awt.image.BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = img.createGraphics();
    g2d.setColor(Color.RED);
    g2d.fillRect(0, 0, 16, 16);
    g2d.dispose();
    return img;
  }
}
