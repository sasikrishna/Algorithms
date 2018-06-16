package com.algorithms.hackerrank.ctci;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Problem statement: 
 * 
 * @author Sasi Jolla on 12-Jun-2018, 11:45:23 pm
 */
public class MakingAnagrams {
	
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		String string1 = scanner.nextLine();
        String string2 = scanner.nextLine();
        
        /**
         * Making sure that string1 is always greater than string2
         */
        if(string2.length() > string1.length()){
        	String temp = string1;
        	string1 = string2;
        	string2 = temp;
        }
        
        /**
         * Thought of taking Set but strings may contain same literals also take couple of more instructions to calculate deletions.
         */
        Map<Character, AtomicInteger> charSet = new HashMap<Character, AtomicInteger>();
        
        for(int index = 0; index < string1.length(); index++){
        	Character eachChar = string1.charAt(index);
        	if(charSet.get(eachChar) == null){
        		charSet.put(eachChar, new AtomicInteger(1));
        		continue;
        	}
        	charSet.get(eachChar).incrementAndGet();
        }
        
        int deletionsCounter = 0;
        for(int index = 0; index < string2.length(); index++){
        	Character eachChar = string2.charAt(index);
        	if(charSet.get(eachChar) == null || charSet.get(eachChar).get() == 0){
        		deletionsCounter++;
        		continue;
        	}
        	
        	charSet.get(eachChar).decrementAndGet();
        }
        
        for(Entry<Character, AtomicInteger> entry : charSet.entrySet()){
        	deletionsCounter += entry.getValue().get();
        }
        System.out.println("Total deletion needed: " + deletionsCounter);
        scanner.close();
	}
}
