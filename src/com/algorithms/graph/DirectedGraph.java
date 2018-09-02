package com.algorithms.graph;

import java.util.ArrayList;

/**
 * 
 * @author Sasi Jolla on 22-Aug-2018, 10:16:11 am
 */
public class DirectedGraph {
	
	public int vertexesCount;
	public int vertexes[];
	public ArrayList<Integer> adjList[];
	
	public DirectedGraph(int vertexesCount) {
		this.vertexesCount = vertexesCount;
		this.vertexes = new int[vertexesCount];
		this.adjList = new ArrayList[vertexesCount];

		for (int i = 0; i < vertexesCount; i++) {
			adjList[i] = new ArrayList<Integer>();
			this.vertexes[i] = i;
		}
	}
	
	/**
	 * 
	 * @param source
	 * @param destination
	 */
	public void addEdge(int source, int destination) {
		adjList[source].add(destination);
	}
}
