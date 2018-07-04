package com.algorithms.dp.easy;

/**
 *
 * @author Sasi Jolla on 23-Jun-2018, 11:48:23 am
 */
public class MaxAverageValue {

	public static float findMaxAverageValue(int cost[][]){
		
		int length = cost.length, dp[][] = new int[length][length];
		dp[0][0] = cost[0][0];
		
		for(int i = 1; i < length; i++){
			dp[0][i] = dp[0][i - 1] + cost[0][i];
		}
		
		for(int j = 1; j < length; j++){
			dp[j][0] = dp[j - 1][0] + cost[j][0];
		}
		
		for(int i = 1; i < length; i++){
			for(int j = 1; j < length; j++){
				dp[i][j] = Math.max(cost[i][j] + dp[i - 1][j], cost[i][j] + dp[i][j - 1]);
			}
		}
		
		return (float) ((dp[length - 1][length - 1])/(2.0 * length - 1));
	}
	
	public static void main(String[] args) {
		int cost[][] = { {1, 2, 3},{6, 5, 4},{7, 3, 9}};
		System.out.println("Max average value is " + findMaxAverageValue(cost));
	}
}

