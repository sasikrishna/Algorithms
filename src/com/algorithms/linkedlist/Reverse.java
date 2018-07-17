package com.algorithms.linkedlist;

/**
 * 
 * @author sasi jolla
 */
public class Reverse {

	static Node<Integer> head;
	public static Node<Integer> reverse(Node<Integer> node){
		
		if(node == null){
			return node;
		}
		
		if(node.next == null){
			head = node;
			return head;
		}
		
		Node<Integer> current = reverse(node.next);
		node.next = null;
		current.next = node;
		return node;
	}
	
	public static void main(String[] args) {
		head = new Node<Integer>(1);
		head.next = new Node<Integer>(2);
		head.next.next = new Node<Integer>(3);
		head.next.next.next = new Node<Integer>(4);
		head.next.next.next.next = new Node<Integer>(5);
		reverse(head);
		Node.print(head);
	}
}
