package com.algorithms.binarytree;

/**
 * Problem statement: Given a binary tree, check whether it is a mirror of itself.
 * 
 * @author Sasi Jolla on 21-Jul-2018, 11:13:11 pm
 */
public class SymmetricTree {
	
	/**
	 * 
	 * @param root
	 * @return true if left and right subtrees are symmetrical
	 */
	public static Boolean isSymmetric(Node<Integer> root){
		return isSymmetric(root.left, root.right);
	}
	
	/**
	 * 
	 * @param left
	 * @param right
	 * @returns true if left and right subtrees are symmetrical
	 */
	private static Boolean isSymmetric(Node<Integer> left, Node<Integer> right){
		if(null == left && null == right){
			return true;
		}
		
		if(null == left || null == right){
			return false;
		}
		
		if(!left.equals(right)){
			return false;
		}
		
		return isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right); 
	}
	
	public static void main(String[] args) {
        Node<Integer> root = new Node<Integer>(1);
        root.left = new Node<Integer>(2);
        root.right = new Node<Integer>(2);
        root.left.left = new Node<Integer>(3);
        root.left.right = new Node<Integer>(4);
        root.right.left = new Node<Integer>(4);
        root.right.right = new Node<Integer>(3);
        System.out.println("Is symmetrical " + isSymmetric(root));
	}
}
