package com.brendanddev.collections;

import java.util.Random;

import com.brendanddev.collections.performance.CompareLists;
import com.brendanddev.collections.performance.CompareMaps;
import com.brendanddev.collections.performance.CompareQueue;
import com.brendanddev.collections.performance.CompareSets;
import com.brendanddev.collections.performance.CompareStack;

/**
 * Main class to demonstrate and benchmark custom collection implementations.
 */
public class Main {
    @SuppressWarnings("unused")
    public static void main(String[] args) {

        int n = 100_000;
        Random random = new Random();
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
        CompareQueue.benchmarkQueues(n);
        System.out.println("-------------------------------------------------");
        CompareQueue.benchmarkQueues(n);
        System.out.println("-------------------------------------------------");
        CompareQueue.benchmarkDeques(n);
        System.out.println("-------------------------------------------------");

        // Total time metrics
        long endTime = System.nanoTime();
        long totalTimeMs = (endTime - startTime) / 1_000_000;
        long totalTimeSec = totalTimeMs / 1000;
        System.out.println("Total benchmarking time: " + totalTimeMs + " ms");
        System.out.println("Total benchmarking time: " + totalTimeSec + " s");





        // /**  CustomLinkedPriorityQueue benchmarks */
        // CustomLinkedPriorityQueue<Integer> customPriorityQueue = new CustomLinkedPriorityQueue<>();

        // Benchmark.measureWithResults("CustomLinkedPriorityQueue enqueue " + n + " elements", () -> {
        //     for (int i = 0; i < n; i++) {
        //         customPriorityQueue.enqueue(i, i);
        //     }
        //     return null;
        // });

        // Benchmark.measureWithResults("CustomLinkedPriorityQueue peek " + n + " elements", () -> {
        //     for (int i = 0; i < n; i++) {
        //         if (!customPriorityQueue.isEmpty()) {
        //             customPriorityQueue.peek();
        //         }
        //     }
        //     return null;
        // });

        // Benchmark.measureWithResults("CustomLinkedPriorityQueue contains " + n + " elements", () -> {
        //     for (int i = 0; i < n; i++) {
        //         customPriorityQueue.contains(i);
        //     }
        //     return null;
        // });

        // Benchmark.measureWithResults("CustomLinkedPriorityQueue dequeue " + n + " elements", () -> {
        //     while (!customPriorityQueue.isEmpty()) {
        //         customPriorityQueue.dequeue();
        //     }
        //     return null;
        // });

        // System.out.println("-------------------------------------------------");

        // /** CustomHeapList benchmarks */
        // CustomHeapList<Integer> customHeapList = new CustomHeapList<>();

        // Benchmark.measureWithResults("CustomHeapList add " + n + " elements", () -> {
        //     for (int i = 0; i < n; i++) {
        //         customHeapList.add(i);
        //     }
        //     return null;
        // });

        // Benchmark.measureWithResults("CustomHeapList contains " + n + " elements", () -> {
        //     for (int i = 0; i < n; i++) {
        //         customHeapList.contains(i);
        //     }
        //     return null;
        // });

        // Benchmark.measureWithResults("CustomHeapList remove " + n + " elements", () -> {
        //     while (!customHeapList.isEmpty()) {
        //         customHeapList.remove(customHeapList.iterator().next());
        //     }
        //     return null;
        // });

        // System.out.println("-------------------------------------------------");

        // /** CustomBinaryTree benchmarks */
        // CustomBinaryTree<Integer> customBinaryTree = new CustomBinaryTree<>((a, b) -> Integer.compare(a, b));    

        // Collections.shuffle(values);
        // Benchmark.measureWithResults("CustomBinaryTree insert " + n + " elements", () -> {
        //     for (int value : values) {
        //         customBinaryTree.insert(value);
        //     }
        //     return null;
        // });

        // Benchmark.measureWithResults("CustomBinaryTree contains " + n + " elements", () -> {
        //     for (int i = 0; i < n; i++) {
        //         customBinaryTree.contains(i);
        //     }
        //     return null;
        // });

        // Benchmark.measureWithResults("CustomBinaryTree in-order traversal", () -> {
        //     customBinaryTree.traverseInOrder();
        //     return null;
        // });

        // Benchmark.measureWithResults("CustomBinaryTree remove " + n + " elements", () -> {
        //     for (int i = 0; i < n; i++) {
        //         customBinaryTree.remove(i);
        //     }
        //     return null;
        // });

        // System.out.println("-------------------------------------------------");

        // long endTime = System.nanoTime();
        // long totalTimeMs = (endTime - startTime) / 1_000_000;
        // System.out.println("Total benchmarking time: " + totalTimeMs + " ms");
    
    }
}