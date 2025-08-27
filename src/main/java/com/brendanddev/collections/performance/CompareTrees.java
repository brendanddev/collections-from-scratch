package com.brendanddev.collections.performance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import com.brendanddev.collections.tree.CustomBinaryTree;

/**
 * Provides performance comparison benchmarks between the custom binary tree implementation
 * and its standard Java Collections Framework counterpart, TreeSet.
 * 
 * This class runs benchmarks for common operations such as inserting, removing, checking for 
 * containment, in-order traversal, and removing elements in both custom and Java trees.
 * 
 * Note: Java's TreeSet is implemented as a Red-Black tree, which is a self-balancing binary search tree.
 *     Therefore, performance characteristics may differ from a standard binary search tree.
 */
public class CompareTrees {

    /**
     * Benchmarks the performance of CustomBinaryTree against Java's TreeSet.
     * 
     * @param n The number of elements to insert, search, traverse, and remove.
     */
    public static void benchmarkTrees(int n) {
        List<Integer> shuffled = generateShuffledElements(n);

        // Compare inserting n elements
        Benchmark.measureWithResults("CustomBinaryTree insert " + n + " elements", () -> {
            CustomBinaryTree<Integer> customBinaryTree = new CustomBinaryTree<>((a, b) -> Integer.compare(a, b));
            for (int e : shuffled) customBinaryTree.insert(e);
            return null;
        });
        Benchmark.measureWithResults("Java TreeSet add " + n + " elements", () -> {
            TreeSet<Integer> javaTreeSet = new TreeSet<>();
            for (int e : shuffled) javaTreeSet.add(e);
            return null;
        });

        // Prepare fresh trees for contains test
        CustomBinaryTree<Integer> customBinaryTreeForContains = buildCustomTree(shuffled);
        TreeSet<Integer> javaTreeSetForContains = buildTreeSet(shuffled);

        // Compare contains n elements
        Benchmark.measureWithResults("CustomBinaryTree contains " + n + " elements", () -> {
            for (int i = 0; i < n; i++) customBinaryTreeForContains.contains(i);
            return null;
        });
        Benchmark.measureWithResults("Java TreeSet contains " + n + " elements", () -> {
            for (int i = 0; i < n; i++) javaTreeSetForContains.contains(i);
            return null;
        });

        // Prepare fresh trees for in-order traversal test
        CustomBinaryTree<Integer> customBinaryTreeForTraversal = buildCustomTree(shuffled);
        TreeSet<Integer> javaTreeSetForTraversal = buildTreeSet(shuffled);

        // Compare in-order traversal
        Benchmark.measureWithResults("CustomBinaryTree in-order traversal", () -> {
            customBinaryTreeForTraversal.traverseInOrder();
            return null;
        });
        Benchmark.measureWithResults("Java TreeSet in-order traversal", () -> {
            for (@SuppressWarnings("unused") int e : javaTreeSetForTraversal) {
                // Simulate traversal
            }
            return null;
        });

        // Prepare fresh trees for remove test
        CustomBinaryTree<Integer> customBinaryTreeForRemove = buildCustomTree(shuffled);
        TreeSet<Integer> javaTreeSetForRemove = buildTreeSet(shuffled);

        // Compare removing n elements
        Benchmark.measureWithResults("CustomBinaryTree remove " + n + " elements", () -> {
            for (int i = 0; i < n; i++) customBinaryTreeForRemove.remove(i);
            return null;
        });
        Benchmark.measureWithResults("Java TreeSet remove " + n + " elements", () -> {
            for (int i = 0; i < n; i++) javaTreeSetForRemove.remove(i);
            return null;
        });

    }


    /**
     * Helper to generate a shuffled list of integers 0..n-1.
     * 
     * @param n The number of elements to add.
     * @return A shuffled list of integers 0..n-1.
     */
    private static List<Integer> generateShuffledElements(int n) {
        List<Integer> elementsToAdd = new ArrayList<>();
        for (int i = 0; i < n; i++) elementsToAdd.add(i);
        Collections.shuffle(elementsToAdd);
        return elementsToAdd;
    }

    /**
     * Helper to build a CustomBinaryTree with elements from the provided list.
     * 
     * @param elements The elements to add.
     * @return A CustomBinaryTree populated with the given elements.
     */
    private static CustomBinaryTree<Integer> buildCustomTree(List<Integer> elements) {
        CustomBinaryTree<Integer> tree = new CustomBinaryTree<>((a, b) -> Integer.compare(a, b));
        for (int e : elements) tree.insert(e);
        return tree;
    }

    /**
     * Helper to build a TreeSet with elements from the provided list.
     * 
     * @param elements The elements to add.
     * @return A TreeSet populated with the given elements.
     */
    private static TreeSet<Integer> buildTreeSet(List<Integer> elements) {
        TreeSet<Integer> tree = new TreeSet<>();
        for (int e : elements) tree.add(e);
        return tree;
    }
    
}