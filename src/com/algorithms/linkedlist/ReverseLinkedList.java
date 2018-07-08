package com.algorithms.linkedlist;

/**
 * Problem statement: Given pointer to the head node of a linked list, the task is to reverse the linked list. We need to reverse the list by changing links between nodes.
 * Time Complexity: O(n)
 * 
 * @author Sasi Jolla on 07-Jul-2018, 2:42:35 pm
 */
public class ReverseLinkedList {
	
	static Node<Integer> head = null;
	
	/**
	 * 
	 * @param head
	 */
	public static Node<Integer> reverse(Node<Integer> head){
		Node<Integer> prev = null, next = null;
		while(null != head){
			next = head.next;
			head.next = prev;
			prev= head;
			head = next;
		}
		head = prev;
		return head;
	}
	
	public static void print(Node<Integer> head){
		while(null != head){
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
	
	/**
	 * 
	 * @param head
	 */
	public static void reverseRecursively(Node<Integer> current){
		
		if(null == current){
			return;
		}
		
		if(null == current.next){
			head = current;
			return;
		}
		
		reverseRecursively(current.next);
		current.next.next = current;
		current.next = null;
	}
	
	public static void main(String[] args) {
		head = new Node<Integer>(1);
		head.next = new Node<Integer>(2);
		head.next.next = new Node<Integer>(3);
		head.next.next.next = new Node<Integer>(4);
		head.next.next.next.next = new Node<Integer>(5);
		head.next.next.next.next.next = new Node<Integer>(7);
		head.next.next.next.next.next.next = new Node<Integer>(8);
		
		head = reverse(head);
		print(head);
		
		System.out.println();
		
		reverseRecursively(head);
		print(head);
	}
}
