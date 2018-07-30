package com.algorithms.binarytree.lca;

import com.algorithms.binarytree.traversals.Node;

/**
 * Problem statement: Given a binary tree, we need to find maximum value we can get by subtracting value of node B from value of node A, where A and B are two nodes of the binary tree and A is an ancestor of B
 * 
 * @author Sasi Jolla on 31-Jul-2018, 12:54:39 am
 */
public class MaxDiff {
	
	static int maxDiff = Integer.MIN_VALUE;
	
	/**
	 * 
	 * @param root
	 */
	public static void maxDiff(Node<Integer> root){
		calculateMaxDifference(root);
	}
	
	/**
	 * 
	 * @param root
	 */
	private static int calculateMaxDifference(Node<Integer> root){
		if(null == root){
			return Integer.MAX_VALUE;
		}
		
		if(null == root.left && null == root.right){
			return root.data;
		}
		
		/**Taking min from left and right tree to maximize diff with current root.*/
		int min = Math.min(calculateMaxDifference(root.left), calculateMaxDifference(root.right));
		
		maxDiff = Math.max(maxDiff, root.data - min);
		
		return Math.min(root.data, min);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
        Node<Integer> root = new Node<Integer>(8);
        root.left = new Node<Integer>(3);
        root.left.left = new Node<Integer>(1);
        root.left.right = new Node<Integer>(6);
        root.left.right.left = new Node<Integer>(4);
        root.left.right.right = new Node<Integer>(7);
  
        root.right = new Node<Integer>(10);
        root.right.right = new Node<Integer>(14);
        root.right.right.left = new Node<Integer>(13);
        maxDiff(root);
        
        System.out.println("Maximum difference between a node and"
                + " its ancestor is : " + maxDiff);
	}
}
