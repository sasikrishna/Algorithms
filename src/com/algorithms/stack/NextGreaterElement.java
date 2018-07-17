package com.algorithms.stack;

/**
 * Problem statement: Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x is the first greater element on the right side of x in array. Elements for which no greater element exist, consider next greater element as -1.
 * 
 * @author Sasi Jolla on 14-Jul-2018, 11:59:42 am
 */
public class NextGreaterElement {
	
	/**
	 * The idea is to store curr element in stack and running loop from next element. If next element is greater than current from stack the print pair. 
	 * Else add nge to stack which can be a NGE for rest of elements.
	 * 
	 * @param array
	 */
	public static void printNGE(int[] array){
		
		/**Auxillary data structure to store the current element*/
		com.datastructures.linear.Stack<Integer> stack = new com.datastructures.linear.Stack<Integer>();
		stack.push(array[0]);
		
		for(int i = 1; i < array.length; i++){
			
			/**NGE represents the next greater element for indexes prior to i.*/
			int nge = array[i];
			if(!stack.isEmpty()){
				
				/**Getting previous indices values*/
				int currentElement = stack.pop();
				
				/**Checking if index i-1, i-2... are less than i*/
				while(currentElement < nge){
					System.out.println(currentElement + "'s next greater element is " + nge);
					if(stack.isEmpty()){
						break;
					}
					currentElement = stack.pop();
				}
				
				/**If index at i-1 is not less than current element push back current element into stack. This is needed to print -1 at the end.*/
				if(currentElement > nge){
					stack.push(currentElement);
				}
			}
			stack.push(nge);
		}
		
		/**Left over elements in stack have no NGE. So printing -1 for them*/
		while(!stack.isEmpty()){
			System.out.println(stack.pop() + "'s next greater element is " + -1);
		}
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		 int array[] = {11, 13, 21, 3};
		 printNGE(array);
		 
		 array = new int[]{13, 7, 6, 12};
		 printNGE(array);
	}
}
