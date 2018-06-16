package com.algorithms.hackerrank.ctci;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author Sasi Jolla on 16-Jun-2018, 1:55:53 pm
 */
public class CountMergeSortInversions {

	private static final Scanner scanner = new Scanner(System.in);
	
	 //Complete the countInversions function below.
    static long countInversions(int[] arr) {
    	long inversions = mergeSort(arr, 0, arr.length - 1);
    	System.out.println(Arrays.toString(arr));
    	return inversions;
    }
    
    /**
     * 
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private static long mergeSort(int[] arr, int low, int high){
    	
    	long inversions = 0;
    	if(low < high){
    		int mid = (high + low)/2;
    		inversions += mergeSort(arr, low, mid);
    		inversions += mergeSort(arr, mid + 1, high);
    		inversions += merge(arr, low, mid, high);
    	}
    	return inversions;
    }
    
    /**
     * Merge sort merge implementation with inversions calculation.
     *  
     * @param arr
     * @param low
     * @param mid
     * @param high
     * @return
     */
    private static long merge(int[] arr, int low, int mid, int high) {
    	int start = low, middle = mid + 1, tempArray[] = new int[high - low + 1], k = 0;
    	long inversions = 0;
    	
    	for(int i = low; i <= high; i++){
    		
    		if(start > mid){
    			tempArray[k++] = arr[middle++];
    		}else if(middle > high){
    			tempArray[k++] = arr[start++];
    		}else if(arr[start] > arr[middle]){
				tempArray[k++] = arr[middle++];
				inversions += (mid + 1) - start;			//Here we are counting the inversions. When ever we have element in right sub array which is greater than element in left sub array 
			}else{										//count all elements in left sub array from start index. Those many inversions we need to do to for sorting.
				tempArray[k++] = arr[start++];
			}
    	}
    	
    	for(int i = 0; i < k; i++){
    		arr[low++] = tempArray[i];
    	}
    	
		return inversions;
	}

	public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long result = countInversions(arr);
            System.out.println(result);
        }

        scanner.close();
    }
}
