package com.algorithms.graph;

/**
 * 
 * @author Sasi on 30-May-2018, 7:52:02 pm
 */
public class Edge implements Comparable<Edge>{
	
	public Character source, destination;
	public int weight;

	public Edge(Character source, Character destination, int weight) {
		super();
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Edge [source=");
		builder.append(source);
		builder.append(", destination=");
		builder.append(destination);
		builder.append(", weight=");
		builder.append(weight);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(Edge edge) {
		return this.weight - edge.weight;
	}
}
