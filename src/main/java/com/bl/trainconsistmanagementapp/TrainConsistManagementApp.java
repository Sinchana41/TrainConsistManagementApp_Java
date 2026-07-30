package com.bl.trainconsistmanagementapp;

import com.bl.trainconsistmanagementapp.model.Bogie;
import com.bl.trainconsistmanagementapp.model.GoodsBogie;
import com.bl.trainconsistmanagementapp.model.PassengerBogie;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {


    public static void main(String[] args) {
        System.out.println(" UC13: Performance Comparison (Loops vs Streams) ");

        // 1. Prepare a large dataset of Bogie objects for realistic benchmarking
        List<Bogie> testBogies = new ArrayList<>();
        int dataSize = 100_000; // 100k records

        System.out.println("\nGenerating " + dataSize + " sample bogies...");
        for (int i = 0; i < dataSize; i++) {
            if (i % 2 == 0) {
                testBogies.add(new PassengerBogie("PB-" + i, "Sleeper", 72));
            } else {
                testBogies.add(new GoodsBogie("GB-" + i, "Box Car", "Coal", 60.0));
            }
        }

        // 2. Benchmarking Loop-Based Filtering
        long loopStartTime = System.nanoTime();

        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : testBogies) {
            if (b instanceof PassengerBogie pb && pb.getSeatCapacity() >= 50) {
                loopFiltered.add(pb);
            }
        }

        long loopEndTime = System.nanoTime();
        long loopDuration = loopEndTime - loopStartTime;

        System.out.println("\n--- Loop-Based Processing ---");
        System.out.println("Filtered Items Count : " + loopFiltered.size());
        System.out.println("Execution Time (ns)  : " + loopDuration + " ns");
        System.out.printf("Execution Time (ms)  : %.3f ms%n", loopDuration / 1_000_000.0);

        // 3. Benchmarking Stream-Based Filtering
        long streamStartTime = System.nanoTime();

        List<Bogie> streamFiltered = testBogies.stream()
                .filter(b -> b instanceof PassengerBogie)
                .filter(b -> ((PassengerBogie) b).getSeatCapacity() >= 50)
                .collect(Collectors.toList());

        long streamEndTime = System.nanoTime();
        long streamDuration = streamEndTime - streamStartTime;

        System.out.println("\n--- Stream-Based Processing ---");
        System.out.println("Filtered Items Count : " + streamFiltered.size());
        System.out.println("Execution Time (ns)  : " + streamDuration + " ns");
        System.out.printf("Execution Time (ms)  : %.3f ms%n", streamDuration / 1_000_000.0);

        // 4. Comparison Summary
        System.out.println("              BENCHMARK SUMMARY                  ");
        System.out.println("=================================================");
        if (loopDuration < streamDuration) {
            long diff = streamDuration - loopDuration;
            System.out.printf("Traditional Loop was FASTER by %d ns (%.3f ms)%n", diff, diff / 1_000_000.0);
        } else {
            long diff = loopDuration - streamDuration;
            System.out.printf("Stream Pipeline was FASTER by %d ns (%.3f ms)%n", diff, diff / 1_000_000.0);
        }
    }
}