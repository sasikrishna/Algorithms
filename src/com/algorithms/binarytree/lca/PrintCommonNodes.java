package com.algorithms.binarytree.lca;

import com.algorithms.binarytree.traversals.Node;


/**
 * Problem statement: Print common nodes on path from root (or common ancestors)
 * 
 * @author Sasi Jolla on 30-Jul-2018, 11:49:56 pm
 */
public class PrintCommonNodes {
	
	/**
	 * 
	 * @param root
	 * @param key1
	 * @param key2
	 */
	public static void printCommonNodes(Node<Integer> root, int key1, int key2) {
		Node<Integer> lca = getLCA(root, key1, key2);
		printPathFromNode(root, lca);
	}
	
	/**
	 * 
	 * @param root
	 * @param target
	 */
	private static boolean printPathFromNode(Node<Integer> root, Node<Integer> target){
		if(null == root){
			return false;
		}
		
		if(root.equals(target)){
			System.out.print(root.data + " ");
			return true;
		}
		
		if(printPathFromNode(root.left, target) 
				|| printPathFromNode(root.right, target)){
			System.out.print(root.data + " ");
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @param root
	 * @param key1
	 * @param key2
	 */
	private static Node<Integer> getLCA(Node<Integer> root, int key1, int key2){
		if(root == null){
			return null;
		}
		
		if(root.data == key1 || root.data == key2){
			return root;
		}
		
		Node<Integer> leftLCA = getLCA(root.left, key1, key2);
		Node<Integer> rightLCA = getLCA(root.right, key1, key2);
		
		if(null != leftLCA && null != rightLCA){
			return root;
		}
		return (leftLCA == null) ? rightLCA : leftLCA;
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
        root.right.left = new Node<Integer>(6);
        root.right.right = new Node<Integer>(7);
        root.left.left.left = new Node<Integer>(8);
        root.right.left.left = new Node<Integer>(9);
        root.right.left.right = new Node<Integer>(10);
        
        System.out.println("Common nodes between 9 and 7 are: ");
        printCommonNodes(root, 9, 7);
	}
}
