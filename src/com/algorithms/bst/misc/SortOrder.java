package com.algorithms.bst.misc;

/**
 * Problem statement: Given an array that stores a complete Binary Search Tree, write a function that efficiently prints the given array in ascending order.
 * 
 * @author Sasi Jolla on 06-Aug-2018, 11:41:48 am
 */
public class SortOrder {
	
	/**
	 * 
	 * @param tree
	 */
	public void printSortOrder(int[] tree){
		printSortOrder(tree, 0, tree.length - 1);
	}
	
	/**
	 * Since given tree is complete BST it holds below properties.
	 * <br>1. Left child in array will be at position - 2 * i + 1
	 * <br>2. Right child in array will be at position - 2 * i + 2
	 * <br>where i is index of current/parent node
	 * 
	 * @param tree
	 * @param start
	 * @param end
	 */
	private void printSortOrder(int[] tree, int start, int end){
		
		/**Base case*/
		if(start > end){
			return;
		}
		
		printSortOrder(tree, 2* start + 1, end);
		System.out.print(tree[start] + " ");
		printSortOrder(tree, 2* start + 2, end);
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int completeTree[] = {4, 2, 5, 1, 3};
		new SortOrder().printSortOrder(completeTree);
	}
}
