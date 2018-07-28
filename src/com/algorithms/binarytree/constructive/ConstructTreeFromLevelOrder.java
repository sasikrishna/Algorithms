package com.algorithms.binarytree.constructive;

import com.algorithms.binarytree.traversals.Node;

/**
 * Problem statement: Construct binary tree from given Inorder and Level order traversals
 * 
 * @author Sasi Jolla on 26-Jul-2018, 10:25:25 pm
 */
public class ConstructTreeFromLevelOrder {

	/**
	 * 
	 * @param inOrderTraversal
	 * @param levelOrderTraversal
	 * @return
	 */
	public static Node<Integer> constructTree(int[] inOrderTraversal, int[] levelOrderTraversal){
		return constructTree(inOrderTraversal, levelOrderTraversal, 0, inOrderTraversal.length - 1);
	}
	
	/**
	 * 
	 * @param inOrderTraversal
	 * @param levelOrderTraversal
	 * @return
	 */
	private static Node<Integer> constructTree(int[] inOrderTraversal, int[] levelOrderTraversal,
			int inOrderStart, int inOrderEnd){
		
		if(inOrderStart > inOrderEnd){
			return null;
		}
		
		if(inOrderStart == inOrderEnd){
			return new Node<Integer>(inOrderTraversal[inOrderStart]);
		}
		
		int rootIndex = 0;
		Node<Integer> root = null;
		for(int i = 0; i < levelOrderTraversal.length; i++){
			int rootValue = levelOrderTraversal[i];
			Boolean isFound = false;
			for(int j = inOrderStart; j < inOrderEnd; j++){
				if(rootValue == inOrderTraversal[j]){
					root = new Node<Integer>(rootValue);
					rootIndex = j;
					isFound = true;
					break;
				}
			}
			
			if(isFound){
				break;
			}
		}
		
		root.left = constructTree(inOrderTraversal, levelOrderTraversal, inOrderStart, rootIndex - 1);
		root.right = constructTree(inOrderTraversal, levelOrderTraversal, rootIndex + 1, inOrderEnd);
		
		return root;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Node<Integer> root = constructTree(new int[]{4, 8, 10, 12, 14, 20, 22}, 
				new int[]{20, 8, 22, 4, 12, 10, 14});
		Node.preOrderTraversal(root);
	}
}
