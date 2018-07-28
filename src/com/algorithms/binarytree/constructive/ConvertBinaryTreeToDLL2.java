package com.algorithms.binarytree.constructive;

import com.algorithms.binarytree.traversals.Node;

/**
 * 
 * @author Sasi Jolla on 28-Jul-2018, 1:00:14 am
 */
public class ConvertBinaryTreeToDLL2 {

	private static Node<Integer> prev;

	/**
	 * 
	 * @param root
	 */
	public static Node<Integer> convertToDLL(Node<Integer> root){
		setLeftPointers(root);
		return setRightPointers(root);
	}
	
	/**
	 * 
	 * @param root
	 */
	public static void setLeftPointers(Node<Integer> root){
		if(null == root){
			return;
		}
		
		setLeftPointers(root.left);
		root.left = prev;
		prev= root;
		setLeftPointers(root.right);
	}
	
	/**
	 * 
	 * @param root
	 * @return
	 */
	public static Node<Integer> setRightPointers(Node<Integer> root){
		
		/**Traversing to right most node in tree*/
		while(null != root.right){
			root = root.right;
		}
		
		/**Iterating for right to left and setting forward pointers*/
		while(null != root && null != root.left){
			Node<Integer> left = root.left;
			left.right = root;
			root = root.left;
		}
			
		return root;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(10);
        root.left = new Node<Integer>(12);
        root.right = new Node<Integer>(15);
        root.left.left = new Node<Integer>(25);
        root.left.right = new Node<Integer>(30);
        root.right.left = new Node<Integer>(36);
        Node<Integer> head = convertToDLL(root);
        
        while(head != null){
        	System.out.print(head.data + " ");
        	head = head.right;
        }
	}
}
