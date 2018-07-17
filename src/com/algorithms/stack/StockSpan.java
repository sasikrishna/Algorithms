package com.algorithms.stack;

import java.util.Arrays;

/**
 * Problem statement: The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate span of stock’s price for all n days.
 * 
 * @author Sasi Jolla on 14-Jul-2018, 11:00:51 am
 */
public class StockSpan {
	
	/**
	 * The idea is to calculate number of days before the current day having price less than the current day's price.
	 *  
	 * @param prices
	 * @param days
	 * @return span array
	 */
	public static int[] findSpan(int[] prices, int days){
		int[] span = new int[prices.length];
		
		/**Auxillary data structure to store day index*/
		com.datastructures.linear.Stack<Integer> stack = new com.datastructures.linear.Stack<Integer>();
		
		/**Span for 1 day is one*/
		span[0] = 1;
		
		/**Iterating through every day's price*/
		for(int i = 0; i < days; i++){
			
			/**Finding a past day whose price is greater than current day price*/
			while(!stack.isEmpty() && prices[i] >= prices[stack.peek()]){
				stack.pop();
			}
			
			/**If stack is empty that mean all past days have prices less than current day so span is current day's index else difference of days between current day index and stack top.*/
			span[i] = stack.isEmpty() ? (i + 1) : i - stack.peek();
			
			/**Pushing current day index for future days span calculation*/
			stack.push(i);
		}
		
		return span;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int prices[] = {100, 80, 60, 70, 60, 75, 85};
		System.out.println(Arrays.toString(findSpan(prices, 7)));
	}	
}
