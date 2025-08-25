package com.brendanddev.collections.stack;

import com.brendanddev.collections.list.CustomLinkedList;

/**
 * A custom generic implementation of a Stack using a linked list.
 * 
 * Time Complexity
 * Push: O(1)
 * Pop: O(1)
 * Peek: O(1)
 * IsEmpty: O(1)
 * Size: O(1)
 * Clear: O(1)
 */
public class CustomStack<T> {

    private CustomLinkedList<T> linkedList;

    /**
     * Constructs an empty CustomStack.
     */
    public CustomStack() {
        linkedList = new CustomLinkedList<>();
    }

    /**
     * Pushes a new element onto the top of the stack.
     * 
     * @param value The value to push onto the stack.
     */
    public void push(T value) {
        linkedList.add(value);
    }

    /**
     * Removes and returns the top element of the stack.
     * 
     * @return The value at the top of the stack.
     * @throws IllegalStateException if the stack is empty.
     */
    public T pop() {
        if (linkedList.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        // Remove last element (top of stack)
        return linkedList.removeAt(linkedList.size() - 1);
    }

    /**
     * Returns the top element of the stack without removing it.
     * 
     * @return The value at the top of the stack.
     * @throws IllegalStateException if the stack is empty.
     */
    public T peek() {
        if (linkedList.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return linkedList.get(linkedList.size() - 1);
    }

    /**
     * Returns true if the stack is empty, otherwise false.
     */
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    /** 
     * Returns the number of elements in the stack.
     */
    public int size() {
        return linkedList.size();
    }

    /**
     * Removes all elements from the stack.
     */
    public void clear() {
        linkedList.clear();
    }

    /**
     * Returns a string representation of the stack.
     */
    @Override
    public String toString() {
        return "CustomStack" + linkedList.toString();
    }
    
}
