package com.algorithms.sortings;

/**
 * 
 * @author Sasi on 26-May-2018, 5:10:40 pm
 */
public class SortUtil {
	
	static int noOfSwaps = 0;
		
	public static void swap(int[] array, int i, int j){
		
		if(i == j){
			return;
		}
		
		array[i] = array[i] + array[j];
		array[j] = array[i] - array[j];
		array[i] = array[i] - array[j];
		
		incrementSwapCount();
	}
	
	private static void incrementSwapCount(){
		noOfSwaps++;
	}
	public static int getSwapCount(){
		return noOfSwaps;
	}
	
	public static void resetSwapCounter(){
		noOfSwaps = 0;
	}
}
