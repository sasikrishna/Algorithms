package com.algorithms.binarytree.lca;

import java.util.ArrayList;
import java.util.List;

import com.algorithms.binarytree.traversals.Node;

/**
 * Problem statement: Given a binary tree (not a binary search tree) and two values say key1 and key2, write a program to find the least common ancestor.
 * 
 * @author Sasi Jolla on 30-Jul-2018, 8:15:17 pm
 */
public class LowestCommonAncestor1 {
	
	static List<Node<Integer>> key1Path = new ArrayList<Node<Integer>>();
	static List<Node<Integer>> key2Path = new ArrayList<Node<Integer>>();
	
	/**
	 * 
	 * Time complexity: O(n)
	 * Space complexity: O(n)
	 * 
	 * @param root
	 * @param key1
	 * @param key2
	 * @returns lowest common ancestor if exits else returns -1
	 */
	public static int findLCA(Node<Integer> root, int key1, int key2){
		
		key1Path.clear();
		key2Path.clear();
		
		if(!findKeyPath(root, key1, key1Path) || !findKeyPath(root, key2, key2Path)){
			return -1;
		}
		
		int i;
		for(i = 0; i < key1Path.size() && i < key2Path.size(); i++){
			/**Node just before the first mismatch will be lowest common ancestor*/
			if(!key1Path.get(i).equals(key2Path.get(i))){
				break;
			}
		}
		return key1Path.get(i - 1).data;
	}
	
	/**
	 * 
	 * @param root
	 * @param key
	 * @param path
	 * @return
	 */
	private static boolean findKeyPath(Node<Integer> root, int key, List<Node<Integer>> path){
		
		if(null == root){
			return false;
		}
		
		path.add(root);
		if (root.data == key) {
            return true;
        }
		
		if(null != root.left && findKeyPath(root.left, key, path)){
			return true;
		}
		if(null != root.right && findKeyPath(root.right, key, path)){
			return true;
		}
		
		path.remove(path.size() - 1);
		return false;
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
        System.out.println("LCA(4, 5): " + findLCA(root, 4, 5));
        System.out.println("LCA(4, 6): " + findLCA(root, 4, 6));
        System.out.println("LCA(3, 4): " + findLCA(root, 3, 4));
        System.out.println("LCA(2, 4): " + findLCA(root, 2, 4));
	}
}
