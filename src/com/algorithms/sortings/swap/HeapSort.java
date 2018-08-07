package com.algorithms.sortings.swap;

import java.util.Arrays;

/**
 * Problem statement: Sorting given using using max heap data structure.
 *  
 * @author Sasi on 27-May-2018, 12:54:08 am
 */
public class HeapSort {
	
	/**
	 * 
	 * @param array
	 */
	public static void sort(int[] array){
		buildHeap(array);
		sortHeap(array);
		System.out.println("Array sorted: " + Arrays.toString(array));
	}
	
	/**
	 * 
	 * @param array
	 */
	private static void buildHeap(int[] array) {
		int length = array.length;
		for(int i= length/2; i >= 0; i--){
			heapify(array, length, i);
		}
		System.out.println("Array heapified: " + Arrays.toString(array));
	}

	/**
	 * 
	 * @param array
	 */
	private static void sortHeap(int[] array){
		
		for(int i = array.length-1; i>=0; i--){
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			
			heapify(array, i, 0);
		}
	}
	
	/**
	 * 
	 * @param array
	 * @param length
	 * @param root
	 */
	private static void heapify(int[] array, int length, int root) {
		int leftChildIndex = 2 * root + 1, rightChildIndex = 2 * root + 2, largestIndex = root;
		
		if(leftChildIndex < length && array[leftChildIndex] > array[largestIndex])
		{
			largestIndex = leftChildIndex;
		}
		
		if(rightChildIndex < length && array[rightChildIndex] > array[largestIndex])
		{
			largestIndex = rightChildIndex;
		}
		
		if(largestIndex != root)
		{
			int temp = array[largestIndex];
			array[largestIndex] = array[root];
			array[root] = temp;
			heapify(array, length, largestIndex);
		}
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		HeapSort.sort(new int[]{25, 23, 9, 8, -21, 12, 100, -12, -27, 36});
		HeapSort.sort(new int[]{5, 4, 3, 2, 1});
	}
}
