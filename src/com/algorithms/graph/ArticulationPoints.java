package com.algorithms.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem statement: Articulation Points (or Cut Vertices) in a Graph
 * 
 * @author Sasi Jolla on 31-Aug-2018, 12:17:13 am
 */
public class ArticulationPoints extends UndirectedGraph{
	
	static int time = 0;
	
	public ArticulationPoints(int vertices) {
		super(vertices);
	}

	/**
	 * 
	 * @return
	 */
	public List<Integer> findArticulationPoints(){
		boolean visited[] = new boolean[vertices];
		
		int parent[] = new int[vertices];
		for(int i = 0; i < vertices; i++){
			parent[i] = -1;
		}
		
		int discoveredTime[] = new int[vertices];
		int lowTime[] = new int[vertices];
		List<Integer> ap = new ArrayList<>();
		
		/**Considering 0 as source vertex*/
		dfsUtil(0, visited, parent, ap, discoveredTime, lowTime);
		
		return ap;
	}
	
	/**
	 * 
	 * @param source
	 * @param visited
	 * @param parent
	 * @param ap
	 */
	private void dfsUtil(int source, boolean visited[], 
			int parent[], List<Integer> ap, int discoveredTime[], int lowTime[]){

		int childs = 0;
		discoveredTime[source] = lowTime[source] = ++time;
		visited[source] = true;
		
		ArrayList<Integer> adjVertices = adjList[source];
		for(Integer adjVertex : adjVertices){
			if(!visited[adjVertex]){
				
				parent[adjVertex] = source;
				childs++;
				
				/**Calling DFS for adj vertex*/
				dfsUtil(adjVertex, visited, parent, ap, discoveredTime, lowTime);
				
				/**If adj vertex have a back edge to ancestor of source then it's low will be less than current source.
				 * If there is such back edge then removing source vertex will not break graph into components.*/
				lowTime[source] = Math.min(lowTime[source], lowTime[adjVertex]);
				
				/***Checking for case 1 i.e if current vertex is source and it has childs greater than 1 then this is a articualtion point*/
				if(parent[source] == -1 && childs > 1){
					ap.add(source);
				}else if(parent[source] != -1 && lowTime[adjVertex] >= discoveredTime[source]){
					ap.add(source);
				}
			}else if(adjVertex != parent[source]){
				/**Vertex is already visited that means there is a back edge*/
				lowTime[source] = Math.min(lowTime[source], discoveredTime[adjVertex]);
			}
		}
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ArticulationPoints graph = new ArticulationPoints(5);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        System.out.println("Articulation points in given graph are " + graph.findArticulationPoints());
        
        graph = new ArticulationPoints(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        System.out.println("Articulation points in given graph are " + graph.findArticulationPoints());
	}
}
