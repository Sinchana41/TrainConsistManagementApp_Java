package com.bl.trainconsistmanagementapp.service;

import com.bl.trainconsistmanagementapp.model.Bogie;
import com.bl.trainconsistmanagementapp.model.GoodsBogie;
import com.bl.trainconsistmanagementapp.model.PassengerBogie;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * UC3: Polymorphic iteration to calculate total goods payload capacity.
     */
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
}