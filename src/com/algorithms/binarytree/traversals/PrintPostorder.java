package com.algorithms.binarytree.traversals;

import java.util.Arrays;

/**
 * Problem statement: Print postorder traversal of tree for given inorder and preorder traversals.
 * 
 * @author Sasi Jolla on 22-Jul-2018, 11:15:37 am
 */
public class PrintPostorder {
	
	public static void printPostorder(int inorder[], int preorder[]){
		
		if(preorder.length < 1){
			return;
		}
		
		int rootInInorder = getRootIndex(inorder, preorder[0]);
		
		/**Traversing left sub tree*/
		printPostorder(Arrays.copyOfRange(inorder, 0, rootInInorder), 
				Arrays.copyOfRange(preorder, 1, 1 + rootInInorder));
		
		/**Traversing right sub tree*/
		printPostorder(Arrays.copyOfRange(inorder, 1 + rootInInorder, inorder.length), 
				Arrays.copyOfRange(preorder, 1 + rootInInorder, preorder.length));
		
		System.out.print(inorder[rootInInorder] + " ");
	}
	
	/**
	 * 
	 * @param inorder
	 * @param rootInPreorder
	 * @return
	 */
	private static int getRootIndex(int inorder[], int rootInPreorder){
		int rootInInorder = -1;
		for(int i = 0; i < inorder.length; i++){
			if(rootInPreorder == inorder[i]){
				rootInInorder = i;
			}
		}
		return rootInInorder;
	}
	
	public static void main(String[] args) {
		int inorder[] = { 4, 2, 5, 1, 3, 6 };
		int preorder[] = { 1, 2, 4, 5, 3, 6 };
		System.out.println("Postorder traversal is ");
		printPostorder(inorder, preorder);
	}
}
