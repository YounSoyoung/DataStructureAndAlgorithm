package com.example.datastructureandalgorithm.completeBinaryTree;

import java.util.LinkedList;

public class MaxHeapTest {
    private Node root;
    private Node currentNode;
    Queue queue = new Queue();

    public void createNode(int data) {
        if(root == null) {
            root = new Node(data);
            currentNode = root;
        }else {
            Node tempNode = searchNode(root, data);

            //이미 해당 데이터를 가진 노드가 존재하기 때문에 새로 생성 X
            if(tempNode != null) {
                return;
            }

            if(root.left == null) {
                //maxHeap 과정
                if(data > root.data) {
                    int tempData = root.data;
                    root.data = data;
                    root.left = new Node(tempData);
                }else {
                    root.left = new Node(data);
                }
                return;
            }

            if(currentNode.left == null) {
//                if(currentNode.right == null) {
//                    currentNode.right = new Node(data);
//                }else {
//                    currentNode.left = new Node(data);
//                }
                //maxHeap 과정
                if(data > currentNode.data) {
                    int tempData = currentNode.data;
                    currentNode.data = data;
                    currentNode.left = new Node(tempData);
                }else {
                    currentNode.left = new Node(data);
                }
                return;
            }
            else if(currentNode.right == null) {
                //maxHeap
                if(data > currentNode.data) {
                    int tempData = currentNode.data;
                    currentNode.data = data;
                    currentNode.right = new Node(tempData);
                }
                else currentNode.right = new Node(data);
            }
        }
    }

//    public Node swap(Node node, int childKey){
//        if(childKey > node.data) {
//            node.data = childKey;
//            node.left = new Node(node.data);
//        }else {
//            node.left = new Node(childKey);
//        }
//        return node;
//    }


    public Node searchNode(Node node, int data) {
        if(node == null) {
            return null;
        }else if(node.data == data) {
            return node;
        }else {
            currentNode = node;
            searchNode(node.left, data);
            searchNode(node.right, data);
        }
        return null;
    }

    //delete -> root의 데이터와 currentNode의 left 또는 right 값 이용
    //root의 데이터 반환 후 currentNode의 자식 값을 root.data에 넣기
    //부모 키와 자식 키 비교 후 maxHeap 만들기
}
