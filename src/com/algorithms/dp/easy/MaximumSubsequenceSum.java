package com.algorithms.dp.easy;


/**
 * Problem Statement: Given a sequence of positive numbers, find the maximum sum that can be formed which has no three consecutive elements present.
 * 
 * @author Sasi Jolla on 22-Jun-2018, 10:51:12 pm
 */
public class MaximumSubsequenceSum {
	
	public static int findways(int array[]){
		int sum[] = new int[array.length], length = array.length;
		
		if(length >= 1){
			sum[0] = array[0];
		}
		
		if(length >= 2){
			sum[1] = array[0] + array[1];
		}
		
		if(length > 2){
			sum[2] = Math.max(sum[1], Math.max(sum[0] + array[2], array[1] + array[2]));
		}
		
		for(int i = 3; i < length; i++){
			sum[i] = Math.max(sum[i - 1], Math.max(sum[i - 2] + array[i], sum[i - 3] + array[i - 1] + array[i]));
		}
		
		return sum[length - 1];
	}
	
	public static void main(String[] args) {
		System.out.println("Max sum in {3000, 2000, 1000, 3, 10} is " + findways(new int[]{3000, 2000, 1000, 3, 10}));
	}
}
