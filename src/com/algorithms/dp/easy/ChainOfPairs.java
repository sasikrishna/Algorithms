package com.algorithms.dp.easy;

/**
 * Problem statement: Find the longest chain which can be formed from a given set of pairs. A pair (c, d) can follow another pair (a, b) if b < c. Chain of pairs can be formed in this fashion
 * <br>Hint: Variant of longest increasing sub sequence.
 * @author Sasi Jolla on 23-Jun-2018, 11:06:28 am
 */
public class ChainOfPairs {

	public static int findWays(Pair[] array){
		int length = array.length;
		int lis[] = new int[length];
		lis[0] = 1;
		
		for(int i = 1; i < length; i++){
			
			Pair currentPair = array[i];
			for(int j = i - 1; j >= 0; j--){
				if(currentPair.isGreaterThan(array[j])
						&& (lis[j] + 1) > lis[i]){
					 lis[i] =  lis[j] + 1;
				}
			}
		}
		
		int maxLength = 0;
		for(int i = 0; i < length; i++){
			maxLength = Math.max(maxLength, lis[i]);
		}
		return maxLength;
	}
	
	public static void main(String[] args) {
		Pair[] pairs = new Pair[5];
		pairs[0] = new Pair(5, 24);
		pairs[1] = new Pair(39, 60);
		pairs[2] = new Pair(15, 28);
		pairs[3] = new Pair(27, 40);
		pairs[4] = new Pair(50, 90);
		
		System.out.println("Length of longest chain is " + findWays(pairs));
	}
}

class Pair{
	int first, second;

	public Pair(int first, int second) {
		super();
		this.first = first;
		this.second = second;
	}
	
	public boolean isGreaterThan(Pair pair){
		if(null == pair){
			return true;
		}
		return this.first > pair.second;
	}
}