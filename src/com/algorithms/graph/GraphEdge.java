package com.algorithms.graph;

/**
 * Represents directed/undirected weighted/non-weight edge of a graph. 
 * 
 * @author Sasi Jolla
 */
public class GraphEdge{
	public int source,
		destination,
		weight;

	public GraphEdge(int source, int destination, int weight) {
		super();
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}
}