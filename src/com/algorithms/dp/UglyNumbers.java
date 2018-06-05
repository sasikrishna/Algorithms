package com.algorithms.dp;

import java.util.Arrays;

/**
 * Problem statement: Find 150th ugly number. An ugly number will have prime factors 2, 3 or 5. Ugly numbers array looks like 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15
 * <br><br>
 * Test case:
 * <br>
 * Input: 7 (find ugly number at position 7)
 * <br>
 * Output: 8
 * <br>
 * @author Sasi on 04-Jun-2018, 11:02:54 pm
 */
public class UglyNumbers {
	
	public static int findUglyNumber(int index){
		int uglyNumbersArray[] = new int[index];
		uglyNumbersArray[0] = 1;
		
		int twosIndex = 0, threesIndex = 0, fivesIndex = 0;
		int twosNextMultiple = 2, threesNextMultiple = 3, 
				fiveNextMultiple = 5; 
		
		for(int i = 1; i < index; i++){
			int nextUglyNumber = Math.min(Math.min(twosNextMultiple, threesNextMultiple), fiveNextMultiple);
			uglyNumbersArray[i] = nextUglyNumber;
			
			if(nextUglyNumber == twosNextMultiple){
				twosNextMultiple = uglyNumbersArray[++twosIndex] * 2; 
			}
			if(nextUglyNumber == threesNextMultiple){
				threesNextMultiple = uglyNumbersArray[++threesIndex] * 3; 
			}
			if(nextUglyNumber == fiveNextMultiple){
				fiveNextMultiple = uglyNumbersArray[++fivesIndex] * 5;  
			}
		}
		System.out.println(Arrays.toString(uglyNumbersArray));
		return uglyNumbersArray[index-1];
	}
	
	public static void main(String[] args) {
		System.out.println("Ugly number at position 7 is " + findUglyNumber(7));
		System.out.println("Ugly number at position 150 is " + findUglyNumber(150));
	}
}
