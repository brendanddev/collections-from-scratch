package com.brendanddev.collections.core;

/**
 * Represents a generic iterator for iterating over a collection of elements.
 * Provides methods to traverse the collection sequentially.
 */
public interface CustomIterator<T> {
    boolean hasNext();
    T next();
}