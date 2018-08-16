package com.algorithms.hashing;

/**
 * Problem statement: Given an array of distinct integers, find length of the
 * longest subarray which contains numbers that can be arranged in a continuous
 * sequence.
 * 
 * @author Sasi Jolla on 15-Aug-2018, 2:04:36 pm
 */
public class LargestContiguousSubarray {

	/**
	 * The idea is to maintain min and max element in current window and
	 * comparing their difference with indices difference. Maximum indices
	 * difference is the expected result.
	 * 
	 * <br>Time complexity: o(n ^ 2)
	 * 
	 * @param array
	 * @return max contiguous subarray length
	 */
	public static int findMaxLength(int array[]) {
		int maxLength = 1;
		for (int i = 0; i < array.length - 1; i++) {
			int minEle = array[i], maxEle = array[i];
			for (int j = i + 1; j < array.length; j++) {
				minEle = Math.min(minEle, array[j]);
				maxEle = Math.max(maxEle, array[j]);

				if (maxEle - minEle == j - i) {
					maxLength = Math.max(maxLength, j - i);
				}
			}
		}
		return maxLength;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = {10, 12, 12, 10, 10, 11, 10};
		System.out.println("Length of the longest contiguous subarray is " + findMaxLength(arr));
	}
}
