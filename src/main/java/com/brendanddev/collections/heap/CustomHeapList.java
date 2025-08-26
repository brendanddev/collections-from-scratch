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

    /**
     * Returns an iterator to traverse the elements in the heap.
     */
    @Override
    public CustomIterator<T> iterator() {
        return list.iterator();
    }

    /**
     * Restores the heap property by moving the element at the given index upward until the 
     * min-heap property is satisfied.
     * 
     * @param index The index of the element to heapify up.
     */
    private void heapifyUp(int index) {
        while (index > 0) {
            // Find the parent index
            int parentIndex = (index - 1) / 2;

            // Get current and parent elements for comparison
            T currentElement = list.get(index);
            T parentElement = list.get(parentIndex);

            // If current element is less than its parent, swap them
            if (currentElement.compareTo(parentElement) < 0) {
                swap(index, parentIndex);
                // Move up to the parent's index and repeat
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    /**
     * Restores the heap property by moving the element at the given index downward until the
     * min-heap property is satisfied.
     * 
     * @param index The index of the element to heapify down.
     */
    private void heapifyDown(int index) {
        int size = list.size();
        
        // Continue while index has at least one child
        while (index < size) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int smallestIndex = index;

            // If left child exists and is smaller, mark it as smallest
            if (leftChildIndex < size && list.get(leftChildIndex).compareTo(list.get(smallestIndex)) < 0) {
                smallestIndex = leftChildIndex;
            }

            // If right child exists and is smaller, mark it as smallest
            if (rightChildIndex < size && list.get(rightChildIndex).compareTo(list.get(smallestIndex)) < 0) {
                smallestIndex = rightChildIndex;
            }

            // If a smaller child was found, swap with it and continue
            if (smallestIndex != index) {
                swap(index, smallestIndex);
                index = smallestIndex;
            } else {
                break;
            }
        }
    }

    /**
     * Helper to swap elements at indices i and j in the underlying list.
     * 
     * @param i The index of the first element.
     * @param j The index of the second element.
     */
    private void swap(int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
    
}
