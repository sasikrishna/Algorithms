package com.algorithms.binarytree.checkprint;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.algorithms.binarytree.traversals.Node;

/**
 * Problem statement: Find ancestors of given node in a Binary Tree
 * 
 * @author Sasi Jolla on 11-Aug-2018, 10:46:45 am
 */
public class Ancestors {

	/**
	 * The idea is to maintain a map where each key, value pair represents node
	 * and its parent. Once we found given node we'll iterate map and print
	 * ancestors.
	 * 
	 * @param root
	 */
	public static void findAcestors(Node<Integer> root, Integer key) {
		if (null == root) {
			return;
		}

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Stack<Node<Integer>> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			Node<Integer> current = stack.pop();
			if (null != current.right) {
				stack.push(current.right);
				map.put(current.right.data, current.data);
			}
			if (null != current.left) {
				stack.push(current.left);
				map.put(current.left.data, current.data);
			}
		}

		if (!map.containsKey(key)) {
			return;
		}

		while (null != key) {
			
			if(null == map.get(key)){
				break;
			}
			
			System.out.print(map.get(key) + " ");
			key = map.get(key);
		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(26);
		root.left = new Node<Integer>(10);
		root.right = new Node<Integer>(3);
		root.left.left = new Node<Integer>(4);
		root.left.right = new Node<Integer>(6);
		root.right.right = new Node<Integer>(7);
		
		System.out.print("Ancestors of node 3 are ");
		findAcestors(root, 7);
	}
}
