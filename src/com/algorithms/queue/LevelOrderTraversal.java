package com.algorithms.queue;

import java.util.Stack;



/**
 * Problem statement: Write a function to print spiral order traversal of a tree. For below tree, function should print 1, 2, 3, 4, 5, 6, 7.
 * 
 * @author Sasi Jolla on 18-Jul-2018, 5:51:52 pm
 */
public class LevelOrderTraversal {
	
	/**
	 * 
	 * @param root
	 */
	public static void printInSpiralForm(Node root){
		int treeHeight = getTreeHeight(root);
		boolean isLTR = false;
		for(int i = 1; i <= treeHeight; i++){
			printInSpiralForm(root, i, isLTR);
			isLTR = !isLTR;
		}
	}
	
	/**
	 * 
	 * @param root
	 */
	public static void printInSpiralFormUsingStack(Node root){
		/**Stores nodes to print from right to left*/
		Stack<Node> stack1 =  new Stack<>();
		stack1.add(root);
		
		/**Stores nodes to print from left to right*/
		Stack<Node> stack2 =  new Stack<>();
		
		while(!stack1.isEmpty() || !stack2.isEmpty()){
			while(!stack1.isEmpty()){
				Node top = stack1.pop();
				System.out.print(top.data + " ");
				if (top.right != null){
					stack2.push(top.right);
				}
				if (top.left != null){
					stack2.push(top.left);
				}
			}
			
			while(!stack2.isEmpty()){
				Node top = stack2.pop();
				System.out.print(top.data + " ");
				if (top.left != null){
					stack1.push(top.left);
				}
				if (top.right != null){
					stack1.push(top.right);
				}
			}
		}
	}
	
	/**
	 * 
	 * @param root
	 * @param level
	 * @param isLTR - boolean type expands isLeftToRight
	 */
	private static void printInSpiralForm(Node root, int level, boolean isLTR){
		if(null == root){
			return;
		}else if(level == 1){
			System.out.print(root.data + " ");
			return;
		}else{
			if(isLTR){
				printInSpiralForm(root.left, level - 1, isLTR);
				printInSpiralForm(root.right, level - 1, isLTR);
			}else{
				printInSpiralForm(root.right, level - 1, isLTR);
				printInSpiralForm(root.left, level - 1, isLTR);
			}
		}
	}
	
	/**
	 * 
	 * @param root
	 * @return
	 */
	private static int getTreeHeight(Node root){
		if(null == root){
			return 0;
		}else{
			int leftTreeHeight = getTreeHeight(root.left);
			int rightTreeHeight = getTreeHeight(root.right);
			if(leftTreeHeight > rightTreeHeight){
				return leftTreeHeight + 1;
			}else{
				return rightTreeHeight + 1;
			}
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);
        System.out.print("Spiral order traversal of binary tree is: ");
        printInSpiralForm(root);
        System.out.println();
        System.out.print("Spiral order traversal of binary tree is: ");
        printInSpiralFormUsingStack(root);
	}
}