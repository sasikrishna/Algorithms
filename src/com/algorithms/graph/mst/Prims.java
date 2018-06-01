package com.algorithms.graph.mst;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.algorithms.graph.AdjacencyListGraph;
import com.algorithms.graph.Graph;
import com.algorithms.graph.Vertex;

/**
 * 
 * @author Sasi on 31-May-2018, 11:46:01 pm
 */
public class Prims {
	AdjacencyListGraph graph;
	Map<Character, List<Vertex>> adjacencyList;
	Map<Character, Integer> visitMap;
	Map<Character, String> path;
	
	public Prims(Graph graph){
		this.graph = (AdjacencyListGraph) graph;
		this.adjacencyList = this.graph.getAdjancencyList();
		this.visitMap = new HashMap<Character, Integer>();
		this.path = new HashMap<Character, String>();
	}

	public void calculateMST(){

		List<Character> vertexes = this.graph.getAllVertexes();
		for(Character vertex : vertexes){
			visitMap.put(vertex, Integer.MAX_VALUE);					//Setting weight of each vertex to max integer value except for one vertex to start the process
		}
		visitMap.put(vertexes.get(0), 0);
		
		while(visitMap.size() > 0){
			Character minVertex = findMinWeightVertex();
			visitMap.remove(minVertex);
			
			List<Vertex> edges =   adjacencyList.get(minVertex);
			for(Vertex vertex : edges){
				if(!visitMap.containsKey(vertex.label)){
					continue;
				}
				
				int currentVertexWeight = visitMap.get(vertex.label);
				if(vertex.weight < currentVertexWeight){				//Checking if weight from current is less than existing weight
					visitMap.put(vertex.label, vertex.weight);
					path.put(vertex.label, minVertex.toString() + vertex.label.toString());
				}
			}
		}
	}
	
	public void printMSTPath(){
		for(Entry<Character, String> entry : path.entrySet()){
			System.out.println(entry.getValue());
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public Character findMinWeightVertex(){
		Character minVertex = null;
		int minVertexWeight = Integer.MAX_VALUE;
		
		for(Entry<Character, Integer> entry : visitMap.entrySet()){
			if(minVertexWeight > entry.getValue()){
				minVertex = entry.getKey();
			}
		}
		
		return minVertex;
	}
	
	public static void main(String[] args) {
		Graph graph = new AdjacencyListGraph();
		graph.addEdge('A', 'B', 5);
		graph.addEdge('A', 'D', 9);
		graph.addEdge('A', 'E', 2);
		graph.addEdge('B', 'C', 4);
		graph.addEdge('C', 'D', 2);
		graph.addEdge('D', 'F', 2);
		graph.addEdge('E', 'F', 3);
		graph.addEdge('F', 'D', 2);
		
		Prims prims = new Prims(graph);
		prims.calculateMST();
		prims.printMSTPath();
	}
}
