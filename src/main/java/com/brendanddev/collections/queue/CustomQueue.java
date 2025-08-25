package com.brendanddev.collections.queue;

import com.brendanddev.collections.list.CustomLinkedList;

/**
 * A custom generic implementation of a Queue using a linked list.
 * 
 * Time Complexity
 * Enqueue: O(1)
 * Dequeue: O(1)
 * Peek: O(1)
 * IsEmpty: O(1)
 * Size: O(1)
 * Clear: O(1)
 */
public class CustomQueue<T> {

    private CustomLinkedList<T> linkedList;

    /**
     * Constructs an empty CustomQueue.
     */
    public CustomQueue() {
        linkedList = new CustomLinkedList<>();
    }

    /**
     * Adds a new element to the end of the queue.
     * 
     * @param value The value to add to the queue.
     */
    public void enqueue(T value) {
        // Add to tail of linked list
        linkedList.add(value);
    }

    /**
     * Removes and returns the element at the front of the queue.
     * 
     * @return The value at the front of the queue.
     * @throws IllegalStateException if the queue is empty.
     */
    public T dequeue() {
        if (linkedList.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        // Remove from head of linked list
        return linkedList.removeAt(0);
    }

    /**
     * Returns the element at the front of the queue without removing it.
     * 
     * @return The value at the front of the queue.
     * @throws IllegalStateException if the queue is empty.
     */
    public T peek() {
        if (linkedList.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        // Get at head of linked list
        return linkedList.get(0);
    }

    /**
     * Checks if the queue is empty.
     * 
     * @return true if the queue is empty, otherwise false.
     */
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    /**
     * Returns the number of elements in the queue.
     * 
     * @return The size of the queue.
     */
    public int size() {
        return linkedList.size();
    }

    /**
     * Removes all elements from the queue.
     */
    public void clear() {
        linkedList.clear();
    }

    /**
     * Returns a string representation of the queue.
     */
    public String toString() {
        return "CustomQueue" + linkedList.toString();
    }


}
