package com.algorithms.stack;

import java.util.Stack;

/**
 * Problem statement: Design and implement special stack Data Structure that supports all the stack operations like push(), pop(), isEmpty(), isFull() and an additional operation getMin() which should 
 * return minimum element from the stack.
 * 
 * @author Sasi Jolla on 12-Jul-2018, 12:47:46 am
 */
public class MinStack {
	
	/**
	 * minWithTwoStacks uses two stacks to achieve getMin in O(1) time complexity. We are storing all min values in a separate stack.
	 * <br>
	 * Time complexity  : getMin() - O(1)<br>
	 * Space complexity : O(n) for other stack to store min values
 	 * @param elements
	 */
	public static void minWithTwoStacks(int elements[]){
		
		/**Stores all array elements*/
		Stack<Integer> stack1 = new Stack<Integer>();
		
		/**Stores only minimum elements*/
		Stack<Integer> stack2 = new Stack<Integer>();
		
		for(int i = 0; i < elements.length; i++){
			int current = elements[i];
			stack1.add(current);
			
			/**Adding current to stack2 if current is less than stack2 top*/
			if(stack2.size() == 0 || current < stack2.peek()){
				stack2.add(current);
			}else{
				stack2.add(stack2.peek());
			}
			System.out.println("Element " + current + " added to stack.");
		}
		
		while(stack1.size() > 0 && stack2.size() > 0){
			System.out.println("Popped element is " + stack1.pop() + ". "
					+ "Minimum element in stack is " + stack2.pop());
		}
	} 
	
	/**
	 * minWithSingleStack is an efficient approach for designing this data structure. O(1) space complexity can be achieved with this approach. 
	 * Basic idea is to store minimum value in a variable and it'll be updated based on certain conditions.
	 * <br>
	 * Time complexity  : getMin() - O(1)<br>
	 * Space complexity : O(1)
	 * @param elements
	 */
	public static void minWithSingleStack(int elements[]){
		
		/**Stores the least value from the entire array*/
		int minEle = elements[0];
		
		/**Stores all array elements*/
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(elements[0]);
		
		/**Adding elements into stack*/
		for(int i = 1; i < elements.length; i++){
			int current = elements[i];
			
			/**Adding current to stack if current is greater than minEle so far.*/
			if(current >= minEle){
				stack.add(current);
			}else{
				/**Adding (2 * current - minEle) value to stack if current is less than min so far.
				 * This will be helpful to calculate previous min when current min is popped from stack.*/
				stack.add(2 * (current) - minEle);
				minEle = current;
			}
			System.out.println("Element " + current + " added to stack.");
		}
		
		/**Popping elements*/
		while(stack.size() > 0){
			int current = stack.pop();
			if(current >= minEle){
				System.out.println("Popped element is " + current + ". "
						+ "Minimum element in stack is " + minEle);
			}else{
				System.out.println("Popped element is " + minEle + ". "
						+ "Minimum element in stack is " + ((2 * minEle) - current));
				
				/**Calculating the next min element in the array*/
				minEle = ((2 * minEle) - current);
			}
		}
	}

	public static void main(String[] args) {
		/**Calling MinStack approach 1*/
		minWithTwoStacks(new int[]{4, 3, 5, 2, 1, 0});
		
		/**Calling MinStack approach 2*/
		minWithSingleStack(new int[]{4, 3, 5, 2, 1, 0});
	}
}
