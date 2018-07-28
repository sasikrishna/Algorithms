package com.algorithms.binarytree.constructive;

import com.algorithms.binarytree.traversals.Node;

/**
 * Problem statement: Given Inorder Traversal of a Special Binary Tree in which key of every node is greater than keys in left and right children, construct the Binary Tree and return root.
 * 
 * @author Sasi Jolla on 27-Jul-2018, 1:47:55 am
 */
public class SpecialTreeFromInorder {

	/**
	 * 
	 * @param inorder
	 */
	public static Node<Integer> constructTree(int[] inorder){
		return constructTree(inorder, 0, inorder.length - 1);
	}

	/**
	 * 
	 * @param inorder
	 * @param start
	 * @param end
	 * @return
	 */
	private static Node<Integer> constructTree(int[] inorder, int start, int end){
		if(start > end){
			return null;
		}
		
		int largestEleIndex = findLargestEleIndex(inorder, start, end);
		Node<Integer> root = new Node<Integer>(inorder[largestEleIndex]);
		
		if(start == end){
			return root;
		}
		
		root.left = constructTree(inorder, start, largestEleIndex - 1);
		root.right = constructTree(inorder, largestEleIndex + 1, end);
		
		return root;
	}
	
	/**
	 * 
	 * @param inorder
	 * @param start
	 * @param end
	 * @return
	 */
	private static int findLargestEleIndex(int[] inorder, int start, int end){
		int maxEleIndex = start, maxEle = inorder[start];
		for(int i = start + 1; i <= end; i++){
			if(maxEle < inorder[i]){
				maxEle = inorder[i];
				maxEleIndex = i;
			}
		}
		return maxEleIndex;
	}
	
	public static void main(String[] args) {
		 int inorder[] = new int[]{5, 10, 40, 30, 28};
		 Node<Integer> root = constructTree(inorder);
		 Node.preOrderTraversal(root);
	}
}
