package com.bl.trainconsistmanagementapp;


import java.util.Arrays;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println(" UC17: Sort Bogie Names Using Arrays.sort()      ");

        // 1. Array of unsorted bogie type names
        String[] bogieTypes = {
                "Sleeper",
                "AC Chair Car",
                "Cylindrical",
                "Box Car",
                "First Class",
                "Flatcar",
                "Pantry Car"
        };

        // 2. Display initial unsorted state using Arrays.toString()
        System.out.println("\nInitial Bogie Types (Unsorted):");
        System.out.println(Arrays.toString(bogieTypes));

        // 3. Perform sorting using Java's built-in optimized Arrays.sort()
        System.out.println("\nSorting bogie types alphabetically using Arrays.sort()...");
        Arrays.sort(bogieTypes);

        // 4. Display sorted result (Natural Alphabetical Order)
        System.out.println("\nSorted Bogie Types (Alphabetical Order):");
        System.out.println(Arrays.toString(bogieTypes));
    }
}