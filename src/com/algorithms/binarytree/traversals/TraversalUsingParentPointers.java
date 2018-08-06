package com.algorithms.binarytree.traversals;

/**
 * Problem statement: Inorder non-threaded Binary Tree traversal without recursion or stack
 * 
 * @author Sasi Jolla on 06-Aug-2018, 11:07:57 am
 */
public class TraversalUsingParentPointers {

	/**
	 * 
	 * @param root
	 */
	public static void inorderTraversal(Node<Integer> root){
		Boolean isLeftDone = false;
		
		while(null != root){
			if(!isLeftDone){
				while(null != root.left){
					root = root.left;
				}
			}
			
			System.out.print(root.data + " ");
			isLeftDone = true;
			
			if(null != root.right){
				root = root.right;
				isLeftDone = false;
			}else if(null != root.parent){
				while(null != root.parent && root == root.parent.right){
					root = root.parent;
				}
				
				if(null == root.parent){
					break;
				}
				
				root = root.parent;
			}
		}
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(1);
		root.left = new Node<Integer>(root, 2);
		root.right = new Node<Integer>(root, 3);
		
		root.left.left = new Node<Integer>(root.left, 4);
		root.left.right = new Node<Integer>(root.left, 5);
		root.right.left = new Node<Integer>(root.right, 6);
		root.right.right = new Node<Integer>(root.right, 7);
		
		root.left.left.left = new Node<Integer>(root.left.left, 8);
		root.left.left.right = new Node<Integer>(root.left.left, 9);
		root.left.right.left = new Node<Integer>(root.left.right, 10);
		root.left.right.right = new Node<Integer>(root.left.right, 11);
		root.right.left.left = new Node<Integer>(root.right.left, 12);
		root.right.left.right = new Node<Integer>(root.right.left, 13);
		root.right.right.left = new Node<Integer>(root.right.right, 14);
		root.right.right.right = new Node<Integer>(root.right.right, 15);
        
		System.out.println("Inorder traversal is ");
        inorderTraversal(root);
	}
}
