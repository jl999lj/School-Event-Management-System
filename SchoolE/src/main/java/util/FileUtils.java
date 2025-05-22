/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.File;

/**
 *
 * @author user
 */
public class FileUtils {
     public static void ensureDataDirectoryExists() {
        File dataDir = new File("data");
        if (!dataDir.exists()) {
            if (dataDir.mkdir()) {
                System.out.println("Data directory created successfully");
            } else {
                System.err.println("Failed to create data directory");
            }
        }
        
        // Create empty files if they don't exist
        createEmptyFileIfNotExists("data/events.txt");
        createEmptyFileIfNotExists("data/mesues.txt");
        createEmptyFileIfNotExists("data/njoftime.txt");
        createEmptyFileIfNotExists("data/nxenes.txt");
        createEmptyFileIfNotExists("data/perdorues.txt");
        createEmptyFileIfNotExists("data/planifikime.txt");
    }
    
    private static void createEmptyFileIfNotExists(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("Created empty file: " + filePath);
                } else {
                    System.err.println("Failed to create file: " + filePath);
                }
            } catch (Exception e) {
                System.err.println("Error creating file " + filePath + ": " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}

