package com.algorithms.binarytree.summation;

import com.algorithms.binarytree.traversals.Node;

/**
 * 
 * @author Sasi Jolla on 29-Jul-2018, 5:49:32 pm
 */
public class LargestSubtreeSum {
	
	static int maxSubtreeSum = 0;
	
	public static int getLargestSubtreeSum(Node<Integer> root){
		if(null == root){
			return 0;
		}
		
		if(root.left == null && root.right == null){
			return root.data;
		}
		
		int leftSum = getLargestSubtreeSum(root.left);
		int rightSum = getLargestSubtreeSum(root.right);
		
		int currentSum = leftSum + rightSum + root.data;
		if(maxSubtreeSum < currentSum){
			maxSubtreeSum = currentSum;
		}
		return currentSum;
	}
	
	public static void main(String[] args) {

	    Node<Integer> root = new Node<Integer>(1);
	    root.left = new Node<Integer>(-2);
	    root.right = new Node<Integer>(3);
	    root.left.left = new Node<Integer>(4);
	    root.left.right = new Node<Integer>(5);
	    root.right.left = new Node<Integer>(-6);
	    root.right.right = new Node<Integer>(2);
	    System.out.println("Largest substree sum is " + getLargestSubtreeSum(root));
	}
}
