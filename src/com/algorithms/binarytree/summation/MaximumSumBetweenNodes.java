package com.algorithms.binarytree.summation;


import com.algorithms.binarytree.traversals.Node;


/**
 * Problem statement: Given a binary tree in which each node element contains a number. 
 * Find the maximum possible sum from one leaf node to another.
 * 
 * @author Sasi Jolla on 29-Jul-2018, 2:48:32 pm
 */
public class MaximumSumBetweenNodes {
	
	static int maxSum = 0;
	
	/**
	 * 
	 * @param root
	 */
	public static int getMaximumPathSum(Node<Integer> root){
		if(null == root){
			return 0;
		}
		
		/**Return root value if this is leaf node*/
		if(null == root.left && null == root.right){
			return root.data;
		}
		
		int leftSum = getMaximumPathSum(root.left);
		int rightSum = getMaximumPathSum(root.right);
		
		if(null != root.left && null != root.right){
			int sumWithRoot = leftSum + rightSum + root.data;
			maxSum = Math.max(maxSum, sumWithRoot);
			
			/**Considering either left or right child as we are considering root in the path for max sum*/
			return Math.max(leftSum, rightSum) + root.data;
		}
		
		return (root.left == null) ? rightSum + root.data : leftSum + root.data;
	}
	
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(-15);
        root.left = new Node<Integer> (5);
        root.right = new Node<Integer> (6);
        root.left.left = new Node<Integer> (-8);
        root.left.right = new Node<Integer> (1);
        root.left.left.left = new Node<Integer> (2);
        root.left.left.right = new Node<Integer> (6);
        root.right.left = new Node<Integer> (3);
        root.right.right = new Node<Integer> (9);
        root.right.right.right = new Node<Integer> (0);
        root.right.right.right.left = new Node<Integer> (4);
        root.right.right.right.right = new Node<Integer> (-1);
        root.right.right.right.right.left = new Node<Integer> (10);
        
        getMaximumPathSum(root);
        System.out.println("Max pathSum of the given binary tree is "
                + maxSum);
	}
}
