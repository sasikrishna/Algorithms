package com.algorithms.bst.conversion;

import java.util.Stack;

import com.algorithms.binarytree.traversals.Node;

/**
 * Problem statement: Convert given preorder traversal into BST.
 * 
 * @author Sasi Jolla on 04-Aug-2018, 10:39:28 pm
 */
public class ConvertToBST2 {

	/**
	 * The idea is to use stack for constructing the tree. 
	 * 
	 * Time complexity: O(n)
	 * Space complexity: O(n) for stack 
	 * 
	 * @param preorder
	 * @return
	 */
	public static Node<Integer> convertToBST(int[] preorder){
		
		Node<Integer> root = new Node<Integer>(preorder[0]);
		Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
		stack.push(root);
		
		for(int i = 1; i < preorder.length; i++){
			Node<Integer> node = new Node<Integer>(preorder[i]);
			Node<Integer> temp = null;
			
			while(!stack.isEmpty() && preorder[i] > stack.peek().data){
				temp = stack.pop();
			}
			
			if(null != temp){
				temp.right = node;
				stack.push(node);
			}else{
				temp = stack.peek();
				temp.left = node;
				stack.push(node);
			}
		}
		
		return root;
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
