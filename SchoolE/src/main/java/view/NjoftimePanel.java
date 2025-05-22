/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.NjoftimeController;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.util.UUID;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Njoftime;
import model.Perdorues;

/**
 *
 * @author user
 */
public class NjoftimePanel extends JPanel {
    private final NjoftimeController controller;

    public NjoftimePanel(NjoftimeController controller) {
        this.controller = controller;
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(0, 2));
        JTextField permbajtja = new JTextField();
        JTextField marresiId = new JTextField();

        inputPanel.add(new JLabel("Përmbajtja e njoftimit:"));
        inputPanel.add(permbajtja);
        inputPanel.add(new JLabel("ID e marrësit:"));
        inputPanel.add(marresiId);

        JButton dergo = new JButton("Dërgo Njoftim");
        dergo.addActionListener(e -> {
            Njoftime n = new Njoftime(
                UUID.randomUUID().toString(),
                permbajtja.getText(),
                new Perdorues(marresiId.getText(), "", "", ""),
                LocalDate.now()
            );
            controller.addNjoftim(n);
            JOptionPane.showMessageDialog(this, "Njoftimi u dërgua me sukses!");
        });

        add(inputPanel, BorderLayout.CENTER);
        add(dergo, BorderLayout.SOUTH);
    }
}

