package com.brendanddev.collections;

import java.util.Random;

import com.brendanddev.collections.core.CustomIterator;
import com.brendanddev.collections.list.CustomArrayList;
import com.brendanddev.collections.list.CustomLinkedList;
import com.brendanddev.collections.map.CustomHashMap;
import com.brendanddev.collections.performance.Benchmark;
import com.brendanddev.collections.queue.CustomDeque;
import com.brendanddev.collections.queue.CustomQueue;
import com.brendanddev.collections.set.CustomHashSet;
import com.brendanddev.collections.stack.CustomStack;

/**
 * Main class to demonstrate and benchmark custom collection implementations.
 */
public class Main {
    @SuppressWarnings("unused")
    public static void main(String[] args) {

        int n = 100_000;
        Random random = new Random();

        /** CustomArrayList benchmarks */
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
        
        
        /** CustomHashSet benchmarks */
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
        

        /** CustomHashMap benchmarks */
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

        System.out.println("-------------------------------------------------");

        /** CustomLinkedList benchmarks */
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();

        Benchmark.measureWithResults("CustomLinkedList add " + n + " elements", () -> {
            for (int i = 0; i < n; i++) {
                customLinkedList.add(i);
            }
            return null;
        });

        Benchmark.measureWithResults("CustomLinkedList contains " + n + " elements", () -> {
            for (int i = 0; i < n; i++) {
                customLinkedList.contains(i);
            }
            return null;
        });

        Benchmark.measureWithResults("CustomLinkedList get " + n + " random elements", () -> {
            for (int i = 0; i < n; i++) {
                int idx = random.nextInt(customLinkedList.size());
                customLinkedList.get(idx);
            }
            return null;
        });

        Benchmark.measureWithResults("CustomLinkedList remove " + n + " elements", () -> {
            while (!customLinkedList.isEmpty()) {
                customLinkedList.removeAt(customLinkedList.size() - 1);
            }
            return null;
        });

        System.out.println("-------------------------------------------------");

        /** CustomStack Benchmarks */
        CustomStack<Integer> customStack = new CustomStack<>();

        Benchmark.measureWithResults("CustomStack push " + n + " elements", () -> {
            for (int i = 0; i < n; i++) {
                customStack.push(i);
            }
            return null;
        });

        Benchmark.measureWithResults("CustomStack peek " + n + " elements", () -> {
            for (int i = 0; i < n; i++) {
                customStack.peek();
            }
            return null;
        });

        Benchmark.measureWithResults("CustomStack pop " + n + " elements", () -> {
            while (!customStack.isEmpty()) {
                customStack.pop();
            }
            return null;
        });

        System.out.println("-------------------------------------------------");

        /** CustomQueue Benchmarks */
        CustomQueue<Integer> customQueue = new CustomQueue<>();

        Benchmark.measureWithResults("CustomQueue enqueue " + n + " elements", () -> {
            for (int i = 0; i < n; i++) {
                customQueue.enqueue(i);
            }
            return null;
        });

        Benchmark.measureWithResults("CustomQueue peek " + n + " elements", () -> {
            for (int i = 0; i < n; i++) {
                customQueue.peek();
            }
            return null;
        });

        Benchmark.measureWithResults("CustomQueue dequeue " + n + " elements", () -> {
            while (!customQueue.isEmpty()) {
                customQueue.dequeue();
            }
            return null;
        });

        System.out.println("-------------------------------------------------");

        CustomDeque<Integer> customDeque = new CustomDeque<>();

        Benchmark.measureWithResults("CustomDeque addFirst " + n + " elements", () -> {
            for (int i = 0; i < n; i++) {
                customDeque.addFirst(i);
            }
            return null;
        });

        Benchmark.measureWithResults("CustomDeque addLast " + n + " elements", () -> {
            for (int i = 0; i < n; i++) {
                customDeque.addLast(i);
            }
            return null;
        });

        Benchmark.measureWithResults("CustomDeque peekFirst " + n + " elements", () -> {
            for (int i = 0; i < n; i++) {
                customDeque.peekFirst();
            }
            return null;
        });

        Benchmark.measureWithResults("CustomDeque peekLast " + n + " elements", () -> {
            for (int i = 0; i < n; i++) {
                customDeque.peekLast();
            }
            return null;
        });

        Benchmark.measureWithResults("CustomDeque removeFirst " + n + " elements", () -> {
            while (!customDeque.isEmpty()) {
                customDeque.removeFirst();
            }
            return null;
        });

        Benchmark.measureWithResults("CustomDeque removeLast " + n + " elements", () -> {
            while (!customDeque.isEmpty()) {
                customDeque.removeLast();
            }
            return null;
        });

        Benchmark.measureWithResults("CustomDeque contains " + n + " elements", () -> {
            for (int i = 0; i < n; i++) {
                customDeque.contains(i);
            }
            return null;
        });




    }
}