package com.algorithms.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem statement: Given a directed graph, find out if a vertex v is
 * reachable from another vertex u for all vertex pairs (u, v) in the given
 * graph. Here reachable mean that there is a path from vertex u to v. The
 * reach-ability matrix is called transitive closure of a graph.
 * 
 * @author Sasi Jolla on 21-Aug-2018, 12:12:32 am
 */
public class TransitiveClosure {

	int vertices;
	ArrayList<Integer> adjList[];
	int tc[][];

	/**
	 * @param vertices
	 */
	public TransitiveClosure(int vertices) {
		this.vertices = vertices;
		adjList = new ArrayList[vertices];
		tc = new int[vertices][vertices];

		for (int i = 0; i < vertices; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
	}

	/**
	 * 
	 * @param source
	 * @param destination
	 */
	public void addEdge(int source, int destination) {
		adjList[source].add(destination);
	}

	/**
	 * 
	 * @param graph
	 */
	public void find() {
		for (int i = 0; i < vertices; i++) {
			find(i, i);
		}

		for (int i = 0; i < vertices; i++) {
			System.out.println(Arrays.toString(tc[i]));
		}
	}

	/**
	 * 
	 * @param source
	 * @param destination
	 */
	private void find(int source, int destination) {
		tc[source][destination] = 1;

		for (int vertex : adjList[destination]) {
			if (tc[source][vertex] == 0) {
				find(source, vertex);
			}
		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TransitiveClosure graph = new TransitiveClosure(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		System.out.println("Transitive closure is ");
		graph.find();
	}
}
