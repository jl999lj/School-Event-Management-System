/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import util.FileUtils;
import view.MainFrame;

/**
 *
 * @author user
 */

public class GUI {
    public static void main(String[] args) {
        try {
           
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
       
        FileUtils.ensureDataDirectoryExists();
        
      
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}
