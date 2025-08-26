package com.brendanddev.collections.performance;

import java.util.Stack;

import com.brendanddev.collections.stack.CustomStack;

/**
 * Provides performance comparison benchmarks between custom stack implementations
 * and their standard Java Collections Framework counterparts.
 * 
 * This class runs benchmarks for common operations such as pushing, popping, and 
 * peeking elements in both custom and Java stacks.
 */
public class CompareStack {

    /**
     * Benchmarks the performance of CustomStack against Java's Stack.
     * 
     * @param n The number of elements to push, pop, and peek.
     */
    public static void benchmarkStacks(int n) {
        CustomStack<Integer> customStack = new CustomStack<>();
        Stack<Integer> javaStack = new Stack<>();

        // Compare pushing (adding) n elements
        Benchmark.measureWithResults("CustomStack push " + n + " elements", () -> {
            for (int i = 0; i < n; i++) customStack.push(i);
            return null;
        });
        Benchmark.measureWithResults("Java Stack push " + n + " elements", () -> {
            for (int i = 0; i < n; i++) javaStack.push(i);
            return null;
        });

        // Compare peeking (accessing top) n elements
        Benchmark.measureWithResults("CustomStack peek " + n + " elements", () -> {
            for (int i = 0; i < n; i++) customStack.peek();
            return null;
        });
        Benchmark.measureWithResults("Java Stack peek " + n + " elements", () -> {
            for (int i = 0; i < n; i++) javaStack.peek();
            return null;
        });

        // Compare popping (removing) n elements
        Benchmark.measureWithResults("CustomStack pop " + n + " elements", () -> {
            while (!customStack.isEmpty()) customStack.pop();
            return null;
        });
        Benchmark.measureWithResults("Java Stack pop " + n + " elements", () -> {
            while (!javaStack.isEmpty()) javaStack.pop();
            return null;
        });

    }
    
}
