package com.algorithms.arrays;

import java.util.ArrayList;


/**
 * Problem statement: Print all combination of numbers from 1 to n having sum n
 * 
 * @author Sasi Jolla on 15-Jul-2018, 3:43:30 pm
 */
public class PrintSumCombinations {
	
	/**
	 * 
	 * @param sum
	 */
	public static void printSumCombinations(int start, int sum, ArrayList<Integer> list){
		
		if(sum == 0){
			System.out.println(list);
			return;
		}
		
		for(int i = start; i <= sum; i++){
			list.add(i);
			printSumCombinations(i, sum - i, list);
			list.remove(list.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		printSumCombinations(1, 5, new ArrayList<Integer>());
	}
}
