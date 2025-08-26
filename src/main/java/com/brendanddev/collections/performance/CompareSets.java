package com.brendanddev.collections.performance;

import java.util.HashSet;
import java.util.Random;

import com.brendanddev.collections.set.CustomHashSet;

/**
 * Provides performance comparison benchmarks between custom set implementations
 * and their standard Java Collections Framework counterparts.
 * 
 * This class runs benchmarks for common operations such as adding, removing,
 * and checking for containment of elements in both custom and Java sets.
 */
public class CompareSets {

    private static final Random random = new Random(42);

    /**
     * Benchmarks the performance of CustomHashSet against Java's HashSet.
     * 
     * @param n The number of elements to insert, search, and remove.
     */
    public static void benchmarkSets(int n) {
        CustomHashSet<Integer> customHashSet = new CustomHashSet<>();
        HashSet<Integer> javaHashSet = new HashSet<>();
        
        // Compare adding n random elements
        Benchmark.measureWithResults("CustomHashSet add " + n + " elements", () -> {
            for (int i = 0; i < n; i++) customHashSet.add(random.nextInt(n));
            return null;
        });
        Benchmark.measureWithResults("Java HashSet add " + n + " elements", () -> {
            for (int i = 0; i < n; i++) javaHashSet.add(random.nextInt(n));
            return null;
        });

        // Compare contains n random elements
        Benchmark.measureWithResults("CustomHashSet contains " + n + " elements", () -> {
            for (int i = 0; i < n; i++) customHashSet.contains(random.nextInt(n));
            return null;
        });
        Benchmark.measureWithResults("Java HashSet contains " + n + " elements", () -> {
            for (int i = 0; i < n; i++) javaHashSet.contains(random.nextInt(n));
            return null;
        });

        // Compare removing n random elements
        Benchmark.measureWithResults("CustomHashSet remove " + n + " elements", () -> {
            for (int i = 0; i < n; i++) customHashSet.remove(random.nextInt(n));
            return null;
        });
        Benchmark.measureWithResults("Java HashSet remove " + n + " elements", () -> {
            for (int i = 0; i < n; i++) javaHashSet.remove(random.nextInt(n));
            return null;
        });
    }

    
}
