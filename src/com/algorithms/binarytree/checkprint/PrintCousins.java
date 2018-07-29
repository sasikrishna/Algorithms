package com.algorithms.binarytree.checkprint;

import com.algorithms.binarytree.traversals.Node;

/**
 * Problem statement: Given a binary tree and a node, print all cousins of given node. Note that siblings should not be printed.
 * 
 * @author Sasi Jolla on 28-Jul-2018, 9:50:34 pm
 */
public class PrintCousins {
	
	/**
	 * 
	 * @param root
	 * @param key
	 */
	public static void printCousins(Node<Integer> root, int key){
		int keyNodeHeight = getHeight(root, key, 1);
		printNodesAtLevel(root, key, keyNodeHeight);
	}
	
	/**
	 * 
	 * @param root
	 * @param key
	 * @param level
	 */
	private static int getHeight(Node<Integer> root, int key, int level){
		if(null == root){
			return 0;
		}
		
		if(root.data == key){
			return level;
		}
		
		int currentLevel = getHeight(root.left, key, level + 1);
		if(currentLevel != 0){
			return currentLevel;
		}
		
		return getHeight(root.right, key, level + 1);
	}
	
	/**
	 * 
	 * @param root
	 * @param level
	 */
	private static void printNodesAtLevel(Node<Integer> root, int key, int level){
		if(root == null || level < 2){
			return;
		}
		
		if(level == 2){
			if(root.left.data == key || root.right.data == key){
				return;
			}
			System.out.print(root.left.data + " ");
			System.out.print(root.right.data + " ");
		}else{
			printNodesAtLevel(root.left, key, level - 1);
			printNodesAtLevel(root.right, key, level - 1);
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
	    root.left.left = new Node<Integer>(4);
	    root.left.right = new Node<Integer>(5);
	    root.left.right.right = new Node<Integer>(15);
	    root.right.left = new Node<Integer>(6);
	    root.right.right = new Node<Integer>(7);
	    root.right.left.right = new Node<Integer>(8);
	    
	    printCousins(root, 5);
	}
}
