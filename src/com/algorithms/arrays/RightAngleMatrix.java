package com.algorithms.arrays;

/**
 * Problem statement: Rotate matrix by 90 degrees in anti-clockwise direction.
 * 
 * @author Sasi Jolla on 03-Jul-2018, 1:42:05 am
 */
public class RightAngleMatrix {
	
	/**
	 * 
	 * @param matrix
	 * @return
	 */
	public static int[][] rightAngleMatrix(int matrix[][]){
		
		int length = matrix.length;
		for(int i = 0; i < length/2; i++){
			for(int j = i; j < length - 1 - i; j++){
				int temp = matrix[i][j];
				
				matrix[i][j] = matrix[j][length - 1 - i];
				matrix[j][length - 1 - i] = matrix[length - 1 - i][length - 1 - j];
				matrix[length - 1 - i][length - 1 - j] = matrix[length - 1 - j][i];
				matrix[length - 1 - j][i] = temp;
			}
		}
		
		printMatrix(matrix);
		return matrix;
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
		int matrix[][] = {{1,  2,  3,  4},
				  {5,  6,  7,  8},
				  {9,  10, 11, 12},
				  {13, 14, 15, 16}};
		rightAngleMatrix(matrix);
	}
}
