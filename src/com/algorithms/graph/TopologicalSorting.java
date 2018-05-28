package com.algorithms.graph;

import java.util.HashSet;
import java.util.Set;

import com.algorithms.graph.traversals.GraphTraversal;
import com.datastructures.linear.Stack;

/**
 * 
 * @author Sasi on 29-May-2018, 12:23:01 am
 */
public class TopologicalSorting extends GraphTraversal{

	public TopologicalSorting(int vertexCount) {
		super(vertexCount);
	}

	@Override
	public void traverse() {
		
		if(isGraphCyclic()){
			System.out.println("Graph is cyclic so topological sort is not possible.");
			return;
		}
		
		Set<Vertex> visitedList = new HashSet<>();
		Stack<Vertex> sortedVertexes = new Stack<Vertex>();
		Stack<Integer> traversedStack = new Stack<Integer>();
		traversedStack.push(0);
		markVertexAsVisited(0);
		visitedList.add(vertex[0]);
		
		while(!traversedStack.isEmpty()){
			int unVisitedIndex = getAdjancentUnVisitedVertex(traversedStack.peek());
			
			if(unVisitedIndex != -1){
				traversedStack.push(unVisitedIndex);
				markVertexAsVisited(unVisitedIndex);
				visitedList.add(vertex[unVisitedIndex]);
				continue;
			}
			
			sortedVertexes.push(vertex[traversedStack.pop()]);
		}
		
		while(!sortedVertexes.isEmpty()){
			System.out.print(sortedVertexes.pop().label + " ");
		}
	}
	
	public static void main(String[] args) throws Exception {
		GraphTraversal bfs = new TopologicalSorting(5);
		bfs.addVertexes(new Character[]{'A', 'B', 'C', 'E', 'H'});
		bfs.addEdges(new int[][]{{0, 1, 0, 0, 0}, 
				                 {0, 0, 1, 0, 1}, 
				                 {0, 0, 0, 1, 0}, 
				                 {1, 0, 0, 0, 1}, 
				                 {0, 0, 0, 0, 0}});
		bfs.traverse();
	}
}
