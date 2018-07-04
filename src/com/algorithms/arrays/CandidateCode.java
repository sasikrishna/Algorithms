package com.algorithms.arrays;

import java.util.Scanner;

public class CandidateCode {
	private static final Scanner scanner = new Scanner(System.in);
	public static void main(String args[]) throws Exception {

		// Write code here
		 int minimumPower = scanner.nextInt();
		 int days = scanner.nextInt();
		 int powerGains[] = new int[days];
		 
		 for(int i = 0; i < days; i++){
			 powerGains[i] = scanner.nextInt();
		 }
		 
		 int totalMinPowerRequired = 0;
		 for(int i = 0; i < days - 1; i++){
			 int powerGain = powerGains[i] + powerGains[i + 1];
			 if(powerGain < minimumPower){
				 int powerRequired = (minimumPower - powerGain);
				 powerGains[i + 1] += powerRequired;
				 totalMinPowerRequired += powerRequired;
			 }
		 }
		 System.out.println(totalMinPowerRequired);
	}
}
