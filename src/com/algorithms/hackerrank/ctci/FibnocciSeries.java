package com.algorithms.hackerrank.ctci;

import java.util.Scanner;

/**
 * 
 * @author Sasi Jolla on 16-Jun-2018, 10:04:22 pm
 */
public class FibnocciSeries {

	public static int fibonacci(int n) {
		int a = 0, b =1, c = 0;
		
		for(int i = 2; i <= n; i++){
			c = a + b;
			a = b;
			b = c;
		}
		
		return c;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();
		System.out.println(fibonacci(n));
	}
}
