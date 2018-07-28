package com.algorithms.binarytree.constructive;

import com.algorithms.binarytree.traversals.Node;

/**
 * Problem statement: Given a string that contains ternary expressions. The expressions may be nested, task is convert the given ternary expression to a binary Tree.
 * 
 * @author Sasi Jolla on 28-Jul-2018, 2:27:55 pm
 */
public class ConvertTernaryToBinaryTree {

	/**
	 * 
	 * @param expression
	 */
	public static Node<Character> convertToBinary(String expression){
		return convertToBinary(expression, 0);
	}

	/**
	 * 
	 * @param expression
	 * @param index
	 */
	private static Node<Character> convertToBinary(String expression, int index){
		if(index >= expression.length()){
			return null;
		}
		
		Node<Character> root = new Node<Character>(expression.charAt(index++));
		/**Checking if next character is ?. If so then next char as left node to root.*/
		if(index < expression.length() && expression.charAt(index) == '?'){
			root.left = convertToBinary(expression, index + 1);
		}else{
			root.right = convertToBinary(expression, index + 1);
		}
		
		return root;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		 String expression = "a?b?c:d:e";
		 Node<Character> root = convertToBinary(expression);
		 Node.preOrderTraversal(root);
	}
}
