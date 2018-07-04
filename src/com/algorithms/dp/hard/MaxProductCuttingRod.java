package com.algorithms.dp.hard;

/**
 * 
 * @author Sasi Jolla on 10-Jun-2018, 2:09:45 am
 */
public class MaxProductCuttingRod {

	/**
	 * DP solution which uses tabulation for saving sub problem solutions.
	 * 
	 * @param rodLength
	 * @return
	 */
	public static int getMaxProduct(int rodLength){
		int products[][] = new int[rodLength + 1][rodLength + 1];
		
		for(int i = 0; i <= rodLength; i++){
			for(int j = 0; j <= rodLength; j++){
				
				if(i == 0 || j == 0){
					products[i][j] = 1;
					continue;
				}
				
				if(i > j){
					products[i][j] = products[i - 1][j];
					continue;
				}
				
				products[i][j] = Math.max(products[i - 1][j], 
						i * products[i][j - i]);
			}
		}
		
		return products[rodLength][rodLength];
	}
	
	/**
	 *	Space optimized solution to return maximum product. The idea is to cut rod at interval 3. So we'll have more max cuts to get max product. 
	 * 
	 * @return
	 */
	public static int spaceOptimizedMaxProduct(int rodLength){
		
		if(rodLength == 2 || rodLength == 3){
			return rodLength;
		}
		
		int maxProduct = 1;
		while(rodLength > 4){
			
			rodLength -= 3;
			maxProduct *= 3;
		}
		
		return rodLength * maxProduct;
	}
	
	public static void main(String[] args) {
		System.out.println("Max product can be gained with rod of length 4 is " + getMaxProduct(4));
		System.out.println("Max product can be gained with rod of length 4 is " + spaceOptimizedMaxProduct(4));
		
		System.out.println("Max product can be gained with rod of length 10 is " + getMaxProduct(10));
		System.out.println("Max product can be gained with rod of length 10 is " + spaceOptimizedMaxProduct(10));
	}
}
