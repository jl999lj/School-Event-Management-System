/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import model.Event;
import model.Perdorues;
import java.time.LocalDate;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author user
 */
  public class EventController {
    private static final String FILE_PATH = "data/events.txt";

    public void addEvent(Event event) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            bw.write(format(event));
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                events.add(parse(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return events;
    }

    public void updateEvent(Event event) {
        List<Event> all = getAllEvents();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Event e : all) {
                if (e.getId().equals(event.getId())) {
                    bw.write(format(event));
                } else {
                    bw.write(format(e));
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteEvent(String id) {
        List<Event> all = getAllEvents();
        all.removeIf(e -> e.getId().equals(id));
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Event e : all) {
                bw.write(format(e));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String format(Event e) {
        return String.join(";",
            e.getId(),
            e.getTitull(),
            e.getPershkrimi(),
            e.getTipi(),
            e.getData().toString(),
            e.getOra().toString(),
            e.getVenddodhja(),
            e.getOrganizatori().getId()
        );
    }

    private Event parse(String line) {
        String[] parts = line.split(";");
        return new Event(
            parts[0], parts[1], parts[2], parts[3],
            LocalDate.parse(parts[4]),
            LocalTime.parse(parts[5]),
            parts[6],
            new Perdorues(parts[7], "", "", "")
        );
    }
}
