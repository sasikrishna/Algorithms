package com.algorithms.queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Problem statement: Given a stream of characters and we have to find first non repeating character each time a character is inserted to the stream. 
 * 
 * @author Sasi Jolla on 19-Jul-2018, 11:22:54 pm
 */
public class FirstNonRepeatingChar {

	/**
	 * Queue based approach for first non-repeating character in a stream.
	 * 
	 * Time complexity: O(n)
	 * Space complexity: O(n)
	 * 
	 * @param stream
	 */
	public static void findFirstNonRepeatingCharacter(char[] stream){
		/**Stores elements in the order they read from stream*/
		Queue<Character> queue = new LinkedList<Character>();
		
		/**Stores frequency of every character appreared in stream*/
		Map<Character, AtomicInteger> frequencies = new HashMap<Character, AtomicInteger>();
		
		/**Iterating over every character in stream*/
		for(Character character : stream){
			
			/**Adding every char to stream*/
			queue.add(character);
			
			/**If character appearing for first time initializing with 0 in counter*/
			if(!frequencies.containsKey(character)){
				frequencies.put(character, new AtomicInteger(0));
			}
			
			/**Incrementing frequency of current character*/
			frequencies.get(character).getAndIncrement();
			
			while(!queue.isEmpty()){
				
				/**If front of queue frequency is greater than 1 then it is repeating so dequeuing untill character with frequency 1 is found.*/
				if(frequencies.get(queue.peek()).intValue() != 1){
					queue.poll();
				}else{
					System.out.print(queue.peek() + " ");
					break;
				}
			}
			
			 if(queue.isEmpty()){
                 System.out.print("-1 ");
			 }
		}
	}
	
	public static void main(String[] args) {
		findFirstNonRepeatingCharacter("aabc".toCharArray());
		System.out.println();
		findFirstNonRepeatingCharacter("geeksforgeeks".toCharArray());
	}
}
