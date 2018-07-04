package com.algorithms.hackerrank.ctci;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 
 * @author Sasi on 15-Jun-2018, 6:33:33 pm
 */
public class RunningMedian {
	
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];
        PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>(1000, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>();
        
        for (int i = 0; i < n; i++) {
            int aItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            a[i] = aItem;
        }
        scanner.close();
        
        for (int i = 0; i < n; i++) {
            if(minQueue.isEmpty()){
            	minQueue.add(a[i]);
            }else{
            	if(minQueue.size() > maxQueue.size()){
            		if(minQueue.peek() > a[i]){
            			maxQueue.add(minQueue.poll());
            			minQueue.add(a[i]);
            		}else{
            			maxQueue.add(a[i]);
            		}
            	}else{
            		if(maxQueue.peek() != null && maxQueue.peek() > a[i]){
            			minQueue.add(a[i]);
            		}else{
            			minQueue.add(maxQueue.poll());
            			maxQueue.add(a[i]);
            		}
            	}
            }
            
            System.out.println(minQueue);
            System.out.println(maxQueue);
            int totalElements = minQueue.size() + maxQueue.size();
            if(totalElements % 2 == 0){
            	System.out.println(((minQueue.peek() + maxQueue.peek()) / 2.0f));
            }else{
            	System.out.println(new Float(minQueue.peek()));
            }
        }
	}
}
