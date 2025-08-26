package com.brendanddev.collections.tree;




/**
 * A custom generic implementation of a Binary Tree.
 * 
 * This Binary Search Tree (BST) stores elements in an ordered structure, where each node has at most two children, 
 * the left subtree of a node contains values less than the nodes value, and the right subtree of a node contains 
 * values greater than the nodes value.
 */
public class CustomBinaryTree<T> {







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
