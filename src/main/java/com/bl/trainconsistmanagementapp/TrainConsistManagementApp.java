package com.bl.trainconsistmanagementapp;

import com.bl.trainconsistmanagementapp.model.Bogie;
import com.bl.trainconsistmanagementapp.model.GoodsBogie;
import com.bl.trainconsistmanagementapp.model.PassengerBogie;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {


    public static void main(String[] args) {

        System.out.println("UC14: Parallel Stream Processing vs Sequential");

        int datasetSize = 1_000_000;
        System.out.println("\nGenerating " + datasetSize + " sample bogie records...");

        List<Bogie> largeBogieList = new ArrayList<>(datasetSize);
        for (int i = 0; i < datasetSize; i++) {
            if (i % 2 == 0) {
                largeBogieList.add(new PassengerBogie("PB-" + i, "Sleeper", 72));
            } else {
                largeBogieList.add(new GoodsBogie("GB-" + i, "Box Car", "Coal", 60.0));
            }
        }

        System.out.println("Available CPU Cores: " + Runtime.getRuntime().availableProcessors());

        // 2. Sequential Stream Processing
        long seqStart =  System.nanoTime();
        List<Bogie> seqResult = largeBogieList.stream()
                .filter(b -> b instanceof PassengerBogie pb && pb.getSeatCapacity() > 50)
                .collect(Collectors.toList());
        long seqEnd = System.nanoTime();
        long seqDuration = seqEnd - seqStart;

        System.out.println("\n--- Sequential Stream Execution ---");
        System.out.println("Processed Count : " + seqResult.size());
        System.out.printf("Execution Time  : %.3f ms%n", seqDuration / 1_000_000.0);

        // 3. Parallel Stream Processing
        long parallelStart = System.nanoTime();

        List<Bogie> parallelResult = largeBogieList.parallelStream()
                .filter(b -> b instanceof PassengerBogie pb && pb.getSeatCapacity() > 50)
                .collect(Collectors.toList());

        long parallelEnd = System.nanoTime();
        long parallelDuration = parallelEnd - parallelStart;

        System.out.println("\n--- Parallel Stream Execution ---");
        System.out.println("Processed Count : " + parallelResult.size());
        System.out.printf("Execution Time  : %.3f ms%n", parallelDuration / 1_000_000.0);

        System.out.println("SUMMARY");
        if (parallelDuration < seqDuration) {
            double speedup = (double) seqDuration / parallelDuration;
            System.out.printf("Parallel Stream was FASTER by %.2fx speedup!%n", speedup);
        } else {
            System.out.println("Sequential Stream was faster (overhead outweighed parallel gains).");
        }
    }
}