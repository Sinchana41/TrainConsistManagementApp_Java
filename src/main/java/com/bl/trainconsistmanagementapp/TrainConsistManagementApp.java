package com.bl.trainconsistmanagementapp;

import com.bl.trainconsistmanagementapp.model.PassengerBogie;
import com.bl.trainconsistmanagementapp.service.TrainConsist;

import java.util.HashMap;
import java.util.Map;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("--- UC4: Mapping Bogie IDs to Bogie Types ---");

        // 1. Create a HashMap to store key-value pairs (Bogie ID -> Bogie Type)
        Map<String, String> bogieTypeMap = new HashMap<>();

        // 2. Add bogie ID mappings
        bogieTypeMap.put("BG101", "Sleeper");
        bogieTypeMap.put("BG102", "AC Chair");
        bogieTypeMap.put("BG103", "First Class");
        bogieTypeMap.put("BG104", "Goods Rectangular");

        // 3. Display all mapped bogies
        System.out.println("\n--- Registered Bogie Mappings ---");
        for (Map.Entry<String, String> entry : bogieTypeMap.entrySet()) {
            System.out.println("Bogie ID: " + entry.getKey() + " | Type: " + entry.getValue());
        }

        // 4. Lookup a specific bogie by ID (O(1) fast lookup)
        String lookupId = "BG102";
        System.out.println("\n--- Fast Lookup Demo ---");
        if (bogieTypeMap.containsKey(lookupId)) {
            System.out.println("Details for " + lookupId + ": " + bogieTypeMap.get(lookupId));
        } else {
            System.out.println("Bogie ID " + lookupId + " not found.");
        }
    }
}
