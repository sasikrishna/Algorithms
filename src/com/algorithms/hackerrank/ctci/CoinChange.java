package com.algorithms.hackerrank.ctci;

import java.util.Scanner;

/**
 * 
 * @author Sasi Jolla on 17-Jun-2018, 1:56:56 am
 */
public class CoinChange {
	
	// Complete the ways function below.
    static long ways(int n, int[] coins) {
    	long[][] coinChangeTable = new long[coins.length + 1][n + 1];
    	
    	for(int i = 0; i <= coins.length; i++){
    		coinChangeTable[i][0] = 1;
    	}
    	
    	for(int i = 1; i <= coins.length; i++){
    		for(int j = 1; j <= n; j++){
    			if(coins[i - 1] > j){
    				coinChangeTable[i][j] = coinChangeTable[i - 1][j]; 
    			}else{
    				coinChangeTable[i][j] = coinChangeTable[i - 1][j] + coinChangeTable[i][j - coins[i - 1]];
    			}
    		}
    	}
    	
    	return coinChangeTable[coins.length][n];
    }

    private static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {

		String[] nm = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nm[0]);

		int m = Integer.parseInt(nm[1]);

		int[] coins = new int[m];

		String[] coinsItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < m; i++) {
			int coinsItem = Integer.parseInt(coinsItems[i]);
			coins[i] = coinsItem;
		}

		long res = ways(n, coins);
		System.out.println(res);
		scanner.close();
	}
}
