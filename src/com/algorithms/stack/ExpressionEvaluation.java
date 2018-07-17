package com.algorithms.stack;

import com.datastructures.linear.Stack;

/**
 * 
 * @author Sasi Jolla on 14-Jul-2018, 6:00:34 pm
 */
public class ExpressionEvaluation {
	
	/**
	 * 
	 * @param expression
	 * @return
	 * @throws Exception 
	 */
	public static int evaluate(String expression) throws Exception{
		
		Stack<Integer> operands = new Stack<Integer>();
		Stack<Character> operators = new Stack<Character>();
		char[] expressionChars = expression.toCharArray();
		
		for(int i = 0; i < expression.length(); i++){
			char ele = expressionChars[i];
			
			/**If element is space continue to next element*/
			if(ele == ' '){
				continue;
			}else if(ele == '('){
				operators.push(ele);
			}else if(ele == ')'){
				
				while(operators.peek() != '('){
					/**Evaluating sub expression*/
					int result = evaluate(operands.pop(), operands.pop(), operators.pop());
					
					/**Putting back calculated result to operands stack*/
					operands.push(result);
				}
				
				/**Pop close paranthesis*/
				operators.pop();
			}else if(ele >= '0' && ele <= '9'){
				StringBuffer intStr = new StringBuffer(ele + "");
				
				/**Iterating for more numbers. Possibility exists if given number is have multiple digits.*/
				while((i + 1) < expressionChars.length && expressionChars[i + 1] >= '0' 
					&& expressionChars[i + 1] <= '9'){
					intStr.append(expressionChars[i+1] + "");
					i++;
				}
				operands.push(Integer.parseInt(intStr.toString()));
			}else if(ele == '*' || ele == '/' || ele == '+' || ele == '-'){
				
				while(!operators.isEmpty() && precedence(ele, operators.peek())){
					/**Evaluating sub expression*/
					int result = evaluate(operands.pop(), operands.pop(), operators.pop());
					operands.push(result);
				}
				operators.push(ele);
			}
		}
		
		/**Expression has been parsed. Evaluating operands with leftover operators*/
		while (!operators.isEmpty()){
			int result = evaluate(operands.pop(), operands.pop(), operators.pop());
			operands.push(result);
		}
		
		return operands.pop();
	}
	
	/**
	 * 
	 * @param operand1
	 * @param operand2
	 * @param operator
	 * @return
	 * @throws Exception 
	 */
	private static int evaluate(int operand1, int operand2, char operator) throws Exception{
		switch (operator) {
			case '+':
				return operand1 + operand2;
			case '-':
				return operand1 - operand2;
			case '*':
				return operand1 * operand2;
			case '/':
				if(operand2 == 0){
					throw new Exception("Divided by zero error.");
				}
				return operand2 / operand1;
			default:
				return 0;
		}
	}
	
	/**
	 * @param operator1
	 * @param operator2
	 * @returns true if operator2 has greater precedence than operator1
	 */
	private static boolean precedence(char operator1, char operator2){
		
		if (operator2 == '(' || operator2 == ')'){
	            return false;
		}
		if(operator1 == '*' || operator1 == '/' 
				&& operator2 == '+' || operator2 == '-'){
			return false;
		}
		return true;
	} 
	
	public static void main(String[] args) throws Exception {
        System.out.println(evaluate("10 + 2 * 6"));
        System.out.println(evaluate("100 * 2 + 12"));
        System.out.println(evaluate("100 * ( 2 + 12 )"));
        System.out.println(evaluate("100 * ( 2 + 12 ) / 14"));
	}
}
