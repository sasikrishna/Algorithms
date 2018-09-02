package com.algorithms.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem statement: Topological sorting using Kahns algorithm
 * 
 * @author Sasi Jolla on 25-Aug-2018, 6:01:11 pm
 */
public class KahnsAlgorithm{
	
	/**
	 * 
	 * @param vertices
	 * @param adjList
	 * @returns 
	 * @throws Exception 
	 */
	public static List<Integer> getTopologicalOrder(int vertices[], 
			ArrayList<Integer> adjListArray[]) throws Exception{
		
		int inDegree[] = new int[vertices.length];
		
		/**Finding in-degree for all vertexes*/
		for(int i = 0; i < adjListArray.length; i++){
			List<Integer> adjList = adjListArray[i];
			for(Integer vertex : adjList){
				inDegree[vertex]++;
			}
		}
		
		/**Adding all vertexes to queue whose in-degree is 0*/
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i = 0; i < inDegree.length; i++){
			if(inDegree[i] == 0){
				queue.add(i);
			}
		}
		
		/**If queue is empty then given graph contains cycle and topological sorting is not possible*/
		if(queue.size() == 0){
			throw new Exception("Topological not possible.");
		}
		
		List<Integer> tpOrder = new ArrayList<>();
		while(!queue.isEmpty()){
			Integer vertex = queue.poll();
			tpOrder.add(vertex);
			
			List<Integer> adjList = adjListArray[vertex];
			for(Integer adjVertex : adjList){
				/**Adding vertex to queue if in-degree becomes zero for vertex*/
				if(--inDegree[adjVertex] == 0){
					queue.add(adjVertex);
				}
			}
		}
		
		return tpOrder;
	}
	
	/**
	 * 
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		DirectedGraph graph = new DirectedGraph(8);
        graph.addEdge(7, 6);
        graph.addEdge(7, 5);
        graph.addEdge(6, 4);
        graph.addEdge(6, 3);
        graph.addEdge(5, 4);
        graph.addEdge(5, 2);
        graph.addEdge(3, 1);
        graph.addEdge(2, 1);
        graph.addEdge(1, 0);
        
        System.out.println("Topological sort order is " + getTopologicalOrder(graph.vertexes, graph.adjList));
	}
}
