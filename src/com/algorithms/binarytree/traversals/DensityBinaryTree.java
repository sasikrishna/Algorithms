package com.algorithms.binarytree.traversals;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem statement: Given a Binary Tree, find density of it by doing one traversal of it.
 * Density of Binary Tree = Size / Height 
 * 
 * @author Sasi Jolla on 26-Jul-2018, 12:02:34 am
 */
public class DensityBinaryTree {

	/**
	 * 
	 * @param root
	 */
	public static float findDensity(Node<Integer> root){
		/**Finding number of nodes in binary tree*/
		int size = findNodesCount(root);
		int height = findHeight(root);
		
		return (float) (size/(1.0 * height));
	}
	
	/**
	 * 
	 * @param root
	 * @return
	 */
	private static int findNodesCount(Node<Integer> root){
		
		if(null == root){
			return 0;
		}
		
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		queue.add(root);
		
		int count = 0;
		while(!queue.isEmpty()){
			Node<Integer> current = queue.poll();
			count++;
			
			if(null != current.left){
				queue.add(current.left);
			}
			if(null != current.right){
				queue.add(current.right);
			}
		}
		return count;
	}
	
	/**
	 * 
	 * @param root
	 * @return
	 */
	private static int findHeight(Node<Integer> root){
		if(null == root){
			return 0;
		}
		
		return Math.max(findHeight(root.left) + 1, findHeight(root.right) + 1);
	}
	
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(8);
        root.left = new Node<Integer>(3);
        root.right = new Node<Integer>(1);
        root.left.left = new Node<Integer>(10);
        System.out.println(findDensity(root));
	}
}
