package com.bl.trainconsistmanagementapp;


public class TrainConsistManagementApp {
    public static void bubbleSort(int[] capacities) {
        int n = capacities.length;

        // Outer loop: Controls the number of passes over the array
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // Optimization flag to stop early if already sorted

            // Inner loop: Compares adjacent elements and swaps if out of order
            for (int j = 0; j < n - 1 - i; j++) {
                if (capacities[j] > capacities[j + 1]) {
                    // Swapping Logic using a temporary variable
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;

                    swapped = true;
                }
            }

            // If no elements were swapped during a pass, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * Utility method to print array elements in a single line.
     */
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {

        System.out.println(" UC16: Sort Passenger Bogies (Bubble Sort)       ");

        // 1. Unsorted array of passenger bogie capacities
        int[] capacities = {72, 24, 108, 56, 18, 90, 36};

        // 2. Display initial unsorted state
        System.out.print("\nInitial Unsorted Capacities : ");
        printArray(capacities);

        // 3. Perform manual Bubble Sort
        System.out.println("\nSorting capacities using Bubble Sort algorithm...");
        bubbleSort(capacities);

        // 4. Display final sorted state
        System.out.print("\nSorted Capacities (Ascending) : ");
        printArray(capacities);

    }
}