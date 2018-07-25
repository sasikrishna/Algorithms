package com.algorithms.binarytree.traversals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Problem statement: Given a Binary Tree, print all diagonal elements in a binary tree belonging to same line.
 * 
 * @author Sasi Jolla on 25-Jul-2018, 1:57:54 am
 */
public class DiagonalTraversal {
	
	/**
	 * 
	 * @param root
	 */
	public static void printDiagonally(Node<Integer> root){
		Map<Integer, List<Node<Integer>>> map = new HashMap<Integer,List<Node<Integer>>>();
		printDiagonally(root, 0, map);
		for(Entry<Integer, List<Node<Integer>>> entry : map.entrySet()){
			List<Node<Integer>> list = entry.getValue();
			for(Node<Integer> node : list){
				System.out.print(node.data + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * 
	 * @param root
	 * @param level
	 * @param map
	 */
	private static void printDiagonally(Node<Integer> root, int level, Map<Integer, List<Node<Integer>>> map){
		if(null == root){
			return;
		}
		
		List<Node<Integer>> list = map.get(level);
		if(null == list){
			list = new ArrayList<>();
			list.add(root);
		}else{
			list.add(root);
		}
		
		map.put(level, list);
		
		/**Recurring for left subtree*/
		printDiagonally(root.left, level + 1, map);
		
		/**Recurring for right subtree which falls into same diagonal so not increasing level*/
		printDiagonally(root.right, level, map);
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(8);
        root.left = new Node<Integer>(3);
        root.right = new Node<Integer>(10);
        root.left.left = new Node<Integer>(1);
        root.left.right = new Node<Integer>(6);
        root.right.right = new Node<Integer>(14);
        root.right.right.left = new Node<Integer>(13);
        root.left.right.left = new Node<Integer>(4);
        root.left.right.right = new Node<Integer>(7);
        printDiagonally(root);
	}
}
