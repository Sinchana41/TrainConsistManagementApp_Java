package com.bl.trainconsistmanagementapp;


import java.util.Arrays;
import java.util.Scanner;

public class TrainConsistManagementApp {

    public static int binarySearch(String[] sortedBogieIds, String searchKey) {
        int low = 0;
        int high = sortedBogieIds.length - 1;

        // Loop until the search range is exhausted
        while (low <= high) {
            // Compute middle index safely
            int mid = low + (high - low) / 2;

            int comparisonResult = searchKey.compareToIgnoreCase(sortedBogieIds[mid]);

            if (comparisonResult == 0) {
                return mid; // Match found -> Return index
            } else if (comparisonResult > 0) {
                low = mid + 1; // Key lies in the right half -> Adjust low index
            } else {
                high = mid - 1; // Key lies in the left half -> Adjust high index
            }
        }

        return -1; // Search range exhausted, element not found
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println(" UC19: Binary Search for Bogie ID (O(log n))    ");
        System.out.println("=================================================");

        // 1. Initial unsorted list of Bogie IDs
        String[] bogieIds = {"PB-104", "GB-201", "PB-101", "GB-205", "PB-102", "GB-203"};

        // Precondition Requirement: Binary search requires sorted data
        System.out.println("\n--- Step 1: Sorting Bogie IDs (Precondition) ---");
        System.out.println("Unsorted Bogie IDs: " + Arrays.toString(bogieIds));

        Arrays.sort(bogieIds); // Ensure sorted order before searching

        System.out.println("Sorted Bogie IDs  : " + Arrays.toString(bogieIds));

        System.out.println("\nIndexed Bogies in Consist:");
        for (int i = 0; i < bogieIds.length; i++) {
            System.out.println(" Index [" + i + "] : " + bogieIds[i]);
        }

        Scanner scanner = new Scanner(System.in);

        // 2. Accept search key from user
        System.out.print("\nEnter Bogie ID to search: ");
        String searchKey = scanner.nextLine().trim();

        // 3. Perform Binary Search
        System.out.println("\nPerforming Binary Search for '" + searchKey + "'...");
        int index = binarySearch(bogieIds, searchKey);

        // 4. Output results based on search outcome
        System.out.println("-------------------------------------------------");
        if (index != -1) {
            System.out.println("Result: Bogie ID '" + searchKey + "' WAS FOUND at Index " + index + " in sorted consist.");
        } else {
            System.out.println("Result: Bogie ID '" + searchKey + "' WAS NOT FOUND in the consist.");
        }
        System.out.println("-------------------------------------------------");

        scanner.close();
    }
}