package com.algorithms.binarytree.constructive;

import com.algorithms.binarytree.traversals.Node;

/**
 * 
 * @author Sasi Jolla on 28-Jul-2018, 10:41:12 am
 */
public class ConvertBinaryToDownRightTree {

	/**
	 * 
	 * @param root
	 */
	public static void convertToDownRightTree(Node<Integer> root){
		
		if(null == root){
			return;
		}
		
		convertToDownRightTree(root.left);
		convertToDownRightTree(root.right);
		
		if(null == root.left){
			root.left = root.right;
		}else{
			root.left.right = root.right;
		}
		
		root.right = null;
	}

	/**
	 * 
	 * @param root
	 */
	public static void printDownRightTree(Node<Integer> root){
		if(null != root){
			System.out.print(root.data + " ");
			printDownRightTree(root.right);
			printDownRightTree(root.left);
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
		root.right.left = new Node<Integer>(4);
		root.right.right = new Node<Integer>(5);
		root.right.left.left = new Node<Integer>(6);
		root.right.right.left = new Node<Integer>(7);
		root.right.right.right = new Node<Integer>(8);
		convertToDownRightTree(root);
		printDownRightTree(root);
	}
}
