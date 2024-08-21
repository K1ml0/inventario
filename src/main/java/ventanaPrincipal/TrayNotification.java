/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventanaPrincipal;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author USER
 */
class TrayNotification {
    
    public static void showTrayNotification(String message) {
        if (!SystemTray.isSupported()) {
            System.out.println("System tray not supported");
            return;
        }

        SystemTray tray = SystemTray.getSystemTray();
        Image image = Toolkit.getDefaultToolkit().getImage("path/to/icon.png"); // Cambia el icono si lo deseas
        TrayIcon trayIcon = new TrayIcon(image, "Notification");

        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("Notification");

        trayIcon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Tray icon clicked");
            }
        });

        try {
            tray.add(trayIcon);
            trayIcon.displayMessage("Notificación", message, TrayIcon.MessageType.INFO);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
    
}

