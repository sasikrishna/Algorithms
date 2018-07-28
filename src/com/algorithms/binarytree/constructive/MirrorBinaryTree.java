package com.algorithms.binarytree.constructive;

import java.util.LinkedList;
import java.util.Queue;

import com.algorithms.binarytree.traversals.Node;

/**
 * Problem statement: Convert a Binary Tree into its Mirror Tree.
 * 
 * @author Sasi Jolla on 28-Jul-2018, 11:36:55 am
 */
public class MirrorBinaryTree {

	/**
	 * 
	 * @param root
	 */
	public static void createMirrorIteratively(Node<Integer> root){
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		queue.add(root);
		
		while(!queue.isEmpty()){
			Node<Integer> current = queue.poll();
			swapNodes(current);
			
			if(null != current.left){
				queue.add(current.left);
			}
			if(null != current.right){
				queue.add(current.right);
			}
		}
	}
	
	/**
	 * 
	 * @param root
	 */
	public static void createMirrorRecursively(Node<Integer> root){
		if(null == root){
			return;
		}
		
		createMirrorIteratively(root.left);
		createMirrorIteratively(root.right);
		swapNodes(root);
	}

	/**
	 * 
	 * @param root
	 */
	private static void swapNodes(Node<Integer> root){
		Node<Integer> temp = root.left;
		root.left = root.right;
		root.right = temp;
	}
	
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(1);
		root.left = new Node<Integer>(2);
		root.right = new Node<Integer>(3);
		root.right.left = new Node<Integer>(4);
		root.right.right = new Node<Integer>(5);
		root.right.left.left = new Node<Integer>(6);
		root.right.right.left = new Node<Integer>(7);
		root.right.right.right = new Node<Integer>(8);
		
		createMirrorIteratively(root);
		Node.preOrderTraversal(root);
		System.out.println();
		createMirrorRecursively(root);
		Node.preOrderTraversal(root);
	}
}
