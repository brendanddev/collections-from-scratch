package com.brendanddev.collections.heap;

import com.brendanddev.collections.core.CustomCollection;

/**
 * A custom generic implementation of a Min-Heap backed by an array.
 * Uses the Comparable interface to maintain ordering of generic elements.
 */
public class CustomHeap<T extends Comparable<T>> implements CustomCollection<T> {
    
    private T[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;

    /**
     * Constructs an empty CustomHeap with default initial capacity.
     */
    @SuppressWarnings("unchecked")
    public CustomHeap() {
        elements = (T[]) new Comparable[DEFAULT_CAPACITY];
        size = 0;
    }




    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (elements[index].compareTo(elements[parent]) < 0) {
                swap(index, parent);
                index = parent;
            } else break;
        }
    }

    private void heapifyDown(int index) {
        while (index < size) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int smallest = index;

            if (leftChild < size && elements[leftChild].compareTo(elements[smallest]) < 0) {
                smallest = leftChild;
            }
            if (rightChild < size && elements[rightChild].compareTo(elements[smallest]) < 0) {
                smallest = rightChild;
            }
            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else break;
        }
    }
    
    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (size >= elements.length) {
            T[] newArray = (T[]) new Comparable[elements.length * 2];
            System.arraycopy(elements, 0, newArray, 0, elements.length);
            elements = newArray;
        }
    }


    /**
     * Helper to swap two elements in the heap array.
     * 
     * @param i The index of the first element to swap.
     * @param j The index of the second element to swap.
     */
    private void swap(int i, int j) {
        T temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }




}
