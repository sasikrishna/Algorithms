package com.algorithms.sortings.swap;

import java.util.Arrays;

/**
 * 
 * @author Sasi on 25-May-2018, 8:26:17 pm
 */
public class ShellSort {
	
	public static int[] sort(int array[]){
		int length = array.length;
		
		//Shell's original gap sequence divide by 2
		for(int gap = length/2; gap > 0; gap = gap/2){
			for(int i = gap; i < length; i++){
				
				int key = array[i], j = i;
				
				for(; j >= gap && array[j-gap] > key; j-=gap){
					array[j] = array[j-gap];
				}
				array[j] = key;
			}
		}
		return array;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(ShellSort.sort(new int[]{25, 23, 9, 8, -21, 12, 100, -12, -27, 36})));
		System.out.println(Arrays.toString(ShellSort.sort(new int[]{123, 234, -213, -333, 23, 4, -24, 45, 12})));
	}
}
