package com.datastructure.collections;

public interface List<T> {
    void add(T value);
    boolean delete(T value);
    boolean contains(T value);
    int size();    
}
