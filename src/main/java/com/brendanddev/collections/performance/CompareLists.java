package com.brendanddev.collections.performance;

import java.util.Random;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.brendanddev.collections.list.CustomArrayList;
import com.brendanddev.collections.list.CustomLinkedList;

/**
 * Provides performance comparison benchmarks between custom list implementations
 * and their standard Java Collections Framework counterparts.
 * 
 * This class runs benchmarks for common operations such as adding, getting, removing,
 * and checking for containment of elements in both custom and Java lists.
 */
public class CompareLists {

    private static final Random random = new Random(42);

    /**
     * Benchmarks the performance of CustomArrayList against Java's ArrayList.
     * 
     * @param n The number of elements to insert, access, search, and remove.
     */
    public static void benchmarkLists(int n) {
        CustomArrayList<Integer> customArrayList = new CustomArrayList<>();
        ArrayList<Integer> javaArrayList = new ArrayList<>();

        // Compare adding n elements
        Benchmark.measureWithResults("CustomArrayList add " + n, () -> {
            for (int i = 0; i < n; i++) customArrayList.add(random.nextInt(n));
            return null;
        });
        Benchmark.measureWithResults("Java ArrayList add " + n, () -> {
            for (int i = 0; i < n; i++) javaArrayList.add(random.nextInt(n));
            return null;
        });

        // Compare getting n elements
        Benchmark.measureWithResults("CustomArrayList get " + n, () -> {
            for (int i = 0; i < n; i++) customArrayList.get(random.nextInt(customArrayList.size()));
            return null;
        });
        Benchmark.measureWithResults("Java ArrayList get " + n, () -> {
            for (int i = 0; i < n; i++) javaArrayList.get(random.nextInt(javaArrayList.size()));
            return null;
        });

        // Compare contains n elements
        Benchmark.measureWithResults("CustomArrayList contains " + n + " elements", () -> {
            for (int i = 0; i < n; i++) customArrayList.contains(random.nextInt(n));
            return null;
        });
        Benchmark.measureWithResults("Java ArrayList contains " + n + " elements", () -> {
            for (int i = 0; i < n; i++) javaArrayList.contains(random.nextInt(n));
            return null;
        });

        // Compare removing n elements
        Benchmark.measureWithResults("CustomArrayList remove " + n + " elements", () -> {
            while (!customArrayList.isEmpty()) customArrayList.remove(customArrayList.size() - 1);
            return null;
        });
        Benchmark.measureWithResults("Java ArrayList remove " + n + " elements", () -> {
            while (!javaArrayList.isEmpty()) javaArrayList.remove(javaArrayList.size() - 1);
            return null;
        });
    }

    /**
     * Benchmarks the performance of CustomLinkedList against Java's LinkedList.
     * 
     * @param n The number of elements to insert, access, search, and remove.
     */
    public static void benchmarkLinkedLists(int n) {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        LinkedList<Integer> javaLinkedList = new LinkedList<>();

        // Compare adding n elements
        Benchmark.measureWithResults("CustomLinkedList add " + n + " elements", () -> {
            for (int i = 0; i < n; i++) customLinkedList.add(random.nextInt(n));
            return null;
        });
        Benchmark.measureWithResults("Java LinkedList add " + n + " elements", () -> {
            for (int i = 0; i < n; i++) javaLinkedList.add(random.nextInt(n));
            return null;
        });

        // Compare contains n elements
        Benchmark.measureWithResults("CustomLinkedList contains " + n + " elements", () -> {
            for (int i = 0; i < n; i++) customLinkedList.contains(random.nextInt(n));
            return null;
        });
        Benchmark.measureWithResults("Java LinkedList contains " + n + " elements", () -> {
            for (int i = 0; i < n; i++) javaLinkedList.contains(random.nextInt(n));
            return null;
        });

        // Compare getting n random elements
        Benchmark.measureWithResults("CustomLinkedList get " + n + " random elements", () -> {
            for (int i = 0; i < n; i++) {   
                int idx = random.nextInt(customLinkedList.size());
                customLinkedList.get(idx);
            }
            return null;
        });
        Benchmark.measureWithResults("Java LinkedList get " + n + " random elements", () -> {
            for (int i = 0; i < n; i++) {   
                int idx = random.nextInt(javaLinkedList.size());
                javaLinkedList.get(idx);
            }
            return null;
        });

        // Compare removing n elements
        Benchmark.measureWithResults("CustomLinkedList remove " + n + " elements", () -> {
            while (!customLinkedList.isEmpty()) customLinkedList.removeAt(customLinkedList.size() - 1);
            return null;
        });
        Benchmark.measureWithResults("Java LinkedList remove " + n + " elements", () -> {
            while (!javaLinkedList.isEmpty()) javaLinkedList.removeLast();
            return null;
        });

    }
    
}
