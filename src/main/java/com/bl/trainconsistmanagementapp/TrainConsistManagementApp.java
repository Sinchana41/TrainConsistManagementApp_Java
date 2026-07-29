package com.bl.trainconsistmanagementapp;

import com.bl.trainconsistmanagementapp.model.Bogie;
import com.bl.trainconsistmanagementapp.model.GoodsBogie;
import com.bl.trainconsistmanagementapp.model.PassengerBogie;
import com.bl.trainconsistmanagementapp.service.TrainConsist;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("   UC9: Group Bogies by Type (groupingBy) ");
        System.out.println("==========================================");

        // 1. Setup TrainConsist with various bogies
        TrainConsist consist = new TrainConsist();
        consist.addBogie(new PassengerBogie("PB-101", "Sleeper", 72));
        consist.addBogie(new PassengerBogie("PB-102", "AC Chair", 56));
        consist.addBogie(new GoodsBogie("GB-201", "Coal Wagon", "Coal", 60.5));
        consist.addBogie(new PassengerBogie("PB-103", "Sleeper", 72));
        consist.addBogie(new GoodsBogie("GB-202", "Tanker", "Oil", 45.0));
        consist.addBogie(new PassengerBogie("PB-104", "AC Chair", 56));

        System.out.println("\n--- Processing Grouping via Stream Pipeline ---");

        // 2. Convert list to stream and apply Collectors.groupingBy
        Map<String, List<Bogie>> groupedBogies = consist.groupBogiesByType();

        // 3. Display the grouped result structured by category/type
        System.out.println("\n==========================================");
        System.out.println("         GROUPED BOGIE REPORT             ");
        System.out.println("==========================================");

        groupedBogies.forEach((type, bogieList) -> {
            System.out.printf("\nCategory / Type: [%s] (Total: %d)%n", type, bogieList.size());
            System.out.println("------------------------------------------");
            for (Bogie bogie : bogieList) {
                System.out.println(" -> " + bogie);
            }
        });

    }
}
