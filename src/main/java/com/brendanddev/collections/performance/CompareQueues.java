package com.brendanddev.collections.performance;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import com.brendanddev.collections.queue.CustomDeque;
import com.brendanddev.collections.queue.CustomLinkedPriorityQueue;
import com.brendanddev.collections.queue.CustomQueue;

/**
 * Provides performance comparison benchmarks between custom queue and deque implementations
 * and their standard Java Collections Framework counterparts.
 * 
 * This class runs benchmarks for common operations such as enqueueing, dequeueing, and
 * peeking elements in both custom and Java queues and deques.
 */
public class CompareQueues {

    /**
     * Benchmarks the performance of CustomQueue against Java's Queue.
     * 
     * @param n The number of elements to enqueue, dequeue, and peek.
     */
    public static void benchmarkQueues(int n) {
        CustomQueue<Integer> customQueue = new CustomQueue<>();
        Queue<Integer> javaQueue = new LinkedList<>();

        // Compare enqueue (adding) n elements
        Benchmark.measureWithResults("CustomQueue enqueue " + n + " elements", () -> {
            for (int i = 0; i < n; i++) customQueue.enqueue(i);
            return null;
        });
        Benchmark.measureWithResults("Java Queue enqueue " + n + " elements", () -> {
            for (int i = 0; i < n; i++) javaQueue.add(i);
            return null;
        });

        // Compare peek (accessing front) n elements
        Benchmark.measureWithResults("CustomQueue peek " + n + " elements", () -> {
            for (int i = 0; i < n; i++) customQueue.peek();
            return null;
        });
        Benchmark.measureWithResults("Java Queue peek " + n + " elements", () -> {
            for (int i = 0; i < n; i++) javaQueue.peek();
            return null;
        });

        // Compare dequeue (removing) n elements
        Benchmark.measureWithResults("CustomQueue dequeue " + n + " elements", () -> {
            while (!customQueue.isEmpty()) customQueue.dequeue();
            return null;
        });
        Benchmark.measureWithResults("Java Queue dequeue " + n + " elements", () -> {
            while (!javaQueue.isEmpty()) javaQueue.poll();
            return null;
        });
    }

    /**
     * Benchmarks the performance of CustomDeque against Java's Deque.
     * 
     * @param n The number of elements to add, remove, and access from both ends.
     */
    public static void benchmarkDeques(int n) {
        CustomDeque<Integer> customDeque = new CustomDeque<>();
        Deque<Integer> javaDeque = new LinkedList<>();

        // Compare adding n elements to front
        Benchmark.measureWithResults("CustomDeque addFirst " + n + " elements", () -> {
            for (int i = 0; i < n; i++) customDeque.addFirst(i);
            return null;
        });
        Benchmark.measureWithResults("Java Deque addFirst " + n + " elements", () -> {
            for (int i = 0; i < n; i++) javaDeque.addFirst(i);
            return null;
        });

        // Compare adding n elements to back
        Benchmark.measureWithResults("CustomDeque addLast " + n + " elements", () -> {
            for (int i = 0; i < n; i++) customDeque.addLast(i);
            return null;
        });
        Benchmark.measureWithResults("Java Deque addLast " + n + " elements", () -> {
            for (int i = 0; i < n; i++) javaDeque.addLast(i);
            return null;
        });

        // Compare peeking n elements from front
        Benchmark.measureWithResults("CustomDeque peekFirst " + n + " elements", () -> {
            for (int i = 0; i < n; i++) customDeque.peekFirst();
            return null;
        });
        Benchmark.measureWithResults("Java Deque peekFirst " + n + " elements", () -> {
            for (int i = 0; i < n; i++) javaDeque.peekFirst();
            return null;
        });

        // Compare peeking n elements from back
        Benchmark.measureWithResults("CustomDeque peekLast " + n + " elements", () -> {
            for (int i = 0; i < n; i++) customDeque.peekLast();
            return null;
        });
        Benchmark.measureWithResults("Java Deque peekLast " + n + " elements", () -> {
            for (int i = 0; i < n; i++) javaDeque.peekLast();
            return null;
        });

        // Compare removing n elements from front
        Benchmark.measureWithResults("CustomDeque removeFirst " + n + " elements", () -> {
            while (!customDeque.isEmpty()) customDeque.removeFirst();
            return null;
        });
        Benchmark.measureWithResults("Java Deque removeFirst " + n + " elements", () -> {
            while (!javaDeque.isEmpty()) javaDeque.removeFirst();
            return null;
        });

        // Compare removing n elements from back
        Benchmark.measureWithResults("CustomDeque removeLast " + n + " elements", () -> {
            while (!customDeque.isEmpty()) customDeque.removeLast();
            return null;
        });
        Benchmark.measureWithResults("Java Deque removeLast " + n + " elements", () -> {
            while (!javaDeque.isEmpty()) javaDeque.removeLast();
            return null;
        });

        // Compare contains n elements
        Benchmark.measureWithResults("CustomDeque contains " + n + " elements", () -> {
            for (int i = 0; i < n; i++) customDeque.contains(i);
            return null;
        });
        Benchmark.measureWithResults("Java Deque contains " + n + " elements", () -> {
            for (int i = 0; i < n; i++) javaDeque.contains(i);
            return null;
        });
    }

    /**
     * Benchmarks the performance of CustomLinkedPriorityQueue against Java's PriorityQueue.
     * 
     * @param n The number of elements to enqueue, dequeue, peek, and check for containment.
     */
    public static void benchmarkPriorityQueues(int n) {
        CustomLinkedPriorityQueue<Integer> customPriorityQueue = new CustomLinkedPriorityQueue<>();
        PriorityQueue<Integer> javaPriorityQueue = new PriorityQueue<>();

        List<Integer> elementsToAdd = new ArrayList<>();
        for (int i = 0; i < n; i++) elementsToAdd.add(i);

        // Compare enqueueing n elements (adding elements to the back of the queue)
        Benchmark.measureWithResults("CustomLinkedPriorityQueue enqueue " + n + " elements", () -> {
            for (int e : elementsToAdd) customPriorityQueue.enqueue(e, e);
            return null;
        });
        Benchmark.measureWithResults("Java PriorityQueue add " + n + " elements", () -> {
            for (int e : elementsToAdd) javaPriorityQueue.add(e);
            return null;
        });

        // Compare peeking n elements (accessing the front of the queue)
        Benchmark.measureWithResults("CustomLinkedPriorityQueue peek " + n + " elements", () -> {
            for (int i = 0; i < elementsToAdd.size(); i++) {
                if (!customPriorityQueue.isEmpty()) {
                    customPriorityQueue.peek();
                }
            }
            return null;
        });
        Benchmark.measureWithResults("Java PriorityQueue peek " + n + " elements", () -> {
            for (int i = 0; i < elementsToAdd.size(); i++) {
                if (!javaPriorityQueue.isEmpty()) {
                    javaPriorityQueue.peek();
                }
            }
            return null;
        });

        // Compare contains n elements
        Benchmark.measureWithResults("CustomLinkedPriorityQueue contains " + n + " elements", () -> {
            for (int i = 0; i < n; i++) {
                customPriorityQueue.contains(i);
            }
            return null;
        });
        Benchmark.measureWithResults("Java PriorityQueue contains " + n + " elements", () -> {
            for (int i = 0; i < n; i++) {
                javaPriorityQueue.contains(i);
            }
            return null;
        });

        // Compare dequeueing n elements (removing elements from the front of the queue)
        Benchmark.measureWithResults("CustomLinkedPriorityQueue dequeue " + n + " elements", () -> {
            while (!customPriorityQueue.isEmpty()) {
                customPriorityQueue.dequeue();
            }
            return null;
        });
        Benchmark.measureWithResults("Java PriorityQueue poll " + n + " elements", () -> {
            while (!javaPriorityQueue.isEmpty()) {
                javaPriorityQueue.poll();
            }
            return null;
        });
    }


    
}

