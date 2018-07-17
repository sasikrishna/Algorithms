package com.algorithms.stack;

/**
 * Problem statement: Reverse stack using recursion.
 * 
 * @author Sasi Jolla on 14-Jul-2018, 4:29:46 pm
 */
public class ReverseStack {

	static com.datastructures.linear.Stack<Integer> stack = 
			new com.datastructures.linear.Stack<Integer>();
	
	/**
	 * The idea is to recur till bottom of the stack by storing top elements call stack. 
	 * Once we reached bottom flip the elements before pushing into stack using insertAtBottom method.
	 */
	public static void reverse(){
		if(!stack.isEmpty()){
			Integer element = stack.pop();
			reverse();
			insertAtBottom(element);
		}
	}
	
	/**
	 * 
	 * @param element
	 */
	private static void insertAtBottom(int element){
		if(stack.isEmpty()){
			stack.push(element);
		}else{
			Integer tempEle = stack.pop();
			insertAtBottom(element);
			stack.push(tempEle);
		}
	}
	
	/**
	 * 
	 */
	private static void printStack(){
		while(!stack.isEmpty()){
			System.out.print(stack.pop() + " ");
		}
	}
	
	public static void main(String[] args) {
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		reverse();
		printStack();
	}
}
