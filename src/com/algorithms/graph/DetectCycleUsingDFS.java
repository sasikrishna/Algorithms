package com.algorithms.graph;

/**
 * Problem statement: Given a directed graph, check whether the graph contains a cycle or not using DFS
 * 
 * @author Sasi Jolla on 22-Aug-2018, 5:50:07 pm
 */
public class DetectCycleUsingDFS extends DirectedGraph {

	/**
	 * 
	 * @param vertices
	 */
	public DetectCycleUsingDFS(int vertices) {
		super(vertices);
	}

	/**
	 * 
	 * @returns
	 */
	public boolean isCyclic() {

		/**We'll maintain a path stack to find if vertex is already found in current path*/
		boolean recStack[] = new boolean[vertexesCount];
		boolean visited[] = new boolean[vertexesCount];

		for (int source = 0; source < vertexesCount; source++) {
			if (isCycleExists(source, recStack, visited)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 
	 * @param source
	 * @param recStack
	 * @param visited
	 * @return
	 */
	private boolean isCycleExists(int source, boolean recStack[], boolean visited[]) {

		if (recStack[source]) {
			return true;
		}

		if (visited[source]) {
			return false;
		}

		recStack[source] = true;
		visited[source] = true;

		for (int vertex : adjList[source]) {
			if (isCycleExists(vertex, recStack, visited)) {
				return true;
			}
		}

		recStack[source] = false;
		return false;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		DetectCycleUsingDFS graph = new DetectCycleUsingDFS(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);

		if (graph.isCyclic()) {
			System.out.println("Graph contains cycle");
		}
		else {
			System.out.println("Graph doesn't contain cycle");
		}
	}
}
