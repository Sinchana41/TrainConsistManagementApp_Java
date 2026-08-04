package com.bl.trainconsistmanagementapp;

import com.bl.trainconsistmanagementapp.exception.CargoSafetyException;
import com.bl.trainconsistmanagementapp.model.GoodsBogie;

public class TrainConsistManagementApp {

        /**
         * Helper method demonstrating structured try-catch-finally error handling.
         */
        public static void processCargoAssignment(GoodsBogie bogie, String cargoType) {
            System.out.println("-------------------------------------------------");
            try {
                // Operation that might throw CargoSafetyException
                bogie.assignCargo(cargoType);
            } catch (CargoSafetyException e) {
                // Catch and handle runtime exception gracefully
                System.out.println("CAUGHT RUNTIME EXCEPTION: " + e.getMessage());
            } finally {
                // Mandatory completion log/cleanup that runs regardless of outcome
                System.out.println("[FINALLY BLOCK]: Completed safety check audit log for " + bogie.getBogieId());
            }
        }

        public static void main(String[] args) {
            System.out.println(" UC15: Safe Cargo Assignment (try-catch-finally) ");

            // Prepare Goods Bogies
            GoodsBogie cylindricalTanker = new GoodsBogie("GB-201", "Cylindrical", "Empty", 50.0);
            GoodsBogie rectangularBoxCar = new GoodsBogie("GB-202", "Box Car", "Empty", 65.0);

            // Scenario 1: Safe Assignment (Petroleum -> Cylindrical Bogie)
            System.out.println("\n--- Scenario 1: Valid Cargo Assignment ---");
            processCargoAssignment(cylindricalTanker, "Petroleum");

            // Scenario 2: Unsafe Assignment (Petroleum -> Rectangular/Box Car Bogie)
            System.out.println("\n--- Scenario 2: Unsafe Cargo Assignment (Triggers Exception) ---");
            processCargoAssignment(rectangularBoxCar, "Petroleum");

            // Scenario 3: Safe Assignment for Box Car (Coal -> Box Car)
            System.out.println("\n--- Scenario 3: Valid Cargo Assignment for Box Car ---");
            processCargoAssignment(rectangularBoxCar, "Coal");

    }
}