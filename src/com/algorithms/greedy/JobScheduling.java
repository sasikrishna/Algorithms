package com.algorithms.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Problem statement:
 * Given set of jobs each with jobId, deadline and profit. Each job takes an unit time to complete and only one has to run at a given point of time.
 * Schedule jobs to make maximum profit.
 * 
 * @author Sasi on 02-Jun-2018, 2:54:41 pm
 */
public class JobScheduling {
	
	List<Job> jobs;
	Job[] jobSequence;
	
	public JobScheduling(){
		jobs = new ArrayList<Job>();
	} 
	
	public void addJob(Object jobName, int deadline, int profit){
		jobs.add(new Job(jobName, deadline, profit));
	}
	
	public void startScheduler(){
		Collections.sort(jobs);
		jobSequence = new Job[jobs.size()];
		
		Job firstJob = jobs.get(0);
		jobSequence[firstJob.deadline - 1] = firstJob;
		
		for(int i = 1; i < jobs.size(); i++){
			Job newJob = jobs.get(i);
			
			for(int j = newJob.deadline - 1; j >= 0; j--){
				if(null == jobSequence[j]){
					jobSequence[j] = newJob;
				}
			}
		}
		
		System.out.println("Scheduled jobs list: " + Arrays.toString(jobSequence));
	}
	
	class Job implements Comparable<Job>{
		Object jobId;
		int deadline, profit;

		public Job(Object jobId, int deadline, int profit) {
			super();
			this.jobId = jobId;
			this.deadline = deadline;
			this.profit = profit;
		}

		@Override
		public int compareTo(Job job) {
			return job.profit - this.profit;
		}

		@Override
		public String toString() {
			return jobId + " ";
		}
	}
	
	public static void main(String[] args) {
		JobScheduling scheduler = new JobScheduling();
		scheduler.addJob('a', 2, 100);
		scheduler.addJob('b', 1, 19);
		scheduler.addJob('c', 2, 27);
		scheduler.addJob('d', 1, 25);
		scheduler.addJob('e', 3, 15);
		
		scheduler.startScheduler();
	}
}
