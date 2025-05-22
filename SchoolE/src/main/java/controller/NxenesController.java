/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Nxenes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */

public class NxenesController {
    private static final String FILE_PATH = "data/nxenes.txt";

    public void addNxenes(Nxenes nx) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            bw.write(format(nx));
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Nxenes> getAllNxenes() {
        List<Nxenes> list = new ArrayList<>();
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

    public void updateNxenes(Nxenes nx) {
        List<Nxenes> all = getAllNxenes();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Nxenes n : all) {
                if (n.getId().equals(nx.getId())) {
                    bw.write(format(nx));
                } else {
                    bw.write(format(n));
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteNxenes(String id) {
        List<Nxenes> all = getAllNxenes();
        all.removeIf(n -> n.getId().equals(id));
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Nxenes n : all) {
                bw.write(format(n));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String format(Nxenes n) {
        return n.getId() + ";" + n.getEmer() + ";" + n.getMbiemer() + ";" + n.getEmail() + ";" + n.getKlasa() + ";" + n.getViti();
    }

    private Nxenes parse(String line) {
        String[] parts = line.split(";");
        return new Nxenes(parts[0], parts[1], parts[2], parts[3], Integer.parseInt(parts[4]), Integer.parseInt(parts[5]));
    }
}

