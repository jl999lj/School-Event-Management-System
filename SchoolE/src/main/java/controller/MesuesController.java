/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import model.Mesuesi;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */

public class MesuesController {
    private static final String FILE_PATH = "data/mesues.txt";

    public void addMesues(Mesuesi m) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            bw.write(format(m));
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Mesuesi> getAllMesues() {
        List<Mesuesi> list = new ArrayList<>();
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

    public void updateMesues(Mesuesi m) {
        List<Mesuesi> all = getAllMesues();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Mesuesi mesues : all) {
                if (mesues.getId().equals(m.getId())) {
                    bw.write(format(m));
                } else {
                    bw.write(format(mesues));
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteMesues(String id) {
        List<Mesuesi> all = getAllMesues();
        all.removeIf(m -> m.getId().equals(id));
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Mesuesi m : all) {
                bw.write(format(m));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String format(Mesuesi m) {
        return m.getId() + ";" + m.getEmer() + ";" + m.getMbiemer() + ";" + m.getEmail() + ";" + m.getLenda();
    }

    private Mesuesi parse(String line) {
        String[] parts = line.split(";");
        return new Mesuesi(parts[0], parts[1], parts[2], parts[3], parts[4]);
    }
}

