package com.brendanddev.collections;

import com.brendanddev.collections.performance.*;

/**
 * Main class to demonstrate and benchmark custom collection implementations.
 */
public class Main {
    
    public static void main(String[] args) {

        int n = 100_000;
        long startTime = System.nanoTime();

        System.out.println("-------------------------------------------------");
        CompareLists.benchmarkLists(n);
        System.out.println("-------------------------------------------------");
        CompareLists.benchmarkLinkedLists(n);
        System.out.println("-------------------------------------------------");
        CompareSets.benchmarkSets(n);
        System.out.println("-------------------------------------------------");
        CompareMaps.benchmarkMaps(n);
        System.out.println("-------------------------------------------------");
        CompareStack.benchmarkStacks(n);
        System.out.println("-------------------------------------------------");
        CompareQueues.benchmarkQueues(n);
        System.out.println("-------------------------------------------------");
        CompareQueues.benchmarkQueues(n);
        System.out.println("-------------------------------------------------");
        CompareQueues.benchmarkDeques(n);
        System.out.println("-------------------------------------------------");
        CompareQueues.benchmarkPriorityQueues(n);
        System.out.println("-------------------------------------------------");
        CompareHeaps.benchmarkHeaps(n);
        System.out.println("-------------------------------------------------");
        CompareTrees.benchmarkTrees(n);
        System.out.println("-------------------------------------------------");

        // Total time metrics
        long endTime = System.nanoTime();
        long totalTimeMs = (endTime - startTime) / 1_000_000;
        long totalTimeSec = totalTimeMs / 1000;
        System.out.println("Total benchmarking time: " + totalTimeMs + " ms");
        System.out.println("Total benchmarking time: " + totalTimeSec + " s");
    }

}