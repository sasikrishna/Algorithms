package com.algorithms.stack;

import java.util.Stack;

/**
 * 
 * @author Sasi Jolla on 13-Jul-2018, 1:13:41 am
 */
public class PostFixToInfixConversion {

	/**
	 * The idea is to scan the string and push every operand to stack. If the scanned character is operator then pop two operands from stack, 
	 * concat them with operator in the middle and put it back in the stack.
	 * 
	 * @param expression
	 * @return
	 */
	public static String convertToInfix(String expression){

		java.util.Stack<String> stack = new Stack<String>();
		for(int i = 0; i < expression.length(); i++){
			Character character = expression.charAt(i);
			
			if(StackUtils.isOperand(character)){
				stack.push(character.toString());
			}
			else{
				StringBuffer expr = new StringBuffer();
				String operand2 = stack.pop(), operand1 = stack.pop();
				expr.append("(").append(operand1).append(character).append(operand2).append(")");
				stack.push(expr.toString());
			}
		}
		
		return stack.pop();
	}
	
	public static void main(String[] args) {
		String infixExpression = "ab*c+";
		System.out.println(convertToInfix(infixExpression));
	}
}
