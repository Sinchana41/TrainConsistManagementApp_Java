package com.bl.trainconsistmanagementapp.service;

import com.bl.trainconsistmanagementapp.model.Bogie;

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