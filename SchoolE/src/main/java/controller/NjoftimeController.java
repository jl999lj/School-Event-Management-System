/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Njoftime;
import model.Perdorues;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */

public class NjoftimeController {
    private static final String FILE_PATH = "data/njoftime.txt";

    public void addNjoftim(Njoftime n) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            bw.write(format(n));
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Njoftime> getAllNjoftime() {
        List<Njoftime> list = new ArrayList<>();
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

    public void updateNjoftim(Njoftime n) {
        List<Njoftime> all = getAllNjoftime();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Njoftime nj : all) {
                if (nj.getId().equals(n.getId())) {
                    bw.write(format(n));
                } else {
                    bw.write(format(nj));
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteNjoftim(String id) {
        List<Njoftime> all = getAllNjoftime();
        all.removeIf(n -> n.getId().equals(id));
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Njoftime n : all) {
                bw.write(format(n));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String format(Njoftime n) {
        return n.getId() + ";" + n.getPermbajta() + ";" + n.getMarres().getId() + ";" + n.getDataDergimit();
    }

    private Njoftime parse(String line) {
        String[] parts = line.split(";");
        return new Njoftime(parts[0], parts[1], new Perdorues(parts[2], "", "", ""), LocalDate.parse(parts[3]));
    }
}
