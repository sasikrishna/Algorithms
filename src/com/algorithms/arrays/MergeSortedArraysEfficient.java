package com.algorithms.arrays;

import java.util.Arrays;

/**
 * 
 * @author Sasi Jolla on 30-Jun-2018, 11:15:08 pm
 */
public class MergeSortedArraysEfficient {
	
	public static void mergeArrays(int array1[], int array2[]){
		
		int array2Length = array2.length, array1Length = array1.length;
		for(int i = array2Length -1; i >= 0; i--){

			int last = array1[array1Length - 1], j;
			for(j = array1Length - 2; j >= 0 && array1[j] > array2[i]; j--){
				array1[j + 1] = array1[j];
			}
			
			if(j != array1Length - 2 || last > array1[j]){
				array1[j + 1] = array2[i];
				array2[i] = last;
			}
		}
		System.out.println(Arrays.toString(array1));
		System.out.println(Arrays.toString(array2));
	}
	
	public static void main(String[] args) {
		int array1[] = {1, 5, 9, 10, 15, 20};
	    int array2[] = {2, 3, 8, 13};
	    mergeArrays(array1, array2);
	}
}
