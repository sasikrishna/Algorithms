package com.algorithms.binarytree.constructive;

import com.algorithms.binarytree.traversals.Node;

/**
 * Problem statement: Given an array ‘preOrderTraversal[]’ that represents Preorder traversal of a spacial binary tree where every node has either 0 or 2 children. One more array ‘preLN[]’ is given which has only two possible values ‘L’ and ‘N’. The value ‘L’ in ‘preLN[]’ indicates that the corresponding node in Binary Tree is a leaf node and value ‘N’ indicates that the corresponding node is non-leaf node. Write a function to construct the tree from the given two arrays.
 * 
 * @author Sasi Jolla on 27-Jul-2018, 1:17:51 am
 */
public class SpecialTreeFromPreorder {
	
	static int index = 0;
	
	/**
	 * 
	 * @param pre
	 * @param preLN
	 */
	public static Node<Integer> constructTree(int preOrderTraversal[], char preLN[]){
		return constructTree(preOrderTraversal, preLN, null);
	}
	
	/**
	 * 
	 * @param preOrderTraversal
	 * @param preLN
	 * @param root
	 * @return
	 */
	private static Node<Integer> constructTree(int preOrderTraversal[], char preLN[], Node<Integer> root){
		
		if(index == preOrderTraversal.length){
			return null;
		}
		
		root = new Node<Integer>(preOrderTraversal[index]);
		if(preLN[index++] == 'N'){
			root.left = constructTree(preOrderTraversal, preLN, root);
			root.right = constructTree(preOrderTraversal, preLN, root);
		}
		
		return root;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int preOrderTraversal[] = new int[]{10, 30, 20, 5, 15};
        char preLN[] = new char[]{'N', 'N', 'L', 'L', 'L'};
        Node<Integer> root = constructTree(preOrderTraversal, preLN);
        Node.preOrderTraversal(root);
	}
}
