package com.algorithms.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem statement: Given N elements, write a program that prints the length of the longest increasing subsequence whose adjacent element difference is one.
 * 
 * @author Sasi Jolla on 14-Aug-2018, 12:03:34 am
 */
public class LongestIncreasingSubsequence {
	
	/**
	 * The idea is to maintain a map which stores current array element along with its index and dp array which stores max length can be achieved at current index.
	 * 
	 * @param array
	 * @returns longest increasing subsequence length 
	 */
	public static int length(int array[]){
		
		int maxLength = 1;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(array[0], 1);
		
		int dp[] = new int[array.length];
		dp[0] = 1;
		
		for(int i = 1; i < array.length; i++){
			if(map.get(array[i] - 1) != null){
				dp[i] = 1 + dp[map.get(array[i] - 1) - 1];
			}else{
				dp[i] = 1;
			}
			
			map.put(array[i], i + 1);
			maxLength = Math.max(dp[i], maxLength);
		}
		
		return maxLength;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int array[] = {3, 10, 3, 11, 4, 5, 6, 7, 8, 12};
		System.out.println("Length of longest increasing sequence is " + length(array));
	}
}
