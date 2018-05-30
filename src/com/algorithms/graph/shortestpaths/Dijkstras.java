package com.algorithms.graph.shortestpaths;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.algorithms.graph.AdjacencyListGraph;
import com.algorithms.graph.Graph;
import com.algorithms.graph.Vertex;

/**
 * 
 * @author Sasi on 29-May-2018, 8:12:18 am
 */
public class Dijkstras {
	
	AdjacencyListGraph graph;
	Map<Character, Integer> visitedVertexes;
	Map<Character, Character> parentVertexes;
	Map<Character, Integer> distance;
	
	public Dijkstras(Graph graph){
		visitedVertexes = new HashMap<>();
		parentVertexes = new HashMap<>();
		distance = new HashMap<>();
		this.graph = (AdjacencyListGraph) graph;
	}
	
	public void buildShortestPathDistance(Character source){
		Map<Character, List<Vertex>> adjacencyList = graph.getAdjancencyList();
		
		//Initializing visitedVertexes map with max value
		for(Entry<Character, List<Vertex>> entry : adjacencyList.entrySet()){
			visitedVertexes.put(entry.getKey(), Integer.MAX_VALUE);
		}
		
		//Keeping 0 for source as distance to itself is 0
		visitedVertexes.put(source, 0);
		
		while(visitedVertexes.size() != 0){
			Character parentNode = getMinVertex();
			
			//Removing above parent from map
			visitedVertexes.remove(parentNode);
			
			List<Vertex> childNodes = adjacencyList.get(parentNode);
			for(Vertex child : childNodes){
				if(!visitedVertexes.containsKey(child.label)){
					continue;
				}
				
				if(visitedVertexes.get(child.label) == Integer.MAX_VALUE){
					parentVertexes.put(child.label, parentNode);
					
					Integer newDistance = ((distance.get(parentNode) == null) ? 0 : distance.get(parentNode))
							+ child.weight;
					distance.put(child.label, newDistance);
					visitedVertexes.put(child.label, newDistance);
				}else{
					Integer currentDistance = visitedVertexes.get(child.label);
					Integer newDistance = ((distance.get(parentNode) == null) ? 0 : distance.get(parentNode))
											+ child.weight;
					
					if(newDistance < currentDistance){
						parentVertexes.put(child.label, parentNode);
						distance.put(child.label, newDistance);
						visitedVertexes.put(child.label, newDistance);
					}
				}
			}
		}
	}
	
	public void printDistances(){
		System.out.println(distance);
	}
	
	private Character getMinVertex(){
		
		int minDistance = Integer.MAX_VALUE; 
		Character minVertexCharacter = null;
		for(Entry<Character, Integer> entry : visitedVertexes.entrySet()){
			
			if(entry.getValue() < minDistance){
				minDistance = entry.getValue();
				minVertexCharacter = entry.getKey();
			}
		}
		return minVertexCharacter;
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
		
		Dijkstras dijkstras = new Dijkstras(graph);
		dijkstras.buildShortestPathDistance('A');
		dijkstras.printDistances();
	}
}
