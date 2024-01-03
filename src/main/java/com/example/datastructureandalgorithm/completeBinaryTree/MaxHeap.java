package com.example.datastructureandalgorithm.completeBinaryTree;

public class MaxHeap {

    Node root = null;

    public Node addNode(int data) {
        if(root == null) {
            root = new Node(data);
            return root;
        } else {
            Queue queue = new Queue();
            queue.push(root);

            while (!queue.isEmpty()) { //queue가 공백이 아닐 경우
                //queue의 맨 앞 값을 삭제하고 반환하여 temp에 대입
                Node temp = (Node) queue.pop();

                if(temp.getLeft() != null) {
                    queue.push(temp.getLeft());

                    if(temp.getRight() != null) {
                        queue.push(temp.getRight());
                    }else {
                        Node child = new Node(data);
                        temp.setRight(child);
                        return child;
                    }
                }else {
                    Node child = new Node(data);
                    temp.setLeft(child);
                    return child;
                }
            }

            return root;
        }
    }

    public Node getParent(Node node) {
        Queue queue = new Queue();
        queue.push(root);

        while (!queue.isEmpty()){
            Node temp = (Node) queue.pop();

            if(temp.getLeft() == null && temp.getRight() == null) {
                break;
            }else {
                if ((temp.getLeft() != null && temp.getLeft().getData() == node.getData()) ||
                (temp.getRight() != null && temp.getRight().getData() == node.getData())) {
                    Node parent = temp;
                    return parent;
                }else {
                    if(temp.getLeft() != null) {
                        queue.push(temp.getLeft());
                    }
                    if(temp.getRight() != null) {
                        queue.push(temp.getRight());
                    }
                }
            }
        }
        return node;
    }

    public void maxHeap(Node currentNode) {
        //노드인 parent에 currentNode의 부모를 대입
        Node parentNode = getParent(currentNode);

        while (parentNode != null) {
            if(currentNode.getData() > parentNode.getData()) {
                int a = currentNode.getData();
                int b = parentNode.getData();

                currentNode.setData(b);
                parentNode.setData(a);
                 // currentNode에 parentNode 삽입.
                //parentNode에 currentNode의 부모노드 삽입.
                currentNode = parentNode;
                parentNode = getParent(currentNode);
            }else break;
        }
    }
}
