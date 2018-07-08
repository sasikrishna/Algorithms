package com.algorithms.linkedlist;

/**
 * Problem statement: Clone a linked list with next and random pointer in O(1) space
 *  
 * @author Sasi Jolla on 08-Jul-2018, 9:41:17 am
 */
public class CloneLinkedList {
	
	/**
	 * The idea is to create copy of each node in the given list and insert right after parent one. 
	 * We'll end up with list like 1 -> 1 -> 2 -> 2 -> 3 -> 3.....<br>
	 * After this, copy arbitrary nodes to duplicate node from parent node and divide the list into two. 
	 * 
	 * @param head
	 * @return
	 */
	public static Node<Integer> clone(Node<Integer> head){
		
		/**Creating each node with current original node and adding right beside to original node */
		Node<Integer> original = head;
		while(null != original){
			Node<Integer> next = original.next;
			original.next = new Node<Integer>(original.data);
			original.next.next = next;
			original = next; 
		}
		
		/**Copying arbitrary nodes from original to cloned list */
		original = head;
		while(null != original){
			original.next.arbitary = original.arbitary;
			
			if(null != original.next){
				original = original.next.next;
			}else{
				original = original.next;
			}
		}
		
		print(head);
		
		/**Dividing original list into two lists */
		original = head;
		Node<Integer> clone = head.next, cloneTemp = clone;
		while(null != original && null != clone){
			//System.out.println(clone.data);
			original.next = (original.next != null) ? original.next.next : original.next;
			clone.next = (clone.next != null) ? clone.next.next : clone.next;
			
			original = original.next;
			clone = clone.next;
		}
		
		return cloneTemp;
	}
	
	public static void main(String[] args) {
		Node<Integer> head = new Node<Integer>(1);
		head.next = new Node<Integer>(2);
		head.next.next = new Node<Integer>(3);
		head.next.next.next = new Node<Integer>(4);
		head.next.next.next.next = new Node<Integer>(5);
		
		/**Setting 2 as arbitrary to node 1 */
		head.arbitary = head.next;
		
		/**Setting 5 as arbitrary to node 2 */
		head.next.arbitary = head.next.next.next.next;
		
		/**Setting 4 as arbitrary to node 3 */
		head.next.next.arbitary = head.next.next.next;
		
		/**Setting 3 as arbitrary to node 4 */
		head.next.next.next.arbitary = head.next.next;
		
		/**Setting 1 as arbitrary to node 5 */
		head.next.next.next.next.arbitary = head;
		print(head);
		System.out.println();
		Node<Integer> clonedList = clone(head);
		print(clonedList);
	}
	
	private static void print(Node<Integer> head){
		while(null != head){
			System.out.print("next = " + head.data + " arbitrary = " + head.arbitary.data);
			System.out.println();
			head = head.next;
		}
	}
}
