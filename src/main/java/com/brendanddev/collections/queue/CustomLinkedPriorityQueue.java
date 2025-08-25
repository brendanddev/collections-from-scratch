package com.brendanddev.collections.queue;


/**
 * A custom generic implementation of a Priority Queue using a linked list.
 * Elements with lower priority values are dequeued before elements with higher priority values.
 * 
 * Time Complexity
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
        size++;

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
     * Represents a doubly linked node in the priority queue.
     * Each node stores a value, its priority, and pointers to the next and previous nodes.
     */
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
    
}
