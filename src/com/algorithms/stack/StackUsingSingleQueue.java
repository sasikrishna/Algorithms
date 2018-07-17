package com.algorithms.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem statement: Implement Stack using Queues
 * 
 * @author Sasi Jolla on 12-Jul-2018, 3:34:02 pm
 */
public class StackUsingSingleQueue {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Stack.push(4);
		Stack.push(3);
		System.out.println("Current top is " + Stack.peek());
		
		Stack.push(2);
		System.out.println("Current top is " + Stack.peek());
		System.out.println("Popped " + Stack.pop() + " from stack.");
		
		Stack.push(1);
		System.out.println("Current top is " + Stack.peek());
		System.out.println("Popped " + Stack.pop() + " from stack.");
		System.out.println("Current top is " + Stack.peek());
	}
	
	/**
	 * Stack class represents standard stack data structure implementation using two queues. Making push operation costly approach.
	 * 
	 * @author Sasi Jolla
	 */
	static class Stack{

		static Queue<Integer> queue = new LinkedList<Integer>();
		
		/**
		 * 
		 * @param element
		 */
		public static void push(int element){
			
			int size = queue.size();
			
			/**Adding element to queue*/
			queue.add(element);
			
			for(int i = 0; i < size; i++){
				queue.add(queue.poll());
			}
			
			System.out.println("Added " + element + " to stack.");
		}
		
		/**
		 * 
		 * @return
		 */
		public static int pop(){
			return queue.size() > 0 ? queue.poll() : -1;
		}
		
		/**
		 * 
		 * @return
		 */
		public static int peek(){
			return queue.size() > 0 ? queue.peek() : -1;
		}
	}
}
