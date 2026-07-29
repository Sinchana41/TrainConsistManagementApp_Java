package com.bl.trainconsistmanagementapp;

import com.bl.trainconsistmanagementapp.model.Bogie;
import com.bl.trainconsistmanagementapp.model.PassengerBogie;
import com.bl.trainconsistmanagementapp.service.TrainConsist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TrainConsistManagementApp {

    public static void main(String[] args) {


        System.out.println(" UC7 Sort Bogies by Capacity (Comparator) ");


        // 1. Create a TrainConsist and attach PassengerBogies
        TrainConsist trainConsist = new TrainConsist();
        trainConsist.addBogie(new PassengerBogie("B1", "Sleeper", 72));
        trainConsist.addBogie(new PassengerBogie("B2", "AC Chair", 56));
        trainConsist.addBogie(new PassengerBogie("B3", "First Class", 24));
        trainConsist.addBogie(new PassengerBogie("B4", "General", 90));

        // 2. Filter passenger bogies into a separate list for sorting
        List<PassengerBogie> passengerBogies = new ArrayList<>();

        // Populate list (assuming we have access or extract via instance check)
        passengerBogies.add(new PassengerBogie("B1", "Sleeper", 72));
        passengerBogies.add(new PassengerBogie("B2", "AC Chair", 56));
        passengerBogies.add(new PassengerBogie("B3", "First Class", 24));
        passengerBogies.add(new PassengerBogie("B4", "General", 90));

        // 3. Display list before sorting
        System.out.println("\n--- Before Sorting ---");
        for (PassengerBogie pb : passengerBogies) {
            System.out.println(pb);
        }

        // 4. Sort using Comparator.comparingInt on getSeatCapacity()
        passengerBogies.sort(Comparator.comparingInt(PassengerBogie::getSeatCapacity));

        // 5. Display list after sorting
        System.out.println("\n--- After Sorting by Seat Capacity (Ascending) ---");
        for (PassengerBogie pb : passengerBogies) {
            System.out.println(pb);
        }

        System.out.println("\nUC7 sorting completed...");

    }
}
