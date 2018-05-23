package com.algorithms.strings;


/**
 * <code>KMPPatternSearch</code> class represents implementation of KMPPatternSearch algorithm for finding patterns in given text in linear time.<br>
 * It works on the principal of skipping long common prefix which is also a suffix in the given pattern to avoid unnecessary comparisions.<br>
 * It first builds lps array contains indices which helps to skip the suffixes comparison.<br><br>
 * 
 * Time complexity for building lps is - O(m) where m is length of array and for searching O(n) where n is length is string. So total time complexity is O(n + m)
 * 
 * @author Sasi on 20-May-2018, 2:47:10 pm
 */
public class KMPPatternSearch {
	
	/**
	 * 
	 * @param text
	 * @param pattern
	 * @return
	 * @throws Exception 
	 */
	public static void search(String text, String pattern) throws Exception{
		
		if(null ==  text || null == pattern){
			throw new Exception("Text or pattern is missing.");
		}

		if(text.length() < pattern.length()){
			throw new Exception("Text length is less than pattern length.");
		}
		
		char[] textArray = text.toCharArray(), patternArray = pattern.toCharArray();
		int[] lps = constructLPS(patternArray);
		//System.out.println("LPS array: " + Arrays.toString(lps));
		
		int i=0,j=0;
		boolean patternFound = false;
		while(i < textArray.length){
			if(textArray[i] == patternArray[j]){
				i++;j++;
				
				if(j == patternArray.length){
					patternFound = true;
					System.out.println(pattern + " pattern found in " + text + " at " + (i-patternArray.length));
					j=0;
				}
				continue;
			}else{
				
				if(j == 0){
					i++;
					continue;
				}
				
				j = lps[j-1];
			}
		}
		
		if(!patternFound){
			System.out.println("Pattern " + pattern + " not found.");
		}
	}
	
	/**
	 * 
	 * @param patternArray
	 * @return
	 */
	private static int[] constructLPS(char[] patternArray){
		
		int j=0, i=1, patternLength = patternArray.length;
		int[] lps = new int[patternLength];
		lps[0] = 0;
		
		while(i < patternLength){
			if(patternArray[j] == patternArray[i]){
				lps[i] = j+1;
				j++; i++;
				continue;
			}else{
				if(j == 0){
					lps[i++] = 0;
					continue;
				}
				
				j =  lps[j-1];
			}
		}
		
		return lps;
	} 
	
	public static void main(String[] args) throws Exception {
		KMPPatternSearch.search("AAAAABAAABA", "ABA");
		KMPPatternSearch.search("KMPPatternSearch", "Pat");
	}
}
