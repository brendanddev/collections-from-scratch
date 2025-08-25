package com.brendanddev.collections.list;

import com.brendanddev.collections.core.CustomCollection;
import com.brendanddev.collections.core.CustomIterator;

public class CustomLinkedList<T> implements CustomCollection<T> {
























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
