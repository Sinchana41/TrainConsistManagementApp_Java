package com.bl.trainconsistmanagementapp;

import com.bl.trainconsistmanagementapp.model.Bogie;
import com.bl.trainconsistmanagementapp.model.GoodsBogie;
import com.bl.trainconsistmanagementapp.model.PassengerBogie;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.bl.trainconsistmanagementapp.fileio.FileIOAndPersistence.*;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println(" UC17: Persistence and File I/O for Consist");

        // 1. Prepare sample bogies
        List<Bogie> originalConsist = new ArrayList<>();
        originalConsist.add(new PassengerBogie("PB-101", "Sleeper", 72));
        originalConsist.add(new GoodsBogie("GB-201", "Cylindrical", "Petroleum", 50.0));
        originalConsist.add(new PassengerBogie("PB-102", "AC Chair", 56));
        originalConsist.add(new GoodsBogie("GB-202", "Box Car", "Coal", 65.0));

        // 2. Export/Save consist configuration to file
        System.out.println("\nStep 1: Saving Consist Data to File");
        saveConsistToFile(originalConsist, FILE_PATH);

        // 3. Import/Load consist configuration from file
        System.out.println("\nStep 2: Restoring Consist Data from File");
        List<Bogie> restoredConsist = loadConsistFromFile(FILE_PATH);

        // 4. Verify loaded records
        System.out.println("\nStep 3: Verifying Loaded Consist");
        for (int i = 0; i < restoredConsist.size(); i++) {
            System.out.printf("Position %d: %s%n", i + 1, restoredConsist.get(i));
        }

        // Clean up temporary benchmark file
        new File(FILE_PATH).deleteOnExit();
    }
}