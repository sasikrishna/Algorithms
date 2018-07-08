package com.algorithms.linkedlist;

/**
 * Problem statement: Given K sorted linked lists of size N each, merge them and print the sorted output.
 * 
 * @author Sasi Jolla on 08-Jul-2018, 7:36:46 pm
 */
public class MergedKSortLinkedLists {
	
	/**
	 * The idea is to merge left and right most linked lists and place the result list at left list position.
	 * We'll apply this on all pairs of linked lists in the array until we end up with one linked list.<br>
	 * 
	 * Time complexity: O(nk Logk)
	 * 
	 * @param arrays of linked lists
	 * @return merged linked list
	 */
	public static Node<Integer> merge(Node<Integer> heads[]){
		int length = heads.length - 1;
		
		while(length > 0){
			int i = 0, j = length;

			/**Traversing through all pairs of linked lists. A pair is formed by considering left and right most lists.*/
			while(i < j){
				/**Merging left list and right most list and placing it in left list position.*/
				heads[i] = mergeSort(heads[i], heads[j]);
				
				/**Increasing i & reducing j indexes to get next pair */
				i++;j--;
				
				if(i >= j){
					length = j;
				}
			}
		}
		
		return heads[0];
	}
	
	/**
	 * Mergesort algorithm sort method to merge two linked lists.
	 * 
	 * @param head1
	 * @param head2
	 * @return merged result linked list
	 */
	private static Node<Integer> mergeSort(Node<Integer> head1, Node<Integer> head2){
		
		if(null == head1){
			return head2;
		}
		if(null == head2){
			return head1;
		}
		
		Node<Integer> result = null;
		if(head1.data < head2.data){
			result = head1;
			result.next = mergeSort(head1.next, head2);
		}else{
			result = head2;
			result.next = mergeSort(head1, head2.next);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		Node<Integer> heads[] = new Node[3];
		
		Node<Integer> head = new Node<Integer>(1);
		head.next = new Node<Integer>(3);
		head.next.next = new Node<Integer>(5);
		head.next.next.next = new Node<Integer>(7);
		heads[0] = head;
		
		head = new Node<Integer>(8);
		head.next = new Node<Integer>(13);
		head.next.next = new Node<Integer>(21);
		head.next.next.next = new Node<Integer>(32);
		heads[1] = head;
		
		head = new Node<Integer>(42);
		head.next = new Node<Integer>(92);
		head.next.next = new Node<Integer>(97);
		head.next.next.next = new Node<Integer>(99);
		heads[2] = head;
		
		Node.print(merge(heads));
	}
}
