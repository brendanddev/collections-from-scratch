package com.brendanddev.collections.performance;

import java.util.function.Supplier;

/**
 * Utility class for comparing performance between different data structures.
 */
public class Benchmark {

    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";

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
        double elapsedMs = (end - start) / 1e6;

        System.out.printf("%s took %s%.3f ms%s%n", 
                name, getColorForTime(elapsedMs), elapsedMs, RESET);
        return result;
    }

    /**
     * Helper to get color code based on elapsed time.
     * 
     * @param elapsedMs The elapsed time in milliseconds.
     * @return The ANSI color code string for the elapsed time.
     */
    private static String getColorForTime(double elapsedMs) {
        if (elapsedMs > 30) {
            return RED;
        } else if (elapsedMs >= 7) {
            return YELLOW;
        } else {
            return GREEN;
        }
    }


    
}
