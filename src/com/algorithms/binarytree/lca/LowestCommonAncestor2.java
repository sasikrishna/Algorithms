package com.algorithms.binarytree.lca;

import com.algorithms.binarytree.traversals.Node;

/**
 * Problem statement: Given a binary tree (not a binary search tree) and two values say key1 and key2, write a program to find the least common ancestor.
 * 
 * @author Sasi Jolla on 30-Jul-2018, 11:27:22 pm
 */
public class LowestCommonAncestor2 {
	
	/**
	 * 
	 * Time complexity: O(n)
	 * Space complexity: O(1)
	 * 
	 * @param root
	 * @param key1
	 * @param key2
	 * @return
	 */
	public static Integer getLCA(Node<Integer> root, int key1, int key2){
		Node<Integer> lca = findLCA(root, key1, key2);
		return (lca == null) ? -1 : lca.data;
	}
	
	/**
	 * 
	 * @param root
	 * @param key1
	 * @param key2
	 * @return
	 */
	private static Node<Integer> findLCA(Node<Integer> root, int key1, int key2){
		
		if(null == root){
			return null;
		}
		
		if(root.data == key1 || root.data == key2){
			return root;
		}
		
		Node<Integer> leftLCA = findLCA(root.left, key1, key2);
		Node<Integer> rightLCA = findLCA(root.right, key1, key2);
		
		if(null != leftLCA && null != rightLCA){
			return root;
		}
		return (null != leftLCA) ? leftLCA : rightLCA;
	}

	/**
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
        System.out.println("LCA(4, 5): " + getLCA(root, 4, 5));
        System.out.println("LCA(4, 6): " + getLCA(root, 4, 6));
        System.out.println("LCA(3, 4): " + getLCA(root, 3, 4));
        System.out.println("LCA(2, 4): " + getLCA(root, 2, 4));
	}	
}
