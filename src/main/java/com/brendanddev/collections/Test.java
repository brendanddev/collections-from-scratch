package com.brendanddev.collections;

import com.brendanddev.collections.tree.CustomBinaryTree;

public class Test {

    public static void main(String[] args) {
        



        CustomBinaryTree<Integer> tree = new CustomBinaryTree<>((a, b) -> Integer.compare(a, b));
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);

        System.out.println("In-order Traversal:");
        System.out.println(tree.traverseInOrder());
    }
    
}
