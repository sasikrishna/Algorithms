package com.algorithms.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Problem statement: Given an array, for each element find the value of nearest element to the right which is having frequency greater than as that of current element. If there does not exist an answer for a position, then make the value ‘-1’.
 * 
 * @author Sasi Jolla on 14-Jul-2018, 1:12:01 pm
 */
public class NexGreaterFrequencyElement {

	/**
	 * 
	 * @param array
	 */
	public static void printNGFE(int[] array){
		
		Map<Integer, AtomicInteger> frequencies = new HashMap<Integer, AtomicInteger>();
		/**Finding frequencies of each element*/
		for(int i = 0; i < array.length; i++){
			if(!frequencies.containsKey(array[i])){
				frequencies.put(array[i], new AtomicInteger(0));
			}
			frequencies.get(array[i]).getAndIncrement();
		}
		
		/**Auxillary data structure to store the current element*/
		com.datastructures.linear.Stack<Integer> stack = new com.datastructures.linear.Stack<Integer>();
		stack.push(array[0]);
		
		for(int i = 1; i < array.length; i++){
			int ngfe = array[i];
			
			if(!stack.isEmpty()){
				int currentElement = stack.pop();
				
				/**Checking if index i frequency is greater than index at i - 1*/
				while(frequencies.get(currentElement).get() < frequencies.get(ngfe).get()){
					System.out.println(currentElement + "'s next greater frequency element is " + ngfe);
					if(stack.isEmpty()){
						break;
					}
					currentElement = stack.pop();
				}
				
				if(frequencies.get(ngfe).get() <= frequencies.get(currentElement).get() ||
						currentElement == ngfe){
					stack.push(currentElement);
				}
			}
			
			stack.push(ngfe);
		}
		
		/**Left over elements in stack have no NGFE printing -1 for them.*/
		while(!stack.isEmpty()){
			System.out.println(stack.pop() + "'s next greater element is " + -1);
		}
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		 int array[] = {1,1,2,3,4,2,4,3,3};
		 printNGFE(array);
	}
}
