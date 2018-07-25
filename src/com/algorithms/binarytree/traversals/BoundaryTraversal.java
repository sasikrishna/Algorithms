package com.algorithms.binarytree.traversals;

/**
 * Problem statement: Given a binary tree, print boundary nodes of the binary tree Anti-Clockwise starting from the root.
 * 
 * @author Sasi Jolla on 25-Jul-2018, 11:41:12 pm
 */
public class BoundaryTraversal {

	/**
	 * 
	 * @param root
	 */
	public static void boundaryTraversal(Node<Integer> root){
		
		if(null == root){
			return;
		}
		
		System.out.print(root.data + " ");
		
		/**Printing left boundary nodes*/
		printLeftBoundary(root.left);
		
		/**Printing left subtree leaf nodes*/
		printLeafNodes(root.left);
		
		/**Printing right subtree leaf nodes*/
		printLeafNodes(root.right);
		
		/**Printing right boundary nodes*/
		printRightBoundary(root.right);
	}
	
	/**
	 * 
	 * @param root
	 */
	private static void printLeftBoundary(Node<Integer> root){
		if(null == root){
			return;
		}
		
		if(root.left == null || root.left.left == null){
			return;
		}
		
		System.out.print(root.data + " ");
		printLeftBoundary(root.left);
	}
	
	/**
	 * 
	 * @param root
	 */
	private static void printRightBoundary(Node<Integer> root){
		if(null == root || null == root.right){
			return;
		}
		
		printRightBoundary(root.right);
		System.out.print(root.data + " ");
	}
	
	/**
	 * 
	 * @param root
	 */
	private static void printLeafNodes(Node<Integer> root){
		
		if(null == root){
			return;
		}
		
		if(null == root.left && null == root.right){
			/**Leaf node printing data*/
			System.out.print(root.data + " ");
			return;
		}
		
		printLeafNodes(root.left);
		printLeafNodes(root.right);
	}
	
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(1);
		root.left = new Node<Integer>(2);
		root.right = new Node<Integer>(3);
		
		root.left.left = new Node<Integer>(4);
		root.left.right = new Node<Integer>(5);
		root.right.left = new Node<Integer>(6);
		root.right.right = new Node<Integer>(7);
		
		root.left.left.left = new Node<Integer>(8);
		root.left.left.right = new Node<Integer>(9);
		root.left.right.left = new Node<Integer>(10);
		root.left.right.right = new Node<Integer>(11);
		root.right.left.left = new Node<Integer>(12);
		root.right.left.right = new Node<Integer>(13);
		root.right.right.left = new Node<Integer>(14);
		root.right.right.right = new Node<Integer>(15);
		boundaryTraversal(root);
	}
}
