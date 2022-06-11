package com.datastructure.collections.impl;

import com.datastructure.collections.BinaryTree;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BinaryTreeImplTest {

    private BinaryTree<Integer> tree = null;

    @Before
    public void beforeTest() {
        /*
         * Tree
         *           6
         *         /   \
         *        4     8
         *       / \   / \
         *      3   5 7   9
         */ 
        tree = new BinaryTreeImpl<Integer>();
        tree.add(6);
        tree.add(4);
        tree.add(8);
        tree.add(3);
        tree.add(5);
        tree.add(7);
        tree.add(9);
    }

    @Test
    public void testContains() {
        assertTrue(tree.contains(6));
        assertTrue(tree.contains(3));
        assertTrue(tree.contains(7));
        assertFalse(tree.contains(0));
    }

    @Test
    public void testToList() {
        List<Integer> expected = new ArrayList<Integer>(List.of(3, 4, 5, 6, 7, 8, 9));
        assertEquals(expected, tree.toSortedList());
    }

    @Test
    public void testDepthFirstSearch() {
        List<Integer> visitedNodes = new ArrayList<>();
        
        boolean search = tree.depthFirstSearch(visitedNodes, 8);
        assertTrue(search);
        assertEquals(List.of(6, 8), visitedNodes);

        visitedNodes.clear();
        search = tree.depthFirstSearch(visitedNodes, 5);
        assertTrue(search);
        assertEquals(List.of(6, 4, 5), visitedNodes);

        visitedNodes.clear();
        search = tree.depthFirstSearch(visitedNodes, 50);
        assertFalse(search);
        assertEquals(List.of(6, 8, 9), visitedNodes);
    }

    @Test
    public void testVisitInOrder() {
        List<Integer> visitedNodes = new ArrayList<>();
        tree.visitInOrder(t -> visitedNodes.add(t));
        assertEquals(List.of(3, 4, 5, 6, 7, 8, 9), visitedNodes);
    }

    @Test
    public void testVisitPreOrder() {
        List<Integer> visitedNodes = new ArrayList<>();
        tree.visitPreOrder(t -> visitedNodes.add(t));
        assertEquals(List.of(6, 3, 4, 5, 7, 8, 9), visitedNodes);
    }

    @Test
    public void testVisitPosOrder() {
        List<Integer> visitedNodes = new ArrayList<>();
        tree.visitPosOrder(t -> visitedNodes.add(t));
        assertEquals(List.of(3, 4,5, 7, 8, 9, 6), visitedNodes);
    }

    @Test
    public void testDelete() {
        assertTrue(tree.contains(3));
        tree.delete(3);
        assertFalse(tree.contains(3));
        assertEquals(List.of(4, 5, 6, 7, 8, 9), tree.toSortedList());

        tree.delete(6);
        assertEquals(List.of(4, 5, 7, 8, 9), tree.toSortedList());

        tree.delete(50);
        assertEquals(List.of(4, 5, 7, 8, 9), tree.toSortedList());
    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenContainsIsCalledWithNullValue() {
        tree.contains(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenAddNullValue() {
        tree.contains(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenDeleteNullValue() {
        tree.delete(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenListIsNullForDFS() {
        tree.depthFirstSearch(null, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenValueIsNullForDFS() {
        tree.depthFirstSearch(new ArrayList<Integer>(), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenListIsNullForBFS() {
        tree.breadthFirstSearch(null, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenValueIsNullForBFS() {
        tree.breadthFirstSearch(new ArrayList<Integer>(), null);
    }
}
