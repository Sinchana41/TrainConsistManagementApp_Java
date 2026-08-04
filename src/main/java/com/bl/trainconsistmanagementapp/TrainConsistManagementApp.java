package com.bl.trainconsistmanagementapp;


import java.util.Scanner;

public class TrainConsistManagementApp {

    public static int linearSearch(String[] bogieIds, String searchKey) {
        // Sequential Traversal from index 0 to length - 1
        for (int i = 0; i < bogieIds.length; i++) {
            // Equality Comparison using equalsIgnoreCase for safe string comparison
            if (bogieIds[i].equalsIgnoreCase(searchKey)) {
                return i; // Match found -> Early Termination
            }
        }
        return -1; // Traversing completed without finding a match
    }

    public static void main(String[] args) {

        System.out.println(" UC18: Linear Search for Bogie ID                ");

        // 1. Unsorted list of Bogie IDs in the train consist
        String[] bogieIds = {"PB-104", "GB-201", "PB-101", "GB-205", "PB-102", "GB-203"};

        System.out.println("\nAvailable Bogies in Consist:");
        for (int i = 0; i < bogieIds.length; i++) {
            System.out.println(" Index [" + i + "] : " + bogieIds[i]);
        }

        Scanner scanner = new Scanner(System.in);

        // 2. User provides search key
        System.out.print("\nEnter Bogie ID to search: ");
        String searchKey = scanner.nextLine().trim();

        // 3. Execute Linear Search algorithm
        System.out.println("\nTraversing array sequentially for '" + searchKey + "'...");
        int index = linearSearch(bogieIds, searchKey);

        // 4. Output results based on search outcome
        System.out.println("-------------------------------------------------");
        if (index != -1) {
            System.out.println("Result: Bogie ID '" + searchKey + "' WAS FOUND at Position/Index " + index + ".");
        } else {
            System.out.println("Result: Bogie ID '" + searchKey + "' WAS NOT FOUND in the consist.");
        }
        System.out.println("-------------------------------------------------");

        scanner.close();

    }

}