package com.algorithms.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem statement: Check if a graph is strongly connected using Kosaraju's
 * algorithm.
 * 
 * @author Sasi Jolla on 28-Aug-2018, 10:31:46 pm
 */
public class StronglyConnectedComponents extends DirectedGraph {

	/**
	 * 
	 * @param vertexesCount
	 */
	public StronglyConnectedComponents(int vertexesCount) {
		super(vertexesCount);
	}

	/**
	 * 
	 * @returns true if graph is strongly connected else false
	 */
	public Boolean isStronglyConnected() {

		boolean visited[] = new boolean[vertexesCount];

		/** Getting DFS visited array to check all vertices are reachable */
		dfs(0, visited);

		/**
		 * If there is one false in visited array then there is node which
		 * cannot be reached so graph is not SCC
		 */
		for (int i = 0; i < vertexesCount; i++) {
			if (!visited[i]) {
				return false;
			}
		}

		/** Reversing graph edges */
		reverseGraphEdges();

		/** Resetting visited array */
		visited = new boolean[vertexesCount];

		/** Getting DFS visited array to check all vertices are reachable */
		dfs(0, visited);

		/**
		 * If there is one false in visited array then there is node which
		 * cannot be reached so graph is not SCC
		 */
		for (int i = 0; i < vertexesCount; i++) {
			if (!visited[i]) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 
	 * @param source
	 * @param visited
	 */
	private void dfs(int source, boolean visited[]) {
		visited[source] = true;
		List<Integer> vertices = adjList[source];
		
		if(null == vertices){
			return;
		}
		
		for (Integer vertex : vertices) {
			if (!visited[vertex]) {
				dfs(vertex, visited);
			}
		}
	}

	/**
	 * 
	 */
	private void reverseGraphEdges() {
		ArrayList<Integer> reversedAdjList[] = new ArrayList[vertexesCount];
		for (int i = 0; i < vertexesCount; i++) {
			List<Integer> vertices = adjList[i];
			if (vertices.size() == 0) {
				continue;
			}

			for (Integer vertex : vertices) {
				
				if(reversedAdjList[vertex] == null){
					reversedAdjList[vertex] = new ArrayList<Integer>();
				}
				
				reversedAdjList[vertex].add(i);
			}
		}
		this.adjList = reversedAdjList;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		StronglyConnectedComponents scc = new StronglyConnectedComponents(5);
		scc.addEdge(0, 1);
		scc.addEdge(1, 2);
		scc.addEdge(2, 3);
		scc.addEdge(3, 0);
		scc.addEdge(2, 4);
		scc.addEdge(4, 2);
		System.out.println("Is graph strongly connected " + scc.isStronglyConnected());
		
		scc = new StronglyConnectedComponents(4);
		scc.addEdge(0, 1);
		scc.addEdge(1, 2);
		scc.addEdge(2, 3);
		System.out.println("Is graph strongly connected " + scc.isStronglyConnected());
	}
}
