package com.bl.trainconsistmanagementapp;

import com.bl.trainconsistmanagementapp.model.Bogie;
import com.bl.trainconsistmanagementapp.model.GoodsBogie;
import com.bl.trainconsistmanagementapp.model.PassengerBogie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {


    public static void main(String[] args) {

        System.out.println(" UC15: Data Grouping & Aggregation (Collectors)   ");

        // 1. Prepare Sample Dataset
        List<Bogie> trainConsist = new ArrayList<>();
        trainConsist.add(new PassengerBogie("PB-101", "Sleeper", 72));
        trainConsist.add(new PassengerBogie("PB-102", "AC First Class", 24));
        trainConsist.add(new PassengerBogie("PB-103", "Sleeper", 72));
        trainConsist.add(new PassengerBogie("PB-104", "AC Chair Car", 78));

        trainConsist.add(new GoodsBogie("GB-201", "Cylindrical", "Petroleum", 50.0));
        trainConsist.add(new GoodsBogie("GB-202", "Box Car", "Coal", 65.0));
        trainConsist.add(new GoodsBogie("GB-203", "Cylindrical", "Petroleum", 55.0));
        trainConsist.add(new GoodsBogie("GB-204", "Box Car", "Coal", 60.0));
        trainConsist.add(new GoodsBogie("GB-205", "Flatcar", "Steel Coils", 70.0));

        // AGGREGATION 1: Group Bogies by Bogie Type
        System.out.println("\n--- 1. Grouping Bogies by Bogie Type ---");
        Map<String, List<Bogie>> bogiesByType = trainConsist.stream()
                .collect(Collectors.groupingBy(Bogie::getBogieType));

        bogiesByType.forEach((type, list) -> {
            System.out.println("Type: [" + type + "] -> Total: " + list.size() + " bogies");
            list.forEach(b -> System.out.println("   - " + b));
        });

        // AGGREGATION 2: Count Bogie Types
        System.out.println("\n--- 2. Bogie Count Summary by Type ---");
        Map<String, Long> bogieCounts = trainConsist.stream()
                .collect(Collectors.groupingBy(Bogie::getBogieType, Collectors.counting()));

        bogieCounts.forEach((type, count) ->
                System.out.printf("   • %-15s : %d bogies%n", type, count)
        );

        // AGGREGATION 3: Total Cargo Weight Grouped by Cargo Type
        System.out.println("\n--- 3. Total Goods Cargo Weight by Cargo Type ---");
        Map<String, Double> totalWeightByCargo = trainConsist.stream()
                .filter(b -> b instanceof GoodsBogie)
                .map(b -> (GoodsBogie) b)
                .collect(Collectors.groupingBy(
                        GoodsBogie::getCargoType,
                        Collectors.summingDouble(GoodsBogie::getMaxCapacityTons)
                ));

        totalWeightByCargo.forEach((cargo, totalTons) ->
                System.out.printf("   • Cargo: %-12s | Total Capacity: %.2f Tons%n", cargo, totalTons)
        );

        // AGGREGATION 4: Average Passenger Seats by Coach Class
        System.out.println("\n--- 4. Average Passenger Capacity per Coach Class ---");
        Map<String, Double> avgSeatsByClass = trainConsist.stream()
                .filter(b -> b instanceof PassengerBogie)
                .map(b -> (PassengerBogie) b)
                .collect(Collectors.groupingBy(
                        PassengerBogie::getBogieType,
                        Collectors.averagingInt(PassengerBogie::getSeatCapacity)
                ));

        avgSeatsByClass.forEach((coachClass, avgSeats) ->
                System.out.printf("   • Class: %-15s | Avg Seat Capacity: %.1f seats%n", coachClass, avgSeats)
        );
    }
}