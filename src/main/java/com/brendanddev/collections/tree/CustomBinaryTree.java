package com.brendanddev.collections.tree;


import com.brendanddev.collections.core.CustomComparator;
import com.brendanddev.collections.list.CustomArrayList;
import com.brendanddev.collections.stack.CustomStack;

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
    private int size = 0;

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
        if (!contains(value)) {
            root = insertRecursive(root, value);
            size++;
        }
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
     * Removes a value from the binary tree, if it exists.
     * 
     * @param value The value to remove from the tree.
     */
    public void remove(T value) {
        if (contains(value)) {
            root = removeRecursive(root, value);
            size--;
        }
    }

    /**
     * Helper to recursively remove a value from the subtree rooted at the given node.
     * Handles all three cases: leaf node, node with one child, and node with two children.
     * 
     * @param current The current node in the recursion.
     * @param value The value to remove.
     * @return The node that should occupy this position in the tree after removal.
     */
    private Node<T> removeRecursive(Node<T> current, T value) {
        // Base case - If current node is null, value is not found
        if (current == null) {
            return null;
        }

        // Compare the value to remove with the current nodes value
        int cmp = comparator.compare(value, current.value);

        if (cmp < 0) {
            // Value is smaller, search in left subtree
            current.left = removeRecursive(current.left, value);
        } else if (cmp > 0) {
            // Value is larger, search in right subtree
            current.right = removeRecursive(current.right, value);
        } else {
            // Node with the value found

            // Case 1 - Node has no children (Leaf node)
            if (current.left == null && current.right == null) {
                return null;
            }

            // Case 2 - Node has only one child
            if (current.left == null) {
                // Replace node with its right child
                return current.right;
            } else if (current.right == null) {
                // Replace node with its left child
                return current.left;
            }

            // Case 3 - Node has two children
            // Find the minimum value in the right subtree to replace the current node's value
            T minValue = findMin(current.right);
            current.value = minValue;

            // Remove the node that had the minimum value in the right subtree
            current.right = removeRecursive(current.right, minValue);
        }
        return current;
    }

    /**
     * Helper to find the minimum value in the subtree rooted at the given node.
     * 
     * @param current The root node of the subtree.
     * @return The minimum value found in the subtree.
     */
    private T findMin(Node<T> current) {
        // Keep going left until we reach the leftmost node
        while (current.left != null) {
            current = current.left;
        }
        return current.value;
    }

    /**
     * Performs an in-order traversal of the binary tree.
     * In-order traversal visits nodes in the order: Left subtree --> Root --> Right subtree.
     * 
     * @return A CustomArrayList containing the elements of the tree in sorted order.
     */
    public CustomArrayList<T> traverseInOrder() {
        CustomArrayList<T> result = new CustomArrayList<>();
        CustomStack<Node<T>> stack = new CustomStack<>();
        Node<T> current = root;

        // Traverse to the leftmost node
        while (current != null || !stack.isEmpty()) {
            // Reach the leftmost node of the current node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Current must be null at this point, so we pop the top node from the stack
            current = stack.pop();
            result.add(current.value);

            // We have visited the node and its left subtree, now visit the right subtree
            current = current.right;
        }
        return result;
    }


    /** 
     * Returns the number of elements in the binary tree.
     */
    public int size() {
        return size;
    }

    /** 
     * Returns true if the binary tree is empty, otherwise false.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Clears all elements from the binary tree by resetting the root to null and size to zero.
     */
    public void clear() {
        root = null;
        size = 0;
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
