package com.algorithms.dp;

/**
 * Problem statement: Find longest common sub sequence between two strings.
 * <br><br>
 * Test case:
 * <br>
 * Input: ABCDGH, AEDFHR
 * <br>
 * Output: ADH
 * <br>
 * @author Sasi on 03-Jun-2018, 7:42:26 pm
 */
public class LongestCommonSequence {
	
	String string1, string2;
	int[][] countSequence;
	
	public LongestCommonSequence(String string1, String string2) {
		super();
		this.string1 = string1;
		this.string2 = string2;
		this.countSequence = new int[string1.length() + 1][string2.length() + 1];
	}

	public int getLCSCount(){
		
		for(int i = 0; i <= string1.length(); i++){
			for(int j = 0; j <= string2.length(); j++){
				if(i == 0 || j == 0){
					countSequence[i][j] = 0;
					continue;
				}
				
				if(string1.charAt(i - 1) == string2.charAt(j - 1)){
					countSequence[i][j] = countSequence[i - 1][j - 1] + 1;
				}else{
					countSequence[i][j] = Math.max(countSequence[i - 1][j], countSequence[i][j - 1]);
				}
			}
		}
		
		return countSequence[string1.length()][string2.length()];
	}
	
	public void printLCS(){
		StringBuffer sb  =  new StringBuffer();
		for(int i = string1.length(); i > 0;){
			for(int j = string2.length(); j > 0 && i > 0;){				
				if(countSequence[i][j] == Math.max(countSequence[i-1][j], countSequence[i][j-1])){
					if(countSequence[i][j] == countSequence[i][j-1]){
						j--;
					}else{
						i--;
					}
				}else{
					sb.append(string1.charAt(i-1));
					i--;j--;
				}
			}
		}
		System.out.println("LCS is: " + sb.reverse());
	}
	
	public static void main(String[] args) {
		LongestCommonSequence lcs = new LongestCommonSequence("ABCDGH", "AEDFHR");
		System.out.println("Longest common sub sequence length between ABCDGH and AEDFHR is " + lcs.getLCSCount());
		lcs.printLCS();
	}
}
