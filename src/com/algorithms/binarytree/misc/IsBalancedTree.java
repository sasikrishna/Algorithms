package com.algorithms.binarytree.misc;

import com.algorithms.binarytree.traversals.Node;

/**
 * 
 * @author Sasi Jolla on 31-Jul-2018, 11:35:20 pm
 */
public class IsBalancedTree {
	
	/**
	 * Time complexity - O(n)^2
	 * 
	 * @param root
	 * @returns true if tree is balanced or returns false
	 */
	public static Boolean isBalanced(Node<Integer> root){
		
		if(null == root){
			return true;
		}
		
		int leftSubtreeHeight = getHeight(root.left);
		int rightSubtreeHeight = getHeight(root.right);
		
		if(Math.abs(rightSubtreeHeight - leftSubtreeHeight) <= 1
				&& isBalanced(root.left) && isBalanced(root.right))
			return true;
		
		return false;
	}
	
	/**
	 * @param root
	 * @return height of binary tree
	 */
	private static int getHeight(Node<Integer> root){
		if(null == root){
			return 0;
		}
		
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}
	
	/**
	 * Optimized method to find tree balancedness
	 * 
	 * Time complexity: O(n)
	 * 
	 * @param root
	 * @returns true if tree is balanced or returns false
	 */
	public static Boolean isBalancedOptimized(Node<Integer> root){
		return isBalancedOptimized(root, new Height());
	}
	
	/**
	 * 
	 * @param root
	 * @param height
	 * @return
	 */
	private static boolean isBalancedOptimized(Node<Integer> root, Height height){
		
		if(null == root){
			height.height = 0;
			return true;
		}
		
		Height lHeight = new Height(), rHeight = new Height();
		boolean isLeftSubtreeBalanced = isBalancedOptimized(root.left, lHeight);
		boolean isRightSubtreeBalanced = isBalancedOptimized(root.right, rHeight);
		
		height.height = Math.max(lHeight.height, rHeight.height) + 1;
		
		if(Math.abs(lHeight.height - rHeight.height) >= 2){
			return false;
		}
		
		return isLeftSubtreeBalanced && isRightSubtreeBalanced;
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
        root.left.left.left = new Node<Integer>(8);
        System.out.println("Is this tree balanced? " + (isBalanced(root) ? "Yes" : "No"));
        System.out.println("Is this tree balanced? " + (isBalancedOptimized(root) ? "Yes" : "No"));
        
        root = new Node<Integer>(1);
        root.left = new Node<Integer>(2);
        root.right = new Node<Integer>(3);
        root.left.left = new Node<Integer>(4);
        root.left.right = new Node<Integer>(5);
        System.out.println("Is this tree balanced? " + (isBalanced(root) ? "Yes" : "No"));
        System.out.println("Is this tree balanced? " + (isBalancedOptimized(root) ? "Yes" : "No"));
	}
}

/**
 * 
 */
class Height{
	int height = 0;
}
