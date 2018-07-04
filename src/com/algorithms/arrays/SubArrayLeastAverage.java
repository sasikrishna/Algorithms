package com.algorithms.arrays;

import java.util.Arrays;

/**
 * Problem statement: Find the subarray with least average. Given an array arr[] of size n and integer k such that k <= n.
 * <br>
 * Input:  arr[] = {3, 7, 90, 20, 10, 50, 40}, k = 3
 * <br>
 * Output:  Subarray between indexes 3 and 5
 * 
 * @author Sasi Jolla on 28-Jun-2018, 12:13:02 am
 */
public class SubArrayLeastAverage {

	public static int findLeastAverage(int array[], int subArraySize) {
		int leastSum = 0, index = 0;

		for (int i = 0; i < subArraySize; i++) {
			leastSum += array[i];
		}
		
		int currentSum = leastSum;
		for (int i = subArraySize; i < array.length; i++) {

			currentSum = (currentSum - array[i - subArraySize]) + array[i];
			leastSum = Math.min(leastSum, currentSum);
			index = i - subArraySize; 
		}
		
		System.out.println("Sub array between indexes " + index + " and " + (index + subArraySize - 1));
		return (leastSum / subArraySize);
	}

	public static void main(String[] args) {
		int array[] = { 3, 7, 5, 20, -10, 0, 12 }, subArraySize = 2;
		System.out.println("Sub array with least average in " + Arrays.toString(array) + " is "
				+ findLeastAverage(array, subArraySize));
		
		array = new int[]{3, 7, 90, 20, 10, 50, 40}; subArraySize = 3;
		System.out.println("Sub array with least average in " + Arrays.toString(array) + " is "
				+ findLeastAverage(array, subArraySize));
	}
}
