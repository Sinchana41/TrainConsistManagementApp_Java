package com.bl.trainconsistmanagementapp;

import com.bl.trainconsistmanagementapp.exception.BogieNotFoundException;
import com.bl.trainconsistmanagementapp.exception.InvalidBogieException;
import com.bl.trainconsistmanagementapp.model.GoodsBogie;
import com.bl.trainconsistmanagementapp.model.PassengerBogie;
import com.bl.trainconsistmanagementapp.service.TrainConsist;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println(" UC16: Custom Exceptions & Fault Tolerance       ");
        TrainConsist consist = new TrainConsist();

        // Scenario 1: Handling Invalid Bogie Attachment
        System.out.println("\n--- Test 1: Adding Valid and Invalid Bogies ---");

        try {
            consist.addBogie(new PassengerBogie("PB-101", "Sleeper", 72));
            consist.addBogie(new GoodsBogie("GB-201", "Cylindrical", "Petroleum", 50.0));

            // Intentionally adding invalid ID format
            System.out.println("Attempting to attach invalid Bogie ID 'INVALID_ID'...");
            consist.addBogie(new PassengerBogie("INVALID_ID", "AC Chair", 56));
        } catch (InvalidBogieException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }

        consist.displayConsistDetails();

        // Scenario 2: Handling Non-Existent Bogie Search
        System.out.println("\n--- Test 2: Searching for Missing Bogie ---");

        try {
            System.out.println("Searching for Bogie 'PB-999'...");
            consist.findBogieById("PB-999");
        } catch (BogieNotFoundException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }

        // Scenario 3: Handling Non-Existent Bogie Removal
        System.out.println("\n--- Test 3: Detaching Missing Bogie ---");

        try {
            System.out.println("Attempting to detach Bogie 'GB-201'...");
            consist.removeBogieById("GB-201"); // Succeeds

            System.out.println("Attempting to detach Bogie 'GB-201' again...");
            consist.removeBogieById("GB-201"); // Fails, already removed
        } catch (BogieNotFoundException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        } finally {
            System.out.println("\n--- Final Status Verification ---");
            consist.displayConsistDetails();
        }
    }
}