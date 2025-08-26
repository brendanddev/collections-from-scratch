package com.brendanddev.collections;

import java.util.Random;

import com.brendanddev.collections.performance.CompareLists;
import com.brendanddev.collections.performance.CompareSets;

/**
 * Main class to demonstrate and benchmark custom collection implementations.
 */
public class Main {
    @SuppressWarnings("unused")
    public static void main(String[] args) {

        int n = 100_000;
        Random random = new Random();
        long startTime = System.nanoTime();

        CompareLists.benchmarkLists(n);
        System.err.println("-------------------------------------------------");
        CompareLists.benchmarkLinkedLists(n);
        System.err.println("-------------------------------------------------");
        CompareSets.benchmarkSets(n);
        System.err.println("-------------------------------------------------");


        long endTime = System.nanoTime();
        long totalTimeMs = (endTime - startTime) / 1_000_000;
        System.out.println("Total benchmarking time: " + totalTimeMs + " ms");
















        // // Prepare a list of values to insert into CustomBinaryTree
        // List<Integer> values = new ArrayList<>();
        // for (int i = 0; i < n; i++) {
        //     values.add(i);
        // }

        // long startTime = System.nanoTime();
                


        // System.out.println("-------------------------------------------------");

        // /** CustomLinkedList benchmarks */
        // CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();

        // Benchmark.measureWithResults("CustomLinkedList add " + n + " elements", () -> {
        //     for (int i = 0; i < n; i++) {
        //         customLinkedList.add(i);
        //     }
        //     return null;
        // });

        // Benchmark.measureWithResults("CustomLinkedList contains " + n + " elements", () -> {
        //     for (int i = 0; i < n; i++) {
        //         customLinkedList.contains(i);
        //     }
        //     return null;
        // });

        // Benchmark.measureWithResults("CustomLinkedList get " + n + " random elements", () -> {
        //     for (int i = 0; i < n; i++) {
        //         int idx = random.nextInt(customLinkedList.size());
        //         customLinkedList.get(idx);
        //     }
        //     return null;
        // });

        // Benchmark.measureWithResults("CustomLinkedList remove " + n + " elements", () -> {
        //     while (!customLinkedList.isEmpty()) {
        //         customLinkedList.removeAt(customLinkedList.size() - 1);
        //     }
        //     return null;
        // });

        // System.out.println("-------------------------------------------------");

        // /** CustomStack Benchmarks */
        // CustomStack<Integer> customStack = new CustomStack<>();

        // Benchmark.measureWithResults("CustomStack push " + n + " elements", () -> {
        //     for (int i = 0; i < n; i++) {
        //         customStack.push(i);
        //     }
        //     return null;
        // });

        // Benchmark.measureWithResults("CustomStack peek " + n + " elements", () -> {
        //     for (int i = 0; i < n; i++) {
        //         customStack.peek();
        //     }
        //     return null;
        // });

        // Benchmark.measureWithResults("CustomStack pop " + n + " elements", () -> {
        //     while (!customStack.isEmpty()) {
        //         customStack.pop();
        //     }
        //     return null;
        // });

        // System.out.println("-------------------------------------------------");

        // /** CustomQueue Benchmarks */
        // CustomQueue<Integer> customQueue = new CustomQueue<>();

        // Benchmark.measureWithResults("CustomQueue enqueue " + n + " elements", () -> {
        //     for (int i = 0; i < n; i++) {
        //         customQueue.enqueue(i);
        //     }
        //     return null;
        // });

        // Benchmark.measureWithResults("CustomQueue peek " + n + " elements", () -> {
        //     for (int i = 0; i < n; i++) {
        //         customQueue.peek();
        //     }
        //     return null;
        // });

        // Benchmark.measureWithResults("CustomQueue dequeue " + n + " elements", () -> {
        //     while (!customQueue.isEmpty()) {
        //         customQueue.dequeue();
        //     }
        //     return null;
        // });

        // System.out.println("-------------------------------------------------");

        // CustomDeque<Integer> customDeque = new CustomDeque<>();

        // Benchmark.measureWithResults("CustomDeque addFirst " + n + " elements", () -> {
        //     for (int i = 0; i < n; i++) {
        //         customDeque.addFirst(i);
        //     }
        //     return null;
        // });

        // Benchmark.measureWithResults("CustomDeque addLast " + n + " elements", () -> {
        //     for (int i = 0; i < n; i++) {
        //         customDeque.addLast(i);
        //     }
        //     return null;
        // });

        // Benchmark.measureWithResults("CustomDeque peekFirst " + n + " elements", () -> {
        //     for (int i = 0; i < n; i++) {
        //         customDeque.peekFirst();
        //     }
        //     return null;
        // });

        // Benchmark.measureWithResults("CustomDeque peekLast " + n + " elements", () -> {
        //     for (int i = 0; i < n; i++) {
        //         customDeque.peekLast();
        //     }
        //     return null;
        // });

        // Benchmark.measureWithResults("CustomDeque removeFirst " + n + " elements", () -> {
        //     while (!customDeque.isEmpty()) {
        //         customDeque.removeFirst();
        //     }
        //     return null;
        // });

        // Benchmark.measureWithResults("CustomDeque removeLast " + n + " elements", () -> {
        //     while (!customDeque.isEmpty()) {
        //         customDeque.removeLast();
        //     }
        //     return null;
        // });

        // Benchmark.measureWithResults("CustomDeque contains " + n + " elements", () -> {
        //     for (int i = 0; i < n; i++) {
        //         customDeque.contains(i);
        //     }
        //     return null;
        // });

        // System.out.println("-------------------------------------------------");

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