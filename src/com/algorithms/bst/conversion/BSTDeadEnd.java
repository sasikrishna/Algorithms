package com.algorithms.bst.conversion;

import com.algorithms.binarytree.traversals.Node;

/**
 * Problem statement: Given a Binary Search Tree that contains positive integer values greater than 0. The task is to check whether the BST contains a dead end or not. Here Dead End means, we are not able to insert any integer element after that node.
 * 
 * @author Sasi Jolla on 05-Aug-2018, 10:47:57 pm
 */
public class BSTDeadEnd {

	/**
	 * 
	 * @param root
	 * @return
	 */
	public boolean isDeadEndExists(Node<Integer> root){
		return isDeadEndExists(root, 1, Integer.MAX_VALUE);
	}
	
	/**
	 * 
	 * @param root
	 * @returns true if dead end exists
	 */
	private boolean isDeadEndExists(Node<Integer> root, int min, int max){
		if(null == root){
			return false;
		}
		
		if(min == max){
			return true;
		}
		
		return isDeadEndExists(root.left, min, root.data - 1) 
				|| isDeadEndExists(root.right, root.data + 1, max);
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(8);
        root.left = new Node<Integer>(5);
        root.right = new Node<Integer>(2);
        root.left.left = new Node<Integer>(3);
        root.left.right = new Node<Integer>(7);
        root.left.right.left = new Node<Integer>(11);
        root.left.right.right = new Node<Integer>(4);
        System.out.println("Is dead end exists " + new BSTDeadEnd().isDeadEndExists(root));
	}
}
