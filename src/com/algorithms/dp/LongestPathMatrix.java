package com.algorithms.dp;

/**
 * Problem statement: Find longest increasing path in given matrix. It is guaranteed that matrix contains unique elements.
 * <br> Constraint: From any cell only possible navigations are next row, next column, previous row or column
 * <br><br>
 * Test case:
 * <br>
 * Input: {{1, 2, 9}, {5, 3, 8}, {4, 6, 7}}
 * <br>
 * Output: 4 (6, 7, 8, 9)
 * <br>
 * @author Sasi on 06-Jun-2018, 11:57:54 pm
 */
public class LongestPathMatrix {

	public static int findLongestPath(int matrix[][]){
		int pathCountMatrix[][] = new int[matrix.length][matrix.length];		//Since matrix should be square
		int maxLength = 1;
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix.length; j++){
				pathCountMatrix[i][j] = -1;
			}
		}
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix.length; j++){
				
				 if (pathCountMatrix[i][j] == -1){
					 maxLength = findLongestPath(matrix, pathCountMatrix, i, j);
				 }
				 
				maxLength = Math.max(maxLength, pathCountMatrix[i][j]);
			}
		}
		
		return maxLength;
	}
	
	private static int findLongestPath(int matrix[][], int pathCountMatrix[][], int i, int j){
		
		int maxtrixSize = matrix.length;
		
	    if (i<0 || i>=maxtrixSize || j<0 || j>=maxtrixSize)
	        return 0;
	 
		if (pathCountMatrix[i][j] != -1)
	        return pathCountMatrix[i][j];
		
		if(i > 0 && (matrix[i][j] + 1 == matrix[i - 1][j])){							//Checking with previous row element
			return pathCountMatrix[i][j] = 1 + findLongestPath(matrix, pathCountMatrix, i - 1, j);
		}
		if(i < maxtrixSize - 1 && (matrix[i][j] + 1 == matrix[i + 1][j])){				//Checking with next row element 
			return pathCountMatrix[i][j] = 1 + findLongestPath(matrix, pathCountMatrix, i + 1, j);
		}
		if(j > 0 && (matrix[i][j] + 1 == matrix[i][j - 1])){							//Checking with previous column element
			return pathCountMatrix[i][j] = 1 + findLongestPath(matrix, pathCountMatrix, i, j - 1);
		}
		if(j < maxtrixSize - 1 && (matrix[i][j] + 1 == matrix[i][j + 1])){				//Checking with next column element 
			return pathCountMatrix[i][j] = 1 + findLongestPath(matrix, pathCountMatrix, i, j + 1);
		}
		
		return (pathCountMatrix[i][j] = 1);
	}
	
	public static void main(String[] args) {
		System.out.println(LongestPathMatrix.findLongestPath(new int[][]{{1, 2, 9}, {5, 3, 8}, {4, 6, 7}}));
	}
}
