/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import model.Event;
import model.PlanifikimEventi;

import java.io.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */

public class PlanifikimController {
    private static final String FILE_PATH = "data/planifikime.txt";

    public void addPlanifikim(PlanifikimEventi p) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            bw.write(format(p));
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<PlanifikimEventi> getAllPlanifikime() {
        List<PlanifikimEventi> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(parse(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updatePlanifikim(PlanifikimEventi p) {
        List<PlanifikimEventi> all = getAllPlanifikime();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (PlanifikimEventi pe : all) {
                if (pe.getId().equals(p.getId())) {
                    bw.write(format(p));
                } else {
                    bw.write(format(pe));
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deletePlanifikim(String id) {
        List<PlanifikimEventi> all = getAllPlanifikime();
        all.removeIf(p -> p.getId().equals(id));
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (PlanifikimEventi p : all) {
                bw.write(format(p));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String format(PlanifikimEventi p) {
        return p.getId() + ";" + p.getEvent().getId() + ";" + p.getOraFillimi() + ";" + p.getOraMbarimit();
    }

    private PlanifikimEventi parse(String line) {
        String[] parts = line.split(";");
        return new PlanifikimEventi(parts[0], new Event(parts[1], "", "", "", null, null, "", null), LocalTime.parse(parts[2]), LocalTime.parse(parts[3]));
    }
}
