package com.brendanddev.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.brendanddev.collections.list.CustomArrayList;

/**
 * Unit tests for the CustomArrayList class.
 * Tests basic functionality of the CustomArrayList implementation, including adding elements,
 * and checking for their presence in the list.
 */
public class CustomArrayListTest {

    /**
     * Tests the CustomArrayLists add and contains methods.
     */
    @Test
    void testAddAndContains() {
        CustomArrayList<String> customArrayList = new CustomArrayList<>();
        assertTrue(customArrayList.add("Brendan"));
        assertTrue(customArrayList.contains("Brendan"));
        assertFalse(customArrayList.contains("Development"));
    }

    /**
     * Tests the CustomArrayList's remove method.
     */
    @Test
    void testRemove() {
        CustomArrayList<String> customArrayList = new CustomArrayList<>();
        customArrayList.add("Hello");
        customArrayList.add("World");
        assertTrue(customArrayList.remove("Hello"));
        assertFalse(customArrayList.contains("Hello"));
        assertEquals(1, customArrayList.size());
    }
    
}
