package com.algorithms.dp;

import java.util.Arrays;

/**
 * Problem statement: Find maximum profit can be made by cutting and selling rod at various lengths. Each length will have its own value. 
 * <br><br>
 * Test case:
 * <br>
 * Input: pricing = {5, 8, 17, 22, 25}, length = {1, 2, 3, 4, 5}
 * <br>
 * Output: 27
 * <br>
 * @author Sasi on 09-Jun-2018, 5:40:34 pm
 */
public class CuttingRod {
	
	public static int getMaxPricing(int rodLength, int pricing[]){
		
		int pricingTable[][] = new int[rodLength + 1][rodLength + 1];
		
		for(int i = 1; i <= rodLength; i++){
			for(int j = 1; j <= rodLength; j++){
				
				if(i > j){									//Checking if with current length, is it possible to gain max value
					pricingTable[i][j] = pricingTable[i - 1][j];	//Since with current length we cannot cut rod, so copying last length cut value
					continue;
				}
				
				pricingTable[i][j] = Math.max(pricingTable[i - 1][j], pricing[i - 1] + pricingTable[i][j - i]);
			}
		}
		
		int i = rodLength, j = rodLength;
		StringBuffer cuts = new StringBuffer(); 
		while(i > 0 && j > 0){
			if(pricingTable[i][j] == pricingTable[i - 1][j]){
				i--;
			}else{
				cuts.append(i);
				j = j - i;
			}
		}
		System.out.println("Cutting order is: " + cuts);
		return pricingTable[rodLength][rodLength];
	}
	
	public static void main(String[] args) {
		int pricing[] = {5, 8, 17, 22, 25};
		System.out.println("Max profit can make with pricings " + Arrays.toString(pricing) + " is "+ getMaxPricing(pricing.length, pricing));
	}
}
