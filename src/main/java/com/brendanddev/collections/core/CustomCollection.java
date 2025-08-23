package com.brendanddev.collections.core;

/**
 * A generic collection interface representing a collection of elements.
 * Provides basic operations for managing the collection.
 */
public interface CustomCollection<T> {
    int size();
    boolean isEmpty();
    boolean add(T element);
    boolean remove(T element);
    boolean contains(T element);
    CustomIterator<T> iterator();
}