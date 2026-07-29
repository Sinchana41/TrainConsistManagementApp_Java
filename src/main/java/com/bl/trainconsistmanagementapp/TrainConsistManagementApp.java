package com.bl.trainconsistmanagementapp;

import com.bl.trainconsistmanagementapp.model.Bogie;
import com.bl.trainconsistmanagementapp.model.GoodsBogie;
import com.bl.trainconsistmanagementapp.model.PassengerBogie;
import com.bl.trainconsistmanagementapp.service.TrainConsist;

import java.util.*;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("   UC10: Count Total Seats (Stream.reduce)");
        System.out.println("==========================================");

        // 1. Create a list of Bogie objects
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new PassengerBogie("PB-101", "Sleeper", 72));
        bogies.add(new GoodsBogie("GB-201", "Coal Wagon", "Coal", 60.5));
        bogies.add(new PassengerBogie("PB-102", "AC Chair", 56));
        bogies.add(new PassengerBogie("PB-103", "First Class", 24));
        bogies.add(new GoodsBogie("GB-202", "Tanker", "Oil", 45.0));
        bogies.add(new PassengerBogie("PB-104", "General", 90));

        System.out.println("\n--- Current Bogies in Train ---");
        bogies.forEach(System.out::println);

        // 2. Stream pipeline: filter passenger bogies, map to capacity, and reduce to sum
        int totalSeatingCapacity = bogies.stream()
                .filter(b -> b instanceof PassengerBogie)
                .map(b -> ((PassengerBogie) b).getSeatCapacity())
                .reduce(0, Integer::sum);

        // 3. Display the aggregated total capacity result
        System.out.println("\n==========================================");
        System.out.println("       TRAIN CAPACITY ANALYTICS REPORT    ");
        System.out.println("==========================================");
        System.out.printf("Total Passenger Seating Capacity : %d seats%n", totalSeatingCapacity);
        System.out.println("==========================================");

        System.out.println("\nUC10 execution complete.");
    }
}
