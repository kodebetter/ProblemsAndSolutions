package com.sandeep.datastructure.tree;

public class TreeNode {

	TreeNode left, right;
	int value;

	public TreeNode() {
		left = null;
		right = null;
		value = 0;
	}

	public TreeNode(int n) {
		left = null;
		right = null;
		value = n;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}

class BST {

	private TreeNode root;

	public BST() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void insert(int data) {
		root = insert(root, data);
	}

	public TreeNode insert(TreeNode node, int data) {
		if (node == null) {
			node = new TreeNode(data);
		} else {
			if (data <= node.getValue())
				node.left = insert(node.left, data);
			else
				node.right = insert(node.right, data);
		}
		return node;
	}
	
	
	public void inorder(TreeNode r)
	     {
	         if (r != null)
	         {
	             inorder(r.getLeft());
	             System.out.print(r.getValue() +" ");
	             inorder(r.getRight());
	         }
	     }

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}
	
	
}

