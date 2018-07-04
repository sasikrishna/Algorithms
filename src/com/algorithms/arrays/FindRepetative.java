package com.algorithms.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem statement: Find the only repetitive element between 1 to n-1
 * 
 * @author Sasi Jolla on 01-Jul-2018, 2:30:00 pm
 */
public class FindRepetative {
	
	/**
	 * Naive approach with 2 loops.
	 * 
	 * <br><br>Time complexity: O(n^2)
	 * <br>Space complexity: O(1)
	 * @return repeated element
	 */
	public static int naiveApproach(int array[]){
		
		int count = 0;
		for(int i = 0; i < array.length; i++){
			for(int j = 1; j < array.length; j++){
				if(array[i] != array[j]){
					continue;
				}
				count++;
				
				if(count == 2){
					return array[j];
				}
			}
			count = 0;
		}
		
		return -1;
	}
	
	/**
	 * Using hash data structure
	 * 
	 * <br><br>Time complexity: O(n)
	 * <br>Space complexity: O(n) for hash table
	 * @return
	 */
	public static int usingHashing(int array[]){
		Set<Integer> hashSet = new HashSet<Integer>();
		for(int i = 0; i < array.length; i++){
			if(hashSet.contains(array[i])){
				return array[i];
			}
			hashSet.add(array[i]);
		}
		return -1;
	}
	
	/**
	 * Based on the idea of sum of numbers formula.
	 * 
	 * <br><br>Time complexity: O(n)
	 * <br>Space complexity: O(1)
	 * @return
	 */
	public static int usingSumofNumbers(int array[]){
		int length = array.length, sum = 0;
		for(int i = 0; i < array.length; i++){
			sum += array[i];
		}
		
		return sum - (length * (length - 1)/2);
	}
	
	/**
	 * Based on changing the sign of element at positions.
	 * 
	 * <br><br>Time complexity: O(n)
	 * <br>Space complexity: O(1)
	 * @return
	 */
	public static int usingIndexing(int array[]){
		
		for(int i = 0; i < array.length; i++){
			
			int element = array[Math.abs(array[i])];
			if(element < 0){
				return Math.abs(array[i]);
			}
			
			array[Math.abs(element)] = - array[Math.abs(element)];
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int array[] = { 9, 8, 2, 6, 1, 8, 5, 3, 4, 7 };
		System.out.println(naiveApproach(array));
		System.out.println(usingHashing(array));
		System.out.println(usingSumofNumbers(array));
		System.out.println(usingIndexing(array));
	}
}
