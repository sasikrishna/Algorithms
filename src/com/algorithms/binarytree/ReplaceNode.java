package com.algorithms.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Problem statement: Given a binary tree containing n nodes. The problem is to replace each node in the binary tree with the sum of its inorder predecessor and inorder successor.
 * 
 * @author Sasi Jolla on 22-Jul-2018, 12:17:22 pm
 */
public class ReplaceNode {
	
	/**
	 * 
	 * @param root
	 */
	public static void replaceNode(Node<Integer> root){
		List<Integer> inorderArray = new ArrayList<Integer>();
		
		/**Finding inorder traversal for the tree*/
		findInorderTraversal(root, inorderArray);
		//System.out.println(inorderArray);
		
		int index = 0;
		Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
		Node<Integer> current = root;
		while(null != current || !stack.isEmpty()){
			while(null != current){
				stack.push(current);
				current = current.left;
			}
			
			current =  stack.pop();
			/**Calculating sum from inorder array*/
			current.data = ((index > 0) ? inorderArray.get(index - 1) : 0) 
						 + ((index < inorderArray.size() - 1) ? inorderArray.get(index + 1) : 0);
			current = current.right;
			index++;
		}
		
		inorderArray = new ArrayList<Integer>();
		findInorderTraversal(root, inorderArray);
		System.out.println(inorderArray);
	}
	
	/**
	 * 
	 * @param root
	 */
	private static void findInorderTraversal(Node<Integer> root, List<Integer> inorderArray){
		Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
		Node<Integer> current = root;
		
		while(null != current || !stack.isEmpty()){
			while(null != current){
				stack.push(current);
				current = current.left;
			}
			
			current =  stack.pop();
			inorderArray.add(current.data);
			current = current.right;
		}
	}
	
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(1);
		root.left = new Node<Integer>(2);
		root.right = new Node<Integer>(3);
		root.left.left = new Node<Integer>(4);
        root.left.right = new Node<Integer>(5);
        root.right.left = new Node<Integer>(6);
        root.right.right = new Node<Integer>(7);
        replaceNode(root);
	}
}
