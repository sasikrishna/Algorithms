package com.algorithms.dp.hard;


/**
 * Problem statement: Find minimum attempts required to know from which floor eggs can be dropped safely (i.e egg shouldn't be break).  
 * <br><br>
 * Test case:
 * <br>
 * Input: eggs = 2, floors = 4
 * <br>
 * Output: 3
 * <br>
 * @author Sasi on 10-Jun-2018, 10:37:40 pm
 */
public class EggDropping {
	
	/**
	 * 
	 * @param eggs
	 * @param floors
	 * @return
	 */
	public static int findWays(int eggs, int floors){
		int countsTable[][] = new int[eggs + 1][floors + 1];
		
		int i = 0;
		for(int j = 0; j <= floors; j++){
			countsTable[1][j] = i++;					//When there is only one egg and n number of floors then minimum findings is n
		}
		
		for(i = 2; i <= eggs; i++){						//Iterating for each egg
			for(int j = 1; j <= floors; j++){			//Iterating for all floors
				
				int minAttempts = Integer.MAX_VALUE;
				for(int k = 1; k<= j; k++){		//Iterating for each floor with eggs
					minAttempts = Math.min(1 + Math.max(countsTable[i - 1][k - 1], countsTable[i][j - k]), 
							minAttempts); 
				}
				
				countsTable[i][j] = minAttempts;
			}
		}
		
		//Printing counts table
		/*for(i = 0; i <= eggs; i++){
			for(int j = 0; j <= floors; j++){
				System.out.print(countsTable[i][j] + " ");
			}
			System.out.println();
		}*/
		
		return countsTable[eggs][floors];
	}
	
	public static void main(String[] args) {
		System.out.println(findWays(2, 4));
		System.out.println(findWays(2, 36));
	}
}
