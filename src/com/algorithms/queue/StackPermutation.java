package com.algorithms.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Problem statement: A stack permutation is a permutation of objects in the given input queue which is done by transferring elements from input queue to the output queue with the help of a stack and the built-in push and pop functions.
 * 
 * @author Sasi Jolla on 20-Jul-2018, 12:19:26 am
 */
public class StackPermutation {

	/**
	 * 
	 * @param queue1
	 * @param queue2
	 * @returns true if queue1 can be converted to queue2 with the help of a temp stack
	 */
	public static boolean isPermutationPossible(int[] queue1, int[] queue2){
		Queue<Integer> inputQueue = new LinkedList<Integer>();
		Queue<Integer> outputQueue = new LinkedList<Integer>();
		
		for(Integer integer : queue1){
			inputQueue.add(integer);
		}
		
		for(Integer integer : queue2){
			outputQueue.add(integer);
		}
		
		Stack<Integer> stack = new Stack<>();
		while(!inputQueue.isEmpty()){
			
			int front = inputQueue.poll();
			if(front == outputQueue.peek()){
				outputQueue.poll();
				while(!stack.isEmpty()){
					if(stack.peek() == outputQueue.peek()){
						stack.pop();
						outputQueue.poll();
					}else{
						break;
					}
				}
			}else{
				stack.push(front);
			}
		}
		
		return inputQueue.isEmpty() && stack.isEmpty();
	}
	
	public static void main(String[] args) {
	    int queue1[] = {1, 2, 3};
	    int queue2[] = {2, 1, 3};
	    System.out.println(isPermutationPossible(queue1, queue2));
	    
	    queue1 = new int[]{1, 2, 3};
	    queue2 = new int[]{3, 1, 2};
	    System.out.println(isPermutationPossible(queue1, queue2));
	}
}
