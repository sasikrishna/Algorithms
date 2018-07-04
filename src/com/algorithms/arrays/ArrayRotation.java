package com.algorithms.arrays;

import java.util.Arrays;

/**
 * Problem statement: Write a function rotate(arr[], d) that rotates arr[] of size n by d elements. 
 * <br>Input  :  arr[] = [1, 2, 3, 4, 5, 6, 7], rotations = 2
 * <br>Output :  arr[] = [3, 4, 5, 6, 7, 1, 2]
 * <br>Time complexity   : O(n * rotations)
 * <br>Space complexity : O(1) 
 * @author Sasi Jolla on 25-Jun-2018, 11:15:35 pm
 */
public class ArrayRotation {
	
	/**
	 * 
	 * @param arr
	 * @param rotations
	 * @return rotated array
	 */
	public static int[] rotateArray(int arr[], int rotations){
		
		while(rotations > 0){
			int firstEle = arr[0];
			for(int i = 1; i < arr.length; i++){
				arr[i - 1] = arr[i]; 
			}
			
			arr[arr.length - 1] = firstEle;
			rotations--;
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		int array[] = {1, 2, 3, 4, 5, 6, 7};
		System.out.println(Arrays.toString(array) + " after 2 rotations is " + Arrays.toString(rotateArray(array, 2)));
	}
}
