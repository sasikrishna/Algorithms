package com.algorithms.dp.easy;

/**
 * Problem statement: Given a fence with n posts and k colors, find out the number of ways of painting the fence.
 * <br>Constraint: At most 2 adjacent posts have the same color
 * 
 * @author Sasi Jolla on 21-Jun-2018, 12:24:17 am
 */
public class FencePainting {
	
	public static int findWays(int posts, int colors){
		int sameColoredPosts = 0;
		int diffColoredPosts = colors;
		
		for(int i = 2; i <= posts; i++){
			int oldDiffColoredPosts = diffColoredPosts;
			diffColoredPosts = (sameColoredPosts + diffColoredPosts) * (colors - 1);
			sameColoredPosts = oldDiffColoredPosts;
		}
		
		return sameColoredPosts + diffColoredPosts;
	}
	
	public static void main(String[] args) {
		System.out.println("Total ways with 3 posts and 2 colors are " + findWays(3, 2));
		System.out.println("Total ways with 2 posts and 4 colors are " + findWays(2, 4));
	}
}
