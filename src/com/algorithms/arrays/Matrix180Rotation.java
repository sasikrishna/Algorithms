package com.algorithms.arrays;

/**
 * Problem statement: Rotate matrix by 180 degrees in anti-clockwise direction.
 * 
 * @author Sasi Jolla on 03-Jul-2018, 8:33:18 am
 */
public class Matrix180Rotation {
	
	/**
	 * Sub routine to rotate the matrix
	 * 
	 * @param matrix
	 */
	public static void rotate(int matrix[][]){
		transpose(matrix);
		reverseColumns(matrix);
		transpose(matrix);
		reverseColumns(matrix);
		printMatrix(matrix);
	}
	
	/**
	 * Sub routine converts given matrix into its transpose and returns
	 * 
	 * @param matrix
	 */
	private static void transpose(int matrix[][]){
		int length = matrix.length;
		for(int i = 0; i < length; i++){
			for(int j = i; j < length; j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}
	
	/**
	 * Sub routine reverses column elements in given matrix
	 * @param matrix
	 */
	private static void reverseColumns(int matrix[][]){
		int length = matrix.length;
		for(int i = 0; i < length; i++){
			for(int j = 0, k = length - 1; j < k; j++, k--){
				int temp = matrix[j][i];
				matrix[j][i] = matrix[k][i];
				matrix[k][i] = temp;
			}
		}
	}
	
	/**
	 * 
	 * @param matrix
	 */
	private static void printMatrix(int matrix[][]){
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix.length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int matrix[][] = {{1, 2, 3, 4 },
						  {5, 6, 7, 8 },
						  {9, 10, 11, 12},
						  {13, 14, 15, 16}};
		rotate(matrix);
	}
}
