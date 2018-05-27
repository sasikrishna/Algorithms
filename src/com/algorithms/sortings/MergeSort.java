package com.algorithms.sortings;

import java.util.Arrays;


/**
 * 
 * @author Sasi on 25-May-2018, 11:56:38 pm
 */
public class MergeSort {
	
	public static void sort(int[] array){
		divide(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));
	}
	
	private static void divide(int[] array, int low, int high){
		
		if(low < high){
			int mid = (low + high)/2;
			divide(array, low, mid);
			divide(array, mid + 1, high);
			merge(array, low, mid, high);
		}
	}
	
	private static void merge(int[] array, int low, int mid, int high) {
		int start = low, center= mid+1, k=0;
		int[] tempArr = new int[high-low+1];
		
		for(int i = low; i <= high; i++){
			if(start > mid){                         // Checking if first sub array is completed. If so copy all second sub array elements to temp array.
				tempArr[k++] = array[center++];
			}else if(center > high){			     // Checking if second sub array is completed
				tempArr[k++] = array[start++];
			}else if(array[start] < array[center]){  // Actual swapping happening here 
				tempArr[k++] = array[start++]; 
			}else{
				tempArr[k++] = array[center++];
			}
		}
		
		for(int i = 0; i < k; i++){
			array[low++] = tempArr[i];
		}
	}

	public static void main(String[] args) {
		MergeSort.sort(new int[]{25, 23, 9, 8, -21, 12, 100, -12, -27, 36});
	}
}
