package com.algorithms.graph;

/**
 * 
 * @author Sasi Jolla on 22-Aug-2018, 10:07:28 pm
 */
public class DetectCycleUndirectedGraph extends UndirectedGraph{
	
	/**
	 * 
	 * @param vertices
	 */
	public DetectCycleUndirectedGraph(int vertices) {
		super(vertices);
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isCyclic(){

		boolean visited[] = new boolean[vertices];
		for(int i = 0; i < vertices; i++){
			if(!visited[i]){
				if(isCyclic(i, visited, -1)){
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * 
	 * @param source
	 * @param visited
	 * @param parent
	 * @return
	 */
	public boolean isCyclic(int source, boolean visited[], int parent){
		visited[source] = true;
		
		for(int vertex : adjList[source]){
			if(!visited[vertex]){
				isCyclic(vertex, visited, parent);
			}else{
				if(vertex != parent){
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		DetectCycleUsingDFS graph = new DetectCycleUsingDFS(4);
		graph.addEdge(1, 0);
		graph.addEdge(0, 2);
		graph.addEdge(2, 0);
		graph.addEdge(0, 3);
		graph.addEdge(3, 4);

		if (graph.isCyclic()) {
			System.out.println("Graph contains cycle");
		}
		else {
			System.out.println("Graph doesn't contain cycle");
		}
		
		graph = new DetectCycleUsingDFS(3);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
        if (graph.isCyclic()){
            System.out.println("Graph contains cycle");
        }
        else {
            System.out.println("Graph doesn't contains cycle");
        }
	}
}
