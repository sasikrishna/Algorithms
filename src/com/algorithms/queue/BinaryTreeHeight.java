package com.algorithms.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author Sasi on 19-Jul-2018, 12:56:36 am
 */
public class BinaryTreeHeight {

	/**
	 * 
	 * @param node
	 */
	public static int findHeight(Node node){
		
		if(node == null){
			return 0;
		}
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		
		int height = 0;
		while(!queue.isEmpty()){
			height++;
			
			int nodeCount = queue.size();
			while(nodeCount > 0){
				Node currentNode = queue.poll();
				if(currentNode.left != null){
					queue.add(currentNode.left);
				}
				if(currentNode.right != null){
					queue.add(currentNode.right);
				}
				nodeCount--;
			}
		}
		
		return height;
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);
        root.left.left.left = new Node(8);
        
        System.out.print("Height of binary tree is: " + findHeight(root));
	}
}
