package com.brendanddev.collections.performance;

import java.util.function.Supplier;

/**
 * Utility class for comparing performance between different data structures.
 */
public class Benchmark {

    /**
     * Measures the time taken to execute a runnable.
     * 
     * @param name The name of the operation.
     * @param operation The code block to benchmark.
     */
    public static void measure(String name, Runnable operation) {
        long start = System.nanoTime();
        operation.run();
        long end = System.nanoTime();
        System.out.printf("%s took %.3f ms%n", name, (end - start) / 1e6);
    }

    /**
     * Measures the time taken to execute a Supplier and returns its result.
     * 
     * @param <T> The type of the result returned by the Supplier.
     * @param name The name of the operation.
     * @param operation The Supplier function being executed.
     * @return The result of the operation.
     */
    public static <T> T measureWithResults(String name, Supplier<T> operation) {
        long start = System.nanoTime();
        T result = operation.get();
        long end = System.nanoTime();
        System.out.printf("%s took %.3f ms%n", name, (end - start) / 1e6);
        return result;
    }


    
}
