package com.brendanddev.collections.list;

import java.util.NoSuchElementException;

import com.brendanddev.collections.core.CustomCollection;
import com.brendanddev.collections.core.CustomIterator;

/**
 * A custom generic array-backed list implementation.
 */
public class CustomArrayList<T> implements CustomCollection<T> {
    
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Constructs an empty CustomArrayList with default initial capacity.
     */
    public CustomArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }


    /**
     * Ensures that the internal array has enough capacity to add a new element.
     * 
     * If the current array is full, the arrays capacity is doubled and all existing
     * elements are copied to the new array.
     */
    private void ensureCapacity() {
        if (size >= elements.length) {
            Object[] newArr = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newArr, 0, elements.length);
            elements = newArr;
        }
    }

    /**
     * Inner class implementing the CustomIterator for this list.
     */
    private class CustomArrayListIterator implements CustomIterator<T> {
        private int currentIndex = 0;

        /**
         * Checks if there are more elements to iterate over.
         */
        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        /**
         * Returns the next element in the iteration.
         */
        @SuppressWarnings("unchecked")
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the list.");
            }
            return (T) elements[currentIndex++];
        }

    }

}
