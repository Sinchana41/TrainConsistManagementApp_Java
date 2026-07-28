package com.bl.trainconsistmanagementapp;

import com.bl.trainconsistmanagementapp.model.PassengerBogie;
import com.bl.trainconsistmanagementapp.service.TrainConsist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("--- UC6: Reordering and Position-Based Insertion ---");

        // 1. Initialize initial consist list
        List<String> trainConsist = new ArrayList<>();
        trainConsist.add("BG101 (Sleeper)");
        trainConsist.add("BG102 (Sleeper)");
        trainConsist.add("BG104 (AC Chair)");

        System.out.println("Initial Train Formation:");
        displayConsist(trainConsist);

        // 2. Insert Pantry Car at specific position (e.g., index 2)
        System.out.println("\nInserting 'PANTRY-01' at Position 3 (Index 2)...");
        trainConsist.add(2, "PANTRY-01 (Pantry Car)");

        // 3. Attach Engine at the front (Index 0)
        System.out.println("Attaching 'ENG-901' at the Front (Index 0)...");
        trainConsist.add(0, "ENG-901 (Locomotive)");

        // 4. Display reordered consist
        System.out.println("\n--- Updated Train Consist Formation ---");
        displayConsist(trainConsist);
    }

    private static void displayConsist(List<String> consist) {
        for (int i = 0; i < consist.size(); i++) {
            System.out.println(" Position " + (i + 1) + ": " + consist.get(i));
        }
    }
}
