package com.brendanddev.collections.tree;


import com.brendanddev.collections.core.CustomComparator;

/**
 * A custom generic implementation of a Binary Tree.
 * 
 * This Binary Search Tree (BST) stores elements in an ordered structure, where each node has at most two children, 
 * the left subtree of a node contains values less than the nodes value, and the right subtree of a node contains 
 * values greater than the nodes value.
 */
public class CustomBinaryTree<T> {

    private Node<T> root;
    private final CustomComparator<T> comparator;

    /**
     * Constructs an empty CustomBinaryTree.
     * 
     * @param comparator The CustomComparator used for ordering the elements in the tree.
     */
    public CustomBinaryTree(CustomComparator<T> comparator) {
        this.root = null;
        this.comparator = comparator;
    }

    /**
     * Inserts a new value into the binary tree.
     * 
     * @param value The value to insert into the tree.
     */
    public void insert(T value) {
        root = insertRecursive(root, value);
    }

    /**
     * Helper to recursively insert a value into the subtree rooted at the given node.
     * 
     * @param current The current node in the recursion.
     * @param value The value to insert.
     * @return The node that should be at this position in the tree (May be a new node).
     */
    private Node<T> insertRecursive(Node<T> current, T value) {
        // Base case - If current node is null, we've found the insertion point
        // Create a new node with the value and return it
        if (current == null) {
            return new Node<>(value);
        }

        // Compare the value to insert with the current nodes value
        int cmp = comparator.compare(value, current.value);

        if (cmp < 0) {
            // Value is smaller, insert into left subtree
            current.left = insertRecursive(current.left, value);
        } else if (cmp > 0) {
            // Value is larger, insert into right subtree
            current.right = insertRecursive(current.right, value);
        }

        return current;
    }

    /**
     * Checks if the binary tree contains the specified value.
     * 
     * @param value The value to search for in the tree.
     * @return true if the value is found, otherwise false.
     */
    public boolean contains(T value) {
        return containsRecursive(root, value);
    }

    /**
     * Helper to recursively search for a value in the subtree rooted at the given node.
     * 
     * @param current The current node in the recursion.
     * @param value The value to search for.
     * @return true if the value is found in this subtree, otherwise false.
     */
    private boolean containsRecursive(Node<T> current, T value) {

        // Base case - If current node is null, value is not found
        if (current == null) {
            return false;
        }

        // Compare the value to search with the current nodes value
        int cmp = comparator.compare(value, current.value);

        if (cmp == 0) {
            // Value found
            return true;
        } else if (cmp < 0) {
            // Value is smaller, search in left subtree
            return containsRecursive(current.left, value);
        } else {
            // Value is larger, search in right subtree
            return containsRecursive(current.right, value);
        }
    }


    









    /**
     * Represents a single Node in the binary tree.
     * Each Node contains a value, a reference to the left child, and a reference to the right child.
     */
    private static class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;
        
        /**
         * Constructs a tree node with the specified value.
         * 
         * @param value The value of the node.
         */
        Node(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

    }
    
}
