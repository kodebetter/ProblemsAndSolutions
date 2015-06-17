package com.sandeep.datastructure.tree;

public class BinarySearchTree {

	
	public static void main(String[] args) {
		
		BST bst = new BST();
		bst.insert(5);
		bst.insert(8);
		bst.insert(3);
		bst.insert(12);
		bst.insert(1);
		bst.inorder(bst.getRoot());
	}
}
