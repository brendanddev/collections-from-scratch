package com.brendanddev.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.brendanddev.collections.core.CustomIterator;
import com.brendanddev.collections.set.CustomHashSet;

/**
 * Unit tests for the CustomHashSet class.
 * Tests basic functionality including adding elements, checking existence, removing elements,
 * and iterating over the set.
 */
public class CustomHashSetTest {

    private CustomHashSet<String> set;

    /**
     * Initializes a new instance of CustomHashSet before each test method.
     */
    @BeforeEach
    void setUp() {
        set = new CustomHashSet<>();
    }

    /**
     * Tests adding elements and preventing duplicates.
     */
    @Test
    void testAddAndContains() {
        assertTrue(set.add("Brendan"));
        assertTrue(set.contains("Brendan"));
        assertFalse(set.contains("Alice"));

        // Adding duplicate should return false
        assertFalse(set.add("Brendan"));
    }

    /**
     * Tests removing elements from the set.
     */
    @Test
    void testRemove() {
        set.add("Brendan");
        set.add("Alice");

        assertTrue(set.remove("Brendan"));
        assertFalse(set.contains("Brendan"));
        // Element not in set
        assertFalse(set.remove("NonExistent"));
    }

    /**
     * Test that size and isEmpty work as expected.
     */
    @Test
    void testSizeAndIsEmpty() {
        assertTrue(set.isEmpty());
        assertEquals(0, set.size());

        set.add("Brendan");
        set.add("Alice");

        assertFalse(set.isEmpty());
        assertEquals(2, set.size());
    }

    /**
     * Test iterator functionality over all elements.
     */
    @Test
    void testIterator() {
        set.add("X");
        set.add("Y");

        CustomIterator<String> iterator = set.iterator();
        assertTrue(iterator.hasNext());
        String first = iterator.next();
        assertTrue(first.equals("X") || first.equals("Y"));

        assertTrue(iterator.hasNext());
        String second = iterator.next();
        assertTrue(second.equals("X") || second.equals("Y"));
        assertNotEquals(first, second);

        assertFalse(iterator.hasNext());
    }
    
}
