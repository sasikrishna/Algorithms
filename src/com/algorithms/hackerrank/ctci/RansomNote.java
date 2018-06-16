package com.algorithms.hackerrank.ctci;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author Sasi Jolla on 13-Jun-2018, 8:49:53 pm
 */
public class RansomNote {
	
	private static final Scanner scanner = new Scanner(System.in);
	
	// Complete the checkMagazine function below.
	static void checkMagazine(String[] magazine, String[] note) {
		Map<String, AtomicInteger> magazineWordFrequency = new HashMap<String, AtomicInteger>();
		
		/**
		 * Counting magazine word frequency
		 */
		for(String word : magazine){
			if(magazineWordFrequency.containsKey(word)){
				magazineWordFrequency.get(word).incrementAndGet();
				continue;
			}
			
			magazineWordFrequency.put(word, new AtomicInteger(1));
		}
		
		for(String word : note){
			if(!magazineWordFrequency.containsKey(word) || 
					magazineWordFrequency.get(word).intValue() == 0){
				System.out.println("No");
				return;
			}
			
			magazineWordFrequency.get(word).decrementAndGet();
		}
		System.out.println("Yes");
	}

	public static void main(String[] args) {
		String[] mn = scanner.nextLine().split(" ");

		int m = Integer.parseInt(mn[0]);
		int n = Integer.parseInt(mn[1]);

		String[] magazine = new String[m];
		String[] magazineItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		for (int i = 0; i < m; i++) {
			String magazineItem = magazineItems[i];
			magazine[i] = magazineItem;
		}

		String[] note = new String[n];
		String[] noteItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		for (int i = 0; i < n; i++) {
			String noteItem = noteItems[i];
			note[i] = noteItem;
		}

		checkMagazine(magazine, note);
		scanner.close();
	}
}
