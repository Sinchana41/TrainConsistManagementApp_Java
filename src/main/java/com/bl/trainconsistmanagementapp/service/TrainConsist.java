package com.bl.trainconsistmanagementapp.service;

import com.bl.trainconsistmanagementapp.model.Bogie;
import com.bl.trainconsistmanagementapp.model.GoodsBogie;
import com.bl.trainconsistmanagementapp.model.PassengerBogie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TrainConsist {

    private List<Bogie> bogies;

    public TrainConsist() {
        this.bogies = new ArrayList<>();
    }

    public int getBogieCount() {
        return bogies.size();
    }

    public void addBogie(Bogie bogie) {
        bogies.add(bogie);
        System.out.println("Attached: " + bogie.getBogieId());
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

    /**
     * UC8.1: Search for a bogie by its Unique ID.
     */
    public Optional<Bogie> findBogieById(String bogieId) {
        return bogies.stream()
                .filter(b -> b.getBogieId().equalsIgnoreCase(bogieId))
                .findFirst();
    }

    /**
     * UC8.2: Filter bogies by Category/Type (e.g., "Passenger" or "Goods").
     */
    public List<Bogie> filterByBogieType(String bogieType) {
        List<Bogie> filteredList = new ArrayList<>();
        for (Bogie bogie : bogies) {
            if (bogie.getBogieType().equalsIgnoreCase(bogieType)) {
                filteredList.add(bogie);
            }
        }
        return filteredList;
    }

    /**
     * UC8.3: Filter passenger bogies having minimum required seat capacity.
     */
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