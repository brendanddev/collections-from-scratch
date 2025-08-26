package com.brendanddev.collections.heap;

import com.brendanddev.collections.core.CustomCollection;
import com.brendanddev.collections.core.CustomIterator;
import com.brendanddev.collections.list.CustomArrayList;

/**
 * A custom generic implementation of a Min-Heap backed by a CustomArrayList.
 * Uses the Comparable interface to maintain ordering of generic elements.
 */
public class CustomHeapList<T extends Comparable<T>> implements CustomCollection<T> {
    
    private final CustomArrayList<T> list;

    /**
     * Constructs an empty CustomHeapList.
     */
    public CustomHeapList() {
        list = new CustomArrayList<>();
    }


    @Override
    public boolean add(T element) {
    }

    @Override
    public boolean remove(T element) {
       
    }

    /**
     * Checks if the heap contains the specified element.
     * 
     * @param element The element to check for.
     * @return true if the element is found, otherwise false.
     */
    @Override
    public boolean contains(T element) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the number of elements in the heap.
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * Checks if the heap is empty.
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }


    @Override
    public CustomIterator<T> iterator() {
    }
    
}
