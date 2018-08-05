package com.algorithms.bst.conversion;

/**
 * Problem statement: Check if a given array can represent Preorder Traversal of Binary Search Tree
 * 
 * @author Sasi Jolla on 05-Aug-2018, 1:36:01 pm
 */
public class ISBSTPreorderTraversal1 {

	/**
	 * 
	 * @param preorder
	 * @return
	 */
	public static boolean isPreorderTraversal(int[] preorder){
		return isPreorderTraversal(preorder, 0, preorder.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	/**
	 * In preorder first element is root. The idea is to find greater element next to root. So elements after greater forms right tree subtree in BST 
	 * and before elements form left subtree. Recursively check for left and right subtrees.
	 * 
	 * Time complexity: O(n^2)
	 * 
	 * @param preorder
	 * @param start
	 * @param end
	 * @param min
	 * @param max
	 * @return true if given preorder traversal is from BST
	 */
	private static boolean isPreorderTraversal(int[] preorder, int start, int end, int min, int max){
		
		if(start >= end){
			return true;
		}
		
		int root = preorder[start], mid = start;
		for(int i = start; i <= end; i++){
			
			if(preorder[i] < min || preorder[i] > max){
				return false;
			}
			
			/**Finding greater element next to root*/
			if(preorder[i] > root){
				break;
			}
			mid++;
		}
		
		boolean left = isPreorderTraversal(preorder, start + 1, mid - 1, min, preorder[start] - 1);
		boolean right = isPreorderTraversal(preorder, mid, end, preorder[start] + 1, max);
		
		return left && right;
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
