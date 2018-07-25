package com.algorithms.binarytree.traversals;

/**
 * Problem statement: Given a Binary Tree where each node has following structure, write a function to populate next pointer for all nodes. 
 * The next pointer for every node should be set to point to inorder successor.
 * 
 * @author Sasi Jolla on 22-Jul-2018, 3:37:15 pm
 */
public class InorderSuccessorAndPredecesor {
	
	static Node<Integer> next = null;
	static Node<Integer> prev = null;
	
	/**
	 * Doing inorder traversal and storing previous node in prev. This will be set as predecessor for current node.
	 * 
	 * @param root
	 */
	public static void findInorderPredecessors(Node<Integer> root){
		if(root != null){
			findInorderPredecessors(root.left);
			root.prev = prev;
			System.out.println("Inorder predecessor of " + root.data + " is " + (prev == null ? -1 : prev.data));
			prev = root;
			findInorderPredecessors(root.right);
		}
	}
	
	/**
	 * Doing reverse inorder traversal i.e traversing right, root and left manner to set the successor for each node.
	 * @param root
	 */
	public static void findInorderSuccessors(Node<Integer> root){
		if(root != null){
			findInorderSuccessors(root.right);
			root.next = next;
			System.out.println("Inorder successor of " + root.data + " is " + (next == null ? -1 : next.data));
			next = root;
			findInorderSuccessors(root.left);
		}
	}
	
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(10);
        root.left = new Node<Integer>(11);
        root.left.left = new Node<Integer>(7);
        root.right = new Node<Integer>(9);
        root.right.left = new Node<Integer>(15);
        root.right.right = new Node<Integer>(8);
        findInorderSuccessors(root);
        findInorderPredecessors(root);
	}
}
