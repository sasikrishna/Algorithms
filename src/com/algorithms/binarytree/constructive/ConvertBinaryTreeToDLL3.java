package com.algorithms.binarytree.constructive;

import com.algorithms.binarytree.traversals.Node;

/**
 * 
 * @author Sasi Jolla on 28-Jul-2018, 1:27:00 am
 */
public class ConvertBinaryTreeToDLL3 {
	static Node<Integer> head, prev;
	
	/**
	 * 
	 * @param root
	 */
	public static void convertToDLL(Node<Integer> root){
		if(null == root){
			return;
		}
		
		convertToDLL(root.left);
		if(null == prev){
			head = root;
		}else{
			root.left = prev;
			prev.right = root;
		}
		
		prev = root;
		convertToDLL(root.right);
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
         convertToDLL(root);
        
        while(head != null){
        	System.out.print(head.data + " ");
        	head = head.right;
        }
	}
}
