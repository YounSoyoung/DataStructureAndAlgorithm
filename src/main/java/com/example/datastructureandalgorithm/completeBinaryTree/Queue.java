package com.example.datastructureandalgorithm.completeBinaryTree;

import java.util.ArrayList;

public class Queue {
    private ArrayList<Object> queue;

    public Queue() {
        queue = new ArrayList<>();
    }

    public void push(Object object) {
        queue.add(object);
    }

    public Object pop() {
        return queue.remove(0);
    }

    public boolean isEmpty() {
        if(queue == null || queue.size() == 0) return true;
        else return false;
    }
}
