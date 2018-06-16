package com.algorithms.hackerrank.ctci;

import java.io.IOException;
import java.util.Scanner;

/**
 * Problem statement: Given an array of n integers and a number rotation to perform left rotations on the array. Return the updated array to be printed as a single line of space-separated integers.
 * 
 * 
 * @author Sasi Jolla on 11-Jun-2018, 10:39:47 pm
 */
public class ArrayRotation {
	
	private static final Scanner scanner = new Scanner(System.in);
	
	/**
	 * 
	 * @param array
	 * @param rotations
	 * @return
	 * @author sasi on 11-Jun-2018, 10:41:31 pm
	 */
    public static int[] rotLeft(int[] array, int rotations) {
    	
    	int arrayLength = array.length;
    	int rotatedArray[] = new int[arrayLength];
    	
    	for(int i = 0; i < arrayLength; i++){
    		int newIndex = i - rotations;
    		if(newIndex < 0){
    			newIndex = arrayLength + newIndex;
    		}
    		rotatedArray[newIndex] = array[i];
    	}
    	
		return rotatedArray;
    }

    public static void main(String[] args) throws IOException {

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);
        int d = Integer.parseInt(nd[1]);
        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);
        for (int i = 0; i < result.length; i++) {
        	System.out.print(String.valueOf(result[i]));

            if (i != result.length - 1) {
            	System.out.println(" ");
            }
        }

        scanner.close();
    }
}
