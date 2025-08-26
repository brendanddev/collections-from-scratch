package com.brendanddev.collections.performance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import com.brendanddev.collections.heap.CustomHeapList;

/**
 * Provides performance comparison benchmarks between a custom heap implementation
 * and its standard Java Collections Framework counterparts.
 * 
 * This class runs benchmarks for common operations such as adding, removing,
 * and checking for containment of elements in both custom and Java heaps.
 * 
 * Note: Under the hood, Java's PriorityQueue is implemented as a binary heap, which is 
 * why I used it for comparison here.
 */
public class CompareHeaps {

    /**
     * Benchmarks the performance of CustomHeapList against Java's PriorityQueue.
     * 
     * @param n The number of elements to insert, search, and remove.
     */
    public static void benchmarkHeaps(int n) {
        CustomHeapList<Integer> customHeapList = new CustomHeapList<>();
        PriorityQueue<Integer> javaHeap = new PriorityQueue<>();
        List<Integer> shuffled = generateShuffledElements(n);

        // Compare adding n elements
        Benchmark.measureWithResults("CustomHeapList add " + n + " elements", () -> {
            for (int i = 0; i < n; i++) customHeapList.add(i);
            return null;
        });
        Benchmark.measureWithResults("Java PriorityQueue add " + n + " elements", () -> {
            for (int i = 0; i < n; i++) javaHeap.add(i);
            return null;
        });

        // Build fresh heaps for contains test
        CustomHeapList<Integer> customHeapListForContains = buildCustomHeapList(shuffled);
        PriorityQueue<Integer> javaHeapForContains = buildJavaPriorityQueue(shuffled);

        // Compare contains n elements
        Benchmark.measureWithResults("CustomHeapList contains " + n + " elements", () -> {
            for (int i = 0; i < n; i++) customHeapListForContains.contains(i);
            return null;
        });
        Benchmark.measureWithResults("Java PriorityQueue contains " + n + " elements", () -> {
            for (int i = 0; i < n; i++) javaHeapForContains.contains(i);
            return null;
        });

        // Prepare fresh heaps for remove test
        CustomHeapList<Integer> customHeapListForRemove = buildCustomHeapList(shuffled);
        PriorityQueue<Integer> javaHeapForRemove = buildJavaPriorityQueue(shuffled);
        
        // Compare removing n elements
        Benchmark.measureWithResults("CustomHeapList remove " + n + " elements", () -> {
            while (!customHeapListForRemove.isEmpty()) customHeapListForRemove.remove(customHeapListForRemove.iterator().next());            
            return null;
        });
        Benchmark.measureWithResults("Java PriorityQueue remove " + n + " elements", () -> {
            while (!javaHeapForRemove.isEmpty()) javaHeapForRemove.poll();
            return null;
        });
    }
    
    /**
     * Helper to generate a shuffled list of integers 0..n-1.
     * 
     * @param n The number of elements to add.
     * @return A shuffled list of integers 0..n-1.
     */
    private static List<Integer> generateShuffledElements(int n) {
        List<Integer> elementsToAdd = new ArrayList<>();
        for (int i = 0; i < n; i++) elementsToAdd.add(i);
        Collections.shuffle(elementsToAdd);
        return elementsToAdd;
    }

    /**
     * Helper to build a CustomHeapList from a list of elements.
     * 
     * @param elementsToAdd The elements to add.
     * @return A CustomHeapList populated with the given elements.
     */
    private static CustomHeapList<Integer> buildCustomHeapList(List<Integer> elementsToAdd) {
        CustomHeapList<Integer> heap = new CustomHeapList<>();
        for (int e : elementsToAdd) heap.add(e);
        return heap;
    }

    /**
     * Helper to build a Java PriorityQueue from a list of elements.
     * 
     * @param elementsToAdd The elements to add.
     * @return A PriorityQueue populated with the given elements.
     */
    private static PriorityQueue<Integer> buildJavaPriorityQueue(List<Integer> elementsToAdd) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int e : elementsToAdd) heap.add(e);
        return heap;
    }

}