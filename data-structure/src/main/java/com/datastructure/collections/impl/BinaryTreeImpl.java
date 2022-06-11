package com.datastructure.collections.impl;

import com.datastructure.collections.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BinaryTreeImpl<T extends Comparable<T>> implements BinaryTree<T> {

    private Node<T> root = null;

    public BinaryTreeImpl() {
        this.root = null;
    }

    @Override
    public void add(T value) {
        if (value == null) {
            throw new IllegalArgumentException();
        }
        
        this.root = this.addRecursive(root, value);
    }

    private Node<T> addRecursive(Node<T> node, T value) {
        if (node == null) {
            return new Node<T>(value);
        }

        if (value.compareTo(node.value) < 0) {
            node.left = addRecursive(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            node.right = addRecursive(node.right, value);
        } else {
            return node;
        }
        return node;
    }

    public void delete(T value) {
        if (value == null) {
            throw new IllegalArgumentException();
        }
        
        this.root = deleteRecursive(this.root, value);
    }

    private Node<T> deleteRecursive(Node<T> node, T value) {

        if (node == null) {
            return null;
        }

        if(value.compareTo(node.value) == 0) {
            
            // It has no children
            if (node.left == null && node.right == null) {
                return null;
            }

            // It has a single children
            if (node.right == null) {
                return node.left;
            }
            if (node.left == null) {
                return node.right;
            }

            // It has two children
            Node<T> smallest = this.findSmallest(node.right);
            node.value = smallest.value;
            node.right = this.deleteRecursive(node.right, smallest.value);
            return node;

        } else if (value.compareTo(node.value) < 0) {
            node.left = this.deleteRecursive(node.left, value);
        } 
        node.right =this.deleteRecursive(node.right, value);
        
        return node;
    }

    private Node<T> findSmallest(Node<T> node) {
        return node.left != null ? findSmallest(node.left) : node;
    }

    public boolean contains(T value) {
        if (value == null) {
            throw new IllegalArgumentException();
        }

        return this.containsRecursive(root, value);
    }

    private boolean containsRecursive(Node<T> node, T value) {
        if (node != null) {
            if (value.compareTo(node.value) == 0) {
                return true;
            } else if (value.compareTo(node.value) < 0) {
                return containsRecursive(node.left, value);
            } else if (value.compareTo(node.value) > 0) {
                return containsRecursive(node.right, value);
            }
        } 
        return false;
    }

    public void visitInOrder(Consumer<T> function) {
        this.visitInOrderRecursive(root, function);
    }

    private void visitInOrderRecursive(Node<T> node, Consumer<T> function) {
        if (node != null) {
            visitInOrderRecursive(node.left, function);
            function.accept(node.value);
            visitInOrderRecursive(node.right, function);
        }
    }

    public void visitPreOrder(Consumer<T> function) { 
        this.visitPreOrderRecursive(root, function);
    }

    private void visitPreOrderRecursive(Node<T> node, Consumer<T> function) {
        if (node != null) {
            function.accept(node.value);
            visitInOrderRecursive(node.left, function);
            visitInOrderRecursive(node.right, function);
        }
    }

    public void visitPosOrder(Consumer<T> function) { 
        this.visitPosOrderRecursive(root, function);
    }

    private void visitPosOrderRecursive(Node<T> node, Consumer<T> function) {
        if (node == null) {
            return;
        }
        
        visitInOrderRecursive(node.left, function);
        visitInOrderRecursive(node.right, function);
        function.accept(node.value);
    }

    public boolean depthFirstSearch(List<T> list, T element) {
        if (element == null || list == null) {
            throw new IllegalArgumentException();
        }

        return this.depthFirstSearchRecursive(root, list, element);
    }


    private boolean depthFirstSearchRecursive(Node<T> node, List<T> list, T value) {
        if (node != null) {
            list.add(node.value);
    
            if (value.compareTo(node.value) < 0) {
                return depthFirstSearchRecursive(node.left, list, value);
            } else if (value.compareTo(node.value) == 0) {
                return true;
            } else if (value.compareTo(node.value) > 0) {
                return depthFirstSearchRecursive(node.right, list, value);
            }
        }
        return false;
    }

    @Override
    public boolean breadthFirstSearch(List<T> list, T element) {
        if (element == null || list == null) {
            throw new IllegalArgumentException();
        }

        return false;
    }

    @Override
    public List<T> toSortedList() { 
        List<T> list = new ArrayList<T>();
        this.visitInOrder((t) -> list.add(t));
        return list;
    }

    private class Node<Z> {
        private Z value;
        private Node<Z> left = null;
        private Node<Z> right = null;

        public Node(Z value) {
            this.value = value;
        }
    }
    
}
