package com.algorithms.binarytree.summation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.algorithms.binarytree.traversals.Node;

/**
 * 
 * @author Sasi Jolla on 29-Jul-2018, 11:32:58 am
 */
public class DiagonalSum {
	
	/**
	 * 
	 * @param root
	 */
	public static void printDiagonalSum(Node<Integer> root){
		Map<Integer, List<Node<Integer>>> map = new HashMap<Integer, List<Node<Integer>>>();
		getDiagonalSum(root, 0, map);
		
		for(Entry<Integer, List<Node<Integer>>> entry : map.entrySet()){
			List<Node<Integer>> list = entry.getValue();
			int sum = 0;
			System.out.print("Diagonal sum of ");
			for(Node<Integer> node : list){
				System.out.print(node.data + " ");
				sum += node.data;
			}
			System.out.print(" is " + sum + "\n");
		}
	}
	
	/**
	 * 
	 * @param root
	 * @param level
	 */
	private static void getDiagonalSum(Node<Integer> root, int level, Map<Integer, List<Node<Integer>>> map){
		if(root == null){
			return;
		}
		
		if(map.containsKey(level)){
			map.get(level).add(root);
		}else{
			List<Node<Integer>> list = new ArrayList<Node<Integer>>();
			list.add(root);
			map.put(level, list);
		}
		
		getDiagonalSum(root.right, level, map);
		
		/**Increasing level as we are about to start traversing next diagonal*/
		getDiagonalSum(root.left, level + 1, map);
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(1);
	    root.left = new Node<Integer>(2);
	    root.right = new Node<Integer>(3);
	    root.left.left = new Node<Integer>(9);
	    root.left.right = new Node<Integer>(6);
	    root.right.left = new Node<Integer>(4);
	    root.right.right = new Node<Integer>(5);
	    root.right.left.left = new Node<Integer>(12);
	    root.right.left.right = new Node<Integer>(7);
	    root.left.right.left = new Node<Integer>(11);
	    root.left.left.right = new Node<Integer>(10);
	    printDiagonalSum(root);
	}
}
