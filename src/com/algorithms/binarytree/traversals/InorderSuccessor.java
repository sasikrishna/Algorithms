package com.algorithms.binarytree.traversals;

/**
 * 
 * @author Sasi Jolla on 11-Aug-2018, 4:56:48 pm
 */
public class InorderSuccessor {
	
	private static Node<Integer> prev= null;
	/**
	 * 
	 * @param root
	 * @param key
	 */
	public static void findInorderSuccessor(Node<Integer> root, Integer key){
		if(null == root){
			return;
		}
		
		findInorderSuccessor(root.left, key);
		if(null != prev && prev.data == key){
			System.out.println("Inorder successor of " + prev.data + " is " + root.data);
		}
		prev = root;
		findInorderSuccessor(root.right, key);
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(10);
        root.left = new Node<Integer>(11);
        root.left.right = new Node<Integer>(14);
        root.left.left = new Node<Integer>(7);
        root.right = new Node<Integer>(9);
        root.right.left = new Node<Integer>(15);
        root.right.right = new Node<Integer>(8);
        
        findInorderSuccessor(root, 14);
        findInorderSuccessor(root, 9);
        findInorderSuccessor(root, 15);
	}
}
