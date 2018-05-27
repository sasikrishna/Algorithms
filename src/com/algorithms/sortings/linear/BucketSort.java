package com.algorithms.sortings.linear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.algorithms.sortings.swap.InsertionSort;

/**
 * 
 * @author Sasi on 27-May-2018, 12:56:24 pm
 */
public class BucketSort {
	
	public static void sort(int[] array){
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<array.length; i++){                //Finding max element
			max = Math.max(max, array[i]);
		}
		
		List<List<Integer>> buckets = new ArrayList<List<Integer>>();
		for(int i=0; i<max; i++){
			buckets.add(null);                           //Initializing buckets to null
		}
		
		for(int i=0; i<array.length; i++){               //Buckets creation
			int bucketIndex = array[i]/10;
			
			List<Integer> bucket = buckets.get(bucketIndex);
			if(buckets.get(bucketIndex) == null){
				bucket = new ArrayList<Integer>();       //Creating new bucket if not exists before
			}
			
			bucket.add(array[i]);                        //Adding elements into bucket
			buckets.remove(bucketIndex);
			buckets.add(bucketIndex, bucket);
		}

		int j=0;
		for(List<Integer> bucket : buckets){
			
			if(bucket == null){
				continue;
			}
			
			int[] tempArray = new int[bucket.size()];
			for(int i=0; i<bucket.size(); i++)
			{
				tempArray[i] = bucket.get(i);
			}
			
			tempArray = InsertionSort.sort(tempArray);
			
			for(int k=0; k < tempArray.length;k++,j++){
				array[j] = tempArray[k];
			}
		}
		
		System.out.println(Arrays.toString(array));
	}
	
	public static void main(String[] args) {
		BucketSort.sort(new int[]{5,2,9,5,2,3,5});
	}
}
