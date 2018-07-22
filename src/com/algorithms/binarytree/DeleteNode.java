package com.algorithms.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem statement: Given a binary tree, delete a node from it by making sure that tree shrinks from the bottom (the deleted not is replaced by bottommost and rightmost node).
 * 
 * @author Sasi Jolla on 21-Jul-2018, 1:18:52 pm
 */
public class DeleteNode {
	
	/**
	 * 
	 * @param root
	 * @param key
	 * @throws Exception 
	 */
	public static void deleteNode(Node<Integer> root, int key) throws Exception{
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		queue.add(root);
		
		Node<Integer> current = null, keyNode = null;
		while(!queue.isEmpty()){
			current = queue.poll();
			if(current.data == key){
				keyNode = current;
			}
			
			if(null != current.left){
				queue.add(current.left);
			}
			if(null != current.right){
				queue.add(current.right);
			}
		}
		
		if(null == keyNode){
			throw new Exception("Key not found.");
		}
		
		/**Deleting last node*/
		deleteDeepestNode(root, current);
		
		/**After the queue is empty current points to last node in the tree. So copying last node value to keyNode*/
		keyNode.data = current.data;
	}
	
	/**
	 * 
	 * @param root
	 * @param lastNode
	 */
	private static void deleteDeepestNode(Node<Integer> root, Node<Integer> lastNode){
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		queue.add(root);
		
		while(!queue.isEmpty()){
			Node<Integer> current = queue.poll();
			
			if(current.right.equals(lastNode)){
				current.right = null;
				break;
			}else{
				queue.add(current.right);
			}
			
			if(current.left.equals(lastNode)){
				current.left = null;
				break;
			}else{
				queue.add(current.left);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		Node<Integer> root = new Node<Integer>(10);
        root.left = new Node<Integer>(11);
        root.left.left = new Node<Integer>(7);
        root.right = new Node<Integer>(9);
        root.right.left = new Node<Integer>(15);
        root.right.right = new Node<Integer>(8);
        Node.preOrderTraversal(root);
        
        deleteNode(root, 11);
        System.out.println("After deleting 11 key...");
        Node.preOrderTraversal(root);
	}
}
