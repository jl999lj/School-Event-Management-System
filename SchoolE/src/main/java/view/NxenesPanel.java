/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.NxenesController;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.UUID;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Nxenes;

/**
 *
 * @author user
 */
public class NxenesPanel extends JPanel {
    private final NxenesController controller;

    public NxenesPanel(NxenesController controller) {
        this.controller = controller;
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(0, 2));
        JTextField emer = new JTextField();
        JTextField mbiemer = new JTextField();
        JTextField email = new JTextField();
        JTextField klasa = new JTextField();
        JTextField viti = new JTextField();

        inputPanel.add(new JLabel("Emri:"));
        inputPanel.add(emer);
        inputPanel.add(new JLabel("Mbiemri:"));
        inputPanel.add(mbiemer);
        inputPanel.add(new JLabel("Email:"));
        inputPanel.add(email);
        inputPanel.add(new JLabel("Klasa:"));
        inputPanel.add(klasa);
        inputPanel.add(new JLabel("Viti:"));
        inputPanel.add(viti);

        JButton shto = new JButton("Shto Nxënës");
        shto.addActionListener(e -> {
            Nxenes n = new Nxenes(
                UUID.randomUUID().toString(),
                emer.getText(),
                mbiemer.getText(),
                email.getText(),
                Integer.parseInt(klasa.getText()),
                Integer.parseInt(viti.getText())
            );
            controller.addNxenes(n);
            JOptionPane.showMessageDialog(this, "Nxënësi u shtua me sukses!");
        });

        add(inputPanel, BorderLayout.CENTER);
        add(shto, BorderLayout.SOUTH);
    }
}

