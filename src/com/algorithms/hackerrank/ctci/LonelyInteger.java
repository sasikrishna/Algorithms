package com.algorithms.hackerrank.ctci;

import java.util.Scanner;

/**
 * 
 * @author Sasi Jolla on 17-Jun-2018, 1:02:09 am
 */
public class LonelyInteger {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] a = new int[n];

		String[] aItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int aItem = Integer.parseInt(aItems[i]);
			a[i] = aItem;
		}
		
		int value = 0;
		for (int i : a) {
	        value ^= i;
	    }
	    System.out.println(value);
	    
		scanner.close();
	}
}
