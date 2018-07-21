package com.algorithms.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Problem statement: Given an array of both positive and negative integers, the task is to compute sum of minimum and maximum elements of all sub-array of size k.
 * 
 * @author Sasi Jolla on 19-Jul-2018, 7:24:39 pm
 */
public class SumOfMinMax {
	
	/**
	 * 
	 * Time complexity: O(n)
	 * Space complexity: O(n)
	 * 
	 * @param array
	 * @param k - sub array size
	 * @return sum of min and max elements in every sub array of size k
	 */
	public static int findSumOfMinMax(int[] array, int k){
		/**Queue to maintain greater element indexes*/
		Deque<Integer> greaterQ = new LinkedList<>();
		
		/**Queue to maintain smaller element indexes*/
		Deque<Integer> smallerQ = new LinkedList<>();
		
		int i = 0;
		/**Iterating for first window*/
		for(; i < k; i++){
			/**Dequeuing index if queue rare index is greater than current element index*/
			while(!smallerQ.isEmpty() && array[smallerQ.peekLast()] >= array[i]){
				smallerQ.pollLast();
			}
			
			/**Dequeuing index if queue rare index is less than current element index*/
			while(!greaterQ.isEmpty() && array[greaterQ.peekLast()] <= array[i]){
				greaterQ.pollLast();
			}
			
			smallerQ.push(i);
			greaterQ.push(i);
		}
		
		int sum = 0;
		/**Iterating for rest of windows*/
		for(;i < array.length; i++){
			/**Calculating sum for every window*/
			sum += array[smallerQ.peekLast()] + array[greaterQ.peekLast()];
			
			/**Removing indexes which are out of current window*/
			while(!smallerQ.isEmpty() && smallerQ.peekLast() <= i - k){
				smallerQ.pollLast();
			}
			/**Removing indexes which are out of current window.*/
			while(!greaterQ.isEmpty() && greaterQ.peekLast() <= i - k){
				greaterQ.pollLast();
			}
			
			while(!smallerQ.isEmpty() && array[smallerQ.peekLast()] >= array[i]){
				smallerQ.pollLast();
			}
			while(!greaterQ.isEmpty() && array[greaterQ.peekLast()] <= array[i]){
				greaterQ.pollLast();
			}
			smallerQ.push(i);
			greaterQ.push(i);
		}
		
		/**Calculating sum for last window*/
		sum += array[smallerQ.peekLast()] + array[greaterQ.peekLast()];
		
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(findSumOfMinMax(new int[]{2, 5, -1, 7, -3, -1, -2}, 4));
	}
}
