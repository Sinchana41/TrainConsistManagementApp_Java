package com.bl.trainconsistmanagementapp;

import com.bl.trainconsistmanagementapp.exception.InvalidCapacityException;
import com.bl.trainconsistmanagementapp.model.PassengerBogie;
import com.bl.trainconsistmanagementapp.service.TrainConsist;


import static com.bl.trainconsistmanagementapp.fileio.FileIOAndPersistence.*;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("UC14: Handle Invalid Bogie Capacity");

        TrainConsist consist = new TrainConsist();

        // Scenario 1: Attempting to create a valid Passenger Bogie
        System.out.println("Scenario 1: Creating Valid Passenger Bogie");
        try {
            PassengerBogie pb1 = new PassengerBogie("PB-101", "Sleeper", 72);
            consist.addBogie(pb1);
            System.out.println("Created and Attached: " + pb1);
        } catch (InvalidCapacityException e) {
            System.out.println("Creation Failed: " + e.getMessage());
        }

        // Scenario 2: Attempting to create Bogie with ZERO capacity
        System.out.println("Scenario 2: Creating Bogie with Zero Capacity");
        try {
            PassengerBogie pb2 = new PassengerBogie("PB-102", "AC Chair", 0);
            consist.addBogie(pb2);
            System.out.println("Created and Attached: " + pb2);
        } catch (InvalidCapacityException e) {
            System.out.println("Caught Custom Exception: " + e.getMessage());
        }

        // Scenario 3: Attempting to create Bogie with NEGATIVE capacity
        System.out.println("Scenario 3: Creating Bogie with Negative Capacity");
        try {
            PassengerBogie pb3 = new PassengerBogie("PB-103", "First Class", -20);
            consist.addBogie(pb3);
            System.out.println("Created and Attached: " + pb3);
        } catch (InvalidCapacityException e) {
            System.out.println("Caught Custom Exception: " + e.getMessage());
        }

        // Final Consist Status
        System.out.println("Final Verified Train Consist");
        consist.displayConsistDetails();

    }
}