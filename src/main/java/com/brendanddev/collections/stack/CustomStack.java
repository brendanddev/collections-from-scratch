package com.brendanddev.collections.stack;

import com.brendanddev.collections.list.CustomLinkedList;

/**
 * A custom generic stack implementation.
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
    
}
