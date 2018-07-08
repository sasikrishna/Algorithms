package com.algorithms.linkedlist;

/**
 * Problem statement: Write a function to get the intersection point of two Linked Lists.
 * 
 * @author Sasi Jolla on 06-Jul-2018, 12:18:15 am
 */
public class IntersectionPoint {
	
	/**
	 * 1. Finding intersection by using extra boolean flag in each node.
	 *  
	 *  Time complexity: O(M + N), where M is length of first linked list and N is second's
	 *  Space complexity: O(1)
	 *  
	 * @param head1
	 * @param head2
	 * @return Intersecting node
	 */
	public static Node<Integer> findByVisitedProperty(Node<Integer> head1, Node<Integer> head2){
		while(head1 != null || head2 != null){
			if(null != head1){
				if(head1.isVisited){
					return head1;
				}
				head1.isVisited = true;
				head1 = head1.next;
			}
			
			if(null != head2){
				if(head2.isVisited){
					return head2;
				}
				head2.isVisited = true;
				head2 = head2.next;
			}
		}
		
		return null;
	}
	
	/**
	 * 2. Using length of each linked list.
	 * 
	 * Time complexity: O(M + N), where M is length of first linked list and N is second's
	 * Space complexity: O(1)
	 *  
	 * @param head1
	 * @param head2
	 * @return Intersecting node
	 */
	public static Node<Integer> findByCount(Node<Integer> head1, Node<Integer> head2){
		int head1Length = 0, head2Length = 0;
		
		Node<Integer> current = head1;
		while(current != null){
			current = current.next;
			head1Length++;
		}
		
		current = head2;
		while(current != null){
			current = current.next;
			head2Length++;
		}
		
		if(head1Length > head2Length){
			return findIntersection(head1, head2, head1Length - head2Length);
		}else{
			return findIntersection(head2, head1, head2Length - head1Length);
		}
	}
	
	/**
	 * Util method to find intersection
	 * 
	 * @param head1
	 * @param head2
	 * @return
	 */
	private static Node<Integer> findIntersection(Node<Integer> head1, Node<Integer> head2, int diff){
		
		int i = 0;
		while(i < diff){
			head1 = head1.next;
			i++;
		}
		
		while(head1 != null && head2 != null){
			if(head1.data == head2.data){
				return head1;
			}
			head1 = head1.next;
			head2 = head2.next;
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		//Creating first linked list
		Node<Integer> head1 = new Node<Integer>(3);
        head1.next = new Node<Integer>(3);
        head1.next.next = new Node<Integer>(6);
        head1.next.next.next = new Node<Integer>(9);
        Node<Integer> commonNode = new Node<Integer>(15);
        head1.next.next.next.next = commonNode;
        head1.next.next.next.next.next = new Node<Integer>(30);
 
        //Creating second linked list
        Node<Integer> head2 = new Node<Integer>(10);
        head2.next = commonNode;
        head2.next.next = new Node<Integer>(30);
        
        System.out.println("List1 and List2 are intersecting at " + findByVisitedProperty(head1, head2));
        System.out.println("List1 and List2 are intersecting at " + findByCount(head1, head2));
	}
}
