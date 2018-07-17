package com.algorithms.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem statement: Implement Stack using Queues
 * 
 * Time complexity: O(1) for push, pop and peek<br>
 * Space complexity: O(n)
 * 
 * @author Sasi Jolla on 12-Jul-2018, 2:23:51 pm
 */
public class StackUsingTwoQueues {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(4);
		stack.push(3);
		System.out.println("Current top is " + stack.peek());
		
		stack.push(2);
		System.out.println("Current top is " + stack.peek());
		System.out.println("Popped " + stack.pop() + " from stack.");
		
		stack.push(1);
		System.out.println("Current top is " + stack.peek());
		System.out.println("Popped " + stack.pop() + " from stack.");
		System.out.println("Current top is " + stack.peek());
	}
}

/**
 * Stack class represents standard stack data structure implementation using two queues. Making push operation costly approach.
 * 
 * @author Sasi Jolla
 */
class Stack{

	Queue<Integer> queue1, queue2;
	public Stack(){
		queue1 = new LinkedList<Integer>();
		queue2 = new LinkedList<Integer>();
	}
	
	/**
	 * 
	 * @param element
	 */
	public void push(int element){
		/**Adding element to queue2*/
		queue2.add(element);
		
		/**Adding all elements from queue1 to queue2. This makes last added element as the one which will be popped first.*/
		int size = queue1.size();
		for(int i = 0; i < size; i++){
			queue2.add(queue1.poll());
		}
		
		/**Exchanging queue1 and queue2 elements*/
		Queue<Integer> tempQueue = queue1;
		queue1 = queue2;
		queue2 = tempQueue;
		System.out.println("Added " + element + " to stack.");
	}
	
	/**
	 * 
	 * @return
	 */
	public int pop(){
		return queue1.size() > 0 ? queue1.poll() : -1;
	}
	
	/**
	 * 
	 * @return
	 */
	public int peek(){
		return queue1.size() > 0 ? queue1.peek() : -1;
	}
}
