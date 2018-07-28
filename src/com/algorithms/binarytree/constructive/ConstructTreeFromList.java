package com.algorithms.binarytree.constructive;

import java.util.LinkedList;
import java.util.Queue;

import com.algorithms.binarytree.traversals.Node;

/**
 * Problem statement: Given Linked List Representation of Complete Binary Tree, construct the Binary tree. A complete binary tree can be represented in an array in the following approach.
 * 
 * @author Sasi Jolla on 27-Jul-2018, 12:08:39 am
 */
public class ConstructTreeFromList {

	/**
	 * 
	 * @param list
	 */
	public static Node<Integer> constructTree(LinkedList<Integer> list){
		Node<Integer> root = new Node<Integer>(list.pollFirst());
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		queue.add(root);
		
		while(list.size() > 0){
			Node<Integer> currentRoot = queue.poll();
			
			currentRoot.left = new Node<Integer>(list.pollFirst());
			queue.add(currentRoot.left);
			
			if(list.size() > 0){
				currentRoot.right = new Node<Integer>(list.pollFirst());
				queue.add(currentRoot.right);
			}
		}
		
		return root;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>(){
			private static final long serialVersionUID = -1014683771390509005L;

		{
			add(10);
			add(12);
			add(15);
			add(25);
			add(30);
			add(36);
		}};
		
		Node<Integer> root = constructTree(list);
		Node.preOrderTraversal(root);
	}
}
