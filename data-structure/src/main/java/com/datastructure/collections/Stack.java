package com.datastructure.collections;
public interface Stack<T> {
    void push(T value);
    T pop();
    T peak();
    int size();    
}
