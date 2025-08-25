package com.brendanddev.collections.queue;

import java.util.NoSuchElementException;

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
     * Removes and returns the element at the front of the deque.
     * 
     * @return The value at the front of the deque.
     * @throws NoSuchElementException if the deque is empty.
     */
    public T removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("Deque is empty");
        // Retrieve data and move head forward
        T data = head.data;
        head = head.next;

        if (head != null) {
            // If deque still has elements, disconnect previous link of the new head
            head.prev = null;
        } else {
            // Deque is now empty, so update tail as well
            tail = null;
        }
        size--;
        return data;
    }

    /**
     * Removes and returns the element at the end of the deque.
     * 
     * @return The value at the end of the deque.
     * @throws NoSuchElementException if the deque is empty.
     */
    public T removeLast() {
        if (isEmpty()) throw new NoSuchElementException("Deque is empty");
        T data = tail.data;
        tail = tail.prev;

        if (tail != null) {
            // If deque still has elements, disconnect next link of the new tail
            tail.next = null;
        } else {
            // Deque is now empty, so update head as well
            head = null;
        }
        size--;
        return data;
    }

    /**
     * Returns the element at the front of the deque without removing it.
     * 
     * @return The value at the front of the deque.
     * @throws NoSuchElementException if the deque is empty.
     */
    public T peekFirst() {
        if (isEmpty()) throw new NoSuchElementException("Deque is empty");
        return head.data;
    }

    /**
     * Returns the element at the end of the deque without removing it.
     * 
     * @return The value at the end of the deque.
     * @throws NoSuchElementException if the deque is empty.
     */
    public T peekLast() {
        if (isEmpty()) throw new NoSuchElementException("Deque is empty");
        return tail.data;
    }

    /**
     * Checks if the deque contains a specific element.
     * 
     * @param element The element to search for.
     * @return true if the element exists in the deque, otherwise false.
     */
    public boolean contains(T element) {
        for (Node<T> current = head; current != null; current = current.next) {
            if (current.data.equals(element)) return true;
        }
        return false;
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
     * Clears all elements from the deque.
     */
    public void clear() {
        head = tail = null;
        size = 0;
    }

    /**
     * Returns a string representation of the deque.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
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
