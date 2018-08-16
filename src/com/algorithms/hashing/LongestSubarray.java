package com.algorithms.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem statement: Given an arr[] containing n integers and a positive
 * integer k. The problem is to find the length of the longest subarray with sum
 * of the elements divisible by the given value k.
 * 
 * @author Sasi Jolla on 13-Aug-2018, 1:03:27 am
 */
public class LongestSubarray {

	/**
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	public static int length(int array[], int k) {
		Map<Integer, Integer> modMap = new HashMap<Integer, Integer>();

		int maxLength = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
			int mod = sum % k, length = 0;

			if (mod == 0) {
				length = i + 1;
			}
			else if (modMap.containsKey(mod) == false) {
				modMap.put(mod, i);
			}
			else {
				length = i - modMap.get(mod);
			}

			maxLength = Math.max(maxLength, length);
		}

		return maxLength;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int array[] = { 2, 7, 6, 1, 4, 5 };
		int k = 3;
		System.out.println("Longest subarray divisible by " + k + " is " + length(array, k));

	}
}
