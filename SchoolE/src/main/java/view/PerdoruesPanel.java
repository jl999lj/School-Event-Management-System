/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.PerdoruesController;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.UUID;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Perdorues;

/**
 *
 * @author user
 */
public class PerdoruesPanel extends JPanel {
    private final PerdoruesController controller;

    public PerdoruesPanel(PerdoruesController controller) {
        this.controller = controller;
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(0, 2));
        JTextField emer = new JTextField();
        JTextField mbiemer = new JTextField();
        JTextField email = new JTextField();

        inputPanel.add(new JLabel("Emri:"));
        inputPanel.add(emer);
        inputPanel.add(new JLabel("Mbiemri:"));
        inputPanel.add(mbiemer);
        inputPanel.add(new JLabel("Email:"));
        inputPanel.add(email);

        JButton shto = new JButton("Shto Përdorues");
        shto.addActionListener(e -> {
            Perdorues p = new Perdorues(
                UUID.randomUUID().toString(),
                emer.getText(),
                mbiemer.getText(),
                email.getText()
            );
            controller.addPerdorues(p);
            JOptionPane.showMessageDialog(this, "Përdoruesi u shtua me sukses!");
        });

        add(inputPanel, BorderLayout.CENTER);
        add(shto, BorderLayout.SOUTH);
    }
}
