package com.algorithms.linkedlist;

import java.util.Stack;

/**
 * Problem statement: Given a linked list, write a function to reverse every k nodes (where k is an input to the function).
 * 
 * @author Sasi Jolla on 07-Jul-2018, 5:11:55 pm
 */
public class ReverseListInGroup {
	
	/**
	 * reverse method reverses the first elements equals to given size and recursively calls itself to reverse rest of the linked list.
	 * It returns head of every sub linked list.
	 * 
	 * Time complexity: O(n)
	 * Space complexity: O(1) 
	 */
	public static Node<Integer> reverse(Node<Integer> head, int size){
		Node<Integer> current = head;
		Node<Integer> prev = null;
		Node<Integer> next = null;
		int count = 0;
		while(count < size && null != current){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}
		
		/** Next is now a pointer to (size + 1) node. Recursively calling to arrange rest of list.*/
		if(null != next){
			head.next = reverse(next, size);
		}
		
		return prev;
	}
	
	/**
	 * This is another approach to reverse nodes using stack.
	 * 
	 * Time complexity: O(n)
	 * Space complexity: O(n) for stack storing nodes 
	 */
	public static Node<Integer> reverseWithStack(Node<Integer> head, int size){
		
		Node<Integer> current = head, prev = null;
		while(null != current){
			int count = 0;
			Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
			while(count < size && null != current){
				/**Storing first group of nodes in stack*/
				stack.push(current);
				current = current.next;
				count++;
			}
			
			/**Popping stack and adding back nodes to list*/
			while(stack.size() > 0){
				if(null == prev){
					head = stack.pop();
					prev = head; 
				}else{
					prev.next = stack.pop();
					prev = prev.next;
				}
			}
		}
		
		return head;
	}
	
	/**
	 * Util method to print all nodes in linked list.
	 *  
	 * @param head
	 */
	public static void print(Node<Integer> head){
		while(null != head){
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
	
	public static void main(String[] args) {
		Node<Integer> head = new Node<Integer>(1);
		head.next = new Node<Integer>(2);
		head.next.next = new Node<Integer>(3);
		head.next.next.next = new Node<Integer>(4);
		head.next.next.next.next = new Node<Integer>(5);
		head.next.next.next.next.next = new Node<Integer>(7);
		head.next.next.next.next.next.next = new Node<Integer>(8);
		
		head = reverse(head, 3);
		print(head);
		System.out.println();
		head = reverseWithStack(head, 3);
		print(head);
	}
}
