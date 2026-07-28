package com.bl.trainconsistmanagementapp;

import com.bl.trainconsistmanagementapp.service.TrainConsist;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("Welcome to Train Consist Management App");

        System.out.println("Train initialized successfully");
        TrainConsist trainConsist = new TrainConsist();

        System.out.println("Initial Bogie Count: " + trainConsist.getBogieCount());

    }
}
