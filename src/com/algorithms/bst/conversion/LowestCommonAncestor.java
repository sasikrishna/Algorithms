package com.algorithms.bst.conversion;

import com.algorithms.binarytree.traversals.Node;

/**
 * Problem statement: Given values of two values n1 and n2 in a Binary Search Tree, find the Lowest Common Ancestor (LCA). You may assume that both the values exist in the tree.
 * 
 * @author Sasi Jolla on 05-Aug-2018, 5:07:57 pm
 */
public class LowestCommonAncestor { 

	/**
	 * 
	 * @return
	 */
	public static Integer findLCA(Node<Integer> root, int key1, int key2){
		
		while(null != root){
			if(root.data > key1 && root.data > key2){
				root = root.left;
			}else if(root.data < key1 && root.data < key2){
				root = root.right;
			}else{
				break;
			}
		}
		
		if(checkIfKeyExists(root, key1) && checkIfKeyExists(root, key2)){
			return root.data;
		}
		return null;
	}

	/**
	 * 
	 * @param root
	 * @param key2
	 * @return
	 */
	private static boolean checkIfKeyExists(Node<Integer> root, int key) {
		
		if(null == root.data){
			return false;
		}
		
		if(root.data == key){
			return true;
		}
		
		if(root.data > key){
			return checkIfKeyExists(root.left, key);
		}else{
			return checkIfKeyExists(root.right, key);
		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(20);
        root.left = new Node<Integer>(8);
        root.right = new Node<Integer>(22);
        root.left.left = new Node<Integer>(4);
        root.left.right = new Node<Integer>(12);
        root.left.right.left = new Node<Integer>(10);
        root.left.right.right = new Node<Integer>(14);
        
        System.out.println("Lowest common ancestor of given BST is " + findLCA(root, 10, 14));
	}
}
