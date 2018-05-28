package com.algorithms.graph.traversals;

import com.datastructures.linear.Stack;

/**
 * 
 * @author Sasi on 28-May-2018, 9:43:18 pm
 */
public class DepthFirstSearch extends GraphTraversal {
	
	public DepthFirstSearch(int vertexCount) {
		super(vertexCount);
	}
	
	@Override
	public void traverse(){
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		printVertex(0);
		markVertexAsVisited(0);
		
		while(!stack.isEmpty()){
			int unVisitedVertex = getAdjancentUnVisitedVertex(stack.peek());
			if(unVisitedVertex == -1){                                  
				stack.pop();											//Poping vertex from stack as there are not out going edges.
			}else{
				printVertex(unVisitedVertex);
				markVertexAsVisited(unVisitedVertex);
				stack.push(unVisitedVertex);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		GraphTraversal dfs = new DepthFirstSearch(5);
		dfs.addVertexes(new Character[]{'A', 'B', 'C', 'E', 'H'});
		dfs.addEdges(new int[][]{{0, 1, 0, 0, 0}, 
				                 {0, 0, 1, 0, 1}, 
				                 {0, 0, 0, 1, 0}, 
				                 {0, 0, 0, 0, 1}, 
				                 {0, 0, 0, 0, 0}});
		dfs.traverse();
	}
}
