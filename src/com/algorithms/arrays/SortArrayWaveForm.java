package com.algorithms.arrays;

import java.util.Arrays;

import com.algorithms.sortings.swap.SortUtil;

/**
 * Problem statement: Sort an array in wave form
 * <br>Test case: 
 * <br>Input : numbers[] = {10, 5, 3, 9, 2, 1}
 * <br>Output : numbers[] = {5, 1, 9, 3, 10, 2}
 * <br>Time complexities: Can be done in O(nlogn) or O(n)
 * <br>Space complexity: O(1) with both approaches
 * 
 * @author Sasi Jolla on 30-Jun-2018, 12:16:37 pm
 */
public class SortArrayWaveForm {
	
	/**
	 * Algorithm with quick sort implementation.
	 * 
	 * @param numbers
	 */
	public static void sort(int numbers[]){
		quickSort(numbers, 0, numbers.length - 1);
		int j = 0, k = 1;
		for(int i = 0; i < numbers.length/2; i++){
			int temp = numbers[j];
			numbers[j] = numbers[k];
			numbers[k] = temp;
			j = j + 2;
			k = k + 2;
		}
		System.out.println(Arrays.toString(numbers));
	}
	
	/**
	 * To create required wave form, we'll make sure even positioned elements are greater than elements at odd index.
	 * 
	 * @param numbers
	 */
	public static void sortEfficeintly(int numbers[]){
		for(int i = 0; i < numbers.length; i = i + 2){
			if((i - 1) > 0 && numbers[i - 1] > numbers[i]){
				SortUtil.swap(numbers, i - 1, i);
			}
			
			if((i + 1) < numbers.length && numbers[i + 1] > numbers[i]){
				SortUtil.swap(numbers, i + 1, i);
			}
		}
		System.out.println(Arrays.toString(numbers));
	}
	
	/**
	 * 
	 * @param numbers
	 * @param low
	 * @param high
	 */
	private static void quickSort(int numbers[], int low, int high){
		if(low < high){
			int pivot = parition(numbers, low, high);
			quickSort(numbers, low, pivot - 1);
			quickSort(numbers, pivot + 1, high);
		}
	}
	
	/**
	 * 
	 * @param numbers
	 * @param low
	 * @param high
	 * @return
	 */
	private static int parition(int[] numbers, int low, int high) {
		int pivotElement = numbers[high], j = low - 1;
		
		for(int i = low; i < high; i++){
			if(numbers[i] <= pivotElement){
				j++;
				SortUtil.swap(numbers, i, j);
			}
		}
		SortUtil.swap(numbers, j + 1, high);
		return j;
	}

	public static void main(String[] args) {
		sort(new int[]{10, 5, 3, 9, 2, 1});
		sortEfficeintly(new int[]{10, 5, 3, 9, 2, 1});
		
		sort(new int[]{20, 10, 8, 6, 4, 2});
		sortEfficeintly(new int[]{20, 10, 8, 6, 4, 2});
		
		sort(new int[]{2, 4, 6, 8, 10, 20});
		sortEfficeintly(new int[]{2, 4, 6, 8, 10, 20});
	}
}
