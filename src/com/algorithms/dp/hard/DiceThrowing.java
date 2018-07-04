package com.algorithms.dp.hard;

/**
 * Problem statement: Find number of ways to get a sum which is summation of n dices each with m faces.  
 * <br><br>
 * Test case:
 * <br>
 * Input: dices = 4, faces = 4, sum = 4
 * <br>
 * Output: 1 (There is only one way to get four with four dices i.e each dice with only 1)
 * <br>
 * @author Sasi Jolla on 10-Jun-2018, 11:30:54 am
 */
public class DiceThrowing {
	
	public static int findWays(int diceCount, int faces, int total){
		
		int totalWays[][] = new int[diceCount + 1][total + 1];
		
	    for (int j = 1; j <= faces && j <= total; j++)
	    	totalWays[1][j] = 1;
	    
		for(int i = 2; i <= diceCount; i++){
			for(int j = 1; j <= total; j++){
				for(int k = 1; k <= faces && k < j; k++){
					totalWays[i][j] += totalWays[i - 1][j - k];
				}
			}
		}
		
		return totalWays[diceCount][total];
	}
	
	public static void main(String[] args) {
		System.out.println(findWays(2, 4, 1));
		System.out.println(findWays(2, 2, 3));
		System.out.println(findWays(4, 4, 4));
	}
}
