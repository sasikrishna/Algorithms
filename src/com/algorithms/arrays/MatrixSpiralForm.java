package com.algorithms.arrays;

/**
 * Problem statement: Print a given matrix in spiral form

 * @author Sasi Jolla on 04-Jul-2018, 9:55:47 pm
 */
public class MatrixSpiralForm {

	public static void printInSpiralForm(int matrix[][]) {
		int row = 0, column = 0, totalRows = matrix.length, totalColumns = matrix[0].length;

		while (row < totalRows && column < totalColumns) {

			// Printing top row
			for (int i = column; i < totalColumns; i++) {
				System.out.print(matrix[row][i] + " ");
			}
			row++;

			// Printing last column
			for (int i = row; i < totalRows; i++) {
				System.out.print(matrix[i][totalColumns - 1] + " ");
			}
			totalColumns--;

			if (row < totalRows) {
				// Printing last column
				for (int i = totalColumns - 1; i >= column; i--) {
					System.out.print(matrix[totalRows - 1][i] + " ");
				}
				totalRows--;
			}

			if (column < totalColumns) {
				// Printing first column
				for (int i = totalRows - 1; i >= row; i--) {
					System.out.print(matrix[i][column] + " ");
				}
				column++;
			}
		}
	}

	public static void main(String[] args) {
		int matrix[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 } };
		printInSpiralForm(matrix);
	}
}
