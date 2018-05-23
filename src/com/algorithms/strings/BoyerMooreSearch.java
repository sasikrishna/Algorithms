package com.algorithms.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * <code>BoyerMooreSearch</code> class represents implementation Boyer Moore pattern search algorithm. For pattern matching we are using bad character rule.<br>
 * Below is the bad character/heuristic rule<br>
 * 	 Let's say there is a mismatch at index i and index j in text and pattern respectively. First we'll check if there is a character in <br>
 *   pattern which equals to text[i]. If so we'll align that character index in pattern with text[i] and start checking again otherwise we'll add patternLength to textIndex to move past.
 * 
 * @author Sasi on 22-May-2018, 8:48:43 am
 */
public class BoyerMooreSearch {
	
	public static void search(String text, String pattern) throws Exception{
		if(null == pattern || null == text){
			throw new Exception("Text and/or pattern are/is missing.");
		}
		
		if(text.length() < pattern.length()){
			throw new Exception("Text length is less than pattern length.");
		}
		
		Map<Character, Integer> badCharacterMap = constructBadCharacterArray(pattern);
		int textLength = text.length(), patternLength = pattern.length(), 
				textIndex = 0;
		
		//textIndex should should be less than or equals to diff of text and pattern. 
		//For e.g text is of length 10 and pattern is 3, so textIndex value can be atmost 7.
		while(textIndex <= (textLength-patternLength)){
			
			int patternIndex = patternLength-1;
			
			//Comparing characters from right to left
			while(patternIndex >= 0 && 
					text.charAt(textIndex+patternIndex) == pattern.charAt(patternIndex)){
				patternIndex--;
			}
			
			//If pattern index is negative that means pattern found in above loop
			if(patternIndex < 0){
				System.out.println(pattern + " pattern found in " + text + " at " + textIndex);
				
				//Adding pattern length to text index to continue checking for next occurence
				int newTextIndex =  textIndex + patternLength;
				Integer badCharIndex = badCharacterMap.get(text.charAt(newTextIndex));
				
				//Checking for edge condition
				textIndex += newTextIndex < textLength ? (patternLength - (badCharIndex == null ? 0 : badCharIndex)) :  1;
				continue;
			}
			
			//Pattern not found so applying bad character rule
			Integer badCharIndex = badCharacterMap.get(text.charAt(textIndex + patternIndex));
			textIndex += Math.max(patternIndex - (badCharIndex == null ? 0 : badCharIndex), 1);
		}
	}
	
	/**
	 * @param pattern
	 * @return an array containing last occurence index of each character in given pattern 
	 */
	private static Map<Character, Integer> constructBadCharacterArray(String pattern){
		Map<Character, Integer> badCharacterMap = new HashMap<Character, Integer>();
		for(int i=0; i< pattern.length(); i++){
			badCharacterMap.put(pattern.charAt(i), i);
		}
		return badCharacterMap;
	}
	
	public static void main(String[] args) throws Exception {
		BoyerMooreSearch.search("AABAACAADAABAAABAA", "AABA");
		BoyerMooreSearch.search("BoyerMooreSearch", "Moore");
	}
}
