package com.brendanddev.collections.heap;

import com.brendanddev.collections.core.CustomCollection;
import com.brendanddev.collections.list.CustomArrayList;

/**
 * A custom generic implementation of a Heap backed by a CustomArrayList.
 */
public class CustomHeapList<T extends Comparable<T>> implements CustomCollection<T> {
    
    private CustomArrayList<T> list;
    
}
