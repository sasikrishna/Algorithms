package com.algorithms.stack;

/**
 * 
 * @author Sasi Jolla on 14-Jul-2018, 1:54:39 pm
 */
public class NumberOfNGEs {
	
	/**
	 * 
	 * @param array
	 * @param index
	 */
	public static int printNumberOfNGE(int[] array, int index){
		
		/**Auxillary data structure to store the current element*/
		com.datastructures.linear.Stack<Integer> stack = new com.datastructures.linear.Stack<Integer>();
		stack.push(array[index]);
		
		int ngesCount = 0;
		for(int i = index + 1; i < array.length; i++){
			int nge = array[i];
			
			if(!stack.isEmpty()){
				int currentEle = stack.peek();
				if(nge > currentEle){
					ngesCount++;
					stack.pop();
				}
			}
			
			stack.push(nge);
		}
		
		return ngesCount;
	}
	
	public static void main(String[] args) {
		int array[] = {3, 4, 2, 7, 5, 8, 10, 6};
		System.out.println("Number of next greater elements from index 0 is " + printNumberOfNGE(array, 0));
		System.out.println("Number of next greater elements from index 5 is " + printNumberOfNGE(array, 5));
	}
}
