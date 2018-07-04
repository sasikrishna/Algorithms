package com.algorithms.dp.easy;

/**
 * Problem Statement: Given an array of n size, the task is to find the longest subsequence such that difference between adjacents is one.
 * <br>Hint: Variant of longest increasing sub sequence.
 * @author Sasi Jolla on 23-Jun-2018, 8:43:51 am
 */
public class LongestSubsequence {
	
	public static int longestSequenceLength(int array[]){
		int length = array.length, dp[] = new int[length];
		dp[0] = 1;
		
		for(int i = 1; i < length; i++){
			for(int j = i - 1; j >= 0; j--){
				if(Math.abs(array[i] - array[j]) == 1
						&& (dp[i] < dp[j] + 1)){
					dp[i] = dp[j] + 1;
				}
			}
		}
		
		int maxLength = 0;
		for(int i = 0; i < length; i++){
			if(maxLength < dp[i]){
				maxLength = dp[i];
			}
		}
		
		return maxLength;
	}
	
	static int maxLength = 0;
	public static int longestSequenceLengthRecursive(int array[], int length){
		
		//Base case
		if(length == 1){
			return 1;
		}
		
		int res = 0, maxLengthSoFar = 1;
		for(int j = 1; j < length; j++){
			res = longestSequenceLengthRecursive(array, j);
			if(Math.abs(array[j - 1] - array[length - 1]) == 1 && (res + 1) > maxLengthSoFar){
				maxLengthSoFar = res + 1;
			}
		}
		
		if(maxLengthSoFar > maxLength){
			maxLength = maxLengthSoFar;
		}
		
		return maxLengthSoFar;
	}
	
	public static void main(String[] args) {
		System.out.println("Longest sub sequence in {1, 2, 3, 2, 3, 7, 2, 1} with diff 1 is " 
				+ longestSequenceLength(new int[]{1, 2, 3, 2, 3, 7, 2, 1}));
		System.out.println("Longest sub sequence in {10, 9, 4, 5, 4, 8, 6} with diff 1 is " 
				+ longestSequenceLength(new int[]{10, 9, 4, 5, 4, 8, 6}));
		
		longestSequenceLengthRecursive(new int[]{10, 9, 4, 5, 4, 8, 6}, 7);
		System.out.println("Longest sub sequence in {10, 9, 4, 5, 4, 8, 6} with diff 1 is " 
				+ maxLength);
	}
}
