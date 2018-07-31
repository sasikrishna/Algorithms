package com.algorithms.binarytree.misc;

import com.algorithms.binarytree.traversals.Node;

/**
 * 
 * @author Sasi Jolla on 01-Aug-2018, 1:09:18 am
 */
public class BinaryTreeDiameter {

	static int height = 0;
	
	/**
	 * 
	 * @param root
	 */
	public static void findDiameter(Node<Integer> root){
		height = Integer.MIN_VALUE;
		getDiameter(root);
	}
	
	/**
	 * 
	 * @param root
	 * @param diameter
	 * @return
	 */
	private static int getDiameter(Node<Integer> root) {
		if(null == root){
			return 0;
		}
		
		int leftHeight = getDiameter(root.left);
		int rightHeight = getDiameter(root.right);
		
		if(height < (1 + leftHeight + rightHeight)){
			System.out.print(root.data + " ");
		}
		
		height = Math.max(height, 1 + leftHeight + rightHeight);
		
		return 1 + Math.max(leftHeight, rightHeight);
	}

	public static void main(String[] args) {
        Node<Integer> root = new Node<Integer>(1);
        root.left = new Node<Integer>(2);
        root.right = new Node<Integer>(3);
        root.left.left = new Node<Integer>(4);
        root.left.right = new Node<Integer>(5);
        findDiameter(root);
        System.out.println("Diameter is " + height);
	}
}
