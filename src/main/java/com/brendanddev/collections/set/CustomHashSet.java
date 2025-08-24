package com.brendanddev.collections.set;

import java.util.ArrayList;

import com.brendanddev.collections.core.CustomCollection;
import com.brendanddev.collections.core.CustomIterator;


/**
 * A generic hash based implementation of a Set using an array of buckets.
 * Each bucket is an ArrayList that stores elements with the same hash index.
 */
public class CustomHashSet<T> implements CustomCollection<T> {

    private ArrayList<T>[] buckets;
    private static final int DEFAULT_BUCKETS = 16;
    private int size = 0;
    public static final double AVERAGE_BUCKET_SIZE = 3;


    /**
     * Constructs a new empty CustomHashSet with a default number of buckets.
     * Initializes each bucket as an empty ArrayList.
     */
    public CustomHashSet() {
        buckets = new ArrayList[DEFAULT_BUCKETS];
        for (int i = 0; i < DEFAULT_BUCKETS; i++) {
            buckets[i] = new ArrayList<T>();
        }
    }

    /**
     * Computes the has bucket index for a given element.
     * The index is calculated using the elements hash code modulo the total number of buckets,
     * and adjusted to ensure a non negative result.
     * 
     * @param x The element for which to compute the bucket index.
     * @param hashSize The total number of buckets.
     * @return The index of the bucket in which the element should be placed.
     */
    public int getHash(T x, int hashSize) {
        return Math.abs(x.hashCode() % hashSize);
    }


    @Override
    public boolean add(T element) {
    }

    @Override
    public boolean remove(T element) {
    }

    @Override
    public boolean contains(T element) {
    }

    /**
     * Returns the number of elements currently stored in the set.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks if the set contains no elements.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public CustomIterator<T> iterator() {

    }

    /**
     * 
     */
    private class CustomHashSetIterator implements CustomIterator<T> {

    }
    
    
}
