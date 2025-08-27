package com.brendanddev.collections;

import java.util.Random;

import com.brendanddev.collections.core.CustomIterator;
import com.brendanddev.collections.heap.CustomHeap;
import com.brendanddev.collections.performance.*;

/**
 * Main class to demonstrate and benchmark custom collection implementations.
 */
public class Main {
    
    public static void main(String[] args) {

        CustomHeap<Integer> customHeap = new CustomHeap<>();

        customHeap.add(10);
        customHeap.add(5);
        customHeap.add(20);
        customHeap.add(1);

        System.out.println("Peek: " + customHeap.peek());

        customHeap.add(15);
        customHeap.add(7);
        customHeap.add(9);

        System.out.println("Remove 7: " + customHeap.remove(7));
        System.out.println("Contains 7? " + customHeap.contains(7));
        

        CustomIterator<Integer> it = customHeap.iterator();
        System.out.print("Heap contents: ");
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // Size check
        System.out.println("Heap size: " + customHeap.size());
        

        // int n = 100_000;
        // Random random = new Random();
        // long startTime = System.nanoTime();

        // System.out.println("-------------------------------------------------");
        // CompareLists.benchmarkLists(n);
        // System.out.println("-------------------------------------------------");
        // CompareLists.benchmarkLinkedLists(n);
        // System.out.println("-------------------------------------------------");
        // CompareSets.benchmarkSets(n);
        // System.out.println("-------------------------------------------------");
        // CompareMaps.benchmarkMaps(n);
        // System.out.println("-------------------------------------------------");
        // CompareStack.benchmarkStacks(n);
        // System.out.println("-------------------------------------------------");
        // CompareQueues.benchmarkQueues(n);
        // System.out.println("-------------------------------------------------");
        // CompareQueues.benchmarkQueues(n);
        // System.out.println("-------------------------------------------------");
        // CompareQueues.benchmarkDeques(n);
        // System.out.println("-------------------------------------------------");
        // CompareQueues.benchmarkPriorityQueues(n);
        // System.out.println("-------------------------------------------------");
        // CompareHeaps.benchmarkHeaps(n);
        // System.out.println("-------------------------------------------------");
        // CompareTrees.benchmarkTrees(n);
        // System.out.println("-------------------------------------------------");


        // // Total time metrics
        // long endTime = System.nanoTime();
        // long totalTimeMs = (endTime - startTime) / 1_000_000;
        // long totalTimeSec = totalTimeMs / 1000;
        // System.out.println("Total benchmarking time: " + totalTimeMs + " ms");
        // System.out.println("Total benchmarking time: " + totalTimeSec + " s");
    }

}