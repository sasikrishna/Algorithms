package com.algorithms.dp.hard;


/**
 * Problem statement: Find efficient way to multiple matrices i.e matrices should be paranthesized such that number of multiplications should be reduced. 
 * <br><br>
 * Test case:
 * <br>
 * Input: dimensions[] = {1, 2, 3, 4, 5} (dimensions of matrices i.e 1x2, 2x3, 3x4, 4x5)
 * <br>
 * Output: 38 multiplications (paranthesized format: ((((12)3)4)5))
 * <br> 
 * @author Sasi on 09-Jun-2018, 1:02:36 pm
 */
public class MatrixChainMultiplication {

	public static int findMinOperations(int[] dimensions){
		int totalMatrices = dimensions.length - 1;
		int[][] operationsCount = new int[totalMatrices + 1][totalMatrices + 1];
		int[][] parathesization =  new int[totalMatrices + 1][totalMatrices + 1];
		
		for(int diagonal = 1; diagonal < totalMatrices; diagonal++){
			for(int row = 1; row < totalMatrices - diagonal + 1; row++){
				int column = row + diagonal;
				int minOperations = Integer.MAX_VALUE;
				
				for(int splitPoint = 1; splitPoint <= column - 1; splitPoint++){
					int totalOperations = operationsCount[row][splitPoint] + operationsCount[splitPoint + 1][column] 
							+ dimensions[row -1] * dimensions[column] * dimensions[splitPoint];
					
					if(totalMatrices < minOperations){
						minOperations = totalOperations;
						parathesization[row][column] = splitPoint;
					}
				}
				
				operationsCount[row][column] = minOperations;
			}
		}
		
		StringBuffer matrices = new StringBuffer();
		for(int i = 0; i < dimensions.length; i++){
			matrices.append(dimensions[i]);
		}
		
		int j = 1;
		for(int i = totalMatrices; i > 0; i--){
			
			if(parathesization[1][i] == 0){
				continue;
			}
			
			matrices.insert(j + parathesization[1][i], ")");				//Inserting ) after the current element
			matrices.insert(0, "(");
			j += 1;
		}
		
		System.out.println("Paranthesized matix format: " + matrices);
		
		return operationsCount[1][totalMatrices];
	}
	
	public static void main(String[] args) {
		int dimensions[] = {1, 2, 3, 4, 5};
		System.out.println("Minimum number of multiplications: " + findMinOperations(dimensions));
	}
}
