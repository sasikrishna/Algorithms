package com.algorithms.binarytree.constructive;

import com.algorithms.binarytree.traversals.Node;

/**
 * Problem statement: Construct a Binary Tree from Postorder and Inorder traversals
 * 
 * @author Sasi Jolla on 27-Jul-2018, 7:51:55 pm
 */
public class ConstructTreeFromInPostOrderTraversals {

	/**
	 * 
	 * @param inOrder
	 * @param postOrder
	 */
	public static Node<Integer> constructTree(int[] inOrder, int[] postOrder){
		return constructTree(inOrder, postOrder, 0, inOrder.length - 1);
	}
	
	/**
	 * 
	 * @param inOrder
	 * @param postOrder
	 */
	private static Node<Integer> constructTree(int[] inOrder, int[] postOrder, 
			int inOrderStart, int inOrderEnd){
		if(inOrderStart > inOrderEnd){
			return null;
		}
		
		if(inOrderStart == inOrderEnd){
			return new Node<Integer>(inOrder[inOrderStart]);
		}
		
		Node<Integer> root = null;
		int index = 0;
		Boolean found = false;
		for(int i = postOrder.length - 1; i >= 0; i--){
			int rootEle = postOrder[i];
			for(int j = inOrderStart; j <= inOrderEnd; j++){
				if(inOrder[j] == rootEle){
					root = new Node<Integer>(inOrder[j]);
					index = j;
					found = true;
					break;
				}
			}
			
			if(found){
				break;
			}
		}
		
		root.left = constructTree(inOrder, postOrder, inOrderStart, index - 1);
		root.right = constructTree(inOrder, postOrder, index + 1, inOrderEnd);
		return root;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int inOrder[] = new int[]{4, 8, 2, 5, 1, 6, 3, 7};
        int postOrder[] = new int[]{8, 4, 5, 2, 6, 7, 3, 1};
        Node<Integer> root = constructTree(inOrder, postOrder);
        Node.preOrderTraversal(root);
	}
}
