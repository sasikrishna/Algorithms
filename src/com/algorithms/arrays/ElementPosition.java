package com.algorithms.arrays;

/**
 * Problem statement: Find position of an element in a sorted array of infinite numbers.
 * 
 * @author Sasi Jolla on 01-Jul-2018, 12:52:05 pm
 */
public class ElementPosition {
	
	public static int findPosition(int array[], int key){
		
		int low = 0, high = 1, element = array[high];
		while(element < key){
			low = high;
			high = 2 * high;
			element = array[high];
		}
		
		return binarySearch(array, low, high, key);
	}
	
	private static int binarySearch(int array[], int low, int high, int key){
		
		if(low <= high){

			int mid = (low + high) / 2;
			if(array[mid] == key){
				return mid;
			}
			
			if(key < array[mid]){
				return binarySearch(array, low, mid, key);
			}
			
			return binarySearch(array, mid + 1, high, key);
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int arr[] = new int[]{3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
		int ans = findPosition(arr,10);
		if (ans == -1){
            System.out.println("Element not found.");
		}
        else{
            System.out.println("Element found at position " + ans);
        }
	}
}
