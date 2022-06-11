package com.datastructure.collections.impl;

import com.datastructure.collections.Queue;

public class QueueImpl<T> implements Queue<T> {

    private int size = 0;
    private Node<T> front = null;
    private Node<T> tail = null;

    public QueueImpl() {

    }

    @Override
    public void enqueue(T value) {
        this.checkNull(value);

        Node<T> element = new Node<T>(value);
        if (front == null) {
            front = element;
            tail = element;
        } else {
            tail.setTail(element);
            tail = element;
        }
        size++;
    }

    @Override
    public  T dequeue() {
        if (front != null) {
            Node<T> temp = front;
            front = front.getTail();

            var value = temp.getValue();
            temp.setTail(null);
            size--;
            return value;
        }
        return null;
    }
    
    @Override
    public T front() {
        return this.front != null ? this.front.getValue() : null;
    }
    
    @Override
    public T rear() {
        return this.tail != null ? this.tail.getValue() : null;
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
        private Node<Z> tail;

        public Node(Z value) {
            this.value = value;
        }

        public Node<Z> getTail() {
            return this.tail;
        }

        public void setTail(Node<Z> tail) {
            this.tail = tail;
        }

        public Z getValue() {
            return this.value;
        }
    }
    
}
