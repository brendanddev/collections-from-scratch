package com.brendanddev.collections;

import java.util.Random;

import com.brendanddev.collections.core.CustomIterator;
import com.brendanddev.collections.list.CustomArrayList;
import com.brendanddev.collections.map.CustomHashMap;
import com.brendanddev.collections.performance.Benchmark;
import com.brendanddev.collections.set.CustomHashSet;

public class Main {
    public static void main(String[] args) {

        int n = 100_000;
        Random random = new Random();

        // CustomArrayList
        CustomArrayList<Integer> customArrayList = new CustomArrayList<>();

        Benchmark.measureWithResults("CustomArrayList add " + n + " elements", () -> {
            for (int i = 0; i < n; i++) {
                customArrayList.add(i);
            }
            return null;
        });

        Benchmark.measureWithResults("CustomArrayList contains " + n + " elements", () -> {
            for (int i = 0; i < n; i++) {
                customArrayList.contains(i);
            }
            return null;
        });

        Benchmark.measureWithResults("CustomArrayList get " + n + " random elements", () -> {
            for (int i = 0; i < n; i++) {
                int idx = random.nextInt(customArrayList.size());
                customArrayList.get(idx);
            }
            return null;
        });

        Benchmark.measureWithResults("CustomArrayList remove " + n + " elements", () -> {
            while (!customArrayList.isEmpty()) {
                customArrayList.remove(customArrayList.size() - 1);
            }
            return null;
        });

        System.out.println("-------------------------------------------------");
        // CustomHashSet
        CustomHashSet<Integer> hashSet = new CustomHashSet<>();

        Benchmark.measureWithResults("CustomHashSet add " + n + " elements", () -> {
            for (int i = 0; i < n; i++) {
                hashSet.add(i);
            }
            return null;
        });

        Benchmark.measureWithResults("CustomHashSet contains " + n + " elements", () -> {
            for (int i = 0; i < n; i++) {
                hashSet.contains(i);
            }
            return null;
        });

        Benchmark.measureWithResults("CustomHashSet iteration", () -> {
            CustomIterator<Integer> it = hashSet.iterator();
            while (it.hasNext()) {
                Integer val = it.next();
                // no-op
            }
            return null;
        });

        Benchmark.measureWithResults("CustomHashSet remove " + n + " elements", () -> {
            for (int i = 0; i < n; i++) {
                hashSet.remove(i);
            }
            return null;
        });
        System.out.println("-------------------------------------------------");
        
        // CustomHashMap
        CustomHashMap<Integer, Integer> hashMap = new CustomHashMap<>();

        Benchmark.measureWithResults("CustomHashMap put " + n + " elements", () -> {
            for (int i = 0; i < n; i++) {
                hashMap.put(i, i);
            }
            return null;
        });

        Benchmark.measureWithResults("CustomHashMap get " + n + " elements", () -> {
            for (int i = 0; i < n; i++) {
                hashMap.get(i);
            }
            return null;
        });

        Benchmark.measureWithResults("CustomHashMap iteration", () -> {
            for (int i = 0; i < hashMap.size(); i++) {
                // iterate through keys using containsKey or similar if iterator isn't implemented
                hashMap.containsKey(i);
            }
            return null;
        });

        Benchmark.measureWithResults("CustomHashMap remove " + n + " elements", () -> {
            for (int i = 0; i < n; i++) {
                hashMap.remove(i);
            }
            return null;
        });

    }
}