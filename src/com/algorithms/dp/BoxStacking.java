package com.algorithms.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Problem statement: Find maximum stack height that can be obtained by stacking given boxes with dimensions. Each box dimensions can be rotated to use multiple instances of same box to get max stack height. 
 * <br><br>Constraints: Every box dimensions should be strictly less than on which it is stacked.
 * Test case:
 * <br>
 * Input: boxes = [{4, 3, 5}, {2, 1 ,3}]
 * <br>
 * Output: 12 is max stack height can be formed
 * <br>
 * @author Sasi Jolla on 10-Jun-2018, 3:08:02 pm
 */
public class BoxStacking {
	
	public static int findMaxStackHeight(List<Box> boxes){
		
		//All boxes contains box with given dimension and its rotations
		List<Box> allBoxes = new ArrayList<>();
		for(Box box : boxes){
			allBoxes.addAll(getRotatedBoxes(box));
		}
		
		//Sorting all the boxes based on their width and length
		Collections.sort(allBoxes);
		//System.out.println(allBoxes);
		
		int totalBoxes = allBoxes.size();
		int maxStackHeight[] = new int[totalBoxes], sequence[] = new int[totalBoxes];
		 
		for(int i = 0; i < totalBoxes; i++){
			maxStackHeight[i] = allBoxes.get(i).height;
			sequence[i] = i;
		}
	    
		/**
		 * applying algorithm same as longest increasing sub sequence
		 */
		for(int i = 1; i < totalBoxes; i++){
			Box box1 = allBoxes.get(i);
			for(int j = 0; j < i; j++){
				Box box2 = allBoxes.get(j);
				if(box1.isSmallerThan(box2) && 
						maxStackHeight[i] < maxStackHeight[j] + box1.height){
					maxStackHeight[i] = maxStackHeight[j] + box1.height;
					sequence[i] = j;
				}
			}
		}
		
		//Iterating through increasing subsequence to get max value
		int maxHeight = -1, boxIndex = 0;
		for(int i = 0; i < totalBoxes; i++){
			if(maxStackHeight[i] > maxHeight){
				maxHeight = maxStackHeight[i];
				boxIndex = i;
			}
		}
		
		//Printing all boxes dimensions
		while(boxIndex >= 0){
			System.out.println(allBoxes.get(boxIndex));
			boxIndex = sequence[boxIndex];
			
			if(boxIndex == 0){
				System.out.println(allBoxes.get(0));
				break;
			}
		}
		
		return maxHeight;
	}
	
	/**
	 * Returns list of all rotated boxes along with given box.
	 *  
	 * @param box
	 * @return
	 */
	private static List<Box> getRotatedBoxes(Box box){
		List<Box> rotatedBoxes = new ArrayList<>();
		rotatedBoxes.add(box);
		
		Box rotatedBox = new Box();
		rotatedBox.height = box.length;
		rotatedBox.length = Math.max(box.width, box.height);		//Making sure that length is always greater than width to avoid more comparisions
		rotatedBox.width = Math.min(box.width, box.height);
		rotatedBoxes.add(rotatedBox);
		
		rotatedBox = new Box();
		rotatedBox.height = box.width;
		rotatedBox.length = Math.max(box.length, box.height);	   //Making sure that length is always greater than width to avoid more comparisions
		rotatedBox.width = Math.min(box.length, box.height);
		rotatedBoxes.add(rotatedBox);
				
		return rotatedBoxes;
	}
	
	public static void main(String[] args) {
		List<Box> boxes = new ArrayList<>();
		boxes.add(new Box(4, 3, 5));
		boxes.add(new Box(2, 1 ,3));
		System.out.println("Max stack height: " + findMaxStackHeight(boxes) + "\n");
		
		boxes = new ArrayList<>();
		boxes.add(new Box(7, 6, 4));
		boxes.add(new Box(3, 2, 1));
		boxes.add(new Box(6, 5, 4));
		boxes.add(new Box(32, 12, 10));
		System.out.println("Max stack height: " + findMaxStackHeight(boxes));
	}
	
	/**
	 * Class Box represents a box with given dimensions.
	 * 
	 * @author Sasi Jolla
	 */
	static class Box implements Comparable<Box>{
		int length, width, height;

		public Box(){
			
		}
		
		public Box( int length, int width, int height) {
			super();
			this.length = length;
			this.width = width;
			this.height = height;
		}

		public boolean isSmallerThan(Box box){
			return this.width < box.width && this.length < box.length;
		}
		
		@Override
		public int compareTo(Box box) {
			return box.length * box.width - this.length * this.width;
		}

		@Override
		public String toString() {
			return this.length + ", " + this.width + 
					", " + this.height;
		}
	}
}
