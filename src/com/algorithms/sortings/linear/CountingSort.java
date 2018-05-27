package com.algorithms.sortings.linear;

import java.util.Arrays;

/**
 * 
 * @author Sasi on 27-May-2018, 11:03:33 am
 */
public class CountingSort {
	
	public static void sort(int[] array){
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<array.length; i++){            //Finding max element
			max = Math.max(max, array[i]);
		}
		
		int[] frequencies = new int[max+1];
		for(int i=0; i<array.length; i++){            //Finding frequency of number in array
			frequencies[array[i]]++;
		}
		
		int j = 0;
		for(int i=0; i<frequencies.length; i++){      //Iterating through frequencies array and filling up sorted array -
			int frequency = frequencies[i];           //for each frequency.
			
			while(frequency-- != 0){
				array[j] = i;
				j++;
			}
		}
		
		System.out.println(Arrays.toString(array));
	}
	
	public static void main(String[] args) {
		CountingSort.sort(new int[]{5,2,9,5,2,3,5});
	}
}
