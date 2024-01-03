package com.example.datastructureandalgorithm.completeBinaryTree;

public class Node {
    private int data;
    private Node left;
    private Node right;
    private Node parent;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public Node getParent(Node parent) {
        return this.parent;
    }

    public Node getLeft(){
        return this.left;
    }

    public Node getRight() {
        return this.right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }


}
