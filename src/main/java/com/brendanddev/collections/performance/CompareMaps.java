package com.brendanddev.collections.performance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.brendanddev.collections.map.CustomHashMap;

/**
 * Provides performance comparison benchmarks between custom map implementations
 * and their standard Java Collections Framework counterparts.
 * 
 * This class runs benchmarks for common operations such as 
 */
public class CompareMaps {

    /**
     * Benchmarks the performance of CustomHashMap against Java's HashMap.
     * 
     * @param n The number of elements to 
     */
    public static void benchmarkMaps(int n) {
        CustomHashMap<Integer, String> customHashMap = new CustomHashMap<>();
        HashMap<Integer, String> javaHashMap = new HashMap<>();

        List<Integer> keysToAdd = new ArrayList<>();
        for (int i = 0; i < n; i++) keysToAdd.add(i);

        // Compare adding n entries
        Benchmark.measureWithResults("CustomHashMap add " + n + " entries", () -> {
            for (int key : keysToAdd) customHashMap.put(key, "Value" + key);
            return null;
        });
        Benchmark.measureWithResults("Java HashMap add " + n + " entries", () -> {
            for (int key : keysToAdd) javaHashMap.put(key, "Value" + key);
            return null;
        });

        // Compare getting n entries
        Benchmark.measureWithResults("CustomHashMap get " + n + " entries", () -> {
            for (int key : keysToAdd) customHashMap.get(key);
            return null;
        });
        Benchmark.measureWithResults("Java HashMap get " + n + " entries", () -> {
            for (int key : keysToAdd) javaHashMap.get(key);
            return null;
        });

        // Compare containsKey n entries
        Benchmark.measureWithResults("CustomHashMap containsKey " + n + " entries", () -> {
            for (int key : keysToAdd) customHashMap.containsKey(key);
            return null;
        });
        Benchmark.measureWithResults("Java HashMap containsKey " + n + " entries", () -> {
            for (int key : keysToAdd) javaHashMap.containsKey(key);
            return null;
        });

        // Compare removing n entries
        Benchmark.measureWithResults("CustomHashMap remove " + n + " entries", () -> {
            for (int key : keysToAdd) customHashMap.remove(key);
            return null;
        });
        Benchmark.measureWithResults("Java HashMap remove " + n + " entries", () -> {
            for (int key : keysToAdd) javaHashMap.remove(key);
            return null;
        });
    }


}
