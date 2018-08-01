package com.algorithms.binarytree.misc;

import com.algorithms.binarytree.traversals.Node;

/**
 * Problem statement: Given a binary tree, write a function to get the maximum width of the given tree. Width of a tree is maximum of widths of all levels.
 *
 * @author Sasi Jolla on 01-Aug-2018, 10:07:23 pm
 */
public class BinaryTreeMaxWidth {

	/**
	 * Time complexity: O(n^2) can be improved to O(n) using level order traversal using queue.
	 *  
	 * @param root
	 * @return
	 */
	public static int getMaxWidth(Node<Integer> root){
		int height = getHeight(root);
		int maxWidth = Integer.MIN_VALUE;
		
		for(int i = 1; i <= height; i++){
			int currMax = getWidth(root, i);
			maxWidth = Math.max(maxWidth, currMax);
		}
		
		return maxWidth;
	}
	
	/**
	 * 
	 * @param root
	 * @param level
	 * @returns number of nodes exists for given level
	 */
	private static int getWidth(Node<Integer> root, int level){
		if(null == root){
			return 0;
		}
		
		if(level == 1){
			return 1;
		}else if(level > 1){
			return getWidth(root.left, level - 1) + getWidth(root.right, level -1);
		}
		
		return 0;
	}
	
	/**
	 * 
	 * @param root
	 * @return
	 */
	private static int getHeight(Node<Integer> root){
		if(null == root){
			return 0;
		}
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
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
        root.right.right = new Node<Integer>(8);
        root.right.right.left = new Node<Integer>(6);
        root.right.right.right = new Node<Integer>(7);
        System.out.println("Maximum width is " + getMaxWidth(root));
	}
}
