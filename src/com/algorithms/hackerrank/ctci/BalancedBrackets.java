package com.algorithms.hackerrank.ctci;

import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * @author Sasi Jolla on 13-Jun-2018, 10:04:25 pm
 */
public class BalancedBrackets {
	
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void isBalanced(String expression){
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < expression.length(); i++){
			char bracket = expression.charAt(i);
			switch(bracket){
				case '{':
				case '[':
				case '(':
					stack.push(bracket);
					break;
				default:
					switch(bracket) {
						case '}':
							if(stack.size() == 0 || stack.pop() != '{'){
								System.out.println("NO");
								return;
							}
							break;
						case ']':
							if(stack.size() == 0 || stack.pop() != '['){
								System.out.println("NO");
								return;
							}
							break;
						case ')':
							if(stack.size() == 0 || stack.pop() != '('){
								System.out.println("NO");
								return;
							}
							break;
					}
					break;
			}
		}
		if(stack.isEmpty()){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
	}
	
	public static void main(String[] args) {
		int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for(int tItr = 0; tItr < t; tItr++) {
            String expression = scanner.nextLine();
            isBalanced(expression);
        }

        scanner.close();
	}
}
