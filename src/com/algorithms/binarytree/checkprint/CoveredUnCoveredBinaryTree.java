package com.algorithms.binarytree.checkprint;

import com.algorithms.binarytree.traversals.Node;


/**
 * Problem statement: Given a binary tree, you need to check whether sum of all covered elements is equal to sum of all uncovered elements or not.
 * 
 * @author Sasi Jolla on 28-Jul-2018, 6:34:49 pm
 */
public class CoveredUnCoveredBinaryTree {

	/**
	 * 
	 * @param Node<Integer>
	 */
	public static boolean isSumSame(Node<Integer> root){
		return 2 * (getLeftSubtreeSum(root.left) + getRightSubtreeSum(root.right)) == getTotalSum(root);
	}
	
	/**
	 * 
	 * @param root
	 */
	public static int getTotalSum(Node<Integer> root){
		if(null == root){
			return 0;
		}
		return root.data + getTotalSum(root.left) + getTotalSum(root.right);
	}
	
	/**
	 * 
	 * @param root
	 */
	public static int getLeftSubtreeSum(Node<Integer> root){
		if(null == root){
			return 0;
		}
		
		int sum = root.data;
		if(root.left != null){
			sum += getLeftSubtreeSum(root.left);
		}else if(root.right != null){
			sum += getLeftSubtreeSum(root.right);
		}
		
		return sum;
	}
	
	/**
	 * 
	 * @param root
	 */
	public static int getRightSubtreeSum(Node<Integer> root){
		if(null == root){
			return 0;
		}
		
		int sum = root.data;
		if(root.right != null){
			sum += getRightSubtreeSum(root.right);
		}else if(root.left != null){
			sum += getRightSubtreeSum(root.left);
		}
		
		return sum;
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
 
        System.out.println("Is covered nodes and uncovered nodes sum same? " + isSumSame(root));
	}
}
