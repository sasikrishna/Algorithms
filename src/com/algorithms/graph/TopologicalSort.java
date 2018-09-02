package com.algorithms.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Problem statement: Topological sorting using DFS algorithm
 * 
 * @author Sasi Jolla on 23-Aug-2018, 11:16:48 pm
 */
public class TopologicalSort extends DirectedGraph {
	
	public TopologicalSort(int vertices) {
		super(vertices);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Integer> getTopologicalOrder(){
		List<Integer> order = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[vertexesCount];
		
		for(int i = 0; i < vertexesCount; i++){
			if(!visited[i]){
				findTopologicalOrder(i, visited, stack);
			}
		}
		
		while(!stack.isEmpty()){
			order.add(stack.pop());
		}
		
		return order;
	}
	
	/**
	 * 
	 * @param source
	 * @param visited
	 * @param stack
	 */
	private void findTopologicalOrder(int source, boolean visited[], 
			Stack<Integer> stack){
		visited[source] = true;
		
		for(int vertex : adjList[source]){
			if(!visited[vertex]){
				findTopologicalOrder(vertex, visited, stack);
			}
		}
		
		stack.push(source);
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TopologicalSort graph = new TopologicalSort(8);
        graph.addEdge(7, 6);
        graph.addEdge(7, 5);
        graph.addEdge(6, 4);
        graph.addEdge(6, 3);
        graph.addEdge(5, 4);
        graph.addEdge(5, 2);
        graph.addEdge(3, 1);
        graph.addEdge(2, 1);
        graph.addEdge(1, 0);
        
        System.out.println("Topological sort order is " + graph.getTopologicalOrder());
	}
}
