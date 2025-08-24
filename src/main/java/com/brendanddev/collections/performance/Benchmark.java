package com.brendanddev.collections.performance;


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

    
    
}
