package com.algorithms.linkedlist;

/**
 * Problem statement: Insertion Sort for Singly Linked List
 * 
 * @author Sasi Jolla on 08-Jul-2018, 11:50:10 am
 */
public class InsertionSortForLinkedLists {

	static Node<Integer> head, sortedList;
	/**
	 * 
	 * @param head
	 */
	public static void sort(){
		Node<Integer> current = head;
		/**Traversing through linked list and inserting each node into new sorted list*/
		while(null != current){
			Node<Integer> nextNode = current.next;
			sortInsertion(current);
			current = nextNode;
		}
	}
	
	/**
	 * 
	 * @param newNode
	 */
	private static void sortInsertion(Node<Integer> newNode){
		
		/**Checking if head is greater than  new node. If so adding new node at first place and making it new head.*/
		if(sortedList == null || sortedList.data > newNode.data){
			newNode.next = sortedList;
			sortedList = newNode;
		}else{
			Node<Integer> current = sortedList;
			
			/**Traverse through list untill we find correct position for new node.*/
			while(null != current.next && current.next.data < newNode.data){
				current = current.next;
			}
			
			newNode.next = current.next;
			current.next = newNode;
		}
	}
	
	/**
	 * 
	 */
	private static void print(){
		Node<Integer> head = sortedList;
		while(null != head){
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
	
	public static void main(String[] args) {
		head = new Node<Integer>(5);
		head.next = new Node<Integer>(4);
		head.next.next = new Node<Integer>(3);
		head.next.next.next = new Node<Integer>(2);
		head.next.next.next.next = new Node<Integer>(1);
		sort();
		print();
	}
}
