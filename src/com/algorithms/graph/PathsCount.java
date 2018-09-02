package com.algorithms.graph;

/**
 * Problem statement: Count all possible walks from a source to a destination with exactly k edges
 * 
 * @author Sasi Jolla on 01-Sep-2018, 10:13:12 am
 */
public class PathsCount {

	/**
	 * 
	 * @param graph
	 *            in adjacency matrix form
	 * @param source
	 * @param destination
	 * @param k
	 *            represents numbers of edges between source and destination
	 * @return
	 */
	public Integer getPathsCount(int graph[][], int source, int destination, int k) {
		int count = 0;

		/** Base cases */
		if (k == 0 && source == destination) {
			return 1;
		}
		else if (k == 1 && graph[source][destination] == 1) {
			return 1;
		}
		else if (k <= 0) {
			return 0;
		}

		for (int i = 0; i < graph[0].length; i++) {
			if (graph[source][i] == 1) {
				count += getPathsCount(graph, i, destination, k - 1);
			}
		}

		return count;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int graph[][] = new int[][] { { 0, 1, 1, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 0 } };
		int source = 0, destination = 3, k = 2;

		PathsCount count = new PathsCount();
		System.out.println("Total paths count with " + k + " edges is "
				+ count.getPathsCount(graph, source, destination, k));
	}
}
