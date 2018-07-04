package com.algorithms.dp.hard;

/**
 * Problem statement: Find binomial coefficient for the given parameters i.e find coefficient of X^k in the equation (1 + X)^n where n and k are input params.<br>
 * In short we need to find value of nCr or n choose r. 
 * <br><br>
 * Test case:
 * <br>
 * Input: n = 4, k = 2
 * <br>
 * Output: 6 - coefficient of X^2 in (1 + X)^4 equation
 * <br>
 * @author Sasi on 03-Jun-2018, 7:46:48 pm
 */
public class BinomialCoefficient {
	
	public static int findCoefficient(int n, int k){
		
		if(k == 0 || k == n){
			return 1;
		}
		
		return findCoefficient(n-1, k) + findCoefficient(n-1, k-1); 
	}
	
	public static void main(String[] args) {
		System.out.println("Binomial coefficient of C(4, 2) is " + findCoefficient(4, 2));
		System.out.println("Binomial coefficient of C(5, 2) is " +findCoefficient(5, 2));
	}
}
