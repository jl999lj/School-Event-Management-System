/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.MesuesController;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.UUID;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Mesuesi;

/**
 *
 * @author user
 */
public class MesuesPanel extends JPanel {
    private final MesuesController controller;

    public MesuesPanel(MesuesController controller) {
        this.controller = controller;
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(0, 2));
        JTextField emer = new JTextField();
        JTextField mbiemer = new JTextField();
        JTextField email = new JTextField();
        JTextField lenda = new JTextField();

        inputPanel.add(new JLabel("Emri:"));
        inputPanel.add(emer);
        inputPanel.add(new JLabel("Mbiemri:"));
        inputPanel.add(mbiemer);
        inputPanel.add(new JLabel("Email:"));
        inputPanel.add(email);
        inputPanel.add(new JLabel("Lënda:"));
        inputPanel.add(lenda);

        JButton shto = new JButton("Shto Mësues");
        shto.addActionListener(e -> {
            Mesuesi m = new Mesuesi(
                UUID.randomUUID().toString(),
                emer.getText(),
                mbiemer.getText(),
                email.getText(),
                lenda.getText()
            );
            controller.addMesues(m);
            JOptionPane.showMessageDialog(this, "Mësuesi u shtua me sukses!");
        });

        add(inputPanel, BorderLayout.CENTER);
        add(shto, BorderLayout.SOUTH);
    }
}
