package com.datastructure.collections;

public interface Queue<T> {
    void enqueue(T value);
    T dequeue();
    T front();
    T rear();
    int size();
}
