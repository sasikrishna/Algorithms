package com.algorithms.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author Sasi Jolla on 26-Aug-2018, 11:36:42 pm
 */
public class ShortestPathDAG extends DirectedWeightedGraph {

	public ShortestPathDAG(int vertexesCount) {
		super(vertexesCount);
	}

	/**
	 * 
	 * @param source
	 * @throws Exception
	 */
	public void printShortestPath(int source) throws Exception{
		List<Integer> topologicalOrder = getTopologicalOrder(this.vertexes, this.adjList);
		System.out.println(topologicalOrder);
		
		int dist[] = new int[vertexesCount];
		for (int i = 0; i < vertexesCount; i++){
			dist[i] = Integer.MAX_VALUE;
		}
		dist[source] = 0;
		
		for(Integer vertex : topologicalOrder){
			if(dist[vertex] != Integer.MAX_VALUE){
				List<GraphEdge> adjEdges = this.adjList[vertex];
				
				for(GraphEdge edge : adjEdges){
					if(dist[edge.destination] > dist[edge.source] + edge.weight){
						dist[edge.destination] = dist[edge.source] + edge.weight;
					}
				}
			}
		}
		
		System.out.println("Shortest path distance is " + Arrays.toString(dist));
	}
	
	/**
	 * 
	 * @param vertices
	 * @param adjList
	 * @returns
	 */
	private static List<Integer> getTopologicalOrder(int vertices[], ArrayList<GraphEdge> adjListArray[])
			throws Exception {

		int inDegree[] = new int[vertices.length];

		/** Finding in-degree for all vertexes */
		for (int i = 0; i < adjListArray.length; i++) {
			List<GraphEdge> adjList = adjListArray[i];
			for (GraphEdge vertex : adjList) {
				inDegree[vertex.destination]++;
			}
		}

		/** Adding all vertexes to queue whose in-degree is 0 */
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < inDegree.length; i++) {
			if (inDegree[i] == 0) {
				queue.add(i);
			}
		}

		/**
		 * If queue is empty then given graph contains cycle and topological
		 * sorting is not possible
		 */
		if (queue.size() == 0) {
			throw new Exception("Topological not possible.");
		}

		List<Integer> tpOrder = new ArrayList<>();
		while (!queue.isEmpty()) {
			Integer vertex = queue.poll();
			tpOrder.add(vertex);

			List<GraphEdge> adjList = adjListArray[vertex];
			for (GraphEdge adjVertex : adjList) {
				/** Adding vertex to queue if in-degree becomes zero for vertex */
				if (--inDegree[adjVertex.destination] == 0) {
					queue.add(adjVertex.destination);
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
		ShortestPathDAG graph = new ShortestPathDAG(6);
		graph.addEdge(0, 1, 5);
		graph.addEdge(0, 2, 3);
		graph.addEdge(1, 3, 6);
		graph.addEdge(1, 2, 2);
		graph.addEdge(2, 4, 4);
		graph.addEdge(2, 5, 2);
		graph.addEdge(2, 3, 7);
		graph.addEdge(3, 4, -1);
		graph.addEdge(4, 5, -2);
		
		graph.printShortestPath(1);
	}
}
