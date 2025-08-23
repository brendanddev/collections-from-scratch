package com.brendanddev.collections.list;

import com.brendanddev.collections.core.CustomCollection;

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
    
}
