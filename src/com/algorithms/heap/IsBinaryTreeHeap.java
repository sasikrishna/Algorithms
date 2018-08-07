package com.algorithms.heap;

import java.util.LinkedList;
import java.util.Queue;

import com.algorithms.binarytree.traversals.Node;

/**
 * Problem statement: Check if a given Binary Tree is Heap
 * 
 * @author Sasi Jolla on 06-Aug-2018, 11:05:48 pm
 */
public class IsBinaryTreeHeap {
	
	/**
	 * 
	 * @param root
	 * @return
	 */
	public static Boolean isBinaryTreeHeap(Node<Integer> root){
		return isCompleteTree(root) && isHeap(root);
	}
	
	/**
	 * 
	 * @param root
	 * @return
	 */
	private static Boolean isCompleteTree(Node<Integer> root){
		
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		queue.add(root);
		
		Boolean leafNodeLevelStarted = false;
		while(!queue.isEmpty()){
			Node<Integer> current = queue.poll();
			
			if(null != current.left){
				if(leafNodeLevelStarted){
					return false;
				}
				queue.add(current.left);
			}else{
				leafNodeLevelStarted = true;
			}
			if(null != current.right){
				if(leafNodeLevelStarted){
					return false;
				}
				queue.add(current.right);
			}else{
				leafNodeLevelStarted = true;
			}
		}
		
		return leafNodeLevelStarted;
	}
	
	/**
	 * 
	 * @param root
	 * @return
	 */
	private static Boolean isHeap(Node<Integer> root){
		/**Base case*/
		if(null == root || (null == root.left && null == root.right)){
			return true;
		}
		
		/**Returning true if leaf node found*//*
		if(null == root.left && null == root.right){
			return true;
		}*/
		
        if(root.right == null)
        {
            return root.data >= root.left.data;
        }
        
		Boolean leftTree = isHeap(root.left);
		Boolean rightTree = isHeap(root.right);
		
		return (leftTree && rightTree) && (root.data >= root.left.data  
				&& root.data >= root.right.data);
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(10);
        root.left = new Node<Integer>(9);
        root.right = new Node<Integer>(8);
        root.left.left = new Node<Integer>(7);
        root.left.right = new Node<Integer>(6);
        root.right.left = new Node<Integer>(5);
        root.right.right = new Node<Integer>(4);
        root.left.left.left = new Node<Integer>(3);
        root.left.left.right = new Node<Integer>(2);
        root.left.right.left = new Node<Integer>(1);
        System.out.println("Is given tree is max heap? " + (isBinaryTreeHeap(root) ? "Yes" : "No"));
	}
}
