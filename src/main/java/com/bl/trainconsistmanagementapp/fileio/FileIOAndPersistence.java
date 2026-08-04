package com.bl.trainconsistmanagementapp.fileio;

import com.bl.trainconsistmanagementapp.model.Bogie;
import com.bl.trainconsistmanagementapp.model.GoodsBogie;
import com.bl.trainconsistmanagementapp.model.PassengerBogie;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileIOAndPersistence {

    public static final String FILE_PATH = "consist_data.txt";

    /**
     * Serializes and writes a list of bogies to a file.
     */
    public static void saveConsistToFile(List<Bogie> bogies, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Bogie bogie : bogies) {
                if (bogie instanceof PassengerBogie pb) {
                    writer.write(String.format("PASSENGER,%s,%s,%d%n",
                            pb.getBogieId(), pb.getBogieType(), pb.getSeatCapacity()));
                } else if (bogie instanceof GoodsBogie gb) {
                    writer.write(String.format("GOODS,%s,%s,%s,%.2f%n",
                            gb.getBogieId(), gb.getBogieType(), gb.getCargoType(), gb.getMaxCapacityTons()));
                }
            }
            System.out.println("Consist configuration successfully saved to '" + filePath + "'");
        } catch (IOException e) {
            System.err.println("Error writing consist to file: " + e.getMessage());
        }
    }

    /**
     * Reads file records and reconstructs the list of Bogie objects.
     */
    public static List<Bogie> loadConsistFromFile(String filePath) {
        List<Bogie> loadedBogies = new ArrayList<>();
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("Warning: File '" + filePath + "' not found.");
            return loadedBogies;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] tokens = line.split(",");
                String category = tokens[0];

                if ("PASSENGER".equalsIgnoreCase(category)) {
                    String id = tokens[1];
                    String type = tokens[2];
                    int seats = Integer.parseInt(tokens[3]);
                    loadedBogies.add(new PassengerBogie(id, type, seats));
                } else if ("GOODS".equalsIgnoreCase(category)) {
                    String id = tokens[1];
                    String type = tokens[2];
                    String cargo = tokens[3];
                    double capacity = Double.parseDouble(tokens[4]);
                    loadedBogies.add(new GoodsBogie(id, type, cargo, capacity));
                }
            }
            System.out.println("Successfully loaded " + loadedBogies.size() + " bogies from '" + filePath + "'");
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading consist from file: " + e.getMessage());
        }
        return loadedBogies;
    }
}
