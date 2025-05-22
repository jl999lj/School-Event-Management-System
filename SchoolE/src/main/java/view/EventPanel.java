/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.EventController;
import controller.PerdoruesController;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import model.Event;
import model.Perdorues;

/**
 *
 * @author user
 */
public class EventPanel extends JPanel {
    private final EventController controller;
    private final JList<Event> eventList;
    private final DefaultListModel<Event> listModel;
    private final JButton registerButton;
    private final PerdoruesController perdoruesController = new PerdoruesController();

    public EventPanel(EventController controller) {
        this.controller = controller;
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(0, 2));
        JTextField titull = new JTextField();
        JTextField pershkrimi = new JTextField();
        JTextField tipi = new JTextField();
        JTextField data = new JTextField("2025-01-01");
        JTextField ora = new JTextField("10:00");
        JTextField vendndodhja = new JTextField();
        JTextField organizatoriId = new JTextField();

        inputPanel.add(new JLabel("Titulli:"));
        inputPanel.add(titull);
        inputPanel.add(new JLabel("Përshkrimi:"));
        inputPanel.add(pershkrimi);
        inputPanel.add(new JLabel("Tipi:"));
        inputPanel.add(tipi);
        inputPanel.add(new JLabel("Data (yyyy-MM-dd):"));
        inputPanel.add(data);
        inputPanel.add(new JLabel("Ora (HH:mm):"));
        inputPanel.add(ora);
        inputPanel.add(new JLabel("Vendndodhja:"));
        inputPanel.add(vendndodhja);
        inputPanel.add(new JLabel("ID e organizatorit:"));
        inputPanel.add(organizatoriId);

        JButton ruaj = new JButton("Shto Event");
        ruaj.addActionListener(e -> {
            try {
                Event event = new Event(
                    UUID.randomUUID().toString(),
                    titull.getText(),
                    pershkrimi.getText(),
                    tipi.getText(),
                    LocalDate.parse(data.getText()),
                    LocalTime.parse(ora.getText()),
                    vendndodhja.getText(),
                    new Perdorues(organizatoriId.getText(), "", "", "")
                );
                controller.addEvent(event);
                refreshEventList();
                JOptionPane.showMessageDialog(this, "Eventi u ruajt me sukses!");
                
              
                titull.setText("");
                pershkrimi.setText("");
                tipi.setText("");
                data.setText("2025-01-01");
                ora.setText("10:00");
                vendndodhja.setText("");
                organizatoriId.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Gabim në ruajtjen e eventit: " + ex.getMessage(), 
                    "Gabim", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });

       
        listModel = new DefaultListModel<>();
        eventList = new JList<>(listModel);
        eventList.setCellRenderer(new EventListCellRenderer());
        JScrollPane scrollPane = new JScrollPane(eventList);
        
   
        registerButton = new JButton("Regjistrohu në Event");
        registerButton.addActionListener(e -> registerForEvent());
        
   
        JButton refreshButton = new JButton("Rifresko Listën");
        refreshButton.addActionListener(e -> refreshEventList());
        
  
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(ruaj);
        buttonPanel.add(registerButton);
        buttonPanel.add(refreshButton);
   
        JSplitPane splitPane = new JSplitPane(
            JSplitPane.VERTICAL_SPLIT,
            new JScrollPane(inputPanel),
            scrollPane
        );
        splitPane.setDividerLocation(200);
        
        add(splitPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
       
        refreshEventList();
    }
    
    private void refreshEventList() {
        listModel.clear();
        try {
            List<Event> events = controller.getAllEvents();
            for (Event event : events) {
                listModel.addElement(event);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Gabim në ngarkimin e eventeve: " + ex.getMessage(),
                "Gabim", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    
    private void registerForEvent() {
        Event selectedEvent = eventList.getSelectedValue();
        if (selectedEvent == null) {
            JOptionPane.showMessageDialog(this, "Ju lutemi zgjidhni një event për t'u regjistruar");
            return;
        }
        
       
        List<Perdorues> users = perdoruesController.getAllPerdorues();
        if (users.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Nuk ka përdorues të regjistruar. Ju lutemi krijoni një përdorues të ri.");
            return;
        }
        
        Perdorues[] userArray = users.toArray(new Perdorues[0]);
        Perdorues selectedUser = (Perdorues) JOptionPane.showInputDialog(
            this,
            "Zgjidhni përdoruesin që dëshiron të regjistrohet:",
            "Regjistrim në Event",
            JOptionPane.QUESTION_MESSAGE,
            null,
            userArray,
            userArray[0]
        );
        
        if (selectedUser != null) {
            
            selectedEvent.getPjesmarres().add(selectedUser);
            controller.updateEvent(selectedEvent);
            JOptionPane.showMessageDialog(this, 
                "Përdoruesi u regjistrua me sukses në event!");
        }
    }
    

    class EventListCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(
                JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            
            if (value instanceof Event) {
                Event event = (Event) value;
                setText(event.getTitull() + " - " + event.getData() + " " + event.getOra() + 
                       " në " + event.getVenddodhja());
            }
            
            return this;
        }
    }
}