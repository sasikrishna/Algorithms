package com.algorithms.dp;

import java.util.Arrays;

/**
 * Problem statement: Find largest sub array with maximum sum.
 * <br><br>
 * Test case:
 * <br>
 * Input: 4, 2, -5, -4, -9, 3, 8, 9
 * <br>
 * Output: 20 (3 + 8 + 9)
 *
 * @author Sasi on 04-Jun-2018, 9:16:57 pm
 */
public class LargestSubArraySum {
	
	/**
	 * <code>findMaxSubArraySum</code> method implements Kadane's algorithms to find max sum.
	 * 
	 * @param array
	 * @return Maximum sum of sub array
	 */
	public static int findMaxSubArraySum(int[] array){

		int maxSum = 0, tempMax = 0;
		for(int i = 0; i < array.length; i++){
			tempMax = tempMax + array[i];
			
			if(tempMax < 0){
				tempMax = 0;
			}
			else if(tempMax > maxSum){
				maxSum = tempMax;
			}
		}
		
		return maxSum;
	}
	
	public static void main(String[] args) {
		int[] array = {4, 2, -5, -4, -9, 3, 8, 9};
		System.out.println("Max sub array sum in " + Arrays.toString(array) + " is " + findMaxSubArraySum(array));
	}
}
