package com.algorithms.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Sasi Jolla on 24-Aug-2018, 12:49:12 am
 */
public class BellmanFordAlgorithm{
	
	/**
	 * 
	 * @param graph
	 * @return
	 */
	public static boolean isNegativeCycleExists(Graph graph){
		
		List<Edge> allEdges = graph.getAllEdges();
		Map<Character, Integer> distances = new HashMap<Character, Integer>();
		Map<Character, Character> parent = new HashMap<Character, Character>();
		
		/**Initializing distances with map with maximum distance*/
		for(Character vertex : graph.getAllVertexes()){
			distances.put(vertex, Integer.MAX_VALUE);
		}
		
		/**Finding single source shortest path is completed*/
		for(int i = 0; i < graph.getVertexesCount() - 1; i++){
			for(Edge edge : allEdges){
				if((distances.get(edge.source) + edge.weight) < distances.get(edge.destination)){
					distances.put(edge.destination, distances.get(edge.source) + edge.weight);
					parent.put(edge.destination, edge.source);
				}
			}
		}
		
		/**If distance decreased further more then there is s negative edge cycle*/
		for(int i = 0; i < 1; i++){
			for(Edge edge : allEdges){
				if((distances.get(edge.source) + edge.weight) < distances.get(edge.destination)){
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Graph graph = new AdjacencyListGraph(); 
		graph.addEdge('A', 'B', -1);
		graph.addEdge('A', 'C', 4);
		graph.addEdge('B', 'C', 3);
		graph.addEdge('B', 'D', 2);
		graph.addEdge('A', 'E', 2);
		graph.addEdge('D', 'C', 5);
		graph.addEdge('D', 'B', 1);
		graph.addEdge('E', 'D', -3);
		System.out.println("Is negative edge cycle present " + isNegativeCycleExists(graph));
		
		graph = new AdjacencyListGraph(); 
		graph.addEdge('A', 'B', 1);
		graph.addEdge('B', 'C', -1);
		graph.addEdge('C', 'D', -1);
		graph.addEdge('D', 'A', -1);
		System.out.println("Is negative edge cycle present " + isNegativeCycleExists(graph));
	}
}
