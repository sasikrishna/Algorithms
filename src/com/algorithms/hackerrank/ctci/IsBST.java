package com.algorithms.hackerrank.ctci;

/**
 * Problem statement: 
 * 
 * @author Sasi Jolla on 12-Jun-2018, 12:26:02 am
 */
public class IsBST {

	public static boolean isBST(Node root, int min, int max){
		if(root == null){
			return true;
		}
		
		if(root.data < min || root.data > max){
			return false;
		}
		
		return isBST(root.left, Integer.MIN_VALUE, root.data) 
				&& isBST(root.right, root.data, Integer.MAX_VALUE);
	}
	
	public static void main(String[] args) {
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		System.out.println("Is binary search tree: " + isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		
		root.right = new Node(-1);
		System.out.println("Is binary search tree: " + isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}
	
	static class Node{
		int data;
		Node left;
		Node right;
		public Node(int data){
			this.data = data;
		}
	}
}
