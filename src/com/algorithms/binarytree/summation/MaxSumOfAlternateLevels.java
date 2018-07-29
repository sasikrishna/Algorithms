package com.algorithms.binarytree.summation;

import com.algorithms.binarytree.traversals.Node;

/**
 * 
 * @author Sasi Jolla on 29-Jul-2018, 5:23:39 pm
 */
public class MaxSumOfAlternateLevels {
	
	/**
	 * 
	 * @param root
	 */
	public static int getMaxSum(Node<Integer> root){
		
		 if(root == null)
			 return 0;
		 
		return Math.max(getSumOfGrandChildren(root), getSumOfGrandChildren(root.left) + 
				getSumOfGrandChildren(root.right));
	}
	
	/**
	 * 
	 * @param root
	 */
	private static int getSumOfGrandChildren(Node<Integer> root){
		int sum = 0;
		
		if(root == null){
			return sum;
		}
		
		sum = root.data;
		if(null != root.left){
			sum += getMaxSum(root.left.left);
			sum += getMaxSum(root.left.right);
		}
		
		if(null != root.right){
			sum += getMaxSum(root.right.left);
			sum += getMaxSum(root.right.right);
		}
		return sum;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(1);
        root.left = new Node<Integer>(2);
        root.right = new Node<Integer>(3);
        root.right.left = new Node<Integer>(4);
        root.right.left.right = new Node<Integer>(5);
        root.right.left.right.left = new Node<Integer>(6);
        System.out.println(getMaxSum(root));
	}
}
