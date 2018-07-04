package com.algorithms.arrays;

/**
 * 
 * @author Sasi Jolla on 02-Jul-2018, 11:08:35 pm
 */
public class MatrixRotations {
	
	/**
	 * 
	 * 
	 * @author sasi on 02-Jul-2018, 11:09:16 pm
	 */
	public static int[][] rotate(int matrix[][]){
		
		int startRow = 0, startColumn = 0, lastRow = matrix.length, 
				lastColumn = matrix[0].length, prev;
		while(startRow < lastRow && startColumn < lastColumn){
			
			if (startRow + 1 == lastRow || 
					startColumn + 1 == lastColumn){
	            break;
			}
			
			prev = matrix[startRow + 1][startColumn];
			
			//Moving first row elements by 1 from left to right
			for(int i =  startColumn; i < lastColumn; i++){
				int current = matrix[startRow][i];
				matrix[startRow][i] = prev;
				prev = current;
			}
			//Decrementing startRow count as it was processed
			startRow++;
			
			//Moving last column elements by 1 from top to bottom
			for(int i = startRow; i < lastRow; i++){
				int current = matrix[i][(lastColumn - 1)];
				matrix[i][(lastColumn - 1)] = prev;
				prev = current;
			}
			//Decrementing last column count as it was processed
			lastColumn--;
			
			//Moving last row elements from right to left
			if(startRow < lastRow){
				for(int i = (lastColumn - 1); i >= startColumn; i--){
					int current = matrix[(lastRow - 1)][i];
					matrix[(lastRow - 1)][i] = prev;
					prev = current;
				}
			}
			lastRow--;
			
			//Moving first column elements from bottom to top
			if(startColumn < lastColumn){
				for(int i = (lastRow - 1); i >= startRow; i--){
					int current = matrix[i][startColumn];
					matrix[i][startColumn] = prev;
					prev = current;
				}
			}
			startColumn++;
		}
		
		printMatrix(matrix);
		return matrix;
	}
	
	private static void printMatrix(int matrix[][]){
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix.length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int matrix[][] = {{1,  2,  3,  4},
						  {5,  6,  7,  8},
						  {9,  10, 11, 12},
						  {13, 14, 15, 16}};
		rotate(matrix);
	}
}
