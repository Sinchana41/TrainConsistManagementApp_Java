package com.bl.trainconsistmanagementapp;

import com.bl.trainconsistmanagementapp.model.Bogie;
import com.bl.trainconsistmanagementapp.model.GoodsBogie;
import com.bl.trainconsistmanagementapp.model.PassengerBogie;
import com.bl.trainconsistmanagementapp.service.TrainConsist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("      UC8: Search & Filter Bogies         ");
        System.out.println("==========================================");

        TrainConsist consist = new TrainConsist();
        // 1. Setup sample train consist
        consist.addBogie(new PassengerBogie("PB-101", "Sleeper", 72));
        consist.addBogie(new GoodsBogie("GB-201", "Coal Wagon", "Coal", 60.5));
        consist.addBogie(new PassengerBogie("PB-102", "AC Chair", 56));
        consist.addBogie(new GoodsBogie("GB-202", "Tanker", "Oil", 45.0));
        consist.addBogie(new PassengerBogie("PB-103", "First Class", 24));

        System.out.println("\n------------------------------------------");
        System.out.println("1. Search Bogie by ID: 'PB-102'");
        System.out.println("------------------------------------------");
        Optional<Bogie> foundBogie = consist.findBogieById("PB-102");
        if (foundBogie.isPresent()) {
            System.out.println("Found: " + foundBogie.get());
        } else {
            System.out.println("Bogie not found.");
        }

        System.out.println("\n------------------------------------------");
        System.out.println("2. Filter Passenger Bogies with Seats >= 50");
        System.out.println("------------------------------------------");
        List<PassengerBogie> capacityFiltered = consist.filterPassengerBogiesByMinCapacity(50);
        capacityFiltered.forEach(System.out::println);

        System.out.println("\n------------------------------------------");
        System.out.println("3. Search for Non-Existent Bogie: 'PB-999'");
        System.out.println("------------------------------------------");
        Optional<Bogie> missingBogie = consist.findBogieById("PB-999");
        System.out.println("Result: " + missingBogie.orElse(null));

    }
}
