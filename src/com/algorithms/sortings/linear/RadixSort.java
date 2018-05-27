package com.algorithms.sortings.linear;

import java.util.Arrays;

/**
 * 
 * @author Sasi on 27-May-2018, 3:55:20 pm
 */
public class RadixSort {

	public static void sort(int[] array){
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<array.length; i++){                //Finding max element
			max = Math.max(max, array[i]);
		}
		
		for(int base = 1; max/base > 0;	base *= 10){      //Iterating each digit 
			countSort(array, base);
		}
		
		System.out.println("Sorted array: " + Arrays.toString(array));
	}
	
	private static void countSort(int[] array, int base) {
		int[] frequencyCounter = new int[10];
		
		for(int i=0; i < array.length; i++){
			frequencyCounter[(array[i]/base)%10]++;
		}
		System.out.println(Arrays.toString(frequencyCounter));
		
		for(int i=1; i < 10; i++){
			frequencyCounter[i] += frequencyCounter[i - 1];
		}
		System.out.println(Arrays.toString(frequencyCounter));
		
		int output[] = new int[array.length];
        for(int i = array.length - 1; i >= 0; i--)         //Build the output array
        {
            output[frequencyCounter[(array[i]/base)%10 ] - 1] = array[i];
            frequencyCounter[(array[i]/base)%10 ]--;
        }
        
        for(int i = 0; i < array.length; i++){
            array[i] = output[i];
        }
	}

	public static void main(String[] args) {
		//RadixSort.sort(new int[]{170, 45, 75, 90, 802, 24, 2, 66});
		RadixSort.sort(new int[]{5,4,3,2,1});
	}
}
