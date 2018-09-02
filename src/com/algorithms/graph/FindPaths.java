package com.algorithms.graph;

/**
 * Problem statement: Count the total number of ways or paths that exist between
 * two vertices in a directed graph. These paths doesn’t contain a cycle, the
 * simple enough reason is that a cylce contain infinite number of paths and
 * hence they create problem.
 * 
 * @author Sasi Jolla on 22-Aug-2018, 10:10:33 am
 */
public class FindPaths extends DirectedGraph {

	/**
	 * 
	 * @param vertices
	 */
	public FindPaths(int vertices) {
		super(vertices);
	}

	/**
	 * 
	 * @param source
	 * @param destination
	 * 
	 * @return count of paths between given source and destination vertexes
	 */
	public int printAllPaths(int source, int destination) {
		boolean visitedArray[] = new boolean[vertexesCount];
		return printAllPaths(source, destination, visitedArray, 0, source + "");
	}

	/**
	 * 
	 * @param source
	 * @param destination
	 * @param visitedArray
	 * @param pathCount
	 * 
	 * @return count of paths between given source and destination vertexes
	 */
	private int printAllPaths(int source, int destination, boolean visitedArray[], int pathCount, String path) {
		visitedArray[source] = true;

		if (source == destination) {
			System.out.println(path);
			pathCount++;
		}
		else {
			for (int vertex : adjList[source]) {
				if (!visitedArray[vertex]) {
					pathCount = printAllPaths(vertex, destination, visitedArray, pathCount,
							path.concat(" --> " + vertex));
				}
			}
		}

		visitedArray[source] = false;
		return pathCount;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		FindPaths graph = new FindPaths(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(2, 0);
		graph.addEdge(2, 1);
		graph.addEdge(1, 3);
		
		System.out.println("Total paths between node 2 and 3 is " + graph.printAllPaths(2, 3));
	}
}
