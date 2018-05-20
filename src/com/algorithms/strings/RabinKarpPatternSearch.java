package com.algorithms.strings;

/**
 * <code>RabinKarpPatternSearch</code> represents implementation for Rabin Karp pattern search algorithm for finding pattern in given text.<br>
 *	This algorithm works based on hash code. First we'll calculate hash code for pattern and then we'll calculate hash code for sub strings of text whose legnth equals to pattern.<br>
 *	Whenever hash code is matches we'll compare chars again to make sure pattern is found in text.<br><br>
 *  
 *  Time complexity for finding pattern: O(m * n) where m is length of text and n is length of pattern.<br><br>
 *  
 *  Though the time complexity is bad, still Rabin Karp performs well for finding plagiarism and findind multiple patterns at same time.
 * 
 * @author Sasi on 20-May-2018, 5:25:23 pm
 */
public class RabinKarpPatternSearch {
	
	/**
	 * 
	 * @param text
	 * @param pattern
	 * @throws Exception 
	 */
	public static void search(String text, String pattern) throws Exception{
		
		if(null == pattern || null == text){
			throw new Exception("Text and/or pattern are/is missing.");
		}
		
		text = text.toLowerCase();
		pattern = pattern.toLowerCase();
		
		double patternHash = 0;
		patternHash = calculateHash(pattern, patternHash, 'a');
		//System.out.println("patternHash: " + patternHash);
		
		for(int i=0, j=0; j<text.length(); i++){
			double textHash = 0;
			j = i + pattern.length();
			textHash = calculateHash(text.substring(i, j), textHash, 'a');
			//System.out.println("textHash: " + textHash);
			
			if(patternHash == textHash){
				System.out.println(pattern + " pattern found in " + text + " at " + i);
			}
		}
	}
	
	/**
	 * 
	 * @param subPattern
	 * @return
	 */
	private static double calculateHash(String subPattern, double oldHash, char firstChar){
		//System.out.println("Calculating hash for: " + subPattern);
		char[] pattern = subPattern.toCharArray();
		int prime = 3; double hash = 0;
		
		//Calculating complete hash value if there is no old hash value
		if(oldHash == 0){
			for(int i=0; i<pattern.length; i++){
				int charIndex = pattern[i] - 97 + 1;
				hash += (charIndex * Math.pow(prime,i));
			}
			return hash;
		}
		
		//Removing first character hash value in old hash
		int charIndex = firstChar - 97 + 1;
		hash = oldHash - charIndex;
		hash = hash/prime;
		
		//Adding last character hash value to old hash 
		charIndex = pattern[pattern.length-1] - 97 + 1;
		hash +=  charIndex * Math.pow(prime,pattern.length-1);
		
		return hash;
	}
	
	public static void main(String[] args) throws Exception {
		RabinKarpPatternSearch.search("abedabc", "abc");
		RabinKarpPatternSearch.search("RKPatternSearch", "Pat");

	}
}
