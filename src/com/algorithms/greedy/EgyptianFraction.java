package com.algorithms.greedy;

/**
 * Problem statement: Find sum of unique unit fractions for a given fractional number. Unit fraction means numenator is 1 and denominator is a +ve integer.
 * 
 * E.g: 6/14 = 1/3 + 1/11 + 1/231 
 * 
 * @author Sasi on 02-Jun-2018, 1:12:10 pm
 */
public class EgyptianFraction {
	
	public static void findUniqueFractions(int nr, int dr){
		
		if(nr == 0 || dr == 0){
			return;
		}
		
		if(dr % nr == 0){
			System.out.print(" 1/" + dr / nr);
			return;
		}
		
		if(nr % dr == 0){
			System.out.println("Not a fraction");
			return;
		}
		
		if(nr > dr){
			System.out.print(" " + (nr > dr));
			return;
		}
		
		int invertedDenominator = dr / nr + 1;					//Finding ceiling
		System.out.print(" 1/" + invertedDenominator);
		
		findUniqueFractions(nr * invertedDenominator - dr, dr * invertedDenominator);
	}
	
	public static void main(String[] args) {
		EgyptianFraction.findUniqueFractions(6, 14);
	}
}
