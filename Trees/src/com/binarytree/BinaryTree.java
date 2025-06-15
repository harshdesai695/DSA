package com.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	Node root;

	public void insert(int key) {
		root = insertRec(root, key);
	}

	public Node insertRec(Node root, int key) {
		if (root == null) {
			root = new Node(key);
			return root;
		}
		if (key < root.data)
			root.left = insertRec(root.left, key);
		else if (key > root.data)
			root.right = insertRec(root.right, key);
		return root;
	}

	public void DFS() {
		System.out.println("PreOrder:");
		DFSPreOrder(root);
		System.out.println("\nPostOrder:");
		DFSPostOrder(root);
		System.out.println("\nInOrder:");
		InOrder(root);

	}

	// Root->Left->Right
	public void DFSPreOrder(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(" " + root.data);
		DFSPreOrder(root.left);
		DFSPreOrder(root.right);
	}

	// Left->Right->Root
	public void DFSPostOrder(Node root) {
		if (root == null) {
			return;
		}
		DFSPostOrder(root.left);
		DFSPostOrder(root.right);
		System.out.print(" " + root.data);
	}

	// Left->Root->Right
	public void InOrder(Node root) {
		if (root == null) {
			return;
		}
		InOrder(root.left);
		System.out.print(" " + root.data);
		InOrder(root.right);
	}

	public void BFS() {
		System.out.println("\nLevel Order Traversal:");
		LevelOrder();
	}

	public void LevelOrder() {
		if (root == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node current = queue.poll();
			System.out.print(" " + current.data);

			if (current.left != null)
				queue.add(current.left);
			if (current.right != null)
				queue.add(current.right);
		}

	}
	
	
	//The height of a binary tree is defined as the number 
	//of edges on the longest path from the root node to any leaf node
	public void MaxDepthOfBinaryTree() {
		System.out.println("\nHeight of Binary Tree:");
		System.out.println(" " + heightOfBinaryTree(root));
	}

	public int heightOfBinaryTree(Node root) {
		if (root == null) {
			return 0;
		}

		int leftSubTree = heightOfBinaryTree(root.left);
		int rigthSubTree = heightOfBinaryTree(root.right);

		return 1 + Math.max(leftSubTree, rigthSubTree);
	}
	
	
	//A balanced binary tree is a type of binary tree where the height 
	//of the left and right subtrees of any node differs by at most one
	public void BalancedBinaryTree() {
		System.out.println("Is a Binary Tree:");
		System.out.println(isBalanced(root)!=-1);
	}

	public int isBalanced(Node root) {
		if (root == null) {
			return 0;
		}
		int left = isBalanced(root.left);
		int right = isBalanced(root.right);

		if (left == -1 || right == -1) {
			return -1;
		}

		if (Math.abs(left - right) > 1) {
			return -1;
		}

		return 1 + Math.max(left, right);
	}
	
	//The diameter of a binary tree is the length of 
	//the longest path between any two nodes in a tree
	public void DiameterOfATree() {
		System.out.println("Diameter of Tree:");
		int dia=0;
		System.out.println(diameterofTree(root,dia));
	}
	
	public int diameterofTree(Node root,int dia) {
		if (root == null) {
			return 0;
		}

		int leftSubTree = diameterofTree(root.left,dia);
		int rigthSubTree = diameterofTree(root.right,dia);
		dia = Math.max(dia, (leftSubTree + rigthSubTree));
		
		return 1 + Math.max(leftSubTree, rigthSubTree);
	}
}
