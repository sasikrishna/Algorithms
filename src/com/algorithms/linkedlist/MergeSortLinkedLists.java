package com.algorithms.linkedlist;

/**
 * Problem statement: Merging linked lists using merge sort algorithm.
 * 
 * @author Sasi Jolla on 07-Jul-2018, 8:00:15 pm
 */
public class MergeSortLinkedLists {
	
	/**
	 * 
	 * @param head
	 * @return
	 */
	public static Node<Integer> mergeSort(Node<Integer> head){
		
		//Base case
		if(null == head || null == head.next){
			return head;
		}
		
		/**Getting middle node*/
		Node<Integer> midNode = getMidNode(head);
		Node<Integer> midNodeNext = midNode.next;
		midNode.next = null;
		
		/**Sorting first half of linked list*/
		Node<Integer> firstListHead = mergeSort(head);
		
		/**Sorting second half of linked list*/
		Node<Integer> secondListHead = mergeSort(midNodeNext);
		
		return sortedMerge(firstListHead, secondListHead);
	}
	
	/**
	 * 
	 * @param firstHalf
	 * @param secondHalf
	 * @return
	 */
	private static Node<Integer> sortedMerge(Node<Integer> head1, Node<Integer> head2) {
		
		/**Base cases */
		if(null == head1){
			return head2;
		}
		if(null == head2){
			return head1;
		}
		
		Node<Integer> head = null;
		if(head1.data < head2.data){
			head = head1;
			head.next = sortedMerge(head1.next, head2);
		}else{
			head = head2;
			head.next = sortedMerge(head1, head2.next);
		}
		return head;
	}
	
	/**
	 * 
	 * @param head
	 * @return
	 */
	private static Node<Integer> getMidNode(Node<Integer> head){
		
		//Base case
		if(null == head){
			return head;
		}
		
		/** Advance fastPtr by two nodes and slowPtr by one node. When fastPtr reaches end slowPtr will be mid point in linked list.*/
		Node<Integer> slowPtr = head, fastPtr = head.next;
		while(null !=  fastPtr){
			fastPtr = fastPtr.next;
			if(null != fastPtr){
				fastPtr = fastPtr.next;
				slowPtr = slowPtr.next;
			}
		}
		return slowPtr;
	}
	
	public static void main(String[] args) {
		Node<Integer> head = new Node<Integer>(1);
		head.next = new Node<Integer>(2);
		head.next.next = new Node<Integer>(3);
		head.next.next.next = new Node<Integer>(4);
		head.next.next.next.next = new Node<Integer>(5);
		head.next.next.next.next.next = new Node<Integer>(7);
		head.next.next.next.next.next.next = new Node<Integer>(8);
		head = mergeSort(head);
		
		while(null != head){
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
}
