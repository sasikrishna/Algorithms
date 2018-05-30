package com.algorithms.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * @author Sasi on 29-May-2018, 8:50:00 am
 */
public class AdjacencyListGraph implements Graph{
	Map<Character, List<Vertex>> graph;
	
	public AdjacencyListGraph(){
		graph  = new HashMap<Character, List<Vertex>>();
	};
	
	public Map<Character, List<Vertex>> getAdjancencyList(){
		return graph;
	}
	
	@Override
	public void addEdge(Character source, Character destination, int weight){
		List<Vertex> adjacencyList = graph.get(source);
		
		if(null == adjacencyList){
			adjacencyList = new ArrayList<Vertex>();
		}
		
		for(Vertex vertex : adjacencyList){
			if(vertex.label.equals(destination)){
				vertex.weight = weight;
				graph.put(source, adjacencyList);
				return;
			}
		}
		
		adjacencyList.add(new Vertex(destination, weight));
		graph.put(source, adjacencyList);
	}

	@Override
	public void addEdge(Character source, Character destination) {
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdjacencyListGraph [graph=");
		builder.append(graph);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public List<Edge> getAllEdges() {
		
		List<Edge> allEdges = new ArrayList<Edge>();
		for(Entry<Character, List<Vertex>> entry : getAdjancencyList().entrySet()){
			for(Vertex vertex : entry.getValue()){
				allEdges.add(new Edge(entry.getKey(), vertex.label, vertex.weight));
			}
		}
		
		return allEdges;
	}
}
