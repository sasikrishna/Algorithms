package com.algorithms.sortings;

import java.util.Arrays;

/**
 * <code>SelectionSort</code> class is implementation for selection sort algorithm. 
 * 
 * @author Sasi on 25-May-2018, 6:57:46 am
 */
public class SelectionSort {
	
	public static int[] sort(int[] array){
		
		for(int i=0; i<array.length-1; i++){
			int minimumNumberIndex = i;
			
			for(int j=i+1; j<array.length; j++){
				if(array[minimumNumberIndex] > array[j]){
					minimumNumberIndex = j;
				}
			}
			
			array[i] = array[i] + array[minimumNumberIndex];
			array[minimumNumberIndex] = array[i] - array[minimumNumberIndex];
			array[i] = array[i] - array[minimumNumberIndex];
		}
		
		return array;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(SelectionSort.sort(new int[]{25, 23, 9, 8, -21, 12, 100, -12, -27, 36})));	
		System.out.println(Arrays.toString(SelectionSort.sort(new int[]{123, 234, -213, -333, 23, 4, -24, 45, 12})));
	}
}
