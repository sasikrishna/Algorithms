package com.algorithms.arrays;

import java.util.Arrays;

/**
 * 
 * @author Sasi Jolla on 27-Jun-2018, 10:41:22 pm
 */
public class MaxProfitStockBuySell {
	
	/**
	 * 
	 * @param pricings
	 * @return
	 */
	public static int maxProfitWithSingleTransaction(int pricings[]){
		
		int minPricing = Integer.MAX_VALUE, profit = 0;
		for(int i = 0; i < pricings.length; i++){
			profit = Math.max(profit, pricings[i] - minPricing);
			minPricing = Math.min(minPricing, pricings[i]);
		}
		
		return profit;
	}
	
	/**
	 * 
	 * @return
	 */
	public static int maxProfitWithTwoTransactions(int pricings[]){
		
		int length = pricings.length;
		int maxPrice =  pricings[length - 1], profit[] = new int[length];
		for(int i = length - 2; i >= 0; i--){
			if(pricings[i] > maxPrice){
				maxPrice = pricings[i];
			}
			
			profit[i] = Math.max(profit[i + 1], maxPrice - pricings[i]);
		}

		int minPrice = pricings[0];
		for(int i = 1; i < length; i++){
			if(pricings[i] < minPrice){
				minPrice = pricings[i];
			}
			
			profit[i] = Math.max(profit[i - 1], profit[i] + (pricings[i] - minPrice));
		}
		return profit[length - 1];
	}
	
	public static void main(String[] args) {
		int[] pricings = {10, 22, 5, 75, 65, 80};
		System.out.println("Max profit with pricings " + Arrays.toString(pricings) + " is " + maxProfitWithSingleTransaction(pricings));
		System.out.println("Max profit for two transactions with pricings " + Arrays.toString(pricings) + " is " + maxProfitWithTwoTransactions(pricings));
	}
}
