package com.algorithms.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Problem statement: Find maximum number of activities can be performed by a single person. A person can handle only one activity at a time.
 * 
 * @author Sasi on 02-Jun-2018, 11:54:15 am
 */
public class ActivitySelection {

	List<Activity> activities;
	List<Activity> maxActivities;
	
	public ActivitySelection() {
		super();
		this.activities = new ArrayList<Activity>();
		this.maxActivities = new ArrayList<Activity>();
	}

	public void addActivity(Integer startTime, Integer endTime) throws Exception{
		if(null == startTime || null == endTime 
				|| startTime == endTime){
			throw new Exception("Error while adding activity. Check start and end times.");
		}
		
		activities.add(new Activity(startTime, endTime));				
	}

	public List<Activity> findMaxActivities(){
		
		Collections.sort(activities);

		Activity previousActivity = null;
		for(int i = 0; i < activities.size(); i++){
			if(null == previousActivity){
				previousActivity = activities.get(0);
				maxActivities.add(previousActivity);
				continue;
			}
			
			Activity currentActivity = activities.get(i);
			if(currentActivity.startTime >= previousActivity.endTime){				//Choosing activity in such a way that difference between previous activity end time and next activity start is less
				maxActivities.add(currentActivity);
				previousActivity = currentActivity;
			}
		}
		
		return maxActivities;
	}
	
	class Activity implements Comparable<Activity>{
		
		Integer startTime, endTime;
		public Activity(Integer startTime, Integer endTime) {
			super();
			this.startTime = startTime;
			this.endTime = endTime;
		}

		@Override
		public int compareTo(Activity activity) {
			return this.endTime - activity.endTime;
		}
		
		@Override
		public String toString(){
			return startTime + " " + endTime;
		}
	}
	
	public static void main(String[] args) throws Exception {
		ActivitySelection activitySelection = new ActivitySelection();
		activitySelection.addActivity(1, 2);
		activitySelection.addActivity(3, 4);
		activitySelection.addActivity(0, 6);
		activitySelection.addActivity(5, 9);
		activitySelection.addActivity(5, 7);
		activitySelection.addActivity(8, 9);
		
		System.out.println("All activities: " + activitySelection.activities);
		System.out.println("Max activities: " + activitySelection.findMaxActivities());
	}
}
