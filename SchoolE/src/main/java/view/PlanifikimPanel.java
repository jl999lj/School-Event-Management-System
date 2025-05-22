/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.PlanifikimController;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.time.LocalTime;
import java.util.UUID;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Event;
import model.PlanifikimEventi;

/**
 *
 * @author user
 */
public class PlanifikimPanel extends JPanel {
    private final PlanifikimController controller;

    public PlanifikimPanel(PlanifikimController controller) {
        this.controller = controller;
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(0, 2));
        JTextField eventId = new JTextField();
        JTextField oraFillimi = new JTextField("09:00");
        JTextField oraMbarimi = new JTextField("10:00");

        inputPanel.add(new JLabel("ID e Eventit:"));
        inputPanel.add(eventId);
        inputPanel.add(new JLabel("Ora Fillimit (HH:mm):"));
        inputPanel.add(oraFillimi);
        inputPanel.add(new JLabel("Ora Mbarimit (HH:mm):"));
        inputPanel.add(oraMbarimi);

        JButton ruaj = new JButton("Shto Planifikim");
        ruaj.addActionListener(e -> {
            PlanifikimEventi p = new PlanifikimEventi(
                UUID.randomUUID().toString(),
                new Event(eventId.getText(), "", "", "", null, null, "", null),
                LocalTime.parse(oraFillimi.getText()),
                LocalTime.parse(oraMbarimi.getText())
            );
            controller.addPlanifikim(p);
            JOptionPane.showMessageDialog(this, "Planifikimi u ruajt me sukses!");
        });

        add(inputPanel, BorderLayout.CENTER);
        add(ruaj, BorderLayout.SOUTH);
    }
}

