package com.algorithms.graph.traversals;

import com.datastructures.linear.Queue;

/**
 * 
 * @author Sasi on 28-May-2018, 10:51:36 pm
 */
public class BreadthFirstSearch extends GraphTraversal {

	public BreadthFirstSearch(int vertexCount) {
		super(vertexCount);
	}

	@Override
	public void traverse() {
		Queue<Integer> queue = new Queue<Integer>();
		queue.enQueue(0);
		printVertex(0);
		markVertexAsVisited(0);
		
		while(!queue.isEmpty()){
			int vertex = queue.deQueue();
			int unVisitedIndex = getAdjancentUnVisitedVertex(vertex);
			while(unVisitedIndex != -1){
				queue.enQueue(unVisitedIndex);
				printVertex(unVisitedIndex);
				markVertexAsVisited(unVisitedIndex);
				unVisitedIndex = getAdjancentUnVisitedVertex(vertex);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		GraphTraversal bfs = new BreadthFirstSearch(5);
		bfs.addVertexes(new Character[]{'A', 'B', 'C', 'E', 'H'});
		bfs.addEdges(new int[][]{{0, 1, 0, 0, 0}, 
				                 {0, 0, 1, 0, 1}, 
				                 {0, 0, 0, 1, 0}, 
				                 {0, 0, 0, 0, 1}, 
				                 {0, 0, 0, 0, 0}});
		bfs.traverse();
	}
}
