package com.algorithms.dp.hard;

/**
 * Problem statement: Find all subsets count for a given set by rearranging or repeating elements. Given that each subset sum should be equals to given sum.<br><br>  
 * 
 * Test case: <br>
 * Input: set = {1, 2, 3} and sum = 5.<br>
 * Output: 5 ({1, 1, 1, 1, 1}, {1, 1, 1, 2}, {1, 1, 3}.....{2, 3})
 * 
 * @author Sasi on 03-Jun-2018, 1:06:54 pm
 */
public class Subsets{
	
	static int lookup[];
	public static int printSubsetsCount(int[] array, int sum){
		lookup = new int[sum];
		for(int i = 0; i < sum; i++){
			lookup[i] = -1;
		}
		
		int count = 0;
		for(int i = 0; i < array.length; i++){
			count += printSubsetsCount(sum - array[i], array);
		}
		
		return count;
	}
	
	private static int printSubsetsCount(int number, int[] array){
		
		if(number < 0){
			return 0;
		}
		if(number == 0){
			return 1;
		}
		
		if(lookup[number] != -1){
			return lookup[number]; 
		}
		
		int count = 0;
		for(int i = 0; i < array.length; i++){
			count += printSubsetsCount(number - array[i], array);
		}
		
		lookup[number] = count;
		return count;
	}
	
	public static void main(String[] args) {
		int array[] = {1, 2, 3}, sum = 4;
		System.out.println("Total subsets count: " + printSubsetsCount(array, sum));
	}
}
