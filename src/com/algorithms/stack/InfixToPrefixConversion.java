package com.algorithms.stack;

import java.util.Stack;


/**
 *  Problem statement: Convert an infix expression into prefix expression
 *  
 * @author Sasi Jolla on 12-Jul-2018, 11:03:35 pm
 */
public class InfixToPrefixConversion {
	
	/**
	 * The idea is to reverse the expression and calculate the postfix expression.
	 * Reversing the postfix expression gives prefix expression.
	 * 
	 * @param expression
	 * @return 
	 * @throws Exception 
	 */
	public static String convertToPrefix(String expression) throws Exception{
		
		/**Reversing the expression to find postfix expression.*/
		expression = new StringBuffer(expression).reverse().toString();
		StringBuffer postfixExpr = new StringBuffer();
		java.util.Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i < expression.length(); i++){
			Character character = expression.charAt(i);
			
			/**Checking if character is an operand. If so write it to string and continue to next*/
			if(StackUtils.isOperand(character)){
				postfixExpr.append(character);
				continue;
			}
			
			if(stack.isEmpty()){
				stack.push(character);
				continue;
			}
			
			/**Because this is reversed expression considering ')' as open brace*/
			if(character == ')'){
				stack.push(character);
				continue;
			}
			
			if(character == '('){
				while(!stack.isEmpty() && stack.peek() != ')'){
					postfixExpr.append(stack.pop());
				}
				
				if(!stack.isEmpty() && stack.peek() != ')'){
					throw new Exception("Invalid expression.");
				}else{
					stack.pop();
				}
				continue;
			}
			
			int precedence = StackUtils.getPrecedence(character);
			if(precedence > StackUtils.getPrecedence(stack.peek())){
				stack.push(character);
			}else{
				while(!stack.isEmpty() && precedence <= StackUtils.getPrecedence(stack.peek())){
					postfixExpr.append(stack.pop());
				}
				stack.push(character);
			}
		}
		
		while(!stack.isEmpty()){
			postfixExpr.append(stack.pop());
		}
		
		/**To get the prefix expression reverse the postfix expression*/
		return new StringBuffer(postfixExpr).reverse().toString();
	}
	
	/**
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(convertToPrefix(exp));
	}
}
