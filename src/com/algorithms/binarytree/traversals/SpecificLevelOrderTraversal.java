package com.algorithms.binarytree.traversals;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Problem statement: Print the level order of nodes in following specific manner.
 * 
 * @author Sasi Jolla on 22-Jul-2018, 5:51:46 pm
 */
public class SpecificLevelOrderTraversal {
	
	/**
	 * The idea is to modify the regular level order traversal little to process two nodes at a time.
	 * 
	 * @param root
	 */
	public static void printSpecificLevelOrderTopToBottom(Node<Integer> root){
		/**Printing root data*/
		System.out.print(root.data + " ");
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		queue.add(root.left);
		queue.add(root.right);
		
		while(!queue.isEmpty()){
			/**Dequeuing two nodes at a time unlike one node in regular level order traversal*/
			Node<Integer> left = queue.poll(), right = queue.poll();
			System.out.print(left.data + " ");
			System.out.print(right.data + " ");
			
			/**Assuming tree is perfect binary tree so checking just left node.*/
			if(null != left.left){
				/**Adding childs to queue in this specific manner allows to get the expected output*/
				queue.add(left.left);
				queue.add(right.right);
				queue.add(left.right);
				queue.add(right.left);
			}
		}
	}
	
	public static void printSpecificLevelOrderBottomUp(Node<Integer> root){
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		queue.add(root.left);
		queue.add(root.right);
		
		Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
		stack.add(root);
		stack.add(root.right);
		stack.add(root.left);
		
		while(!queue.isEmpty()){
			/**Dequeuing two nodes at a time unlike one node in regular level order traversal*/
			Node<Integer> left = queue.poll(), right = queue.poll();
			
			/**Assuming tree is perfect binary tree so checking just left node.*/
			if(null != left.left){
				
				stack.add(right.left);
				stack.add(left.right);
				stack.add(right.right);
				stack.add(left.left);
				
				/**Adding childs to queue in this specific manner allows to get the expected output*/
				queue.add(left.right);
				queue.add(right.left);
				queue.add(left.left);
				queue.add(right.right);
			}
		}
		
		while(!stack.isEmpty()){
			System.out.print(stack.pop().data + " ");
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
  
        root.left.left.left = new Node<Integer>(8);
        root.left.left.right = new Node<Integer>(9);
        root.left.right.left = new Node<Integer>(10);
        root.left.right.right = new Node<Integer>(11);
        root.right.left.left = new Node<Integer>(12);
        root.right.left.right = new Node<Integer>(13);
        root.right.right.left = new Node<Integer>(14);
        root.right.right.right = new Node<Integer>(15);
  
        root.left.left.left.left = new Node<Integer>(16);
        root.left.left.left.right = new Node<Integer>(17);
        root.left.left.right.left = new Node<Integer>(18);
        root.left.left.right.right = new Node<Integer>(19);
        root.left.right.left.left = new Node<Integer>(20);
        root.left.right.left.right = new Node<Integer>(21);
        root.left.right.right.left = new Node<Integer>(22);
        root.left.right.right.right = new Node<Integer>(23);
        root.right.left.left.left = new Node<Integer>(24);
        root.right.left.left.right = new Node<Integer>(25);
        root.right.left.right.left = new Node<Integer>(26);
        root.right.left.right.right = new Node<Integer>(27);
        root.right.right.left.left = new Node<Integer>(28);
        root.right.right.left.right = new Node<Integer>(29);
        root.right.right.right.left = new Node<Integer>(30);
        root.right.right.right.right = new Node<Integer>(31);
  
        System.out.println("Specific level rrder traversal of binary  tree is ");
        printSpecificLevelOrderTopToBottom(root);
        
        System.out.println("\nSpecific Level Order traversal of binary tree in bottom up is ");
        printSpecificLevelOrderBottomUp(root);
	}
}
