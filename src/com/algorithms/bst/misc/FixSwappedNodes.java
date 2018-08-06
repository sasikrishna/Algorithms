package com.algorithms.bst.misc;

import com.algorithms.binarytree.traversals.Node;

/**
 * Problem statement: Two of the nodes of a Binary Search Tree (BST) are swapped. Fix (or correct) the BST.
 * 
 * @author Sasi Jolla on 06-Aug-2018, 12:20:37 pm
 */
public class FixSwappedNodes {
	
	/**first object will contain first err node. Middle and last contains err nodes depending on scenario.*/
	static Node<Integer> first, middle, last;
	
	/**
	 * 
	 * @param root
	 */
	public static void fixErrNodes(Node<Integer> root){
		findErrNodes(root, null);
		fixErrNodes();
	}
	
	/**
	 * 
	 * @author sasi on 06-Aug-2018, 12:22:57 pm
	 */
	private static void fixErrNodes() {
		/**first and last nodes will not be null if err nodes aren't adjacent in inorder traversal*/
		if(null != first && null != last){
			int temp = first.data;
			first.data = last.data;
			last.data = temp;
		}else{
			
			/**This case exists when err nodes are adjacent in inorder traversal*/
			int temp = first.data;
			first.data = middle.data;
			middle.data = temp;
		}
	}
	
	/**
	 * 
	 * @param root
	 */
	private static void findErrNodes(Node<Integer> root, Node<Integer> prev) {
		
		if(null == root){
			return;
		}
		
		findErrNodes(root.left, prev);
		if(null != prev){
			
			/**Saving err nodes when root data is less than prev node data*/
			if(root.data < prev.data){
				if(first == null){
					first = prev;
					middle = root;
				}else{
					last = root;
				}
			}
		}
		prev = root;
		findErrNodes(root.right, prev);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(6);
        root.left = new Node<Integer>(10);
        root.right = new Node<Integer>(2);
        root.left.left = new Node<Integer>(1);
        root.left.right = new Node<Integer>(3);
        root.right.right = new Node<Integer>(12);
        root.right.left = new Node<Integer>(7);
        
        System.out.println("Inorder traversal with err nodes ");
        Node.inOrderTraversal(root);
        System.out.println();
        fixErrNodes(root);
        System.out.println("Inorder traversal with err fixed nodes ");
        Node.inOrderTraversal(root);
	}
}
