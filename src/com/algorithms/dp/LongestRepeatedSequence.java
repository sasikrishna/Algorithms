package com.algorithms.dp;

/**
 * Problem statement: Find longest repeated sub sequence between two strings.
 * <br><br>
 * Test case:
 * <br>
 * Input: ABDEGHADE
 * <br>
 * Output: ADE
 * <br>
 * @author Sasi on 04-Jun-2018, 12:30:17 am
 */
public class LongestRepeatedSequence {

	String string;
	int[][] countSequence;
	
	
	public LongestRepeatedSequence(String string) {
		super();
		this.string = string;
		this.countSequence = new int[string.length() + 1][string.length() + 1];
	}
	
	public int getLRSCount(){
		for(int i = 1; i <= string.length(); i++){
			for(int j = 1; j <= string.length(); j++){
				if(string.charAt(i - 1) == string.charAt(j - 1) && i != j){
					countSequence[i][j] = countSequence[i - 1][j - 1] + 1;
				}else{
					countSequence[i][j] = Math.max(countSequence[i - 1][j], countSequence[i][j - 1]);
				}
			}
		}
		
		return countSequence[string.length()][string.length()];
	}
	
	public void printLRS(){
		StringBuffer sb  =  new StringBuffer();
		for(int i = string.length(), j = string.length(); i > 0 && j > 0;){
				if(countSequence[i][j] == Math.max(countSequence[i-1][j], countSequence[i][j-1])){
					if(countSequence[i][j] == countSequence[i][j-1]){
						j--;
					}else{
						i--;
					}
				}else{
					sb.append(string.charAt(i-1));
					i--;j--;
				}
		}
		System.out.println("LRS is: " + sb.reverse());
	}
	
	public static void main(String[] args) {
		LongestRepeatedSequence lrs = new LongestRepeatedSequence("ABDEGHADE");
		System.out.println("Longest repeated sequence in ABDEGHADE is " + lrs.getLRSCount());
		lrs.printLRS();
	}
}
