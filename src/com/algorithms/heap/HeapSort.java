package com.algorithms.heap;

import java.util.Arrays;

/**
 * 
 * @author Sasi Jolla on 06-Aug-2018, 9:11:49 pm
 */
public class HeapSort {
	
	/**
	 * The idea is to create max heap from given array. So root element is greater than all elements.
	 * Swapping root with last element in heap and calling heapify on root.
	 * 
	 * Time complexity: O(nlogn)
	 * Space complexity: O(1)
	 * 
	 * @param array
	 */
	public static void sort(int array[]){
		int arraySize = array.length;
		
		/**Creating max heap for the given array*/
		for(int i = arraySize/2 ; i >= 0; i--){
			heapify(array, arraySize, i);
		}
		
		/**Performing heap sort*/
		for(int i = arraySize - 1; i >= 0; i--){
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			
			heapify(array, i, 0);
		}
	}
	
	/**
	 * 
	 * @param array
	 * @param size
	 * @param root
	 */
	private static void heapify(int array[], int size, int root){
		int largest = root;
		int left = 2 * root + 1, right = 2 * root + 2;
		
		if(left < size && array[left] > array[root]){
			largest = left;
		}
		if(right < size && array[right] > array[largest]){
			largest = right;
		}
		
		if(root != largest){
			int temp = array[largest];
			array[largest] = array[root];
			array[root] = temp;
			
			heapify(array, size, largest);
		}
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		 int array[] = {12, 11, 13, 5, 6, 7};
		 
		 System.out.print("Array before sorting " + Arrays.toString(array));
		 sort(array);
		 System.out.print("\nArray after sorting " + Arrays.toString(array));
	}
}
