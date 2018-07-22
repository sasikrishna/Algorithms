package com.algorithms.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem statement: Given a binary tree and a key, insert the key into the binary tree at first position available in level order.
 * 
 * @author Sasi Jolla on 21-Jul-2018, 12:33:48 pm
 */
public class InsertionAtFirstPosition {
	
	/**
	 * The idea is to traverse tree in level order and finding first available position to insert the node.
	 * 
	 * Time complexity: O(n)
	 * Space complextiy: O(n)
	 * 
	 * @param root
	 */
	public static void insertAtFirstAvailablePosition(Node<Integer> root, int key){
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		queue.add(root);
		
		while(!queue.isEmpty()){
			Node<Integer> node = queue.poll();
			if(null != node.left){
				queue.add(node.left);
			}else{
				node.left = new Node<Integer>(key);
				break;
			}
			if(null != node.right){
				queue.add(node.right);
			}else{
				node.right = new Node<Integer>(key);
				break;
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
        Node.preOrderTraversal(root);
        
        insertAtFirstAvailablePosition(root, 12);
        System.out.println("After inserting 12 key...");
        Node.preOrderTraversal(root);
	}
}
