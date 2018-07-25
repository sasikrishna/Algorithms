package com.algorithms.binarytree.traversals;

/***
 * Problem statement: Given a Perfect Binary Tree, reverse the alternate level nodes of the binary tree.
 * 
 * @author Sasi Jolla on 23-Jul-2018, 11:24:41 pm
 */
public class ReverseAlternateNodes {
	
	/**
	 * 
	 * Time complexity: O(n)
	 * Space complexity: O(1)
	 * 
	 * @param root
	 */
	public static void reverse(Node<Integer> root){
		reverse(root.left, root.right, 1);
	}
	
	/**
	 * 
	 * @param left
	 * @param right
	 * @param level
	 */
	private static void reverse(Node<Integer> left, Node<Integer> right, int level){
		if(null == left || null == right){
			return;
		}
		
		/**Swapping nodes data if current level is odd*/
		if(level % 2 != 0){
			int temp = left.data;
			left.data = right.data;
			right.data = temp;
		}
		
		/**Recurring for left and right most subtrees*/
		reverse(left.left, right.right, level + 1);
		
		/**Recurring for left and right inner subtrees*/
		reverse(left.right, right.left, level + 1);
	}
	
	/**
	 * 
	 * @param args
	 */
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
		System.out.println("Preorder traversal is");
		Node.preOrderTraversal(root);
		reverse(root);
		System.out.println("\nPreorder traversal after reversal is");
		Node.preOrderTraversal(root);
	}
}
