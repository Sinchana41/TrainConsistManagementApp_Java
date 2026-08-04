package com.bl.trainconsistmanagementapp;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TrainConsistManagementApp {

    public static int searchBogie(List<String> bogieIds, String searchKey) {
        // State Validation: Check whether the bogie collection is empty before searching
        if (bogieIds == null || bogieIds.isEmpty()) {
            // Fail-Fast Principle: Stop execution immediately and throw IllegalStateException
            throw new IllegalStateException("Search Failed: Cannot perform search on an empty train consist. Please add bogies first.");
        }

        // Search logic executes only if state is valid
        for (int i = 0; i < bogieIds.size(); i++) {
            if (bogieIds.get(i).equalsIgnoreCase(searchKey)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        System.out.println(" UC20: Exception Handling During Search          ");

        System.out.println("\n--- Scenario 1: Searching in an Empty Train Consist ---");
        List<String> emptyConsist = new ArrayList<>();

        try {
            System.out.println("Triggering search for 'PB-101' in empty consist...");
            searchBogie(emptyConsist, "PB-101");
        } catch (IllegalStateException e) {
            System.out.println("CAUGHT RUNTIME EXCEPTION: " + e.getMessage());
        }

        // Scenario 2: Searching on a VALID (Non-Empty) Consist
        System.out.println("\n--- Scenario 2: Searching in a Populated Train Consist ---");
        List<String> validConsist = new ArrayList<>();
        validConsist.add("PB-101");
        validConsist.add("GB-201");
        validConsist.add("PB-102");

        System.out.println("Current Consist: " + validConsist);

        try {
            String searchKey = "GB-201";
            System.out.println("Triggering search for '" + searchKey + "'...");
            int index = searchBogie(validConsist, searchKey);

            if (index != -1) {
                System.out.println("Result: Bogie ID '" + searchKey + "' WAS FOUND at Index " + index + ".");
            } else {
                System.out.println("Result: Bogie ID '" + searchKey + "' WAS NOT FOUND.");
            }
        } catch (IllegalStateException e) {
            System.out.println("CAUGHT RUNTIME EXCEPTION: " + e.getMessage());
        }
    }
}