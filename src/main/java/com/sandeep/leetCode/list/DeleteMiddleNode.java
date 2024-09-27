package com.sandeep.leetCode.list;

public class DeleteMiddleNode {

    public static void main(String[] args) {
        DeleteMiddleNode deleteMiddleNode = new DeleteMiddleNode();
        Node node = new Node(4);
        node.setNextNode(new Node(5));
        node.getNextNode().setNextNode(new Node(1));
        node.getNextNode().getNextNode().setNextNode(new Node(9));
        Node toDeleteNode = node.getNextNode().getNextNode();
        deleteMiddleNode.deleteNode(node.getNextNode().getNextNode());
        System.out.println("Completed ");

    }

    public void deleteNode(Node node) {
        Node curr = node;
        Node prev = null;
        while(curr.nextNode != null) {
            int temp = curr.nextNode.data;
            curr.nextNode.data = curr.data;
            curr.data = temp;
            prev = curr;
            curr = curr.nextNode;
        }
        prev.nextNode = null;
    }

}

class Node{
    int data;
    Node nextNode;

    Node(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

}
