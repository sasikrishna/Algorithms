package com.algorithms.binarytree.traversals;

/**
 * Problem statement: Morris traversal for Preorder
 * 
 * @author Sasi Jolla on 23-Jul-2018, 11:51:55 pm
 */
public class MorrisPreorderTraversal {
	
	/**
	 * Time complexity: O(n)
	 * Space complexity: O(1)
	 * 
	 * @param root
	 */
	public static void preorderTraversal(Node<Integer> root){
		Node<Integer> current = root;
		while(null != current){
			
			if(null == current.left){
				System.out.print(current.data + " ");
				current = current.right;
			}else{
				Node<Integer> predecessor = current.left;
				while(null != predecessor.right && !predecessor.right.equals(current)){
					predecessor = predecessor.right;
				}
				
				if(null == predecessor.right){
					System.out.print(current.data + " ");
					predecessor.right = current.right;
					current = current.left;
				}else{
					current = predecessor.right;
					predecessor.right = null;
				}
			}
		}
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
		root.left.left.right = new Node<Integer>(9);
		root.left.right.left = new Node<Integer>(10);
		root.left.right.right = new Node<Integer>(11);
		root.right.left.left = new Node<Integer>(12);
		root.right.left.right = new Node<Integer>(13);
		root.right.right.left = new Node<Integer>(14);
		root.right.right.right = new Node<Integer>(15);
		System.out.println("Preorder traversal using Morris traversal is ");
		preorderTraversal(root);
	}
}
