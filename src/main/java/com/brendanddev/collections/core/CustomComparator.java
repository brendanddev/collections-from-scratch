package com.brendanddev.collections.core;


/**
 * A custom Comparator interface for comparing two generic values of type T.
 */
@FunctionalInterface
public interface CustomComparator<T> {

    /**
     * Compares two values of type T.
     * 
     * @param a The first value to compare.
     * @param b The second value to compare.
     * @return A negative integer if a is less than b, zero if they are equal,
     *         or a positive integer if a is greater than b.
     */
    int compare(T a, T b);
    
}
