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

    /**
     * Adds the specified element to the set if not already present.
     * 
     * @param element The element to add to the set.
     * @return true if the element was successfully added, otherwise false.
     */
    @Override
    public boolean add(T element) {
        // Compute the bucket index for this element based on its hash code
        int index = getHash(element, buckets.length);
        ArrayList<T> bucket = buckets[index];

        // Prevent duplicates
        if (bucket.contains(element)) {
            return false;
        }

        // Add element to the bucket and increment total size
        bucket.add(element);
        size++;

        // Check if resize is needed
        if ((double) size / buckets.length > AVERAGE_BUCKET_SIZE) {
            resize();
        }

        return true;
    }

    /**
     * Removes the specified element from the set if present.
     * 
     * @param element The element to remove.
     * @return true if the element was found and removed, otherwise false.
     */
    @Override
    public boolean remove(T element) {
        int index = getHash(element, buckets.length);
        ArrayList<T> bucket = buckets[index];

        if (bucket.remove(element)) {
            size--;
            return true;
        }
        return false;
    }

    /**
     * Checks whether the specified element exists in the set.
     * 
     * @param element The element to check for.
     * @return true if the element exists in the set, otherwise false.
     */
    @Override
    public boolean contains(T element) {
        // Compute which bucket this element belongs to based on its hash code
        int index = getHash(element, buckets.length);
        ArrayList<T> bucket = buckets[index];
        return bucket.contains(element);
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

    /**
     * Doubles the number of buckets in the set and redistributes all existing elements.
     * 
     * This method is called when the average number of elements per bucket exceeds the desired
     * threshold, to reduce collisions and maintain efficient access. Each element is rehashed 
     * according to the new bucket array size.
     */
    private void resize() {
        // Calculate new bucket count
        int newBucketCount = buckets.length * 2;

        // Create a new array of buckets, initializing each bucket as an empty list
        ArrayList<T>[] newBuckets = new ArrayList[newBucketCount];
        for (int i = 0; i < newBucketCount; i++) {
            newBuckets[i] = new ArrayList<T>();
        }

        // Rehash each element from the old buckets into new buckets
        for (ArrayList<T> bucket : buckets) {
            for (T element : bucket) {
                int index = getHash(element, newBucketCount);
                newBuckets[index].add(element);
            }
        }
        // Replace old buckets with new resized bucket array
        buckets = newBuckets;
    }

    /**
     * Returns the number of buckets that are currently empty.
     */
    public int getNumberOfEmptyBuckets() {
        int empty = 0;
        for (ArrayList<T> bucket : buckets) {
            if (bucket.isEmpty()) empty++;
        }
        return empty;
    }

    /** 
     * Returns the number of elements in the largest bucket.
     */
    public int getLargestBucketSize() {
        int max = 0;
        for (ArrayList<T> bucket : buckets) {
            if (bucket.size() > max) max = bucket.size();
        }
        return max;
    }


    /**
     * Returns the total number of buckets in the set.
     */
    public int getNumberOfBuckets() {
        return buckets.length;
    }

    /**
     * Creates and returns a new iterator over the elements in this set.
     * The iterator will traverse all buckets in order and all elements in each bucket.
     * 
     * @return CustomIterator for iterating over the sets elements.
     */
    @Override
    public CustomIterator<T> iterator() {
        return new CustomHashSetIterator();
    }

    /**
     * Private inner class that provides iteration over all elements in the set.
     */
    private class CustomHashSetIterator implements CustomIterator<T> {
        // Track current bucket and index within current bucket
        private int bucketIndex = 0;
        private int elementIndex = 0;

        /**
         * Checks whether there are more elements to iterate over in the set.
         * Advances the bucket index forward if the current bucket is empty or if the
         * element index has passed the last element in the current bucket.
         * 
         * @return true if there are more elements in the set, otherwise false.
         */
        @Override
        public boolean hasNext() {

            // Skip empty buckets
            while (bucketIndex < buckets.length && elementIndex >= buckets[bucketIndex].size()) {
                bucketIndex++;
                elementIndex = 0;
            }
            return bucketIndex < buckets.length;
        }

        /**
         * Returns the next element in the iteration.
         * If no more elements are available, throws an exception.
         * 
         * @return The next element in the set.
         * @throws IllegalStateException if there are no more elements to return.
         */
        @Override
        public T next() {
            if (!hasNext()) {
                throw new IllegalStateException("No more elements in iterator!");
            }
            return buckets[bucketIndex].get(elementIndex++);
        }

    }
    
    
}
