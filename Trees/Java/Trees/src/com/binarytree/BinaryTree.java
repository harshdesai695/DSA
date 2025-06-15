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
    
    //Root->Left->Right
    public void DFSPreOrder(Node root) {
    	if(root == null) {
    		return;
    	}
    	System.out.print(" "+root.data);
    	DFSPreOrder(root.left);
    	DFSPreOrder(root.right);
    }
    
    //Left->Right->Root
    public void DFSPostOrder(Node root) {
    	if(root==null) {
    		return;
    	}
    	DFSPostOrder(root.left);
    	DFSPostOrder(root.right);
    	System.out.print(" "+root.data);
    }
    
    //Left->Root->Right
    public void InOrder(Node root) {
    	if(root==null) {
    		return;
    	}
    	InOrder(root.left);
    	System.out.print(" "+root.data);
    	InOrder(root.right);	
    }
    
    public void BFS() {
    	System.out.println("\nLevel Order Traversal:");
    	LevelOrder();
    }
    
    public void LevelOrder() {
    	if(root==null) {
    		return;
    	}
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(" "+current.data );

            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
        }
    	
    }
    
}
