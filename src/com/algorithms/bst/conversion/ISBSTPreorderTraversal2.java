package com.algorithms.bst.conversion;

import java.util.Stack;

/**
 * Problem statement: Check if a given array can represent Preorder Traversal of Binary Search Tree
 * 
 * @author Sasi Jolla on 05-Aug-2018, 3:19:00 pm
 */
public class ISBSTPreorderTraversal2 {

	/**
	 * 
	 * @param preorder
	 */
	public static boolean isPreorderTraversal(int[] preorder){
		Stack<Integer> stack = new Stack<Integer>();
		int root = Integer.MIN_VALUE;
		
		for(int i = 0; i < preorder.length; i++){
			if(preorder[i] < root){
				return false;
			}
			
			while(!stack.isEmpty() && stack.peek() < preorder[i]){
				root = stack.pop();
			}
			
			stack.push(preorder[i]);
		}
		return true;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] preOrderTraversal = {4, 2, 1, 3, 6, 5, 7};
		System.out.println(isPreorderTraversal(preOrderTraversal));
	}
}
