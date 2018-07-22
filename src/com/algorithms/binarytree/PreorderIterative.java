package com.algorithms.binarytree;

import java.util.Stack;

/**
 * Problem statement: Preorder iterative traversal.
 * 
 * @author Sasi Jolla on 22-Jul-2018, 12:41:27 am
 */
public class PreorderIterative {
	
	/**
	 * 
	 * @param root
	 */
	public static void iterativePreorder(Node<Integer> root){
		Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
		Node<Integer> current  = root;
		stack.push(current);
		
		while(!stack.isEmpty()){
			
			current = stack.pop();
			System.out.print(current.data + " ");
		
			if(current.right != null){
				stack.push(current.right);
			}
			if(current.left != null){
				stack.push(current.left);
			}
		}
	}
	
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(10);
        root.left = new Node<Integer>(11);
        root.left.left = new Node<Integer>(7);
        root.right = new Node<Integer>(9);
        root.right.left = new Node<Integer>(15);
        root.right.right = new Node<Integer>(8);
        iterativePreorder(root);
	}
}
