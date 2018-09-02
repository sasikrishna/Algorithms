package com.algorithms.graph;

import java.util.ArrayList;

/**
 * 
 * @author Sasi Jolla on 22-Aug-2018, 10:05:23 pm
 */
public class UndirectedGraph {
	
	public int vertices;
	public ArrayList<Integer> adjList[];
	
	public UndirectedGraph(int vertices) {
		this.vertices = vertices;
		adjList = new ArrayList[vertices];

		for (int i = 0; i < vertices; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
	}
	
	/**
	 * 
	 * @param source
	 * @param destination
	 */
	public void addEdge(int source, int destination) {
		adjList[source].add(destination);
		adjList[destination].add(source);
	}
}
