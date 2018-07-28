package com.algorithms.binarytree.constructive;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

import com.algorithms.binarytree.traversals.Node;

/**
 * 
 * @author Sasi Jolla on 28-Jul-2018, 12:50:33 pm
 */
public class ConvertBinaryTreeToDLLInSpiral {

	static Node<Integer> head;
	
	/**
	 * 
	 * @param root
	 */
	public static void convertToDLL(Node<Integer> root){
		Deque<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		queue.add(root);
		
		Stack<Node<Integer>> stack = new Stack<>();
		int level = 0;
		while(!queue.isEmpty()){
			
			int nodeCount = queue.size();
			
			/**Checking if level is even*/
			if(level % 2 == 0){
				/**If level is even dequeue from first and enqueue new nodes at last*/
				while(nodeCount > 0){
					Node<Integer> node = queue.pollFirst();
					stack.add(node);
					if(null != node.left){
						queue.addLast(node.left);
					}
					if(null != node.right){
						queue.addLast(node.right);
					}
					nodeCount--;
				}
			}else{
				/**If level is odd pop dequeue from last and enqueue new nodes at first*/
				while(nodeCount > 0){
					Node<Integer> node = queue.pollLast();
					stack.add(node);
					if(null != node.right){
						queue.addFirst(node.right);
					}
					if(null != node.left){
						queue.addFirst(node.left);
					}
					nodeCount--;
				}
			}
			
			level++;
		}
		
		/**Stack contains all the nodes in required order. Creating DLL while poping each node from stack.*/
		while(!stack.isEmpty()){
			buildDLL(stack.pop());
		}
	}
	
	/**
	 * 
	 * @param node
	 */
	private static void buildDLL(Node<Integer> node){
		
		/**Making node as head if head is not created till now*/
		if(head == null){
			head = node;
			return;
		}
		
		/**Setting left and right nodes for current node*/
		node.right = head;
		node.left = null;
		
		head.left = node;
		
		/**Making current as head*/
		head = node;
	}
	
	/**
	 */
	public static void printDLL(){
		Node<Integer> current = head;
		while(null != current){
			System.out.print(current.data + " ");
			current = current.right;
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

        convertToDLL(root);
        printDLL();
	}
}
