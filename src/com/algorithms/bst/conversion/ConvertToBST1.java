package com.algorithms.bst.conversion;

import java.util.Arrays;

import com.algorithms.binarytree.traversals.Node;

/**
 * Problem statement: Given preorder traversal of a binary search tree, construct the BST.
 * 
 * @author Sasi on 03-Aug-2018, 1:11:15 am
 */
public class ConvertToBST1 {

	/**
	 * 
	 * @param preOrder
	 * @return
	 */
	public static Node<Integer> convertToBST(int[] preOrder){
		
		if(preOrder.length < 1){
			return null;
		}
		
		Node<Integer> node = new Node<Integer>(preOrder[0]);
		int i = 0;
		for(; i < preOrder.length; i++){
			if(node.data < preOrder[i]){
				break;
			}
		}
		
		node.left = convertToBST(Arrays.copyOfRange(preOrder, 1, i));
		node.right = convertToBST(Arrays.copyOfRange(preOrder, i, preOrder.length));
		return node;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int preOrder[] = new int[]{10, 5, 1, 7, 40, 50};
		Node<Integer> root = convertToBST(preOrder);
		Node.inOrderTraversal(root);
	}
}
