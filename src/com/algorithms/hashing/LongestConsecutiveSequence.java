package com.algorithms.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem statement: Given an array of integers, find the length of the longest
 * sub-sequence such that elements in the subsequence are consecutive integers,
 * the consecutive numbers can be in any order.
 * 
 * @author Sasi Jolla on 14-Aug-2018, 11:48:13 pm
 */
public class LongestConsecutiveSequence {

	/**
	 * 
	 * @param array
	 */
	public static int length(int array[]) {
		Set<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < array.length; i++) {
			set.add(array[i]);
		}

		int maxLength = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			int currentEle = array[i];
			if (!set.contains(currentEle - 1)) {
				while (set.contains(currentEle)) {
					currentEle++;
				}

				if (maxLength < currentEle - array[i]) {
					maxLength = currentEle - array[i];
				}
			}
		}

		return maxLength;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int array[] = { 1, 9, 3, 10, 4, 20, 2 };
		System.out.println("Length of the Longest consecutive subsequence is " + length(array));
	}
}
