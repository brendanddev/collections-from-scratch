package com.brendanddev.collections.queue;


/**
 * A custom generic implementation of a Deque (double-ended queue).
 */
public class CustomDeque<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    /**
     * Adds an element to the front of the deque.
     * 
     * @param element The value to add to the front of the deque.
     */
    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element);
        // If deque is empty, new node is both head and tail
        if (isEmpty()) {
            head = tail = newNode;
        // If not empty, insert at front
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    /**
     * Adds an element to the end of the deque.
     * 
     * @param element The value to add to the end of the deque.
     */
    public void addLast(T element) {
        Node<T> newNode = new Node<>(element);
        // If deque is empty, new node is both head and tail
        if (isEmpty()) {
            head = tail = newNode;
        // If not empty, insert at end
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }













    /** 
     * Checks if the deque is empty.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /** 
     * Returns the size of the deque.
     */
    public int size() {
        return size;
    }


    /**
     * A doubly linked Node used internally by the Deque.
     */
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        /**
         * Constructs a new Node with the specified data.
         * 
         * @param data The data to store in this node.
         */
        Node(T data) {
            this.data = data;
        }
    }
    
}
