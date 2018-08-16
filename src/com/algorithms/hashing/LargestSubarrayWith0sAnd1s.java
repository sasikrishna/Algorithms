package com.algorithms.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem statement: Given an array containing only 0s and 1s, find the largest
 * subarray which contain equal no of 0s and 1s. Expected time complexity is
 * O(n).
 * 
 * @author Sasi Jolla on 15-Aug-2018, 6:22:32 pm
 */
public class LargestSubarrayWith0sAnd1s {

	/**
	 * The idea is to maintain a counter which will be incremented when current
	 * element is 1 else decremented by 1. Whenever sum appears as 0, we'll save
	 * current index in hashmap for reference.
	 * 
	 * @param array
	 * @return
	 */
	public static int findLargestSubarray(int array[]) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0, maxLength = 0, start = 0, end = 0;
		
		/**Converting all 0's to -1's to reduce problem to largest sumarray whose sum is 0 problem*/
		for(int i = 0; i < array.length; i++){
			if(array[i] == 0){
				array[i] = -1;
			}
		}

		for(int i = 0; i < array.length; i++){
			sum += array[i];
			
			if(sum == 0){
				maxLength = i + 1;
				start = 0;
				end = i;
			}
			
			Integer previous = map.get(sum);
			if(null == previous){
				map.put(sum, i);
			}else{
				maxLength = Math.max(maxLength, i - previous);
				
				/**Updating start if maxLength at current iteration is greater*/
				if(maxLength == i - previous){
					start = previous + 1;
					end = i;
				}
			}
		}
		System.out.println("Largest sub array starts at " + start + " and end at " + end);
		return maxLength;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int array[] = {1, 1, 1, 1, 1, 1, 0, 0};
		System.out.println(findLargestSubarray(array));
		
		array = new int[]{1, 0, 1, 1, 1, 0, 0};
		System.out.println(findLargestSubarray(array));
	}
}
