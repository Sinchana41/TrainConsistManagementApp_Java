package com.bl.trainconsistmanagementapp;

import com.bl.trainconsistmanagementapp.model.PassengerBogie;
import com.bl.trainconsistmanagementapp.service.TrainConsist;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        // Initialize Train Consist
        TrainConsist trainConsist = new TrainConsist();
        System.out.println("Initial Bogie Count: " + trainConsist.getBogieCount());

        System.out.println("\n--- UC2: Adding Bogies ---");

        // Attaching passenger bogies
        trainConsist.addBogie(new PassengerBogie("SL-101", "Sleeper", 72));
        trainConsist.addBogie(new PassengerBogie("AC-201", "AC Chair", 56));
        trainConsist.addBogie(new PassengerBogie("FC-301", "First Class", 24));

        // Display updated count and details
        System.out.println("\nUpdated Bogie Count: " + trainConsist.getBogieCount());
        trainConsist.displayConsistDetails();
    }
}
