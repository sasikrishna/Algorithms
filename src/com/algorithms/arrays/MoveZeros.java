package com.algorithms.arrays;

import java.util.Arrays;

/**
 * Problem statement: Move all zeroes to end of array while maintaining the order of other elements.
 * <br>Input : arr[]  = {1, 2, 0, 0, 0, 3, 6}
 * <br>Output : 1 2 3 6 0 0 0 
 * <br>Time Complexity: O(n)
 * <br>Space Complexity: O(1)
 * @author Sasi Jolla on 26-Jun-2018, 8:35:27 am
 */
public class MoveZeros {

	public static int[] moveZeros(int arr[]){
		int count = 0;
		
		for(int i = 0; i < arr.length; i++){
			if(arr[i] != 0){
				int temp = arr[count];
				arr[count] = arr[i];
				arr[i] = temp;
				count++;
			}
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 2, 0, 0, 0, 3, 6};
		System.err.println(Arrays.toString(moveZeros(arr)));
		
		arr = new int[]{0, 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
		System.err.println(Arrays.toString(moveZeros(arr)));
	}
}
