package com.algorithms.hackerrank.ctci;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * @author Sasi Jolla on 16-Jun-2018, 4:06:06 pm
 */
public class HashTablesIceCreamParlour {

    private static final Scanner scanner = new Scanner(System.in);
	
	// Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
    	 
    	/**
    	 * Building a hash table with key as price and value as index
    	 */
    	Map<Integer, Integer> costsMap = new HashMap<Integer, Integer>();
    	for(int i = 0; i < cost.length; i++){
    		costsMap.put(cost[i], i);
    	}
    	
    	for(int i = 0; i < cost.length; i++){
    		int leftOver = money - cost[i];
    		if(costsMap.containsKey(leftOver)){
    			int j = costsMap.get(leftOver);
    			if(i > j){
    				System.out.println((j + 1) + " " + (i + 1));
    				return;
    			}else{
    				System.out.println((i + 1) + " " + (j + 1));
    				return;
    			}
    		}
    	}
    }

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}
