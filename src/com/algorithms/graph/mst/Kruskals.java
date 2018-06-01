package com.algorithms.graph.mst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.algorithms.graph.AdjacencyListGraph;
import com.algorithms.graph.Edge;
import com.algorithms.graph.Graph;
import com.algorithms.graph.Vertex;
import com.datastructures.linear.DisjointSets;

/**
 * 
 * @author Sasi on 01-Jun-2018, 10:32:58 pm
 */
public class Kruskals {
	AdjacencyListGraph graph;
	Map<Character, List<Vertex>> adjacencyList;
	DisjointSets<Character> disjointSets;
	List<String> path;
	
	public Kruskals(Graph graph){
		this.graph = (AdjacencyListGraph) graph;
		this.adjacencyList = this.graph.getAdjancencyList();
		this.disjointSets = new DisjointSets<Character>();
		this.path = new ArrayList<>();
	}
	
	public void calculateMST(){
		List<Character> vertexes = graph.getAllVertexes();
		
		for(Character vertex : vertexes){
			disjointSets.makeSet(vertex);
		}
		
		List<Edge> edges = graph.getAllEdges();
		Collections.sort(edges);
		
		for(Edge edge : edges){
			Character sourceVertex = disjointSets.findSet(edge.source);
			Character destinationVertex = disjointSets.findSet(edge.destination);
			
			if(sourceVertex == destinationVertex){
				continue;												//Source and Destination vertexes belongs to same disjoint set to continuing to avoid cycle
			}
			
			disjointSets.union(edge.source, edge.destination);
			path.add(edge.source + "" + edge.destination);
		}
		
		System.out.println(disjointSets.getDisjointSet());
	}
	
	public void printMSTPath(){
		System.out.println(path);
	}
	
	public static void main(String[] args) {
		Graph graph = new AdjacencyListGraph();
		graph.addEdge('A', 'B', 4);
		graph.addEdge('B', 'C', 3);
		graph.addEdge('C', 'D', 2);
		graph.addEdge('D', 'A', 1);
		
		Kruskals kruskals = new Kruskals(graph);
		kruskals.calculateMST();
		kruskals.printMSTPath();
	}
}
