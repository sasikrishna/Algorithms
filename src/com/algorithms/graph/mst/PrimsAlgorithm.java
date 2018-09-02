package com.algorithms.graph.mst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.algorithms.graph.GraphEdge;
import com.algorithms.graph.UndirectedWeightGraph;

/**
 * Problem statement: Prims algorithms implementation for finding minimum
 * spanning tree.
 * 
 * @author Sasi Jolla on 26-Aug-2018, 6:53:12 pm
 */
public class PrimsAlgorithm extends UndirectedWeightGraph {

	public PrimsAlgorithm(int vertices) {
		super(vertices);
	}

	/**
	 * The idea is to create map with all vertices and for each vertex
	 * initialize value as infinite except for source. Now extract minimum from map
	 * and explore its adjacent vertices. While exploring update the distance in
	 * map if current path distance is smaller then existing path distance and update its parent if required.
	 * 
	 */
	public void printMST() {
		
		String mstPath = "";
		
		/**Stores the parent child hierarchy*/
		int distance[] = new int[this.vertices];
		
		/**Stores all the vertices with their distances from source vertex*/
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 0);
		
		for(int i = 1; i < vertices; i++){
			map.put(i, Integer.MAX_VALUE);
		}
		
		for(int i = 0; i < vertices; i++){
			
			Integer minVertex = extractMin(map), minValue = map.get(minVertex);
			distance[minVertex] = minValue;
			
			mstPath += minVertex + " --> ";
			
			/**Removing min vertex from map*/
			map.remove(minVertex);
			
			/**Exploring edges of min vertex*/
			ArrayList<GraphEdge> edges = this.adjList[minVertex];
			for(GraphEdge edge : edges){
				if(map.containsKey(edge.destination)){
					if(map.get(edge.destination) >  distance[edge.source] + edge.weight){
						map.put(edge.destination, distance[edge.source] + edge.weight);
					}
				}
			}
		}
		
		System.out.println(mstPath);
	}
	
	/**
	 * 
	 * @param map
	 * @return
	 */
	private Integer extractMin(Map<Integer, Integer> map){
		Integer minVertex = null, minValue = Integer.MAX_VALUE;
		for(Entry<Integer, Integer> entry : map.entrySet()){
			if(entry.getValue() < minValue){
				minVertex = entry.getKey();
				minValue = entry.getValue();
			}
		}
		return minVertex;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		PrimsAlgorithm graph = new PrimsAlgorithm(9);
		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 7, 8);
		graph.addEdge(1, 2, 8);
		graph.addEdge(1, 7, 11);
		graph.addEdge(2, 3, 7);
		graph.addEdge(2, 8, 2);
		graph.addEdge(2, 5, 4);
		graph.addEdge(3, 4, 9);
		graph.addEdge(3, 5, 14);
		graph.addEdge(4, 5, 10);
		graph.addEdge(5, 6, 2);
		graph.addEdge(6, 7, 1);
		graph.addEdge(6, 8, 6);
		graph.addEdge(7, 8, 7);
		
		graph.printMST();
	}
}
