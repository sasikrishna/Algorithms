package com.algorithms.linkedlist;

/**
 * Problem statement: Move all occurrences of an element to end in a linked list
 * 
 * @author Sasi Jolla on 08-Jul-2018, 6:45:16 pm
 */
public class MoveOccurences {

	/**
	 * The idea is to find the keyNode with given key and swapping them its value with current node whose job is just traverse the linked list.
	 * So at any given point of time keyNode is same as currentNode or stays behind the currentNode.<br>
	 *  
	 *  Time complexity: O(n)<br>
	 *  Space complexity: O(1)
	 * @param head
	 */
	public static void moveOccurences(Node<Integer> head, int key){
		Node<Integer> currentNode = head, keyNode = head;
		
		/**Traversing linked list one at each node*/
		while(null != currentNode){
			/**currentNode and keyNode should always be same. If not then we found a key which needs to be moved to end of linked list.*/
			if(currentNode.data != keyNode.data && currentNode.data != key){
				
				/**Swapping currentNode data with keyNode data*/
				keyNode.data = currentNode.data;
				currentNode.data = key;
				
				/**Moving keyNode to next position*/
				keyNode = keyNode.next;
			}
			
			if(keyNode.data != key){
				keyNode = keyNode.next;
			}
			
			/**Moving currentNode to next position*/
			currentNode = currentNode.next;
		}
		
		Node.print(head);
	}
	
	public static void main(String[] args) {
		Node<Integer> head = new Node<Integer>(1);
		head.next = new Node<Integer>(2);
		head.next.next = new Node<Integer>(2);
		head.next.next.next = new Node<Integer>(4);
		head.next.next.next.next = new Node<Integer>(5);
		head.next.next.next.next.next = new Node<Integer>(6);
		head.next.next.next.next.next.next = new Node<Integer>(7);
		moveOccurences(head, 2);
	}
}
