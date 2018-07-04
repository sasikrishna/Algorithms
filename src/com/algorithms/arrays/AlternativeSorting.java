package com.algorithms.arrays;


/**
 * Problem statement: Given an array of integers, print the array in such a way that the first element is 
 * 						first maximum and second element is first minimum and so on.
 * <br>Testcase:
 * <br>Input : arr[] = {7, 1, 2, 3, 4, 5, 6}
 * <br>Output : 7 1 6 2 5 3 4
 * <br>Time Complexity: O(nlogn) + O(n)
 * <br>Space Complexity: O(n) for temp array while sorting
 * @author Sasi Jolla on 30-Jun-2018, 9:49:16 am
 */
public class AlternativeSorting {
	
	public static void printAlternatives(int numbers[]){
		mergesort(numbers, 0, numbers.length - 1);
		int length = numbers.length;
		
		int i = length - 1, j = 0;
		while(j <= i){
			if(i == j){
				System.out.print(numbers[j++]);
			}else{
				System.out.print(numbers[i--] + " " + numbers[j++] + " ");
			}
		}
		System.out.println();
	}
	
	private static void mergesort(int numbers[], int low, int high){
		if(low < high){
			int mid = (low + high)/2;
			mergesort(numbers, low, mid);
			mergesort(numbers, mid + 1, high);
			merge(numbers, low, mid, high);
		}
	}
	
	private static void merge(int numbers[], int low, int mid, int high){
		int start = low, center = mid + 1;
		
		int length = high - low + 1;
		int sortedArray[] = new int[length];
		
		for(int i = 0; i < length; i++){
			if(start > mid){
				sortedArray[i] = numbers[center++];
			}else if(center > high){
				sortedArray[i] = numbers[start++];
			}else if(numbers[start] > numbers[center]){
				sortedArray[i] = numbers[center++];
			}else{
				sortedArray[i] = numbers[start++];
			}
		}
		
		for(int i = 0; i < length; i++){
			numbers[low++] = sortedArray[i];
		}
	}
	
	public static void main(String[] args) {
		printAlternatives(new int[]{2, 5, 7, 1, 8, 19, 4});
		printAlternatives(new int[]{25, 26, 43, 19, 17, 52});
	}
}
