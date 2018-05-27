package com.algorithms.sortings;

import java.util.Arrays;

/**
 * 
 * 
 * @author Sasi on 25-May-2018, 7:09:07 am
 */
public class InsertionSort {
	public static int[] sort(int[] array){
		
		for(int i=1; i<array.length; ++i){
			int j=i-1, key = array[i];
			
			while(j >= 0 && array[j] > key){
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = key;
		}
		
		return array;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(InsertionSort.sort(new int[]{25, 23, 9, 8, -21, 12, 100, -12, -27, 36})));	
		System.out.println(Arrays.toString(InsertionSort.sort(new int[]{123, 234, -213, -333, 23, 4, -24, 45, 12})));
	}
}
	