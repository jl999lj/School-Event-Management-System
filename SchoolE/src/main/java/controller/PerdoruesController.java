/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import model.Perdorues;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */

public class PerdoruesController {
    private static final String FILE_PATH = "data/perdorues.txt";

    public void addPerdorues(Perdorues p) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            bw.write(format(p));
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Perdorues> getAllPerdorues() {
        List<Perdorues> list = new ArrayList<>();
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

    public void updatePerdorues(Perdorues p) {
        List<Perdorues> all = getAllPerdorues();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Perdorues perdorues : all) {
                if (perdorues.getId().equals(p.getId())) {
                    bw.write(format(p));
                } else {
                    bw.write(format(perdorues));
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deletePerdorues(String id) {
        List<Perdorues> all = getAllPerdorues();
        all.removeIf(p -> p.getId().equals(id));
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Perdorues p : all) {
                bw.write(format(p));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String format(Perdorues p) {
        return p.getId() + ";" + p.getEmer() + ";" + p.getMbiemer() + ";" + p.getEmail();
    }

    private Perdorues parse(String line) {
        String[] parts = line.split(";");
        return new Perdorues(parts[0], parts[1], parts[2], parts[3]);
    }
}
