package com.algorithms.binarytree.summation;

import com.algorithms.binarytree.traversals.Node;

/**
 * Problem statement: Given a binary tree containing n nodes. The problem is to find the sum of all nodes on the longest path from root to leaf node. If two or more paths compete for the longest path, then the path having maximum sum of nodes is being considered.
 * s
 * @author Sasi Jolla on 29-Jul-2018, 12:31:56 pm
 */
public class SumInLongestPath {

	static int maxSum = Integer.MIN_VALUE, maxHeight = Integer.MIN_VALUE;
	
	/**
	 * 
	 * @param root
	 */
	public static void getSumInLongestPath(Node<Integer> root){
		getSumInLongestPath(root, 0, 0);
	}
	
	/**
	 * 
	 * @param root
	 * @param currentHeight
	 * @param currentSum
	 */
	private static void getSumInLongestPath(Node<Integer> root, int currentHeight, int currentSum){
		if(maxHeight < currentHeight){
			maxHeight = currentHeight;
			maxSum = currentSum;
		}
		
		if(null == root){
			return;
		}
		
		getSumInLongestPath(root.left, currentHeight + 1, currentSum + root.data);
		getSumInLongestPath(root.right, currentHeight + 1, currentSum + root.data);
	}
	
	public static void main(String[] args) {
		// binary tree formation
        Node<Integer> root = new Node<Integer>(4);/*        4        */
        root.left = new Node<Integer>(2);         /*       / \       */
        root.right = new Node<Integer>(5);        /*      2   5      */
        root.left.left = new Node<Integer>(7);    /*     / \ / \     */
        root.left.right = new Node<Integer>(1);   /*    7  1 2  3    */
        root.right.left = new Node<Integer>(2);   /*      /          */
        root.right.right = new Node<Integer>(3);  /*     6           */
        root.left.right.left = new Node<Integer>(6);
        getSumInLongestPath(root);
        System.out.println("Max height: " + maxHeight);
        System.out.println("Max sum: " + maxSum);
	}
}
