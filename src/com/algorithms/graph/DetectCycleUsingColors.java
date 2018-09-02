package com.algorithms.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem statement: Given a directed graph write an algorithm to find out whether graph contains cycle or not.
 * 
 * @author Sasi Jolla on 22-Aug-2018, 10:59:36 pm
 */
public class DetectCycleUsingColors extends DirectedGraph{
	
	/**
	 * 
	 * @param vertices
	 */
	public DetectCycleUsingColors(int vertices) {
		super(vertices);
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isCyclic(){
		
		/**Contains all nodes which needs to be processed*/
		Set<Integer> whiteSet = new HashSet<Integer>();
		
		/**Contains all nodes which are being processed*/
		Set<Integer> greySet = new HashSet<Integer>();
		
		/**Contains all nodes which are done processing*/
		Set<Integer> blackSet = new HashSet<Integer>();
		
        for (int i = 0; i < vertexesCount ; i++) {
            whiteSet.add(i);
        }
        
		for(int i = 0; i < vertexesCount; i++){
			if(whiteSet.contains(i) 
					&& isCyclic(i, whiteSet, greySet, blackSet)){
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * 
	 * @param source
	 * @param whiteSet
	 * @param greySet
	 * @param blackSet
	 * @return
	 */
	private boolean isCyclic(int source, Set<Integer> whiteSet, 
			Set<Integer> greySet, Set<Integer> blackSet){
		
		whiteSet.remove(source);
		greySet.add(source);
		
		for(int vertex : adjList[source]){
			
			/**If vertex color is grey then it is being processed so cycle exists*/
			if(greySet.contains(vertex)){
				return true;
			}
			
			/**If vertex color is black then it is already processed so skipping this vertex*/
			if(blackSet.contains(vertex)){
				continue;
			}
			
			if(isCyclic(vertex, whiteSet, greySet, blackSet)){
				return true;
			}
		}
		
		greySet.remove(source);
		blackSet.add(source);
		
		return false;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		DetectCycleUsingColors graph = new DetectCycleUsingColors(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 0);
        graph.addEdge(3, 4);
        
        if (graph.isCyclic()){
            System.out.println("Graph contains cycle");
        }
        else {
            System.out.println("Graph doesn't contains cycle");
        }
	}
}
