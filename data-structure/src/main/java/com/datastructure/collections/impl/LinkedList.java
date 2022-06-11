package com.datastructure.collections.impl;

import com.datastructure.collections.List;

public class LinkedList<T> implements List<T> {

    private Node<T> head = null;
    private Node<T> tail = head;
    private int size = 0;

    public LinkedList() {}

    @Override
    public void add(T value) {
        this.checkNull(value);

        Node<T> element = new Node<T>(value);
        if (head == null) {
            head = element;
            tail = head;
        } else if (tail != null) {
            tail.setNext(element);
            tail = element;
        } else {
            throw new RuntimeException("Error adding new element");
        }
        size++;
    }

    @Override
    public boolean delete(T value) {
        this.checkNull(value);

        var current = head;
        var previous = head;
        while (current != null) {
            if (current.getValue().equals(value)) {
                previous.setNext(current.getNext());
                size--;
                return true;
            }
            previous = current;
            current = current.getNext();
        }
        return false;
    }

    @Override
    public boolean contains(T value) {
        this.checkNull(value);

        Node<T> current = this.head;
        while(current != null) {
            if (current.getValue().equals(value)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
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
        private Node<Z> next;

        public Node(Z value) {
            this.value = value;
        }

        public Node<Z> getNext() {
            return this.next;
        }

        public void setNext(Node<Z> next) {
            this.next = next;
        }

        public Z getValue() {
            return this.value;
        }
    }
    
}
