package com.algorithms.dp.hard;

/**
 * Problem statement: Find number of ways of covering given distance with steps 1, 2 and 3 only.
 * <br><br>
 * Test case:
 * <br>
 * Input: 3
 * <br>
 * Output: 4 [(1+1+1, 1+2, 2+1, 3)]
 * <br>
 * @author Sasi on 06-Jun-2018, 11:00:14 pm
 */
public class CoverDistance {

	public static int findWays(int distance){
		
		int coveredDistances[] = new int[distance + 1];
		//Filling up 0, 1 and 2 positions as we know there going to 
		//be 0, 1 and 2 ways to cover 0, 1, 2 distances
		coveredDistances[0] = 1;
		coveredDistances[1] = 1;
		coveredDistances[2] = 2;
		
		for(int i = 3; i <= distance; i++){
			coveredDistances[i] = coveredDistances[i - 1] + coveredDistances[i - 2] + coveredDistances[i - 3];
		}
		
		return coveredDistances[distance];
	}
	
	public static void main(String[] args) {
		System.out.println("Ways to cover distance 3 in steps of 1, 2, 3 is " + CoverDistance.findWays(3));
		System.out.println("Ways to cover distance 4 in steps of 1, 2, 3 is " + CoverDistance.findWays(4));
	}
}
