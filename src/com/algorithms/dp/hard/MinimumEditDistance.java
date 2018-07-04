package com.algorithms.dp.hard;

/**
 * Problem statement: Find minimum number of edits required to turn String string1 into string2. Allowed operations are insert, delete and replace and all operations are equal cost.
 * <br><br>
 * Test case:
 * <br>
 * Input: ABACADAA, ACADABAA
 * <br>
 * Output: 3 (Replace B, C D in string1 with C, D, B from string2)
 * <br>
 * @author Sasi on 06-Jun-2018, 7:31:32 am
 */
public class MinimumEditDistance {

	public static int findMinimumEdits(String string1, String string2){
		
		int minEditTable[][] = new int[string1.length() + 1][string2.length() + 1];
		for(int i = 0; i <= string1.length(); i++){
			for(int j = 0; j <= string2.length(); j++){
				if(i == 0 || j == 0){
					if(i == 0){
						minEditTable[i][j] = j;
					}else if(j == 0){
						minEditTable[i][j] = i;
					}
					continue;
				}
				
				if(string1.charAt(i - 1) == string2.charAt(j - 1)){
					minEditTable[i][j] = minEditTable[i - 1][j - 1];
				}else{
					minEditTable[i][j] = 1 + Math.min(minEditTable[i - 1][j], 
							Math.min(minEditTable[i][j-1], minEditTable[i - 1][j-1]));
				}
			}
		}
		
		return minEditTable[string1.length()][string2.length()];
	}
	
	public static void main(String[] args) {
		System.out.println("Minimum edits required to convert ABACADAA to ACADABAA is " + findMinimumEdits("ABACADAA", "ACADABAA"));
		System.out.println("Minimum edits required to convert ACHIEVMENT to ACHIEVER is " + findMinimumEdits("ACHIEVMENT", "ACHIEVER"));
	}
}
