package com.bl.trainconsistmanagementapp;

import com.bl.trainconsistmanagementapp.model.GoodsBogie;

import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {


    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println(" UC12: Safety Compliance Check for Goods Bogies ");
        System.out.println("=================================================");

        // --- Scenario 1: SAFE TRAIN CONSIST ---
        System.out.println("\n--- Scenario 1: Validating Safe Train Consist ---");
        List<GoodsBogie> safeGoodsBogies = new ArrayList<>();
        safeGoodsBogies.add(new GoodsBogie("GB-101", "Cylindrical", "Petroleum", 50.0));
        safeGoodsBogies.add(new GoodsBogie("GB-102", "Box Car", "Coal", 60.0));
        safeGoodsBogies.add(new GoodsBogie("GB-103", "Cylindrical", "PET-AB", 45.0));

        // Display Goods Bogies
        safeGoodsBogies.forEach(System.out::println);

        // Convert list to Stream and apply allMatch() for safety validation
        boolean isSafeConsist = safeGoodsBogies.stream()
                .allMatch(gb -> {
                    if (gb.getBogieType().equalsIgnoreCase("Cylindrical")) {
                        return gb.getCargoType().equalsIgnoreCase("Petroleum") || gb.getCargoType().startsWith("PET-");
                    }
                    return true;
                });

        System.out.println("\nSafety Compliance Result: " + (isSafeConsist ? "TRAIN IS SAFE & COMPLIANT" : "SAFETY VIOLATION DETECTED"));

        // --- Scenario 2: UNSAFE TRAIN CONSIST (Cylindrical carrying Coal) ---
        System.out.println("\n--- Scenario 2: Validating Unsafe Train Consist ---");
        List<GoodsBogie> unsafeGoodsBogies = new ArrayList<>();
        unsafeGoodsBogies.add(new GoodsBogie("GB-201", "Cylindrical", "Petroleum", 50.0));
        unsafeGoodsBogies.add(new GoodsBogie("GB-202", "Cylindrical", "Coal", 65.0)); // UNSAFE: Cylindrical cannot carry Coal!
        unsafeGoodsBogies.add(new GoodsBogie("GB-203", "Flatcar", "Steel", 70.0));

        // Display Goods Bogies
        unsafeGoodsBogies.forEach(System.out::println);

        // Convert list to Stream and apply allMatch() for safety validation
        boolean isUnsafeConsist = unsafeGoodsBogies.stream()
                .allMatch(gb -> {
                    if (gb.getBogieType().equalsIgnoreCase("Cylindrical")) {
                        return gb.getCargoType().equalsIgnoreCase("Petroleum") || gb.getCargoType().startsWith("PET-");
                    }
                    return true;
                });

        System.out.println("\nSafety Compliance Result: " + (isUnsafeConsist ? "TRAIN IS SAFE & COMPLIANT" : "SAFETY VIOLATION DETECTED (Cylindrical carrying illegal cargo)"));

    }
}