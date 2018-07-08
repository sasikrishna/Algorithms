package com.algorithms.linkedlist;

import java.util.Stack;


/**
 * Problem statement: Given a singly linked list of characters, write a function that returns true if the given list is palindrome, else false.
 * 
 * @author Sasi Jolla on 05-Jul-2018, 7:22:01 am
 */
public class LinkedListPalindrome {
	
	/**
	 *  
	 * Time complexity: O(n)
	 * Space complexity: O(n) for stack
	 * 
	 * @author sasi on 05-Jul-2018, 7:25:19 am
	 */
	public static boolean findUsingStack(Node<Character> head){
		Stack<Character> stack = new Stack<Character>();
		
		Node<Character> tempHead = head; 
		while(null != tempHead){
			stack.push(tempHead.data);
			tempHead = tempHead.next;
		}
		
		tempHead = head;
		while(null != tempHead){
			if(!stack.pop().equals(tempHead.data)){
				return false;
			}
			tempHead = tempHead.next;
		}
		
		return true;
	}
	
	/**
	 * 
	 * Time complexity: O(n)
	 * Space complexity: O(1)
	 * 
	 * @author sasi on 05-Jul-2018, 7:46:25 am
	 */
	public static boolean findUsingMid(Node<Character> head){
		Node<Character> tempHead = head, slowNode = head, previousSlow = null, midNode = null;
		
		while(null != tempHead && null != tempHead.next){
			previousSlow = slowNode;
			slowNode = slowNode.next;
			tempHead = tempHead.next.next;
		}
		
		//We have reached end of the linked list with above loop. If temp is null then we have even number of nodes.
		//So moving mid pointer to next node.
		if(null != tempHead){
			midNode = slowNode;
			slowNode = slowNode.next;
		}
		
		//Reversing the second half of linked list
		Node<Character> secondHalf = reverseList(slowNode);
		
		//Setting null to last node in first half.
		previousSlow.next = null;
		boolean isPalindrome = compareList(head, secondHalf);
		
		secondHalf = reverseList(secondHalf);
		
		if(null != midNode){
			previousSlow.next = midNode;
			midNode.next = secondHalf;
		}else{
			previousSlow.next = midNode;
		}
		
		return isPalindrome;
	}
	
	/**
	 * 
	 * @param head
	 * @param secondHalf
	 * @return
	 */
	private static boolean compareList(Node<Character> head, Node<Character> secondHalf) {
		while(head != null && secondHalf != null){
			if(!head.data.equals(secondHalf.data)){
				return false;
			}else{
				head = head.next;
				secondHalf = secondHalf.next;
			}
		}
		
		if(head == null && secondHalf == null){
			return true;
		}
		
		return false;
	}

	/**
	 * 
	 * @param head
	 * @return
	 */
	private static Node<Character> reverseList(Node<Character> head){
		Node<Character> prev = null;
		while(null != head){
			Node<Character> next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
	
	/**
	 * 
	 * Time complexity: O(n)
	 * Space complexity: O(n) if we consider call stack
	 * 
	 * @param head
	 * @param secondHalf
	 */
	static Node<Character> left = null;
	public static boolean findWithTwoPointers(Node<Character> right){
		
		if(left == null){
			left = right;
		}
		
		if(null == right){
			return true;
		}
		
		Boolean isPalin = findWithTwoPointers(right.next);
		if(!isPalin){
			return false;
		}
		
		isPalin = left.data.equals(right.data);
		left = left.next;
		return isPalin;
	}
	
	public static void main(String[] args) {
		Node<Character> head = new Node<Character>(new Character('R'));
		head.next = new Node<Character>(new Character('A'));
		head.next.next = new Node<Character>(new Character('D'));
		head.next.next.next = new Node<Character>(new Character('A'));
		head.next.next.next.next = new Node<Character>(new Character('R'));
		System.out.println("Is 'RADAR' palindrome? " + (findUsingStack(head) ? "Yes" : "No"));
		System.out.println("Is 'RADAR' palindrome? " + (findUsingMid(head) ? "Yes" : "No"));
		System.out.println("Is 'RADAR' palindrome? " + (findWithTwoPointers(head) ? "Yes" : "No"));
		
		head = new Node<Character>(new Character('R'));
		head.next = new Node<Character>(new Character('A'));
		head.next.next = new Node<Character>(new Character('D'));
		head.next.next.next = new Node<Character>(new Character('A'));
		System.out.println("Is 'RADA' palindrome? " + (findUsingStack(head) ? "Yes" : "No"));
		System.out.println("Is 'RADA' palindrome? " + (findUsingMid(head) ? "Yes" : "No"));
		System.out.println("Is 'RADA' palindrome? " + (findWithTwoPointers(head) ? "Yes" : "No"));
	}
}
