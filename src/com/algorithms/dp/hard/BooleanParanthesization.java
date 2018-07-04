package com.algorithms.dp.hard;

/**
 * 
 * @author Sasi on 09-Jun-2018, 1:07:53 am
 */
public class BooleanParanthesization {
	
	public static void findTotalTrues(char operands[], char operators[]){
		int totalOperands = operands.length;
		int trueTable[][] = new int[totalOperands][totalOperands];
		int falseTable[][] = new int[totalOperands][totalOperands];
		
		for(int i = 0; i < totalOperands; i++){
			trueTable[i][i] = (operands[i] == 'T') ? 1 : 0;
			falseTable[i][i] = (operands[i] == 'F') ? 1 : 0;
		}
		
		for(int l = 0; l < totalOperands; l++){
			for(int i = 0, j = l; j < totalOperands; ++i, ++j){
				for(int n = 0; n < l; n++){
					int k = i + n;
					System.out.println(i + " " + k);
					System.out.println(k+1 + " " + j);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		findTotalTrues(new char[]{'T', 'T', 'F', 'T'}, new char[]{'|', '&', '^'});
	}
}
