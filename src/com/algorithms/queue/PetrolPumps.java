package com.algorithms.queue;

/**
 * Problem statement: Find the first circular tour that visits all petrol pumps.Calculate the first point from where a truck will be able to complete the circle (The truck will stop at each petrol pump and it has infinite capacity).
 * 
 * @author Sasi Jolla on 18-Jul-2018, 11:30:52 pm
 */
public class PetrolPumps {

	/**
	 * The idea is to start from 0th station. Whenever petrolLeft becomes less than 0 change the start station. 
	 * 
	 * Time complexity: O(n)
	 * Space complextiy: O(1)
	 * 
	 * @param petrolPumps
	 */
	public static int findStartingPoint(PetrolPump[] petrolPumps){
		int petrolLeft = 0, sumOfGas = 0, sumOfDistance = 0, startPoint = 0;
		int index = 0;
		for(PetrolPump stop : petrolPumps){
			sumOfGas += stop.capacity;
			sumOfDistance += stop.distance;
			petrolLeft += stop.capacity - stop.distance;

			/**Petrol left is less than 0 so considering next station as starting point.*/
			if(petrolLeft < 0){
				startPoint = index + 1;
				petrolLeft = 0;
			}
			index++;
		}
		
		if(sumOfGas < sumOfDistance){
			return -1;
		}
		
		return startPoint;
	}
	
	public static void main(String[] args) {
		PetrolPump[] pumps = new PetrolPump[4];
		pumps[0] = new PetrolPump(4, 6);
		pumps[1] = new PetrolPump(6, 5);
		pumps[2] = new PetrolPump(7, 3);
		pumps[3] = new PetrolPump(4, 5);
		System.out.println("Circular tour can be completed by start at petrol station " + findStartingPoint(pumps));
	}
}

/**
 * 
 */
class PetrolPump{
	int capacity;
	int distance;

	public PetrolPump(int capacity, int distance) {
		super();
		this.capacity = capacity;
		this.distance = distance;
	}
}
