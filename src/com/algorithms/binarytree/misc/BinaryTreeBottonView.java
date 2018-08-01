package com.algorithms.binarytree.misc;

import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

import com.algorithms.binarytree.traversals.Node;

/**
 * Problem statement: Given a Binary Tree, we need to print the bottom view from left to right. A node x is there in output if x is the bottommost node at its horizontal distance. Horizontal distance of left child of a node x is equal to horizontal distance of x minus 1, and that of right child is horizontal distance of x plus 1.
 * 
 * @author Sasi Jolla on 01-Aug-2018, 11:43:42 pm
 */
public class BinaryTreeBottonView {
	
	/**
	 * 
	 * @param root
	 */
	public static void printBottomView(Node<Integer> root){
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		queue.add(root);
		root.hd = 0;
		
		while(!queue.isEmpty()){
			Node<Integer> current = queue.poll();
			map.put(current.hd, current.data);
			
			if(null != current.left){
				current.left.hd = current.hd - 1;
				queue.add(current.left);
			}
			if(null != current.right){
				current.right.hd = current.hd + 1;
				queue.add(current.right);
			}
		}
		
		Set<Entry<Integer, Integer>> entrySet = map.entrySet();
		for(Entry<Integer, Integer> entry : entrySet){
			System.out.print(entry.getValue() + " ");
		}
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(20);
        root.left = new Node<Integer>(8);
        root.right = new Node<Integer>(22);
        root.left.left = new Node<Integer>(5);
        root.left.right = new Node<Integer>(3);
        root.right.left = new Node<Integer>(4);
        root.right.right = new Node<Integer>(25);
        root.left.right.left = new Node<Integer>(10);
        root.left.right.right = new Node<Integer>(14);
        System.out.println("Bottom view of binary tree is ");
        printBottomView(root);
	}
}
