package com.algorithms.binarytree;

import java.util.Stack;

/**
 * Problem statement: Inorder Tree Traversal without Recursion
 * 
 * @author Sasi Jolla on 22-Jul-2018, 12:06:02 am
 */
public class InorderIterative {
	
	/**
	 * 
	 * @param root
	 */
	public static void iterativeInorder(Node<Integer> root){
		Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
		Node<Integer> current  = root;
		
		while(null != current || !stack.isEmpty()){
			while(current != null){
				stack.push(current);
				current = current.left;
			}
			
			current = stack.pop();
			System.out.print(current.data + " ");
			current = current.right;
		}
	}
	
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(10);
        root.left = new Node<Integer>(11);
        root.left.left = new Node<Integer>(7);
        root.right = new Node<Integer>(9);
        root.right.left = new Node<Integer>(15);
        root.right.right = new Node<Integer>(8);
        iterativeInorder(root);
	}
}
