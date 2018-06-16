package com.algorithms.hackerrank.ctci;

/**
 * Finding if given linked list has cycle or not. Returns true if there exists
 * cycle otherwise returns false.
 * 
 * 
 * @author Sasi Jolla on 13-Jun-2018, 9:09:03 pm
 */
public class CycleDetection {
	
	/**
	 * Implementing floyd-warshall's algorithm for detecting cycle 
	 * @param head
	 * @return
	 */
	static boolean hasCycle(Node head) {
		if (null == head) {
			return false;
		}

		if (head.next == head) {
			return true;
		}

		if (head.next.next == head) {
			return true;
		}

		Node tempHead = head.next.next;
		while (head != null && tempHead != null && tempHead.next != null) {
			if (head == tempHead) {
				return true;
			}

			head = head.next;
			tempHead = tempHead.next.next;
		}
		return false;
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next  = new Node(2);
		head.next.next  = new Node(3);
		head.next.next.next  = new Node(4);
		head.next.next.next.next = head;
		System.out.println("Cycle exists: " + hasCycle(head));
		
		head = new Node(1);
		head.next  = new Node(2);
		head.next.next  = new Node(3);
		head.next.next.next  = new Node(4);
		head.next.next.next.next = new Node(5);
		System.out.println("Cycle exists: " + hasCycle(head));
	}

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}
}
