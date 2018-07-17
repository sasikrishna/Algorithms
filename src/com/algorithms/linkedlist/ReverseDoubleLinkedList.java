package com.algorithms.linkedlist;

/**
 * 
 * @author Sasi Jolla on 10-Jul-2018, 10:34:27 pm
 */
public class ReverseDoubleLinkedList {
	
	public static Node<Integer> reverseIteratively(Node<Integer> head){
		Node<Integer> prev = null, current = head;
		while(null != current){
			Node<Integer> next = current.next;
			current.prev = next;
			current.next = prev;
			prev = current;
			current = next;
		}
		Node.print(prev);
		return prev;
	}
	
	static Node<Integer> tempHead;
	public static Node<Integer> reverseReursively(Node<Integer> head){
		
		if(null == head){
			return head;
		}
		
		if(null == head.next){
			head.next = head.prev;
			tempHead = head;
			return tempHead;
		}
	
		Node<Integer> current = reverseReursively(head.next);
		head.next = head.prev;
		head.prev = current;
		
		return head;
	}
	
	public static void main(String[] args) {
		Node<Integer> head = new Node<Integer>(1);
		Node<Integer> node2 = new Node<Integer>(2);
		Node<Integer> node3 = new Node<Integer>(3);
		Node<Integer> node4 = new Node<Integer>(4);
		Node<Integer> node5 = new Node<Integer>(5);
		
		head.prev = null;
		head.next = node2;
		head.next.prev = head;
		head.next.next = node3;
		head.next.next.prev = node2;
		head.next.next.next = node4;
		head.next.next.next.prev = node3;
		head.next.next.next.next = node5;
		head.next.next.next.next.prev = node4;
		head.next.next.next.next.next = null;
		head = reverseIteratively(head);
		reverseReursively(head);
		System.out.println();
		Node.print(tempHead);
	}
}
