package com.algorithms.binarytree.constructive;

import com.algorithms.binarytree.traversals.Node;

/**
 * Problem statement: Construct binary tree from given Inorder and Preorder traversals
 * 
 * @author Sasi Jolla on 26-Jul-2018, 1:13:42 am
 */
public class ConstructTree {

	static int preOrderIndex = 0;
	/**
	 * 
	 * @param inorderTraversal
	 * @param preorderTraversal
	 * @return
	 */
	public static Node<Character> constructTree(char[] inorderTraversal, char[] preorderTraversal){
		return constructTree(inorderTraversal, preorderTraversal, 
				0, inorderTraversal.length - 1);
	}
	
	/**
	 * 
	 * @param inorderTraversal
	 * @param preorderTraversal
	 * @param inOrderStart
	 * @param inOrderEnd
	 * @param preOrderIndex
	 * @return
	 */
	private static Node<Character> constructTree(char[] inorderTraversal, char[] preorderTraversal,
			int inOrderStart, int inOrderEnd){
		
		if(inOrderStart > inOrderEnd){
			return null;
		}
		
		Character character = preorderTraversal[preOrderIndex++];
		Node<Character> root = new Node<Character>(character);
		
		if(inOrderStart == inOrderEnd){
			return root;
		}
		
		int index = findCharacterIndex(character, inorderTraversal, inOrderStart, inOrderEnd);
		
		root.left = constructTree(inorderTraversal, preorderTraversal, inOrderStart, index - 1);
		root.right = constructTree(inorderTraversal, preorderTraversal, index + 1, inOrderEnd);
		
		return root;
	}
	
	/**
	 * 
	 * @param character
	 * @param inorderTraversal
	 * @param start
	 * @param end
	 * @return
	 */
	private static int findCharacterIndex(char character, char[] inorderTraversal, 
			int start, int end){
		for(int i = 0; i < inorderTraversal.length; i++){
			if(character == inorderTraversal[i]){
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Node<Character> root = constructTree(new char[]{'D','B','E','A','F','C'}, 
				new char[]{'A','B','D','E','C','F'});
		Node.preOrderTraversal(root);
	}
}
