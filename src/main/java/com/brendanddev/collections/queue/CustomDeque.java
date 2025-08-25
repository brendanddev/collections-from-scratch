package com.brendanddev.collections.queue;







/**
 * A custom generic implementation of a Deque (double-ended queue).
 */
public class CustomDeque<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

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
