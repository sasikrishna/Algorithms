package com.algorithms.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Problem statement: Find a triplet in array that sum should be equals to given value.
 * 
 * @author Sasi Jolla on 01-Jul-2018, 7:21:56 pm
 */
public class TripletsSum {
	
	/**
	 * Sorting approach. Keeping the current element constant and we'll move two pointers left and right both ends of the array.
	 * If current sum is greater than given sum decrease right pointer otherwise increment left pointer 1. If current sum is equals to given sum we found the triplet. 
	 * 
	 * <br><br>Time complexity: O(n^2)
	 * <br>Space complexity: O(1)
	 * @param array
	 * @param sum
	 */
	public static void findTriplet(int array[], int sum){

		Arrays.sort(array);
		int arrayLength = array.length;
		int left, right;
		for(int i = 0; i < arrayLength - 2; i++){
			left = i + 1;
			right = arrayLength - 1;
			
			while(left < right){
				int currentSum = array[i] + array[left] + array[right];
				if(currentSum == sum){
					System.out.println("Triplet found: " + array[i] + " " + array[left] + " " + array[right]);
					left++;
					right--;
				}else if(currentSum > sum){
					right--;
				}else{
					left++;
				}
			}
		}
	}
	
	/**
	 * Hashing based solution.
	 * 
	 * <br><br>Time complexity: O(n^2)
	 * <br>Space complexity: O(n) for hash table
	 * @param array2
	 * @param sum
	 */
	public static void findTripletUsingHashing(int array[], int sum){
		
		int arrayLength = array.length;
		Set<Integer> sumTable = new HashSet<Integer>();
		for(int i = 0; i < arrayLength - 2; i++){

			int currentSum = sum - array[i];
			for(int j = i + 1; j < arrayLength; j++){
				if(sumTable.contains(currentSum - array[j])){
					System.out.println("Triplet found: " + array[i] + " " + array[j] + " " + (currentSum - array[j]));
					return;
				}
				sumTable.add(array[j]);
			}
		}
	}
	
	public static void main(String[] args) {
		int array[] = {1, 4, 45, 6, 10, 8};
	    int sum = 22;
	    findTriplet(array, sum);
	    findTripletUsingHashing(array, sum);
	}
}
