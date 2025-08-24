package com.brendanddev.collections.map;


/**
 * 
 */
public class CustomHashMap<K, V> {






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
