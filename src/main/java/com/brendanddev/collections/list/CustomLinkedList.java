package com.brendanddev.collections.list;

import com.brendanddev.collections.core.CustomCollection;
import com.brendanddev.collections.core.CustomIterator;

/**
 * 
 */
public class CustomLinkedList<T> implements CustomCollection<T> {
    
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    /**
     * Constructs an empty CustomLinkedList.
     */
    public CustomLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Adds a new element to the end of the doubly linked list.
     * 
     * A new node is created with the specified value, and its previous link points to the current
     * tail of the list. If the list is empty, the new node becomes both the head and tail.
     * Otherwise, the current tail's next link is updated to point to the new node. The tail
     * reference is then updated to the new node, and the size of the list is incremented.
     * 
     * @param value The value to add to the end of the list.
     * @return true, since the list is always modified by adding.
     */
    @Override
    public boolean add(T value) {
        Node<T> newNode = new Node<T>(value, tail, null);
        if (tail != null) {
            // Link the old tail to the new node
            tail.next = newNode;
        } else {
            // List was empty, so new node is also the head
            head = newNode;
        }
        tail = newNode;
        size++;
        return true;
    }




    

    /**
     * Returns the number of elements in the list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns true if the list contains no elements, otherwise false.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }




    /**
     * A Node of a doubly linked list, holding a value a links to the previous and next nodes.
     */
    private static class Node<T> {
        T value;
        Node<T> prev;
        Node<T> next;

        /**
         * Constructs a Node with a value, link to the previous node, and link to the next node.
         * 
         * @param value The value to store in this node.
         * @param prev The link to the previous node.
         * @param next The link to the next node.
         */
        Node(T value, Node<T> prev, Node<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        /**
         * Constructs a Node with only a value.
         * 
         * @param value The value to store in this node.
         */
        Node(T value) {
            this(value, null, null);
        }
    }
    
}
