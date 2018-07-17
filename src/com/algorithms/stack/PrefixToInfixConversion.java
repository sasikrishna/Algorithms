package com.algorithms.stack;

import java.util.Stack;

/**
 * Problem statement: Convert given prefix expression into infix expression.
 * 
 * @author Sasi Jolla on 13-Jul-2018, 12:03:15 am
 */
public class PrefixToInfixConversion {
	
	/**
	 * The idea is to scan the string in reverse order and push every operand to stack. If the scanned character is operator then pop two operands from stack, 
	 * concat them with operator in middle and put it back in the stack. 
	 * 
	 * @param expression
	 * @return
	 */
	public static String convertToInfix(String expression){
		
		/**Reversing the expression to find infix expression.*/
		expression = new StringBuffer(expression.toLowerCase()).reverse().toString();
		java.util.Stack<String> stack = new Stack<String>();
		
		for(int i = 0; i < expression.length(); i++){
			Character character = expression.charAt(i);
			
			if(StackUtils.isOperand(character)){
				stack.push(character.toString());
			}
			else{
				StringBuffer expr = new StringBuffer();
				expr.append("(").append(stack.pop()).append(character).append(stack.pop()).append(")");
				stack.push(expr.toString());
			}
		}
		
		return stack.pop();
	}
	
	public static void main(String[] args) {
		String infixExpression = "+a-*b^-^cde+f*ghi";
		System.out.println(convertToInfix(infixExpression));
	}
}
