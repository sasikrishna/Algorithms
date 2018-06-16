package com.algorithms.hackerrank.ctci;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * @author Sasi Jolla on 16-Jun-2018, 11:22:13 pm
 */
public class RecursiveStaircase {

	private static final Scanner scanner = new Scanner(System.in);
	
	static Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
	
	// Complete the stepPerms function below.
	public static int stepPerms(int n) {
		
		if(cache.containsKey(n)){
			return cache.get(n);
		}
		
		int count = stepPerms(1, n - 1) + stepPerms(2, n - 2) + stepPerms(3, n - 3);
		cache.put(n, count);
		
		return count;
    }
	
	public static int stepPerms(int step, int stairsLeft) {
		System.out.println(step + " " + stairsLeft);
		
		if(stairsLeft < 0){
			return 0;
		}
		
		if(stairsLeft == 0){
			return 1;
		}
		
		return stepPerms(stairsLeft);
	}

    public static void main(String[] args) throws IOException {

        int s = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int sItr = 0; sItr < s; sItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int res = stepPerms(n);
            System.out.println(res);
        }

        scanner.close();
    }

}
