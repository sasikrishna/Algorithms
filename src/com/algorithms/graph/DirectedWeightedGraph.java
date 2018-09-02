package com.algorithms.graph;

import java.util.ArrayList;

/**
 * 
 * @author Sasi Jolla on 26-Aug-2018, 11:43:43 pm
 */
public class DirectedWeightedGraph {
	
	public int vertexesCount;
	public int vertexes[];
	public ArrayList<GraphEdge> adjList[];
	
	public DirectedWeightedGraph(int vertexesCount) {
		this.vertexesCount = vertexesCount;
		this.vertexes = new int[vertexesCount];
		this.adjList = new ArrayList[vertexesCount];

		for (int i = 0; i < vertexesCount; i++) {
			adjList[i] = new ArrayList<GraphEdge>();
			this.vertexes[i] = i;
		}
	}
	
	/**
	 * 
	 * @param source
	 * @param destination
	 */
	public void addEdge(int source, int destination, int weight) {
		adjList[source].add(new GraphEdge(source, destination, weight));
	}

}
