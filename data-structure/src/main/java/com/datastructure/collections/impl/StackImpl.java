package com.datastructure.collections.impl;

import com.datastructure.collections.Stack;

public class StackImpl<T> implements Stack<T> {

    private int size = 0;
    private Node<T> top = null;

    public StackImpl() { }

    @Override
    public void push(T value) {
        this.checkNull(value);
        Node<T> element = new Node<T>(value);
        element.setPrevious(top);
        top = element;
        size++;
    }

    @Override
    public T pop() {
        if (top != null) {
            var value = top.getValue();
            top = top.getPrevious();
            size--;
            return value;
        }
        return null;
    }

    @Override
    public T peak() {
        return top != null ? top.getValue() : null;
    }

    @Override
    public int size() {
        return this.size;
    }
    
    private void checkNull(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Null value is not allowed");
        }
    }

    private class Node<Z> {
        private Z value;
        private Node<Z> previous;

        public Node(Z value) {
            this.value = value;
        }

        public Node<Z> getPrevious() {
            return this.previous;
        }

        public void setPrevious(Node<Z> previous) {
            this.previous = previous;
        }

        public Z getValue() {
            return this.value;
        }
    }
}
