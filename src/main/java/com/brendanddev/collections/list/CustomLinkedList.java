package com.brendanddev.collections.list;

import com.brendanddev.collections.core.CustomCollection;
import com.brendanddev.collections.core.CustomIterator;

/**
 * A custom implementation of a generic doubly linked list.
 * 
 * Time Complexity
 * Add: O(1) - (At the end)
 * Contains: O(n)
 * Remove: O(n)
 * Get: O(n)
 * Set: O(n)
 * RemoveAt: O(n)
 * Clear: O(1)
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
     * Checks if the list contains the specified element.
     * 
     * @param element The element to search for in the list.
     * @return true if the element is found, otherwise false.
     */
    @Override
    public boolean contains(T element) {
        if (isEmpty()) return false;

        // Traverse the list to find the element starting from the head
        for (Node<T> current = head; current != null; current = current.next) {
            if (current.value.equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Removes the first occurrence of the specified element from the list if it exists.
     * 
     * Traverses the list starting from the head. If the element is found, the node is removed by
     * updating the links of its previous and next nodes. If the node to remove is the head or tail,
     * the head or tail references are updated accordingly.
     * 
     * @param element The element to remove from the list.
     * @return true if the element was found and removed, otherwise false.
     */
    @Override
    public boolean remove(T element) {
        if (isEmpty()) return false;

        // Start at the head and traverse the list
        Node<T> current = head;
        while (current != null) {
            // Check if current node holds the element to remove
            if (current.value.equals(element)) {
                // Element found
                if (current.prev != null) {
                    // Update the link from the previous node if it exists
                    current.prev.next = current.next;
                } else {
                    // If no previous node, we are at the head
                    head = current.next;
                }

                // Update the link from the next node if it exists
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    // If no next node, we are removing the tail
                    tail = current.prev;
                }

                size--;
                return true;
            }
            // Move to the next node
            current = current.next;
        }
        return false;
    }

    /**
     * Returns the element at the specified index in the list.
     * 
     * @param index The index of the element to retrieve.
     * @return The element at the specified index.
     */
    public T get(int index) {
        checkIndex(index);
        return nodeAt(index).value;
    }

    /**
     * Replaces the element at the specified index with the given value.
     * 
     * @param index The index of the element to replace.
     * @param element The new value to set at the specified index.
     * @return The old value that was replaced.
     */
    public T set(int index, T element) {
        checkIndex(index);
        // Find node at the specified index
        Node<T> targetNode = nodeAt(index);
        // Save old value and replace with new
        T oldValue = targetNode.value;
        targetNode.value = element;
        return oldValue;
    }


    /**
     * Removes and returns the element at the specified index in the list.
     * 
     * Traverses the list to locate the node at the given index. Once found, it updates the links of the
     * previous and next nodes to exclude the target node from the list. If the target node is the head or tail,
     * the head or tail references are updated accordingly.
     * 
     * @param index The index of the element to remove.
     * @return The value of the removed element.
     */
    public T removeAt(int index) {
        checkIndex(index);
        Node<T> targetNode = nodeAt(index);
        T removedValue = targetNode.value;

        // Update the previous nodes next pointer
        if (targetNode.prev != null) {
            targetNode.prev.next = targetNode.next;
        } else {
            head = targetNode.next;
        }

        // Update the next nodes previous pointer
        if (targetNode.next != null) {
            targetNode.next.prev = targetNode.prev;
        } else {
            tail = targetNode.prev;
        }
        size--;
        return removedValue;
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
     * Removes all elements from the list, resetting it to an empty state.
     */
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Returns a string representation of the linked list.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CustomLinkedList{ ");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) {
                sb.append(" <-> ");
            }
            current = current.next;
        }
        sb.append(" }");
        return sb.toString();
    }

    /**
     * Returns an iterator to traverse the elements of the linked list.
     */
    @Override
    public CustomIterator<T> iterator() {
        return new CustomLinkedListIterator();
    }



    /**
     * A helper method to check if an index is within the valid range for the list.
     * 
     * @param index The index to check.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    /**
     * A helper method to find the node at a specific index.
     * If the index is in the first half of the list, traversal starts from the head.
     * If the index is in the second half, traversal starts from the tail.
     * 
     * @param index The index of the node to retrieve.
     * @return The node at the specified index.
     */
    private Node<T> nodeAt(int index) {
        Node<T> current;
        // If index is in the first half of the list, start from head
        if (index < (size / 2)) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        // If index is in the second half, start from tail
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
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
        @SuppressWarnings("unused")
        Node(T value) {
            this(value, null, null);
        }
    }


    /**
     * Iterator implementation for the CustomLinkedList.
     * Iterates from head to tail of the list.
     */
    private class CustomLinkedListIterator implements CustomIterator<T> {
        private Node<T> current = head;

        /**
         * Checks if there are more elements to iterate over in the list.
         * @return true if there are more elements, otherwise false.
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Returns the next element in the iteration.
         * @return The next element.
         * @throws IllegalStateException if there are no more elements to return.
         */
        @Override
        public T next() {
            if (current == null) throw new IllegalStateException("No more elements in the list");
            T val = current.value;
            current = current.next;
            return val;
        }
    }
    
}
