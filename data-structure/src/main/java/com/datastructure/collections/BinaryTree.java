package com.datastructure.collections;

import java.util.function.Consumer;
import java.util.List;

public interface BinaryTree<T extends Comparable<T>> {
    void add(T value);
    void delete(T value);
    boolean contains(T value);

    void visitInOrder(Consumer<T> function);
    void visitPreOrder(Consumer<T> function);
    void visitPosOrder(Consumer<T> function);

    boolean depthFirstSearch(List<T> list, T value);
    boolean breadthFirstSearch(List<T> list, T value);
    List<T> toSortedList();
}
