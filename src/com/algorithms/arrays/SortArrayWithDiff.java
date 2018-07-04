package com.algorithms.arrays;

import java.util.Arrays;

/**
 * Problem statement: Sort an array according to absolute difference with given value.
 * <br>Test case: 
 * <br>Input : numbers[] = {10, 5, 3, 9, 2}, k = 7
 * <br>Output : numbers[] = {5, 9, 10, 3, 2}
 * <br>Time complexity: O(n^2) because using insertion sort. Can be reduced to O(nlogn) with other sortings.
 * <br>Space complexity: O(1) Because of inplace algorithm
 * @author Sasi Jolla on 30-Jun-2018, 11:32:03 am
 */
public class SortArrayWithDiff {
	
	public static void sort(int numbers[], int k){
		
		for(int i = 1; i < numbers.length; i++){
			int j = i - 1, abs =  Math.abs(numbers[i] - k), temp = numbers[i];
			
			while(j >= 0 && Math.abs(numbers[j] - k) > abs){
				numbers[j + 1] = numbers[j];
				j--;
			}
			numbers[j + 1] = temp;
		}
		System.out.println(Arrays.toString(numbers));
	}
	
	public static void main(String[] args) {
		sort(new int[]{10, 5, 3, 9, 2}, 7);
		sort(new int[]{1, 2, 3, 4, 5}, 6);
		sort(new int[]{2, 6, 8, 3}, 5);
	}
}
