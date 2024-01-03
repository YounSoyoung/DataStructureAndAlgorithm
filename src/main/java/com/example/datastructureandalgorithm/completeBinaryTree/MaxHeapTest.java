package com.example.datastructureandalgorithm.completeBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxHeapTest {

    class Node{
        int data;
        Node parent;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
        }
    }
    Node root = null;
    int size = 0;
    Node[] q;

    public MaxHeapTest(int length){
        q = new Node[length];
    }

    public boolean insert(int data){
        Node newNode = new Node(data);
        if(size == 0){
            root = newNode;
            return true;
        }


        q.add(root);

        while(true){
            Node tmp = q.peek();
            if(tmp.left == null){
                tmp.left = newNode;
                newNode.parent=tmp;
                break;
            } else {
                q.add(tmp.left);
            }

            if(tmp.right == null){
                tmp.right = newNode;
                newNode.parent=tmp;
                break;
            } else {
                q.add(tmp.right);
            }
        }
        return true;
    }

    public void inorder(Node node){
        if(node != null){
            inorder(node.left);
            System.out.print(node.data + ", ");
            inorder(node.right);
        }
    }

    public void preOrder(Node node){
        if(node != null){
            System.out.print(node.data + ", ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void postOrder(Node node){
        if(node != null){
            preOrder(node.left);
            preOrder(node.right);
            System.out.print(node.data + ", ");
        }
    }

    public void levelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            Node temp = q.peek();
            System.out.print(temp.data + ", ");
            if(temp.left != null){
                q.add(temp.left);
            }
            if(temp.right != null) {
                q.add(temp.right);
            }
            q.poll();
        }

    }
}
