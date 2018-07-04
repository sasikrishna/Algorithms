package com.algorithms.arrays;

import java.util.Arrays;

/**
 * Problem statement: Merge an array of size n into another array of size m+n
 * <br>Test case: 
 * <br>Input : m[] = {2, 8, -1, -1, -1, 13, -1, 15, 20}, n[] = {5, 7, 9, 25}
 * <br>Output : numbers[] = [2, 5, 7, 8, 9, 13, 15, 20, 25]
 * <br>Time complexity: O(m + n)
 * <br>Space complexity: O(1)
 * <br>Algorithm:
 * <ol>
 * 	<li>Move all elements in m+n size array to right side.</li>
 *  <li>Compare elements m+n array and nth array and copy them to m+n array starting from 0th index</li>
 * </ol>
 * @author Sasi Jolla on 30-Jun-2018, 2:34:46 pm
 */
public class MergeSortedArrays {
	
	/**
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public static int[] mergeArrays(int m[], int n[]){
		moveElementsToRight(m);
		
		int index = 0, indexN = 0, indexM = n.length;
		while(index < m.length){
			if(((indexM < (m.length)) && m[indexM] <= n[indexN]) || (indexN >= n.length)){
				m[index++] = m[indexM++];
			}else{
				m[index++] = n[indexN++];
			}
		}
		
		System.out.println(Arrays.toString(m));
		return m;
	}
	
	private static void moveElementsToRight(int[] array){
		int length = array.length;
		int emptyIndex = length - 1;
		
		for(int i = length - 1; i >= 0; i--){
			if(array[i] != -1){
				array[emptyIndex] = array[i];
				emptyIndex--;
			}
		}
	}
	
	public static void main(String[] args) {
		mergeArrays(new int[]{2, 8, -1, -1, -1, 13, -1, 15, 20}, new int[]{5, 7, 9, 25});
	}
}
