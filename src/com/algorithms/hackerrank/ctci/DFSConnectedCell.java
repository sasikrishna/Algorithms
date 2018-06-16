package com.algorithms.hackerrank.ctci;

import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author Sasi Jolla on 16-Jun-2018, 5:06:31 pm
 */
public class DFSConnectedCell {
	
	private static final Scanner scanner = new Scanner(System.in);
	
	// Complete the maxRegion function below.
    static int maxRegion(int[][] grid) {
    	
    	int maxConnectedCells = 0;
    	for(int i = 0; i < grid.length; i++){
    		maxConnectedCells = Math.max(maxConnectedCells, connections(grid, i, 0));
    	}
    	
    	return maxConnectedCells;
    }
    
    private static int connections(int[][] grid, int row, int column){
    	
    	if(row >= grid.length || column >= grid[0].length || 
    			row < 0 || column < 0){
    		return 0;
    	}
    	
    	if(grid[row][column] == 0){
    		return 0;
    	}
    	
    	grid[row][column]--;
    	int count = 1;
    	count += connections(grid, row - 1, column - 1);
    	count += connections(grid, row - 1, column + 1);
    	count += connections(grid, row - 1, column);
    	count += connections(grid, row, column - 1);
    	count += connections(grid, row + 1, column + 1);
    	count += connections(grid, row + 1, column - 1);
    	count += connections(grid, row + 1, column);
    	count += connections(grid, row, column + 1);
    	
    	return count;
    }
    
    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] gridRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int gridItem = Integer.parseInt(gridRowItems[j]);
                grid[i][j] = gridItem;
            }
        }

        System.out.println(maxRegion(grid));
        scanner.close();
    }
}
