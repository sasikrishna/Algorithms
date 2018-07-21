package com.algorithms.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem statement: Given a number n, write a function that generates and prints all binary numbers with decimal values from 1 to n.
 * 
 * @author Sasi Jolla on 19-Jul-2018, 12:31:43 am
 */
public class GenerateBinaryNumbers {

	/**
	 * Generates binary numbers till given number.
	 * 
	 * Time complexity: O(n)
	 * Space complexity: O(n)
	 * @param number
	 */
	public static void generateBinaryNumbers(int number){
		Queue<String> queue = new LinkedList<String>();
		queue.add("1");
		
		for(int i = 0; i < number; i++){
			String first = queue.poll();
			System.out.println(first);
			queue.add(first + "0");
			queue.add(first + "1");
		}
	}
	
	public static void main(String[] args) {
		generateBinaryNumbers(5);
		generateBinaryNumbers(9);
	}
}
