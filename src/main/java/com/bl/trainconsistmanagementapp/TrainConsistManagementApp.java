package com.bl.trainconsistmanagementapp;

import com.bl.trainconsistmanagementapp.model.PassengerBogie;
import com.bl.trainconsistmanagementapp.service.TrainConsist;

import java.util.HashSet;
import java.util.Set;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        // Welcome Message
        System.out.println("=== Train Consist Management App ===");
        System.out.println("--- UC3: Tracking Unique Bogie IDs ---");

        // Requirement 1: Create a HashSet<String> for bogie IDs
        Set<String> bogieIds = new HashSet<>();

        // Requirement 2: Add bogie IDs, including duplicate values intentionally
        System.out.println("Adding BG101...");
        bogieIds.add("BG101");

        System.out.println("Adding BG102...");
        bogieIds.add("BG102");

        System.out.println("Adding BG103...");
        bogieIds.add("BG103");

        // Adding intentional duplicates
        System.out.println("Adding duplicate BG101...");
        bogieIds.add("BG101");

        System.out.println("Adding duplicate BG102...");
        bogieIds.add("BG102");

        // Requirement 3 & 4: Print the final set and observe duplicate removal
        System.out.println("\n--- Unique Bogie IDs Summary ---");
        System.out.println("Final Bogie IDs Set: " + bogieIds);
        System.out.println("Unique Bogie Count: " + bogieIds.size());
    }
}
