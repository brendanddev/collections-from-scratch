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
     * Adds an element to the end of the list.
     * If the internal array is full, the arrays capacity is doubled before adding.
     * 
     * @param element The element to add to the list.
     * @return true, since the list is always modified by adding.
     */
    @Override
    public boolean add(T element) {
        if (element == null) throw new IllegalArgumentException("Null elements not allowed");
        ensureCapacity();
        elements[size] = element;
        size++;
        return true;
    }

    /**
     * Removes the first occurrence of the specified element from the list if it exists.
     * After removal, all subsequent elements to the left are shifted to fill the gap.
     * 
     * @param element The element to remove from the list.
     * @return true if the element was found and removed, otherwise false.
     */
    @Override
    public boolean remove(T element) {
        if (isEmpty()) return false;

        // Loop to find element
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                // Shift all elements to the left after the removed element
                for (int j = i; j < size - 1; j++) {
                    elements[j] = elements[j + 1];
                }

                elements[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the CustomArrayList contains a specific element.
     * 
     * @param item The item to search for.
     * @return true if the item exists in the list, otherwise false.
     */
    @Override
    public boolean contains(T element) {
        if (isEmpty()) return false;

        for (int i = 0; i < size; i++) {
            if (elements[i] != null && elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the number of elements in the list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks if the list is empty.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns an iterator over the elements in the list.
     * 
     * @return a CustomIterator for traversing the list
     */
    @Override
    public CustomIterator<T> iterator() {
        return new CustomArrayListIterator();
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
