package com.bl.trainconsistmanagementapp.service;

import com.bl.trainconsistmanagementapp.model.Bogie;
import com.bl.trainconsistmanagementapp.model.GoodsBogie;
import com.bl.trainconsistmanagementapp.model.PassengerBogie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TrainConsist {

    private List<Bogie> bogies;

    // UC11: Regex Patterns for Validation
    private static final String BOGIE_ID_REGEX = "^[A-Z]{2}-\\d{3,4}$";
    private static final Pattern BOGIE_ID_PATTERN = Pattern.compile(BOGIE_ID_REGEX);

    public TrainConsist() {
        this.bogies = new ArrayList<>();
    }

    public int getBogieCount() {
        return bogies.size();
    }

    /**
     * UC11: Validates Bogie ID format (e.g., PB-101, GB-2001) using Matcher.
     */
    public boolean isValidBogieId(String bogieId) {
        if (bogieId == null) return false;
        Matcher matcher = BOGIE_ID_PATTERN.matcher(bogieId);
        return matcher.matches();
    }

    public void addBogie(Bogie bogie) {
        if (bogie != null && isValidBogieId(bogie.getBogieId())) {
            bogies.add(bogie);
            System.out.println("Attached: " + bogie.getBogieId());
        } else {
            String id = (bogie != null) ? bogie.getBogieId() : "null";
            System.out.println("Rejected: Invalid Bogie ID format -> [" + id + "]");
        }
    }

    public int getTotalPassengerCapacity() {
        int totalSeats = 0;
        for (Bogie bogie : bogies) {
            if (bogie instanceof PassengerBogie pb) {
                totalSeats += pb.getSeatCapacity();
            }
        }
        return totalSeats;
    }

    public double getTotalGoodsCapacity() {
        double totalCapacity = 0;
        for (Bogie bogie : bogies) {
            if (bogie instanceof GoodsBogie gb) {
                totalCapacity += gb.getMaxCapacityTons();
            }
        }
        return totalCapacity;
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

    // ==========================================
    // USE CASE 8: Search & Filter Functionality
    // ==========================================

    public Optional<Bogie> findBogieById(String bogieId) {
        return bogies.stream()
                .filter(b -> b.getBogieId().equalsIgnoreCase(bogieId))
                .findFirst();
    }

    public List<Bogie> filterByBogieType(String bogieType) {
        List<Bogie> filteredList = new ArrayList<>();
        for (Bogie bogie : bogies) {
            if (bogie.getBogieType().equalsIgnoreCase(bogieType)) {
                filteredList.add(bogie);
            }
        }
        return filteredList;
    }

    public List<PassengerBogie> filterPassengerBogiesByMinCapacity(int minSeats) {
        List<PassengerBogie> result = new ArrayList<>();
        for (Bogie bogie : bogies) {
            if (bogie instanceof PassengerBogie pb && pb.getSeatCapacity() >= minSeats) {
                result.add(pb);
            }
        }
        return result;
    }

    public Map<String, List<Bogie>> groupBogiesByType() {
        return bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getBogieType));
    }
}