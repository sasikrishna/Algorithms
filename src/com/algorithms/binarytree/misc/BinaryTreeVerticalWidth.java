package com.algorithms.binarytree.misc;

import java.util.LinkedList;
import java.util.List;

import com.algorithms.binarytree.traversals.Node;

/**
 * 
 * @author Sasi Jolla on 01-Aug-2018, 10:28:40 pm
 */
public class BinaryTreeVerticalWidth {

	/**
	 * 
	 * @param root
	 * @returns vertical width of binary tree
	 */
	public static int getVerticalWidth(Node<Integer> root){
		List<Integer> list = new LinkedList<Integer>();
		getVerticalWidth(root, 0, list);
		return list.size();
	}
	
	/**
	 * 
	 * @param root
	 * @param columnNumber
	 * @param list
	 */
	private static void getVerticalWidth(Node<Integer> root, int columnNumber, List<Integer> list){
		if(null == root){
			return;
		}
		
		if(!list.contains(columnNumber)){
			list.add(columnNumber);
		}
		
		/**Decreasing width by 1 if tree have left child*/
		getVerticalWidth(root.left, columnNumber - 1, list);
		
		/**Increasing width by 1 if tree have left child*/
		getVerticalWidth(root.right, columnNumber + 1, list);
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(7);
	    root.left = new Node<Integer>(6);
	    root.right = new Node<Integer>(5);
	    root.left.left = new Node<Integer>(4);
	    root.left.right = new Node<Integer>(3);
	    root.right.left = new Node<Integer>(2);
	    root.right.right = new Node<Integer>(1);
	    System.out.println("Vertical width is " + getVerticalWidth(root));
	}
}
