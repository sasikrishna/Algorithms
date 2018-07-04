package com.algorithms.dp.easy;



/**
 * 
 * @author Sasi Jolla on 23-Jun-2018, 3:49:52 pm
 */
public class MinimumJumps {
	
	/**
	 * Finds minimum jumps required to reach end of array in O(n * n). 
	 * 
	 * @param array
	 * @return minimum jumps required to reach end of array
	 */
	public static int findMinJumps(int array[]){
		
		int length = array.length;
		int dp[] =  new int[length], path[] =  new int[length];
		dp[0] = 0;
		path[0] = -1;
		
		for(int i = 1; i < array.length; i++){
			dp[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 1; i < array.length; i++){
			for(int j = 0; j < i; j++){
				if(j + array[j] >= i &&
						dp[i] > dp[j] + 1){
					dp[i] = dp[j] + 1;
					path[i] = j;
				}
			}
		}
		
		for(int i = array.length -1 ; i >= 0;){
			System.out.print(array[i] + " ");
			i = path[i];
		}
		System.out.println();
		
		return dp[length - 1];
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 */
	public static int findMinJumpsEfficiently(int array[]){
		int ladder = array[0], stairs = array[0], jumps = 1;
		for(int i = 1; i < array.length; i++){
			
			if(i + array[i] > ladder){
				ladder = i + array[i];
			}
			
			stairs--;
			if(stairs == 0){
				stairs = ladder - i;
				jumps++;
			}
		}
		
		return jumps;
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		System.out.println("Minimum jumps required " + findMinJumps(arr));
		
		arr = new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		System.out.println("Minimum jumps required in O(n) TC is " + findMinJumpsEfficiently(arr));
		
		arr = new int[]{1, 3, 6, 1, 0, 9};
		System.out.println("Minimum jumps required " + findMinJumps(arr));
		
		arr = new int[]{1, 3, 6, 1, 0, 9};
		System.out.println("Minimum jumps required in O(n) TC is " + findMinJumpsEfficiently(arr));
	}
}
