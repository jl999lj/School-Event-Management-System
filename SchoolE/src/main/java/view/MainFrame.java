/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.EventController;
import controller.MesuesController;
import controller.NjoftimeController;
import controller.NxenesController;
import controller.PerdoruesController;
import controller.PlanifikimController;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import util.FileUtils;

/**
 *
 * @author user
 */
public class MainFrame extends JFrame {
    public MainFrame() {
        // Initialize data directory and files
        FileUtils.ensureDataDirectoryExists();
        
        setTitle("Menaxhimi i Eventeve Shkollore");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Evente", new EventPanel(new EventController()));
        tabbedPane.addTab("Planifikime", new PlanifikimPanel(new PlanifikimController()));
        tabbedPane.addTab("Njoftime", new NjoftimePanel(new NjoftimeController()));
        tabbedPane.addTab("Përdorues", new PerdoruesPanel(new PerdoruesController()));
        tabbedPane.addTab("Nxënës", new NxenesPanel(new NxenesController()));
        tabbedPane.addTab("Mësues", new MesuesPanel(new MesuesController()));

        add(tabbedPane);
        setVisible(true);
    }
}
