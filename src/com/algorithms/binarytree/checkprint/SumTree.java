package com.algorithms.binarytree.checkprint;

import com.algorithms.binarytree.traversals.Node;

/**
 * Problem statement: Write a function that returns true if the given Binary Tree is SumTree else false. 
 * A SumTree is a Binary Tree where the value of a node is equal to sum of the nodes present in its left subtree and right subtree.
 * 
 * @author Sasi Jolla on 28-Jul-2018, 4:31:41 pm
 */
public class SumTree {
	
	/**
	 * 
	 * @param root
	 */
	public static boolean isSumTree(Node<Integer> root){
		int leftSum = getSum(root.left);
		int rightSum = getSum(root.right);
		return root.data ==  leftSum + rightSum;
	}
	
	/**
	 * 
	 * @param root
	 * @return
	 */
	private static int getSum(Node<Integer> root){
		
		if(null == root){
			return 0;
		}
		
		if(null == root.left && null == root.right){
			return root.data;
		}
		
		int leftSum = getSum(root.left);
		int rightSum = getSum(root.right);
		
		return root.data + leftSum + rightSum;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
        Node<Integer> root = new Node<Integer>(26);
        root.left = new Node<Integer>(10);
        root.right = new Node<Integer>(3);
        root.left.left = new Node<Integer>(4);
        root.left.right = new Node<Integer>(6);
        root.right.right = new Node<Integer>(3);
        
        System.out.println("Is sum tree " + isSumTree(root));
	}
}
