package com.algorithms.dp.easy;

/**
 * 
 * @author Sasi Jolla on 22-Jun-2018, 4:33:43 am
 */
public class MaximumLengthSnake {
	
	public static int findMaxLength(int matrix[][]){
		
		int dp[][] = new int[matrix.length][matrix[0].length];
		int maxLength = 0;
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				if(i > 0){
					if(Math.abs(matrix[i][j] - matrix[i - 1][j]) == 1){
						dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + 1);
						maxLength = dp[i][j]; 
					}
				}
				
				if(j > 0){
					if(Math.abs(matrix[i][j] - matrix[i][j - 1]) == 1){
						dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + 1);
						maxLength = dp[i][j];
					}
				}
			}
		}
		
		return maxLength;
	}
	
	public static void main(String[] args) {
		System.out.println(findMaxLength(new int[][]{{1, 2, 3}, {4 , 5, 6}}));
		System.out.println(findMaxLength(new int[][]{{9, 6, 5, 2},{8, 7, 6, 5},{7, 3, 1, 6},{1, 1, 1, 7}}));
	}
}
