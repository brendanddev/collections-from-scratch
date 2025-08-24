package com.brendanddev.collections.map;

import java.util.ArrayList;

/**
 * A custom generic hash based implementation of a Map using an array of buckets.
 * 
 * Time Complexity
 * Insert/Update: O(1)
 * Search (get/containsKey): O(1)
 * Remove: O(1)
 * Resize: O(n) (but happens rarely)
 * 
 * Note: Worst-case time complexity can degrade to O(n) per operation if many keys collide.
 */
public class CustomHashMap<K, V> {

    private ArrayList<Entry<K, V>>[] buckets;
    private static final int DEFAULT_BUCKETS = 16;
    private int size = 0;
    public static final double AVERAGE_BUCKET_SIZE = 3;

    /**
     * Constructs an empty CustomHashMap with default number of buckets.
     */
    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        buckets = new ArrayList[DEFAULT_BUCKETS];
        for (int i = 0; i < DEFAULT_BUCKETS; i++) {
            buckets[i] = new ArrayList<>();
        }
    }

    /**
     * Computes the bucket index for a given key.
     * 
     * @param key The key for which to compute the bucket index.
     * @param hashSize The total number of buckets in the map.
     * @return The index of the bucket where the key should be stored.
     */
    private int getHash(K key, int hashSize) {
        return Math.abs(key.hashCode() % hashSize);
    }

    /**
     * Adds a key-value pair to the CustomHashMap.
     * 
     * If the key already exists, updates its value and returns the old value.
     * If the key does not exist, inserts a new entry and returns null.
     * Automatically resizes the buckets array if the average number of entries per bucket 
     * exceeds the threshold to maintain performance.
     * 
     * @param key The key to add or update in the map.
     * @param value The value associated with the key.
     * @return The old value associated with the key if it existed, 
     *         or null if a new entry was added.
     */
    public V put(K key, V value) {
        // Compute bucket index for this key using its hash code
        int index = getHash(key, buckets.length);
        ArrayList<Entry<K, V>> bucket = buckets[index];

        // Iterate over existing entries in the bucket to see if the key already exists
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                // Key exists, update its value and return old value
                V oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
        }

        // Key not found, add new entry
        bucket.add(new Entry<>(key, value));
        size++;

        // Resize if necessary
        if ((double) size / buckets.length > AVERAGE_BUCKET_SIZE) {
            resize();
        }

        return null;
    }

    /**
     * Retrieves the value associated with a key.
     * 
     * @param key The key to lookup.
     * @return The value for the key, or null if the key does not exist.
     */
    public V get(K key) {
        // Compute bucket index for the key
        int index = getHash(key, buckets.length);
        ArrayList<Entry<K, V>> bucket = buckets[index];

        // Iterate through the entries in this bucket
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                // Key found, return value
                return entry.value;
            }
        }
        // Key not found
        return null;
    }

    /**
     * Removes the key-value pair for a given key.
     * 
     * @param key The key to remove.
     * @return true if the key existed and was removed, otherwise false.
     */
    public boolean remove(K key) {
        int index = getHash(key, buckets.length);
        ArrayList<Entry<K, V>> bucket = buckets[index];

        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).key.equals(key)) {
                bucket.remove(i);
                size--;
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the map contains a given key.
     * 
     * @param key The key to check.
     * @return true if the key exists, otherwise false.
     */
    public boolean containsKey(K key) {
        int index = getHash(key, buckets.length);
        ArrayList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns the number of key-value pairs currently stored in the map.
     */
    public int size() {
        return size;
    }

    /**
     * Checks whether the map contains any key-value pairs.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Doubles the number of buckets in the map and rehashes all existing entries.
     * 
     * This method is called when the average number of entries per bucket exceeds a threshold,
     * in order to reduce collisions and maintain efficient access. Each entry is redistributed
     * according to the new number of buckets.
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        // Calculate the new number of buckets
        int newBucketCount = buckets.length * 2;

        // Create a new array of buckets, initializing each as an empty ArrayList
        ArrayList<Entry<K, V>>[] newBuckets = new ArrayList[newBucketCount];
        for (int i = 0; i < newBucketCount; i++) {
            newBuckets[i] = new ArrayList<>();
        }

        // Rehash each existing entry into the appropriate new bucket
        for (ArrayList<Entry<K, V>> bucket : buckets) {
            for (Entry<K, V> entry : bucket) {
                int newIndex = getHash(entry.key, newBucketCount);
                newBuckets[newIndex].add(entry);
            }
        }
        // Replace the old buckets array with the new, resized array
        buckets = newBuckets;
    }


    /**
     * Represents a key-value pair stored in the CustomHashMap.
     * Each entry is stored in a bucket, and key equality determines uniqueness.
     */
    private static class Entry<K, V> {
        K key;
        V value;

        /**
         * Constructs an Entry with both a key and value.
         * 
         * @param key The key for the entry.
         * @param value The value associated with the key.
         */
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Constructs an Entry with only a key.
         * 
         * @param key The key for this entry.
         */
        @SuppressWarnings("unused")
        Entry(K key) {
            this.key = key;
        }

        /**
         * Checks if this Entry is equal to another object.
         * Two entries are considered equal if their keys are equal.
         * 
         * @param o The object to compare to.
         * @return true if the keys are equal, otherwise false.
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Entry)) return false;
            return key.equals(((Entry<?, ?>) o).key);
        }

        /**
         * Returns the hash code of this entry.
         * Based only on the key to ensure consistent bucket placement.
         * 
         * @return The hash code of the key.
         */
        @Override
        public int hashCode() {
            return key.hashCode();
        }

        /** Returns a string representation of this Entry  */
        @Override
        public String toString() {
            return key + "=" + value;
        }
    }
    
}
