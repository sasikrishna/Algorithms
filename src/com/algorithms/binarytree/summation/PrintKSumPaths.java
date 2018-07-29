package com.algorithms.binarytree.summation;

import java.util.ArrayList;
import java.util.List;

import com.algorithms.binarytree.traversals.Node;

/**
 * 
 * @author Sasi Jolla on 29-Jul-2018, 6:05:38 pm
 */
public class PrintKSumPaths {
	
	static List<Node<Integer>> path = new ArrayList<Node<Integer>>();
	
	/**
	 * 
	 * @param root
	 * @param sum
	 */
	public static void printKSumPaths(Node<Integer> root, int sum){
		if(null == root){
			return;
		}
		
		path.add(root);
		printKSumPaths(root.left, sum);
		printKSumPaths(root.right, sum);
		
		int currentSum = 0;
		for(int i = (path.size() - 1); i >= 0; i--){
			currentSum += path.get(i).data;
			
			if(currentSum == sum){
				printPath(i);
			}
		}
		
		path.remove(path.size() - 1);
	}
	
	/**
	 * 
	 * @param start
	 */
	private static void printPath(int start){
		for(int i = start; i < path.size(); i++){
			System.out.print(path.get(i).data + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(1);
	    root.left = new Node<Integer>(3);
	    root.left.left = new Node<Integer>(2);
	    root.left.right = new Node<Integer>(1);
	    root.left.right.left = new Node<Integer>(1);
	    root.right = new Node<Integer>(-1);
	    root.right.left = new Node<Integer>(4);
	    root.right.left.left = new Node<Integer>(1);
	    root.right.left.right = new Node<Integer>(2);
	    root.right.right = new Node<Integer>(5);
	    root.right.right.right = new Node<Integer>(2);
	    printKSumPaths(root, 5);
	}
}
