package com.bl.trainconsistmanagementapp;

import com.bl.trainconsistmanagementapp.model.GoodsBogie;
import com.bl.trainconsistmanagementapp.model.PassengerBogie;
import com.bl.trainconsistmanagementapp.service.TrainConsist;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrainConsistManagementApp {

    // UC11 Regex Patterns
    private static final String TRAIN_ID_REGEX = "^TRN-\\d{4}$";
    private static final String CARGO_CODE_REGEX = "^PET-[A-Z]{2}$";

    private static final Pattern TRAIN_ID_PATTERN = Pattern.compile(TRAIN_ID_REGEX);
    private static final Pattern CARGO_CODE_PATTERN = Pattern.compile(CARGO_CODE_REGEX);

    /**
     * UC11: Validates Train ID format (e.g., TRN-1234)
     */
    public static boolean validateTrainId(String trainId) {
        if (trainId == null) return false;
        Matcher matcher = TRAIN_ID_PATTERN.matcher(trainId);
        return matcher.matches();
    }

    /**
     * UC11: Validates Cargo Code format (e.g., PET-AB)
     */
    public static boolean validateCargoCode(String cargoCode) {
        if (cargoCode == null) return false;
        Matcher matcher = CARGO_CODE_PATTERN.matcher(cargoCode);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println(" UC11: Validate Train ID & Cargo Codes (Regex)  ");
        System.out.println("=================================================");

        // 1. Validate Train IDs
        String[] testTrainIds = {"TRN-1234", "TRAIN12", "TRN12A", "TRN-9876"};
        System.out.println("\n--- Validating Train IDs ---");
        for (String id : testTrainIds) {
            boolean isValid = validateTrainId(id);
            System.out.printf("Train ID [%s] -> %s%n", id, isValid ? "VALID" : "INVALID");
        }

        // 2. Validate Cargo Codes
        String[] testCargoCodes = {"PET-AB", "PET-12", "PET-XYZ", "PET-CD"};
        System.out.println("\n--- Validating Cargo Codes ---");
        for (String code : testCargoCodes) {
            boolean isValid = validateCargoCode(code);
            System.out.printf("Cargo Code [%s] -> %s%n", code, isValid ? "VALID" : "INVALID");
        }

        // 3. Test Bogie Validation inside TrainConsist
        System.out.println("\n--- Testing Bogie Attachment Validation ---");
        TrainConsist consist = new TrainConsist();

        // Valid Bogies
        consist.addBogie(new PassengerBogie("PB-101", "Sleeper", 72));
        consist.addBogie(new GoodsBogie("GB-201", "Tanker", "PET-AB", 45.0));

        // Invalid Bogie IDs (rejected by regex check)
        consist.addBogie(new PassengerBogie("PASS12", "AC Chair", 56));
        consist.addBogie(new GoodsBogie("101-GB", "Coal Wagon", "Coal", 60.0));

        consist.displayConsistDetails();
    }
}