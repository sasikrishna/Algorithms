package com.algorithms.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * <code>FiniteAutomataSearch</code> class represents implementation of finite state automata for finding pattern occurences in a given text.<br>
 * First we'll construct finite automata transition table for given pattern and then we'll iterate through each character in text try to navigate through<br>
 * transisition table. If we are able reach end state then we can confirm that pattern has occurences in text.  
 * 
 * @author Sasi on 20-May-2018, 10:39:59 pm
 */
public class FiniteAutomataSearch {
	private int[][] faTransitionTable;
	private List<Character> uniqueList;
	
	public void search(String text, String pattern) throws Exception{
		
		if(null == pattern || null == text){
			throw new Exception("Text and/or pattern are/is missing.");
		}
		
		constructFA(pattern);
		
		//Iterating through text and we'll verify through transition table if pattern exists in text or not.
		int faState = 0;
		for(int i=0; i<text.length(); i++){
			int charIndex = uniqueList.indexOf(text.charAt(i));
			
			if(charIndex == -1){
				faState = 0;
				continue;
			}
			
			faState = faTransitionTable[faState][charIndex];
			if(faState == pattern.length()){
				System.out.println(pattern + " pattern found in " + text + " at " + (i-pattern.length()+1));
				faState = 0;
			}
		}
	}
	
	private void constructFA(String pattern){
		
		//Getting unique characters from pattern
		uniqueList = new ArrayList<Character>();
		for(int i=0; i<pattern.length(); i++){
			
			//We can use Set to maintain uniqueness but we'll use this later to build transition table for which we need the order
			if(!uniqueList.contains(pattern.charAt(i)))
				uniqueList.add(pattern.charAt(i));
		}
		
		//Appending end of pattern character
		pattern = pattern.concat("$");
				
		faTransitionTable = new int[pattern.length()+1][uniqueList.size()];
		
		//Iterating through pattern and building transition table for each character
		for(int i=0; i<pattern.length(); i++){
			for(int j=0; j<uniqueList.size(); j++){
				
				//Putting index (i+1) value into table if character at index i and j are same
				if(pattern.charAt(i) == uniqueList.get(j)){
					faTransitionTable[i][j] = i+1;
					continue;
				}
				
				//Calculating length of prefix which is also suffix to pattern that has been processed so far
				if(i == 0){
					faTransitionTable[i][j] = 0;
				}else{
					faTransitionTable[i][j] = calculateLPS(pattern.substring(0, i) + uniqueList.get(j));
				}
			}
		}
		
		//Priting transistion table
		for(int i=0; i<pattern.length(); i++){
			for(int j=0; j<uniqueList.size(); j++){
				System.out.print(faTransitionTable[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * 
	 * @param pattern
	 * @returns length of prefix which is also a suffix to given pattern
	 */
	private int calculateLPS(String pattern) {
		String leftDistr = pattern.substring(0, pattern.length()-1),
				rightDistr = pattern.substring(1, pattern.length());
		
		while(true){
			if(leftDistr.equals(rightDistr)){
				return rightDistr.length();
			}
			
			if(leftDistr.length() == 0 || rightDistr.length() == 0){
				return 0;
			}
			
			leftDistr = leftDistr.substring(0, leftDistr.length()-1);
			rightDistr = rightDistr.substring(1, rightDistr.length());
		}
	}
	
	public static void main(String[] args) throws Exception {
		FiniteAutomataSearch fas = new FiniteAutomataSearch();
		fas.search("AABAACAADAABAAABAA", "AABA");
	}
}
