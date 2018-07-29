package com.algorithms.binarytree.summation;

import com.algorithms.binarytree.traversals.Node;

/**
 * Problem statement: Given a Binary Tree, find the maximum sum path from a leaf to root. 
 * 
 * @author Sasi Jolla on 29-Jul-2018, 4:01:04 pm
 */
public class MaximumSumPathWithPath{
	
	static int maxSum = 0;
	static Node<Integer> maxLeafNode;
	
	/**
	 * 
	 * @param node
	 */
	public static void printMaximumSumPath(Node<Integer> root){
		printMaximumSumPath(root, 0);
		System.out.println("Maximum sum is " + maxSum + " and path is ");
		printPathToNode(root, maxLeafNode);
	}
	
	/**
	 * 
	 * @param root
	 * @param keyNode
	 * @return
	 */
	private static boolean printPathToNode(Node<Integer> root, Node<Integer> keyNode){
		if(null == root){
			return false;
		}
		
		if(root.equals(keyNode) || printPathToNode(root.left, keyNode) || 
				printPathToNode(root.right, keyNode)){
			System.out.print(root.data + " ");
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @param root
	 * @param sum
	 */
	private static void printMaximumSumPath(Node<Integer> root, int sum){
		if(null == root){
			return;
		}
		
		int curremtSum =  sum + root.data;
		printMaximumSumPath(root.left, curremtSum);
		printMaximumSumPath(root.right,curremtSum);
		
		/***/
		if(root.left == null && root.right == null){

			if(maxSum < curremtSum){
				maxLeafNode = root;
				maxSum = curremtSum;
			}
		}
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(10);
		root.left = new Node<Integer>(-2);
		root.right = new Node<Integer>(7);
		root.left.left = new Node<Integer>(8);
		root.left.right = new Node<Integer>(-4);
		printMaximumSumPath(root);
		//System.out.println("Following are the nodes " + "on maximum sum path");
	}
}
