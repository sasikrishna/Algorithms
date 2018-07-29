package com.algorithms.binarytree.checkprint;


import com.algorithms.binarytree.traversals.Node;


/**
 * Problem statement: Given a Binary Tree, find if there exist edge whose removal creates two trees of equal size.
 * 
 * @author Sasi Jolla on 28-Jul-2018, 7:31:49 pm
 */
public class DivideBinaryTree {

	static Boolean isDividable = false;
	/**
	 * 
	 * @param root
	 * @return
	 */
	public static void isBinaryTreeDividable(Node<Integer> root){
		isBinaryTreeDividable(root, getTotalNodes(root));
	}
	
	/**
	 * 
	 * @param root
	 * @param totalNodes
	 * @param isDividable
	 * @return
	 */
	private static int isBinaryTreeDividable(Node<Integer> root, int totalNodes){
		if(null == root){
			return 0;
		}
		
		int nodesCount = 1 + isBinaryTreeDividable(root.left, totalNodes) 
					+ isBinaryTreeDividable(root.right, totalNodes);
		
		if(nodesCount == (totalNodes - nodesCount)){
			isDividable = true;
		}
		
		return nodesCount;
	}
	
	/**
	 * 
	 * @param root
	 * @return total number of nodes in binary tree
	 */
	private static int getTotalNodes(Node<Integer> root){
		if(null == root){
			return 0;
		}
		return 1 + getTotalNodes(root.left) + getTotalNodes(root.right);
	}
	
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(5);
        root.left = new Node<Integer>(1);
        root.right = new Node<Integer>(6);
        root.left.left = new Node<Integer>(3);
        root.right.left = new Node<Integer>(7);
        root.right.right = new Node<Integer>(4);
        isBinaryTreeDividable(root);
        
        System.out.println("Binary tree can be divide into two trees of equal size: " + (isDividable ? "Yes" : "No"));
	}
}
