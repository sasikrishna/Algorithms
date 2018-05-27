package com.algorithms.sortings;

import java.util.Arrays;

/**
 * 
 * @author Sasi on 26-May-2018, 4:17:43 pm
 */
public class QuickSort {
	
	public static void sort(int[] array){
		SortUtil.resetSwapCounter();
		quickSort(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));
		System.out.println("Number of swaps: " + SortUtil.getSwapCount());
	}
	
	private static void quickSort(int[] array, int low, int high){
		if(low < high){
			int pivotIndex = partition(array, low, high);
			quickSort(array, low, pivotIndex-1);
			quickSort(array, pivotIndex+1, high);
		}
	}
	
	private static int partition(int[] array, int low, int high){
		
		int pivotEle = array[high];               //Considering last element in array as pivot
		int i= low-1;                             //Considering index i as minimum element index
		
		for(int j = low; j <= high-1; j++){       
			if(array[j] <= pivotEle){             //Swapping elements to left of array which are less than or equals to pivot
				i++;
				SortUtil.swap(array, i, j);
			}
		}
		
		SortUtil.swap(array, i+1, high);
		return i+1;                               //Returning pivot element index
	}
	
	public static void main(String[] args) {
		QuickSort.sort(new int[]{25, 23, 9, 8, -21, 12, 100, -12, -27, 36});
		QuickSort.sort(new int[]{5,4,3,2,1});
	}
}
