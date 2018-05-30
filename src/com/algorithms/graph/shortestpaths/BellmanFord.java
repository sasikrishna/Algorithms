package com.algorithms.graph.shortestpaths;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.algorithms.graph.AdjacencyListGraph;
import com.algorithms.graph.Edge;
import com.algorithms.graph.Graph;
import com.algorithms.graph.Vertex;

/**
 * 
 * @author Sasi on 30-May-2018, 8:42:43 am
 */
public class BellmanFord {
	
	AdjacencyListGraph graph;
	Map<Character, Integer> distance;
	Map<Character, Character> parent;
	
	public BellmanFord(Graph graph){
		this.graph = (AdjacencyListGraph) graph;
		this.distance = new HashMap<Character, Integer>();
		this.parent = new HashMap<Character, Character>();
	}
	
	public void buildShortestPathDistance(Character source) throws Exception{
		Map<Character, List<Vertex>> adjancencyList= 
				 this.graph.getAdjancencyList();
		 
		//Initializing distance map with max value
		for(Entry<Character, List<Vertex>> entry : this.graph.getAdjancencyList().entrySet()){
			distance.put(entry.getKey(), Integer.MAX_VALUE);
		}
		distance.put(source, 0);
		parent.put(source, null);
		
		int v = adjancencyList.size();
		List<Edge> edges = graph.getAllEdges();
		
		for(int i = 0; i < v-1; i++){
			for(Edge edge : edges){
				
				if(distance.get(edge.source) == Integer.MAX_VALUE){                //Vertex hasn't been processed yet
					continue;
				}
				
				int newDistance = distance.get(edge.source) + edge.weight;
				if(newDistance < distance.get(edge.destination)){                  //Checking if distance till now is greater than distance from source vertex 
					distance.put(edge.destination, newDistance);
					parent.put(edge.destination, edge.source);
				}
			}
		}
		
		for(int i = 0; i < 1; i++){                                                //Iterating one more time to see if there is change in distances if so negative edge exists  
			for(Edge edge : edges){
				int newDistance = distance.get(edge.source) + edge.weight;
				if(newDistance < distance.get(edge.destination)){                                               
					throw new Exception("Negative edge exists so finding shortest path not possible");
				}
			}
		}
	}
	
	public void printDistances(){
		for(Entry<Character, Integer> entry : distance.entrySet()){
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
	}
	
	public static void main(String[] args) throws Exception {
		Graph graph = new AdjacencyListGraph();
		graph.addEdge('A', 'B', 5);
		graph.addEdge('A', 'D', 9);
		graph.addEdge('A', 'E', 2);
		graph.addEdge('B', 'C', 4);
		graph.addEdge('C', 'D', 2);
		graph.addEdge('D', 'F', 2);
		graph.addEdge('E', 'F', 3);
		graph.addEdge('F', 'D', 2);
		
		BellmanFord bellmanFord = new BellmanFord(graph);
		bellmanFord.buildShortestPathDistance('A');
		bellmanFord.printDistances();
	}
}
