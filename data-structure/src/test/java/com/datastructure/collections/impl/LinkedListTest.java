package com.datastructure.collections.impl;

import com.datastructure.collections.List;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    private List<Integer> list;

    @Before
    public void before() {
        this.list = new LinkedList<Integer>();
    }

    @Test
    public void shoudSearchElements() {
        this.list.add(1);
        assertTrue("Should have found the new element", this.list.contains(1));
        assertFalse("Should not have found element", this.list.contains(2));
    }

    @Test
    public void testSizeMethod() {
        assertEquals(0, list.size());

        this.list.add(1);
        this.list.add(2);
        this.list.add(3);
        assertEquals(3, list.size());

        this.list.delete(1);
        assertEquals(2, list.size());

        this.list.delete(Integer.MIN_VALUE);
        assertEquals(2, list.size());
    }

    @Test
    public void shouldRemoveElements() {
        this.list.add(1);
        this.list.add(2);
        this.list.add(3);
        assertTrue(list.contains(3));

        assertTrue(list.delete(3));
        assertEquals(2, list.size());
        assertFalse(list.contains(3));
    }


    @Test(expected = IllegalArgumentException.class)
    public void shoudThrowExceptionWhenAddNullElement() {
        this.list.add(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shoudThrowExceptionWhenSearchForNull() {
        this.list.contains(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shoudThrowExceptionWhenDeleteNull() {
        this.list.delete(null);
    }
}
