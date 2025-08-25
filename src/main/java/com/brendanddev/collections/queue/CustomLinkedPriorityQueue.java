package com.brendanddev.collections.queue;


/**
 * A custom generic implementation of a Priority Queue using a linked list.
 */
public class CustomLinkedPriorityQueue<T> {

    private Node<T> first;
    private Node<T> last;
    private int size = 0;







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
