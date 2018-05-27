package com.algorithms.sortings;

import java.util.Arrays;

/**
 * <code>BubbleSort</code> class is implementation for bubble sort algorithm for sorting an array.<br>
 * 
 * Time complexity for sorting - O(n * n) where n is array length<br>
 * 
 * Suits for sorting small sets.
 * 
 * @author Sasi on 25-May-2018, 6:41:35 am
 */
public class BubbleSort {
	public static int[] sort(int[] array){
		
		for(int i=0; i<array.length-1; i++){
			for(int j=i+1; j<array.length; j++){
				if(array[i] > array[j]){
					array[i] = array[i] + array[j];
					array[j] = array[i] - array[j];
					array[i] = array[i] - array[j];
				}
			}
		}
		
		return array;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(BubbleSort.sort(new int[]{25, 23, 9, 8, -21, 12, 100, -12, -27, 36})));	
		System.out.println(Arrays.toString(BubbleSort.sort(new int[]{123, 234, -213, -333, 23, 4, -24, 45, 12})));
	}
}
