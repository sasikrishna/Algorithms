package com.algorithms.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Problem statement: Given an array and a positive integer k, find the first negative integer for each and every window(contiguous subarray) of size k. If a window does not contain a negative integer, then print 0 for that window.
 * 
 * @author Sasi Jolla on 19-Jul-2018, 10:40:20 pm
 */
public class NegativeInteger {

	/**
	 * 
	 * Time complexity: O(n)
	 * Space complexity: O(n) -  for Queue
	 * 
	 * @param array
	 * @param k - window size
	 */
	public static void findFirstNegative(int[] array, int k){
		/**Queue to maintain negative element indexes*/
		Deque<Integer> queue = new LinkedList<>();
		
		int i;
		/**Iterating for first in window*/
		for(i = 0; i < k; i++){
			/**Adding element index to queue if it is negative*/
			if(array[i] < 0){
				queue.push(i);
			}
		}
		
		/**Iterating for rest of the windows*/
		for(;i < array.length; i++){
			/**Printing first negative element in last window*/
			System.out.print((queue.isEmpty() ? 0 : array[queue.peekLast()]) + ", ");
			
			/**Removing indexes which are out of current window range*/
			while(!queue.isEmpty() && queue.peekLast() <= (i - k)){
				queue.pollLast();
			}
			
			/**Adding element index to queue if it is negative*/
			if(array[i] < 0){
				queue.push(i);
			}
		}
		
		/**Printing first negative element in last window*/
		System.out.print((queue.isEmpty() ? 0 : array[queue.peekLast()]));
	}
	
	public static void main(String[] args) {
		findFirstNegative(new int[]{-8, 2, 3, -6, 10}, 2);
		System.out.println();
		findFirstNegative(new int[]{12, -1, -7, 8, -15, 30, 16, 28}, 3);
	}
}
