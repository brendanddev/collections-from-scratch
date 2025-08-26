package com.brendanddev.collections.queue;

import java.util.NoSuchElementException;

import com.brendanddev.collections.core.CustomIterator;

/**
 * A custom generic implementation of a Priority Queue using a linked list.
 * Elements with lower priority values are dequeued before elements with higher priority values.
 * 
 * Time Complexity
 * Enqueue: O(n) - due to traversal to find correct position
 * Dequeue: O(1)
 * Peek: O(1)
 * Contains: O(n)
 * IsEmpty: O(1)
 * Size: O(1)
 * Clear: O(1)
 */
public class CustomLinkedPriorityQueue<T> {

    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    /**
     * Adds a new element to the priority queue with the specified priority.
     * 
     * @param value The value to add to the queue.
     * @param priority The priority of the element.
     */
    public void enqueue(T value, int priority) {
        Node<T> newNode = new Node<>(value, priority);

        // If queue is empty, new node is both the first and last node
        if (isEmpty()) {
            first = last = newNode;
            return;
        }

        // Store refs to traverse the list
        Node<T> current = first;
        Node<T> previous = null;

        // Traverse to find the correct insertion point based on priority
        while (current != null && current.priority <= priority) {
            previous = current;
            current = current.next;
        }

        if (previous == null) {
            // Insert at the front
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        } else if (current == null) {
            // Insert at the end
            previous.next = newNode;
            newNode.prev = previous;
            last = newNode;
        } else {
            // Insert in the middle
            previous.next = newNode;
            newNode.prev = previous;
            newNode.next = current;
            current.prev = newNode;
        }
        size++;
    }

    /**
     * Removes and returns the element with the highest priority (lowest priority value).
     * 
     * @return The value of the removed element.
     * @throws NoSuchElementException if the priority queue is empty.
     */
    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException("PriorityQueue is empty");
        
        // Store the value of first node, and move first pointer to next node
        T value = first.value;
        first = first.next;

        if (first != null) {
            // If there is a new first node, disconnect its previous link
            first.prev = null;
        } else {
            // If the queue is now empty, also clear the last pointer
            last = null;
        }
        size--;
        return value;
    }

    /**
     * Returns the element with the highest priority without removing it.
     * 
     * @return The value of the element at the front of the queue.
     * @throws NoSuchElementException if the priority queue is empty.
     */
    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("PriorityQueue is empty");
        return first.value;
    }

    /**
     * Checks if the priority queue contains the specified value.
     * 
     * @param value The value to search for.
     * @return true if the value exists in the queue, otherwise false.
     */
    public boolean contains(T value) {
        Node<T> current = first;
        while (current != null) {
            if (current.value.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /** 
     * Checks if the priority queue is empty.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /** 
     * Returns the number of elements in the priority queue.
     */
    public int size() {
        return size;
    }

    /**
     * Clears all elements from the priority queue.
     */
    public void clear() {
        first = last = null;
        size = 0;
    }

    /**
     * Returns a string representation of the priority queue.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CustomLinkedPriorityQueue: [");
        Node<T> current = first;
        while (current != null) {
            sb.append("{value: ").append(current.value)
              .append(", priority: ").append(current.priority).append("}");
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Returns an iterator to traverse the priority queue from front to back.
     * 
     * @return A CustomIterator for the priority queue.
     */
    public CustomIterator<T> iterator() {
        return new LinkedPriorityQueueIterator();
    }


    /**
     * Represents a doubly linked node in the priority queue.
     * Each node stores a value, its priority, and pointers to the next and previous nodes.
     */
    @SuppressWarnings("hiding")
    private class Node<T> {
        T value;
        int priority;
        Node<T> next;
        Node<T> prev;

        /**
         * Constructs a new node with the given value and priority.
         * 
         * @param value The value to store in this node.
         * @param priority The priority of this node.
         */
        Node(T value, int priority) {
            this.value = value;
            this.priority = priority;
            this.next = null;
            this.prev = null;
        }
    }

    /**
     * An iterator for the CustomLinkedPriorityQueue.
     * Allows traversal of elements from the front to the back of the queue.
     */
    private class LinkedPriorityQueueIterator implements CustomIterator<T> {
        private Node<T> current = first;

        /**
         * Checks if there are more elements to iterate over.
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Returns the next element in the iteration and advances the iterator.
         */
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T value = current.value;
            current = current.next;
            return value;
        }
    }
    
}
