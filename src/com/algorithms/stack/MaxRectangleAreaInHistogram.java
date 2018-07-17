package com.algorithms.stack;

/**
 * Problem statement: Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number of contiguous bars.
 * 
 * @author Sasi Jolla on 16-Jul-2018, 11:15:36 pm
 */
public class MaxRectangleAreaInHistogram {
	
	/**
	 * 
	 * @param columns
	 */
	public static int maxArea(int columns[]){
		java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
		int maxArea = Integer.MIN_VALUE, index = 0;
		
		/**Iterating through every column*/
		while(index < columns.length){
			
			/**Every column will be added to stack if stack is empty or current column is greater or equal to top. 
			 * Finding area for these stacked columns will give the max area.*/
			if(stack.isEmpty() || columns[index] >= columns[stack.peek()]){
				/**Index will be increased only if a column is added to stack*/
				stack.push(index++);
			}else{
				/**Current column is less than top so pop from stack and find area for top column*/
				int top = stack.pop();
				int currMax = columns[top] * (stack.empty() ? index : (index - 1 - stack.peek()));
				
				if(maxArea < currMax){
					maxArea = currMax;
				}
			}
		}
		
		return maxArea;
	}
	
	public static void main(String[] args) {
		System.out.println(maxArea(new int[]{6, 2, 5, 4, 5, 1, 6}));
		System.out.println(maxArea(new int[]{6, 2, 5, 4, 1, 4}));
	}
}
