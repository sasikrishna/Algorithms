package com.algorithms.hackerrank.ctci;

import java.util.Scanner;

/**
 * 
 * @author Sasi Jolla on 16-Jun-2018, 12:20:39 pm
 */
public class CountBubbleSortInversions {

	private static final Scanner scanner = new Scanner(System.in);
	
	// Complete the countSwaps function below.
    static void countSwaps(int[] a) {
        int inversions = 0;
        for(int i = 0; i < a.length - 1; i++){
            for(int j = i + 1; j < a.length; j++){
                if(a[i] > a[j]){
                    a[i] = a[i] + a[j];
                    a[j] = a[i] - a[j];
                    a[i] = a[i] - a[j];
                    inversions++;
                }
            }
        }
        System.out.println("Array is sorted in " + inversions + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length - 1]);
    }

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

        countSwaps(a);
        scanner.close();
    }
}
