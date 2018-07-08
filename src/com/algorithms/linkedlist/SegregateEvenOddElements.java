package com.algorithms.linkedlist;

/**
 * Problem statement: Segregate even and odd nodes in a Linked List
 * Time complexity: O(n)
 * 
 * @author Sasi Jolla on 07-Jul-2018, 1:46:10 pm
 */
public class SegregateEvenOddElements {

	/**
	 * 
	 * @param head
	 */
	public static void sortElements(Node<Integer> head){
		int count = 0;
		Node<Integer> lastNode = head;
		while(null != lastNode.next){
			lastNode = lastNode.next;
			count++;
		}
		
		Node<Integer> current = head, prev = null;
		while(count >= 0){
			Node<Integer> newLastNode = current;
			current = current.next;
			
			//Odd numbered node then moving to end of linked list
			if(newLastNode.data % 2 == 1){
				
				if(prev == null){
					head = head.next;
				}else{
					prev.next = current;
				}
				
				//Updating new last node
				lastNode.next = newLastNode;
				lastNode = lastNode.next;
				lastNode.next = null;
			}else{
				prev = newLastNode;
			}
			
			count--;
		}
		
		//Printing all node values
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
		sortElements(head);
	}
}
