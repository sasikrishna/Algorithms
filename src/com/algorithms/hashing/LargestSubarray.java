package com.algorithms.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem statement: Given an array of integers, find length of the largest
 * subarray with sum equals to 0.
 * 
 * @author Sasi Jolla on 13-Aug-2018, 11:16:11 pm
 */
public class LargestSubarray {

	/**
	 * The idea is to maintain a map with sum so far in the array and index of
	 * the current element. So when we same sum again in map then we their is
	 * subarray whose sum is zero.
	 * 
	 * @param array
	 * @returns max subarray length whose sum is 0
	 */
	public static int findLargestSubarrayLength(int array[]) {
		int maxLength = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int currentSum = 0;

		for (int i = 0; i < array.length; i++) {

			if (array[i] == 0 && maxLength == 0) {
				maxLength = 1;
				continue;
			}

			currentSum += array[i];
			if (currentSum == 0) {
				maxLength = i + 1;
			}

			Integer prevLength = map.get(currentSum);
			if (null == prevLength) {
				map.put(currentSum, i);
			}
			else {
				maxLength = Math.max(maxLength, i - prevLength);
			}
		}

		return maxLength;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int array[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
		System.out.println("Length of the longest 0 sum subarray is " + findLargestSubarrayLength(array));
	}
}
