package com.algorithms.graph.traversals;

import com.algorithms.graph.Vertex;
import com.datastructures.linear.Stack;

/**
 * 
 * @author Sasi on 28-May-2018, 9:58:16 pm
 */
public abstract class GraphTraversal {

	protected Vertex[] vertex;
	protected int[][] edges;
	protected int vertexCount;

	
	public GraphTraversal(int vertexCount) {
		super();
		this.vertexCount = vertexCount;
		this.vertex = new Vertex[vertexCount];
		this.edges = new int[vertexCount][vertexCount];
	}

	public void addVertexes(Character[] labels) throws Exception {

		if (null == labels || labels.length != vertexCount) {
			throw new Exception("Vertexes count mismatched");
		}

		for (int i = 0; i < vertexCount; i++) {
			vertex[i] = new Vertex(labels[i]);
		}
	}
	
	public void addEdges(int[][] edges) throws Exception {

		if (null == edges) {
			throw new Exception("Edges shouldn't be null.");
		}
		this.edges = edges;
	}
	
	/**
	 * 
	 * @param vertex
	 * @return index of unvisited vertex (or) -1 if all vertexes are already visited
	 */
	public int getAdjancentUnVisitedVertex(int vertex){
		for(int j=0 ;j<vertexCount; j++){
			if(edges[vertex][j] == 1 && !(this.vertex[j].isVisited)){
				return j;
			}
		}
		return -1;
	}
	
	public void markVertexAsVisited(int vertex){
		this.vertex[vertex].isVisited = true;
	}
	
	public void markVertexAsNotVisited(int vertex){
		this.vertex[vertex].isVisited = false;
	}
	
	public void printVertex(int vertex){
		System.out.print(this.vertex[vertex].label + " ");
	}
	
	public boolean isGraphCyclic(){
		
		Stack<Integer> stack = null;
		for(int vertex = 0; vertex < vertexCount; vertex++){
			stack = new Stack<Integer>();
			stack.push(vertex);
			
			while(!stack.isEmpty()){
				int unVisitedVertex = getAdjancentUnVisitedVertex(stack.peek());
				
				if(unVisitedVertex == vertex){
					cleanVertexes();
					return true;
				}
				
				if(unVisitedVertex != -1){
					stack.push(unVisitedVertex);
					markVertexAsVisited(unVisitedVertex);
					continue;
				}
				
				stack.pop();
			}
		}
		
		cleanVertexes();
		return false;
	}
	
	public void cleanVertexes(){
		for(int vertex = 0; vertex < vertexCount; vertex++){
			markVertexAsNotVisited(vertex);
		}
	}
	
	/**
	 * Abstract method to be implemented by child classes like DFS or BFS 
	 */
	public abstract void traverse();
}