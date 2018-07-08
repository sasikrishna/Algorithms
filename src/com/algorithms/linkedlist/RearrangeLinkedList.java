package com.algorithms.linkedlist;

/**
 * Problem statement: Given a singly linked list L0 -> L1 -> … -> Ln-1 -> Ln. Rearrange the nodes in the list so that the new formed list is : L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2
 * 
 * @author Sasi Jolla on 08-Jul-2018, 3:01:02 pm
 */
public class RearrangeLinkedList {
	
	/**
	 * The idea is to split the list into two halves and reverse and second half. Merging both the lists yields the required arrangement.
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * 
	 * @param head
	 */
	public static void rearrange(Node<Integer> head){
		
		Node<Integer> current = head;
		
		/**Finding middle node to divide list into two halves*/
		Node<Integer> mid = getMidNode(current);
		Node<Integer> secondHalf = mid.next;
		/**Breaking chain from mid node so we'll end up with two lists*/
		mid.next = null;
		
		/**Reversing the second half*/
		secondHalf = reverse(secondHalf);
		
		/**Merging first and reversed second half to get the required arrangement*/
		while(null != current){
			Node<Integer> currentNext = current.next;
			Node<Integer> secondHalfNext = (secondHalf == null) ? null : secondHalf.next;
			current.next = secondHalf;
			
			if(null != secondHalf){
				secondHalf.next = currentNext;
			}
			
			secondHalf = secondHalfNext;
			current = currentNext;
		}
		
		while(null != head){
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
	
	/**
	 * Util method to get the mid node in linked list.
	 * 
	 * @param head
	 * @return
	 */
	private static Node<Integer> getMidNode(Node<Integer> head){
		Node<Integer> slowPtr = head, fastPtr = head;
		while(null != fastPtr && null != fastPtr.next){
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		return slowPtr;
	}
	
	/**
	 * util method to reverse the linked list.
	 * 
	 * @param head
	 * @return
	 */
	private static Node<Integer> reverse(Node<Integer> head){
		Node<Integer> prev =  null;
		while(null != head){
			Node<Integer> next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
	
	public static void main(String[] args) {
		Node<Integer> head = new Node<Integer>(1);
		head.next = new Node<Integer>(2);
		head.next.next = new Node<Integer>(3);
		head.next.next.next = new Node<Integer>(4);
		head.next.next.next.next = new Node<Integer>(5);
		head.next.next.next.next.next = new Node<Integer>(7);
		head.next.next.next.next.next.next = new Node<Integer>(8);
		
		rearrange(head);
	}
}
