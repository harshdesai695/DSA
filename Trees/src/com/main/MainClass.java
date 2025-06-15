package com.main;

import com.binarytree.BinaryTree;

public class MainClass {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		int[] datas = { 50, 30, 70, 20, 40, 60, 80 };
		for (int i : datas) {
			tree.insert(i);
		}
		
		tree.DFS();
		tree.BFS();
		tree.MaxDepthOfBinaryTree();
		tree.BalancedBinaryTree();
		tree.DiameterOfATree();
	}

}
