package com.algorithms.dp.hard;

import java.util.Arrays;

/**
 * Problem statement: Find number of ways of arranging unlimited given set of coins to form given sum.
 * <br><br>
 * Test case:
 * <br>
 * Input: coins = {1, 3, 4, 6}, total = 7
 * <br>
 * Output: 6
 * <br>
 * @author Sasi Jolla on 09-Jun-2018, 7:41:30 pm
 */
public class CoinChangeWays {
	
	/**
	 * 
	 * 
	 */
	public static int findWays(int coins[], int total){
		int countsTable[][] = new int[coins.length + 1][total+1];
		
		for(int i = 0; i <= coins.length; i++){
			countsTable[i][0] = 1;
		}
		
		for(int i = 1; i <= coins.length; i++){
			for(int j = 1; j <= total; j++){
				if(coins[i - 1] > j){
					countsTable[i][j] = countsTable[i - 1][j];
				}else{
					countsTable[i][j] = countsTable[i - 1][j] + countsTable[i][j - coins[i - 1]];		//Number of ways so far + number of ways with i & j
				}
			}
		}
		
		return countsTable[coins.length][total]; 
	}
	
	/**
	 * space optimized coin change solution 
	 */
	public static int spaceOptimizedFindWays(int coins[], int total){
		int countsTable[] = new int[total + 1];
		countsTable[0] = 1;

		for(int i = 0; i < coins.length; i++){
			for(int j = coins[i]; j <= total; j++){
				countsTable[j] = countsTable[j] + countsTable[j - coins[i]];			//Number of ways so far + number of ways with i & j
			}
		}
		
		return countsTable[total];
	}
	
	public static void main(String[] args) {
		int coins[] = {1, 3, 4, 6}, total = 7;
		System.out.println("Nuber of ways to get total " + total + " with coins " + Arrays.toString(coins) + " is "+ findWays(coins, total));
		System.out.println("Nuber of ways to get total " + total + " with coins " + Arrays.toString(coins) + " is "+ spaceOptimizedFindWays(coins, total));
		
		coins = new int[]{1, 2, 3, 4}; total = 8;
		System.out.println("Nuber of ways to get total " + total + " with coins " + Arrays.toString(coins) + " is "+ findWays(coins, total));
		System.out.println("Nuber of ways to get total " + total + " with coins " + Arrays.toString(coins) + " is "+ spaceOptimizedFindWays(coins, total));
	}
}
