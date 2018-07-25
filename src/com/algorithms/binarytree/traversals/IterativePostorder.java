package com.algorithms.binarytree.traversals;

import java.util.Stack;

/**
 * 
 * @author Sasi Jolla on 24-Jul-2018, 12:39:59 am
 */
public class IterativePostorder {
	
	/**
	 * 
	 * @param root
	 */
	public static void postOrderIterative(Node<Integer> root){
		Node<Integer> current = root;
		Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
		
		while(!stack.isEmpty() || current != null){
			if(null != current){
				stack.push(current);
				current = current.left;
			}else{
				Node<Integer> temp = stack.peek().right;
				if(null == temp){
					temp = stack.pop();
					System.out.print(temp.data + " ");
					while(!stack.empty() && temp.equals(stack.peek().right)){
						temp = stack.pop();
						System.out.print(temp.data + " ");
					}
				}else{
					current = temp;
				}
			}
			
		}
 	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(1);
		root.left = new Node<Integer>(2);
		root.right = new Node<Integer>(3);
		
		root.left.left = new Node<Integer>(4);
		root.left.right = new Node<Integer>(5);
		root.right.left = new Node<Integer>(6);
		root.right.right = new Node<Integer>(7);
		
		root.left.left.left = new Node<Integer>(8);
		root.left.left.right = new Node<Integer>(9);
		root.left.right.left = new Node<Integer>(10);
		root.left.right.right = new Node<Integer>(11);
		root.right.left.left = new Node<Integer>(12);
		root.right.left.right = new Node<Integer>(13);
		root.right.right.left = new Node<Integer>(14);
		root.right.right.right = new Node<Integer>(15);
		postOrderIterative(root);
	}
}
