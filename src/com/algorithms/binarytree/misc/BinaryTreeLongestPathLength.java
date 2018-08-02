package com.algorithms.binarytree.misc;

import com.algorithms.binarytree.traversals.Node;

/**
 * Problem statement: Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root. The length of path between two nodes is represented by the number of edges between them.
 * 
 * @author Sasi Jolla on 02-Aug-2018, 11:06:14 pm
 */
public class BinaryTreeLongestPathLength {
	
	/**
	 * 
	 * @param root
	 * @return
	 */
	public static int findLongestLength(Node<Integer> root){
		LongestPathLength max = new LongestPathLength();
		findLongestLength(root, max);
		return max.length;
	}
	
	private static int findLongestLength(Node<Integer> root, LongestPathLength max){
		
		if(null == root){
			return 0;
		}
		
		int leftMax = findLongestLength(root.left, max);
		int rightMax = findLongestLength(root.right, max);
		
		if(null != root.left && root.data == root.left.data){
			leftMax++;
		}
		
		if(null != root.right && root.data == root.right.data){
			rightMax++;
		}
		
		max.length = Math.max(max.length, leftMax + rightMax);
		return Math.max(leftMax, rightMax);
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
	  Node<Integer> root = new Node<Integer>(4);
	  root.left = new Node<Integer>(4);
	  root.right = new Node<Integer>(4);
	  root.left.left = new Node<Integer>(4);
	  root.left.right = new Node<Integer>(9);
	  root.right.right = new Node<Integer>(5);
	  System.out.println("Longest path length is " + findLongestLength(root));
	}
}

class LongestPathLength{
	int length = 1;
}
