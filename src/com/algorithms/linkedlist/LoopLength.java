package com.algorithms.linkedlist;

/**
 * Problem statement: Finding length of loop in single linked list. Return -1 if loop doesn't exists.
 * 
 * @author Sasi Jolla on 04-Jul-2018, 11:12:04 pm
 */
public class LoopLength {

	/**
	 * 
	 * @param head
	 */
	public static int findLoopLength(Node<Integer> head){
		Node<Integer> loopNode = detectLoop(head);
		
		if(null == loopNode){
			return -1;
		}
		
		Node<Integer> loopNodeCopy = loopNode;
		int loopLength = 1;
		while(loopNode.next != loopNodeCopy){
			loopLength++;
			loopNode = loopNode.next;
		}
		return loopLength;
	}
	
	/**
	 * Floyd-Warshall algorithm implementation for detecting loop in linked list.
	 * 
	 * @param head
	 * @return
	 */
	private static Node<Integer> detectLoop(Node<Integer> head){
		
		if(null == head){
			return head;
		}
		
		Node<Integer> slow = head, fast = head.next;
		while(null != slow && null != fast && slow.next != null &&
				fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast){
				return slow;
			}
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		Node<Integer> head = new Node<Integer>(1);
		Node<Integer> second = new Node<Integer>(2);
		head.next = second;
		
		head.next.next = new Node<Integer>(3);
		head.next.next.next = new Node<Integer>(4);
		head.next.next.next.next = new Node<Integer>(5);
		
		//Setting loop. Pointing last node to second node
		head.next.next.next.next.next = second;
		
		System.out.println("Length of loop in linked list is " + findLoopLength(head));
	}
}
