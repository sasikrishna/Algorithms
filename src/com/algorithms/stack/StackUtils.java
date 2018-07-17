package com.algorithms.stack;

/**
 * @author Sasi Jolla on 12-Jul-2018, 11:08:07 pm
 */
public class StackUtils {
	
	/**
	 * @param operator
	 * @returns operator precedence. Greater operator higher precedence.
	 */
	static int getPrecedence(Character operator){
		switch (operator)
        {
	        case '+':
	        case '-':
	            return 1;
	        case '*':
	        case '/':
	            return 2;
	        case '^':
	            return 3;
        }
        return -1;
	}
	
	/**
	 * @param operator
	 * @returns operator precedence. Greater operator higher precedence.
	 */
	static boolean isOperand(Character element){
		/**Checking if current is either a number or character*/
		return ((element > 47 && element < 58) || (element > 96 && element < 113));
	}
}
