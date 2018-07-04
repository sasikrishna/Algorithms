package com.algorithms.dp.easy;

/**
 * 
 * @author Sasi Jolla on 23-Jun-2018, 1:45:27 pm
 */
public class MaxSubArraySize {

	public static int maxSize(int array[]){
		
		int start = 0, end = 0, maxSum = 0, sumSoFar = 0;
		
		for(int i = 0; i < array.length; i++){
			
			sumSoFar += array[i];
			if(sumSoFar < 0){
				sumSoFar = 0;
				start = i + 1;
			}
	            
			if(maxSum < sumSoFar){
				maxSum = sumSoFar;
				end = i;
			}
		}
		//System.out.println(maxSum);
		return end - start + 1;
	}
	
	public static void main(String[] args) {
		System.out.println("Max sub array sum size is " + maxSize(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}));
		System.out.println("Max sub array sum size is " + maxSize(new int[]{1, -2, 1, 1, -2, 1}));
	}
}
