package com.algorithms.dp.hard;

/**
 * Problem statement: Given a knapsack with some maximum capacity find maximum value can be achieved by putting weights into the sack. Each weight will have some value.
 * <br>Constraint: This is 0 or 1 knapsack problem so we'll put whole weight into knapsack or not
 * <br><br>
 * Test case:
 * <br>
 * Input: weights = {3, 2, 1, 5} values = {6, 5, 1, 10} and sack capacity = 7
 * <br>
 * Output: 5 (10), 2 (5)
 * <br>
 * @author Sasi on 08-Jun-2018, 8:14:13 pm
 */
public class KnapsackProblem {
	
	int weights[], values[], capacity;
	int knapsackTable[][];
	
	public KnapsackProblem(int[] weights, int[] values, int capacity) {
		super();
		this.weights = weights;
		this.values = values;
		this.capacity = capacity;
		knapsackTable = new int[this.weights.length][capacity + 1];
	}

	public void findMaxWeight(){
		for(int i = 0; i < this.weights.length; i++){
			for(int j = 0; j <= capacity; j++){
				
				if(j == 0){
					knapsackTable[i][0] = 0;							//Filling first column with considering sack capacity is zero so max can achieve is 0
					continue;
				}
				
				if(i == 0){
					if(this.weights[i] <= j){
						knapsackTable[i][j] = this.values[i];
					}else{
						knapsackTable[i][j] = 0;
					}
					continue;
				}
				
				if(this.weights[i] > j){								//Checking if current weight is greater than sack limit if so taking max value from previous row i.e 
					knapsackTable[i][j] = knapsackTable[i - 1][j];      //max value can be achieved without current weight.
					continue;
				}
				
				//Max(sum so far, sum so far + current weight)
				knapsackTable[i][j] = Math.max(knapsackTable[i - 1][j], this.values[i] + knapsackTable[i - 1][j - this.weights[i]]);
			}
		}
		printWeights();
	}
	
	private void printWeights(){
		int i = this.weights.length - 1, j = capacity, maxWeight = 0;
		
		while(i >= 0 && j >= 0){
			
			if(i == 0){
				if(knapsackTable[i][j] != 0){
					System.out.println(this.weights[0] + " (" + this.values[0] + ")");
					maxWeight += this.values[0];
				}
				break;
			}
			
			if(knapsackTable[i][j] != knapsackTable[i - 1][j]){			//Checking if current is equals to previous row sum. If they aren't equal then current weight is part of selection.	
				System.out.println(this.weights[i] + " (" + this.values[i] + ")");
				maxWeight += this.values[i];
				j = j - this.weights[i];
				i--;
			}else{
				i--;												   //Current total sum is equals to previous row sum that means it came from previous row. So current weight is not part of selection.
			}
		}
		System.out.println("Max value can be put is: " + maxWeight);
	}
	
	public static void main(String[] args) {
		KnapsackProblem sack = new KnapsackProblem(new int[]{3, 2, 1, 5}, new int[]{6, 5, 1, 10}, 7);
		sack.findMaxWeight();
	}
}
