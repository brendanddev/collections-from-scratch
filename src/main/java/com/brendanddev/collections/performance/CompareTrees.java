package com.brendanddev.collections.performance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import com.brendanddev.collections.tree.CustomBinaryTree;

/**
 * 
 */
public class CompareTrees {

    public static void benchmarkTrees(int n) {


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
     * Helper to build a CustomBinaryTree with n elements from the provided list.
     * 
     * @param n The number of elements to add.
     * @param elements The elements to add.
     * @return A CustomBinaryTree populated with the given elements.
     */
    private static CustomBinaryTree<Integer> buildCustomTree(int n, List<Integer> elements) {
        CustomBinaryTree<Integer> tree = new CustomBinaryTree<>((a, b) -> Integer.compare(a, b));
        for (int e : elements) tree.insert(e);
        return tree;
    }

    /**
     * Helper to build a TreeSet with n elements from the provided list.
     * 
     * @param n The number of elements to add.
     * @param elements The elements to add.
     * @return A TreeSet populated with the given elements.
     */
    private static TreeSet<Integer> buildTreeSet(int n, List<Integer> elements) {
        TreeSet<Integer> tree = new TreeSet<>();
        for (int e : elements) tree.add(e);
        return tree;
    }
    
}