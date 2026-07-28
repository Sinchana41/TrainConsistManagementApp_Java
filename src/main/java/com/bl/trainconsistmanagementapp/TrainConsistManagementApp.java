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
        System.out.println("--- UC5: Search and Remove Bogie Operations ---");

        // 1. Initialize train consist list
        List<String> trainConsist = new ArrayList<>();
        trainConsist.add("ENGINE");
        trainConsist.add("BG101");
        trainConsist.add("BG102");
        trainConsist.add("BG103");
        trainConsist.add("BG104");

        System.out.println("Initial Train Consist: " + trainConsist);

        // 2. Search for a specific Bogie ID
        String searchId = "BG103";
        if (trainConsist.contains(searchId)) {
            int position = trainConsist.indexOf(searchId);
            System.out.println("Found " + searchId + " at position (index): " + position);
        } else {
            System.out.println("Bogie " + searchId + " not found in consist.");
        }

        // 3. Remove/Detach a Bogie from the consist
        String removeId = "BG102";
        System.out.println("\n--- Detaching Bogie: " + removeId + " ---");
        boolean isRemoved = trainConsist.remove(removeId);

        if (isRemoved) {
            System.out.println("Bogie " + removeId + " detached successfully.");
        } else {
            System.out.println("Failed to detach " + removeId + " (Not found).");
        }

        // 4. Print updated train consist and summary
        System.out.println("\nUpdated Train Consist: " + trainConsist);
        System.out.println("Updated Bogie Count: " + (trainConsist.size() - 1)); // excluding ENGINE
    }
}
