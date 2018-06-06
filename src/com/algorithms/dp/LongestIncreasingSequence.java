package com.algorithms.dp;

import java.util.Arrays;

/**
 * Problem statement: Find  longest increasing sequence in given array.
 * <br><br>
 * Test case:
 * <br>
 * Input: 26, 32, 24, 36, 18, 42, 20, 45 
 * <br>
 * Output: 5 (26, 32, 36, 42, 45)
 * <br>
 * @author Sasi on 05-Jun-2018, 8:54:10 am
 */
public class LongestIncreasingSequence {

	public static int findLongestSequence(int array[]){
		int lis[] = new int[array.length];
		
		for(int i = 0; i < lis.length; i++){
			lis[i] = 1;
		}
		
		for(int i = 1; i < array.length; i++){
			for(int j = 0; j < i; j++){
				if(array[i] > array[j]){
					lis[i] = Math.max(lis[i], lis[j] + 1);
				}
			}
		}
		
		int maxSequenceCount = 0;
		for(int i = 0; i < lis.length; i++){
			if(maxSequenceCount < lis[i]){
				maxSequenceCount = lis[i];
			}
		}
		
		return maxSequenceCount;
	}
	
	public static void main(String[] args) {
		int array[] = new int[]{26, 32, 24, 36, 18, 42, 20, 45};
		System.out.println("Longest increasing subsequence in " + Arrays.toString(array) + " is " + findLongestSequence(array));
		
		array = new int[]{-2, -1, 4, 8, -3, 9, 10};
		System.out.println("Longest increasing subsequence in " + Arrays.toString(array) + " is " + findLongestSequence(array));
	}
}
