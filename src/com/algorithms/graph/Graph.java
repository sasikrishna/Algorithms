package com.algorithms.graph;

import java.util.List;

/**
 * 
 * @author Sasi on 29-May-2018, 8:51:42 am
 */
public interface Graph {
	public void addEdge(Character source, Character destination);
	public void addEdge(Character source, Character destination, int weight);
	public List<Edge> getAllEdges();
}
