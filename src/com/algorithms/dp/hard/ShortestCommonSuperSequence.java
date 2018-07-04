package com.algorithms.dp.hard;

/**
 * Problem statement: Find the shortest string that has both string1 and string2 as subsequences. 
 * <br><br>
 * Test case:
 * <br>
 * Input: string1 = "AGGTAB", string2 = "GXTXAYB"
 * <br>
 * Output: AGXGTXAYB
 * <br>
 * @author Sasi on 09-Jun-2018, 9:17:41 am
 */
public class ShortestCommonSuperSequence {
	
	static int lcs[][];
	public static String findSequence(String string1, String string2){
		
		int str1Len = string1.length(), str2Len = string2.length();
		lcs = new int[str1Len + 1][str2Len + 1];
		String lcs = findLongestSubSequence(string1, string2, str1Len, str2Len);
		
		StringBuffer css = new StringBuffer();
		int i = 0, j= 0, k = 0;
		
		int maxStringLength = Math.max(str1Len, str2Len);
		
		String longString = (maxStringLength == str1Len) ? string1 : string2;
		String shortString = (maxStringLength == str1Len) ? string2 : string1;
		
		/**
		 * Merging both the strings to get common super sequence with the help of LCS
		 */
		while(i < longString.length() || j < shortString.length()){
			
			while((longString.charAt(i) != lcs.charAt(k) || k >= lcs.length()) && i < str1Len){
				css.append(longString.charAt(i++));
			}
			
			while((shortString.charAt(j) != lcs.charAt(k) || k >= lcs.length()) && j < str2Len){
				css.append(shortString.charAt(j++));
			}
			
			if(k < lcs.length()){
				css.append(lcs.charAt(k++));
				i++;j++;
			}
		}
		
		return css.toString();
	}
	
	/**
	 * 
	 * @param string1
	 * @param string2
	 * @param str1Len
	 * @param str2Len
	 * @return longest sub sequence between two strings	
	 */
	private static String findLongestSubSequence(String string1, String string2,
			int str1Len, int str2Len){
		
		for(int i = 0; i <= str1Len; i++){
			for(int j = 0; j <= str2Len; j++){
				if(i == 0 || j == 0){
					lcs[i][j] = 0;
					continue;
				}
				
				if(string1.charAt(i - 1) == string2.charAt(j - 1)){
					lcs[i][j] = 1 + lcs[i - 1][j - 1];
					continue;
				}
				
				lcs[i][j] = Math.max(Math.max(lcs[i][j - 1], lcs[i - 1][j - 1]), lcs[i - 1][j]);
			}
		}
		
		int i = str1Len, j = str2Len;
		StringBuffer lcsString = new StringBuffer();
		while(i > 0 && j > 0){
			if(lcs[i][j] == (1 + lcs[i - 1][j - 1])){
				lcsString.append(string1.charAt(i - 1));
				i--; j--;
			}else{
				if(lcs[i][j] == lcs[i - 1][j]){
					i--;
				}else{
					j--;
				}
			}
			
		}
		
		return lcsString.reverse().toString();
	}
	
	public static void main(String[] args) {
		System.out.println(findSequence("AGGTAB", "GXTXAYB"));
	}
}
