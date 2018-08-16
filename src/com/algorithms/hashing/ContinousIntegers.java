package com.algorithms.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem statement: Given an array of n integers(duplicates allowed). Print
 * “Yes” if it is a set of contiguous integers else print “No”.
 * 
 * @author Sasi Jolla on 15-Aug-2018, 11:56:37 am
 */
public class ContinousIntegers {

	/**
	 * The idea is to use visited array. For every element in given array we'll
	 * put true in visited array. If visited array contains all trues then array
	 * contains contigous integers. Visited array size will be max - min + 1
	 * where min and max are minimum and maximum values in array.
	 * 
	 * @param array
	 * @returns
	 */
	public static boolean isContinousArray(int array[]) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		/** Finding min and max values in given array */
		for (int i = 0; i < array.length; i++) {
			max = Math.max(max, array[i]);
			min = Math.min(min, array[i]);
		}

		int visitedArraySize = max - min + 1;

		if (visitedArraySize > array.length) {
			return false;
		}

		boolean[] visitedArray = new boolean[visitedArraySize];
		for (int i = 0; i < array.length; i++) {
			visitedArray[array[i] - min] = true;
		}

		for (int i = 0; i < visitedArraySize; i++) {
			if (!visitedArray[i]) {
				return false;
			}
		}

		return true;
	}

	/**
	 * In the above approach we have a temp array to find contiguous integers or
	 * not. In this approach we'll use Set to find array contains contiguous
	 * integers or not.
	 * 
	 * The idea is to find sum of next contiguous elements to first array
	 * element and contiguous elements before the first array element. This sum
	 * should be equals to size of hashset.
	 * 
	 * @param array
	 * @return
	 */
	public static boolean isContinousArrayUsingHashing(int array[]) {

		Set<Integer> hashSet = new HashSet<Integer>();
		for (int i = 0; i < array.length; i++) {
			hashSet.add(array[i]);
		}
		int contigousEleCount = 1;
		int firstEle = array[0] + 1;
		/**Finding count of elements which are contiguous to first element*/
		while(hashSet.contains(firstEle)){
			contigousEleCount++;
			firstEle++;
		}
		
		firstEle = array[0] - 1;
		/**Finding count of elements which are appears before the first element*/
		while(hashSet.contains(firstEle)){
			contigousEleCount++;
			firstEle--;
		}
		
		return (contigousEleCount == hashSet.size());
	}

	/**
	 * 
	 * @param arg
	 */
	public static void main(String[] args) {
		int array[] = {5, 2, 3, 6, 4, 4, 6, 6};
		System.out.println("Array contains contiguous elements " + (isContinousArray(array) ? "Yes" : "No"));
		System.out.println("Array contains contiguous elements " + (isContinousArrayUsingHashing(array) ? "Yes" : "No"));
	}
}
