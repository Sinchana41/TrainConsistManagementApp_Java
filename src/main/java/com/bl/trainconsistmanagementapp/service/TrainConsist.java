package com.bl.trainconsistmanagementapp.service;

import com.bl.trainconsistmanagementapp.exception.BogieNotFoundException;
import com.bl.trainconsistmanagementapp.exception.InvalidBogieException;
import com.bl.trainconsistmanagementapp.model.Bogie;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TrainConsist {

    private final List<Bogie> bogies = new ArrayList<>();
    private static final Pattern BOGIE_ID_PATTERN = Pattern.compile("^[A-Z]{2}-\\d{3,4}$");

    /**
     * UC16: Validates and attaches a bogie. Throws InvalidBogieException if validation fails.
     */
    public void addBogie(Bogie bogie) throws InvalidBogieException {
        if (bogie == null) {
            throw new InvalidBogieException("Bogie object cannot be null.");
        }
        if (bogie.getBogieId() == null || !BOGIE_ID_PATTERN.matcher(bogie.getBogieId()).matches()) {
            throw new InvalidBogieException("Invalid Bogie ID format: [" + bogie.getBogieId() + "]. Expected format: XX-101");
        }
        bogies.add(bogie);
        System.out.println("Successfully Attached: " + bogie.getBogieId());
    }

    /**
     * UC16: Searches for a bogie by ID. Throws BogieNotFoundException if not present.
     */
    public Bogie findBogieById(String bogieId) throws BogieNotFoundException {
        return bogies.stream()
                .filter(b -> b.getBogieId().equalsIgnoreCase(bogieId))
                .findFirst()
                .orElseThrow(() -> new BogieNotFoundException("Bogie with ID '" + bogieId + "' was not found in the consist."));
    }

    /**
     * UC16: Removes a bogie by ID. Throws BogieNotFoundException if target missing.
     */
    public void removeBogieById(String bogieId) throws BogieNotFoundException {
        Bogie bogie = findBogieById(bogieId);
        bogies.remove(bogie);
        System.out.println("Successfully Detached Bogie: " + bogieId);
    }

    public void displayConsistDetails() {
        System.out.println("\n--- Current Train Consist Details ---");
        if (bogies.isEmpty()) {
            System.out.println("No bogies attached.");
        } else {
            for (int i = 0; i < bogies.size(); i++) {
                System.out.printf("Position %d: %s%n", i + 1, bogies.get(i));
            }
        }
    }
}