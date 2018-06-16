package com.algorithms.hackerrank.ctci;

import java.util.Scanner;

/**
 * 
 * @author Sasi Jolla on 16-Jun-2018, 7:41:00 pm
 */
public class Primality {

	private static final Scanner scanner = new Scanner(System.in);
	public static void isPrime(int n) {

		if (n == 1) {
			System.out.println("Not prime");
			return;
		}

		if (n == 2 || n == 3 || n == 5) {
			System.out.println("Prime");
			return;
		}

		int max = (int) Math.sqrt(n);
		for (int i = 2; i <= max; i++) {
			if (n % i == 0) {
				System.out.println("Not prime");
				return;
			}
		}

		System.out.println("Prime");
	}

	public static void main(String[] args) {
		int p = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int pItr = 0; pItr < p; pItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			isPrime(n);
		}

		scanner.close();
	}
}
