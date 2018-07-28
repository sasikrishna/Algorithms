package com.algorithms.binarytree.constructive;

import com.algorithms.binarytree.traversals.Node;

/**
 * Problem statement: Given an array that represents a tree in such a way that array indexes are values in tree nodes and array values give the parent node of that particular index (or node). The value of the root node index would always be -1 as there is no parent for root. Construct the standard linked representation of given Binary Tree from this given representation.
 * 
 * @author Sasi Jolla on 27-Jul-2018, 6:15:24 pm
 */
public class ConstructTreeFromArray {

	/**
	 * 
	 * @param array
	 * @return
	 */
	public static Node<Integer> constructTree(int[] array){
		Node<Integer>[] nodes = new Node[array.length];
		Node<Integer> root = null;
		
		for(int i = 0; i < array.length; i++){
			
			Node<Integer> node = null;
			
			/**Checking if node is already created*/
			if(null != nodes[i]){
				node = nodes[i];
			}
			else{
				/**Node creation*/
				node = new Node<Integer>(i);
				nodes[i] = node;
			}
			
			if(array[i] == -1){
				root = node;
				continue;
			}
			
			/**Checking if parent exists*/
			if(null == nodes[array[i]]){
				createParentNode(array, nodes, array[i]);
			}
			
			/**Connecting to parent*/
			Node<Integer> parent = nodes[array[i]];
			if(null == parent.left){
				parent.left = node;
			}else{
				parent.right = node;
			}
		}
		
		return root;
	}
	
	/**
	 * 
	 * @param array
	 * @param index
	 * @return 
	 * @return
	 */
	private static void createParentNode(int[] array, Node<Integer>[] nodes, int parentIndex){
		Node<Integer> node = new Node<Integer>(parentIndex);
		nodes[parentIndex] = node;
		
		/**-1 means current node is parent so no need to recur for its parent*/
		if(array[parentIndex] == -1){
			return;
		}
		
		if(null == nodes[array[parentIndex]]){
			createParentNode(array, nodes, array[parentIndex]);
		}
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Inorder traversal of constructed tree is: ");
		int parent[] = new int[]{-1, 0, 0, 1, 1, 3, 5};
		Node<Integer> root = constructTree(parent);
		Node.inOrderTraversal(root);
		
		System.out.println("\nInorder traversal of constructed tree is: ");
		parent = new int[]{1, 5, 5, 2, 2, -1, 3};
		root = constructTree(parent);
		Node.inOrderTraversal(root);
		
	}
}
