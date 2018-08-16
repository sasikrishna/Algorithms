package com.algorithms.hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Problem statement: Given an array of integers and a number k, write a function that returns true if given array can be divided into pairs such that sum of every pair is divisible by k. 
 * 
 * @author Sasi Jolla on 12-Aug-2018, 10:09:57 pm
 */
public class SumPairsExists {

	/**
	 * 
	 * @param array
	 */
	public static boolean isSumPairsExists(int[] array, int sum) {

		Map<Integer, AtomicInteger> remaindersFreq = new HashMap<Integer, AtomicInteger>();
		for (int i = 0; i < array.length; i++) {
			int rem = array[i] % sum;
			if (!remaindersFreq.containsKey(rem)) {
				remaindersFreq.put(rem, new AtomicInteger(0));
			}
			remaindersFreq.get(rem).getAndIncrement();
		}

		for (int i = 0; i < array.length; i++) {
			int rem = array[i] % sum;
			if (2 * rem == sum || rem == 0) {
				if (remaindersFreq.get(rem).intValue() % 2 == 1) {
					return false;
				}
			}
			else {
				if (remaindersFreq.get(sum - rem).intValue() != remaindersFreq.get(rem).intValue()) {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = { 92, 75, 65, 48, 45, 35 }, sum = 10;
        System.out.println("Sum pairs exists " + (isSumPairsExists(arr, sum) ? "Yes" : "No"));
	}
}
