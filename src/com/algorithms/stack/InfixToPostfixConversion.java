package com.algorithms.stack;

import java.util.Stack;

/**
 * Problem statement: Convert an infix expression into postfix expression
 * 
 * @author Sasi Jolla on 12-Jul-2018, 4:39:37 pm
 */
public class InfixToPostfixConversion {

	/**
	 * 
	 * @param expression
	 * @throws Exception 
	 */
	public static String convertToPostfix(String expression) throws Exception{
		expression = expression.toLowerCase();
		StringBuffer postfixExpr = new StringBuffer();
		java.util.Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i < expression.length(); i++){
			Character character = expression.charAt(i);
			
			/**Checking if character is an operand. If so write it to string and continue to next*/
			if(StackUtils.isOperand(character)){
				postfixExpr.append(character);
				continue;
			}
			
			/**Base case - add element to stack if stack is empty*/
			if(stack.isEmpty()){
				stack.add(character);
				continue;
			}
			
			/**Add to stack if current operator is open parenthesis*/
			if(character == '('){
				stack.add(character);
				continue;
			}
			
			/**Pop operators from stack and add them to string untill we find (*/
			if(character == ')'){
				while(!stack.isEmpty() && stack.peek() != '('){
					postfixExpr.append(stack.pop());
				}
				
				/**If stack is not empty and top is not open parenthesis then expr is invalid*/
				if(!stack.isEmpty() && stack.peek() != '('){
                   throw new Exception("Invalid expression");
				}
                else{
                	/**Pop for (*/
                    stack.pop();
                }
				
				continue;
			}
			
			int currentPrecedence = StackUtils.getPrecedence(character);
			
			/**Pushing operator to stack if its precedence if greater than stack top*/
			if(currentPrecedence > StackUtils.getPrecedence(stack.peek())){
				stack.add(character);
			}else{
				
				/**Popping operators from stack untill we find operator with precedence less than current operator*/
				while(!stack.isEmpty() && currentPrecedence <= StackUtils.getPrecedence(stack.peek())){
					postfixExpr.append(stack.pop());
				}
				stack.add(character);
			}
		}
		
		/**Scanning expression is completed. So adding left over operators to postfix expression.*/
		while(!stack.isEmpty()){
			postfixExpr.append(stack.pop());
		}
		
		return postfixExpr.toString();
	}
	
	/**
	 * 
	 * @param args
	 * @throws Exception - if given expression is invalid
	 */
	public static void main(String[] args) throws Exception {
		String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(convertToPostfix(exp));
	}
}
