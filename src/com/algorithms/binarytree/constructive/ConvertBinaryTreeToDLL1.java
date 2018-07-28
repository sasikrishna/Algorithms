package com.algorithms.binarytree.constructive;

import com.algorithms.binarytree.traversals.Node;

/**
 * 
 * @author Sasi Jolla on 27-Jul-2018, 11:13:28 pm
 */
public class ConvertBinaryTreeToDLL1 {
	
	/**
	 * 
	 * @param root
	 * @return
	 */
	public static Node<Integer> convertToDLL(Node<Integer> root) {
		Node<Integer> head = convertToDLLUtil(root);
		
		while(null != head.left){
			head = head.left;
		}
		
		return head;
	}
	
	/**
	 * 
	 * @param root
	 * @return
	 */
	private static Node<Integer> convertToDLLUtil(Node<Integer> root) {
		if(null == root){
			return root;
		}
		
		if(null != root.left){
			Node<Integer> left = convertToDLLUtil(root.left);
			
			/**Finding inorder predecessor for root*/
			for(; left.right != null; left = left.right);
			
			/**Making root as next to predecessor*/
			left.right = root;
			
			/**Making predecessor as prev to root*/
			root.left = left;
		}
		if(null != root.right){
			Node<Integer> right = convertToDLLUtil(root.right);
			
			/**Finding inorder successor for root*/
			for(; right.left != null; right = right.left);
			
			/**Making inorder successor as next to root*/
			root.right = right;
			
			/**Making root as prev to inorder successor*/
			right.left = root;
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
