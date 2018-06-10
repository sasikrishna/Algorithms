package com.algorithms.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author Sasi Jolla on 09-Jun-2018, 11:05:34 pm
 */
public class WordBreak {

	Set<String> dictionary =  new HashSet<String>(){
		private static final long serialVersionUID = 1L;
	{
		add("i");
		add("am");
		add("coder");
	}};
	
	public Boolean isStringCanBeSegmented(String sentence){
		
		int sentenceLength = sentence.length();
		List<Integer> splitPointsList = new ArrayList<Integer>();
		
		boolean words[][] = new boolean[sentenceLength][sentenceLength];
		
		for(int i = 0; i < sentenceLength; i++){
			words[i][i] = dictionaryContains(sentence.substring(i, i + 1));
		}
		
		for(int diagonal = 1; diagonal <= sentenceLength; diagonal++){
			for(int row = 0; row < sentenceLength - diagonal + 1; row++){
				int column = row + diagonal - 1;
				if(column >= sentenceLength){
					continue;
				}
				
				if(dictionaryContains(sentence.substring(row, column + 1))){
					//System.out.println(sentence.substring(row, column + 1));
					splitPointsList.add(row);
					words[row][column] = true;
				}else{
					for(int splitPoint = row; splitPoint <= column; splitPoint++){
						if(words[row][splitPoint] && 
								words[splitPoint + 1][column]){
							words[row][column] = true;
							break;
						}
					}
				}
			}
		}
		
		return words[0][sentenceLength -1];
	}
	
	private boolean dictionaryContains(String word){
		return null == word ? false : dictionary.contains(word);
	}
	
	public static void main(String[] args) {
		WordBreak wb = new WordBreak();
		System.out.println("Is iamcoder can be segmented? " + wb.isStringCanBeSegmented("iamcoder"));
	}
}
