package com.algorithms.graph;

import java.util.ArrayList;

/**
 * 
 * @author Sasi Jolla on 26-Aug-2018, 7:22:28 pm
 */
public class UndirectedWeightGraph {
	public int vertices;
	public ArrayList<GraphEdge> adjList[];
	
	public UndirectedWeightGraph(int vertices) {
		this.vertices = vertices;
		adjList = new ArrayList[vertices];

		for (int i = 0; i < vertices; i++) {
			adjList[i] = new ArrayList<GraphEdge>();
		}
	}
	
	/**
	 * 
	 * @param source
	 * @param destination
	 */
	public void addEdge(int source, int destination, int weight) {
		adjList[source].add(new GraphEdge(source, destination, weight));
		adjList[destination].add(new GraphEdge(destination, source, weight));
	}
}