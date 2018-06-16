package com.algorithms.hackerrank.ctci;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * Dijkstras single source shortest path algorithm implementation.
 * 
 * @author Sasi Jolla on 16-Jun-2018, 6:15:38 pm
 */
public class SingleSourceShortestPath {

	public static class Graph {
		
		int[][] adjancencyMatrix;
		Map<Integer, Integer> visitedVertexes;
		Map<Integer, Integer> parentVertexes;
		int[] distance;
		
		public Graph(int size) {
			adjancencyMatrix = new int[size][size];
			distance = new int[size];
			visitedVertexes = new HashMap<>();
			parentVertexes = new HashMap<>();
			
			for(int i = 0; i < size; i++){
				distance[i] = -1;
			}
		}

		public void addEdge(int first, int second) {
			adjancencyMatrix[first][second] = 1;
		}

		public int[] shortestReach(int startId) {

			//Initializing visitedVertexes map with max value
			for(int i = 0; i < adjancencyMatrix.length; i++){
				visitedVertexes.put((i), Integer.MAX_VALUE - 1);
			}
			
			//Keeping 0 for source as distance to itself is 0
			visitedVertexes.put(startId, 0);
			
			while(visitedVertexes.size() != 0){
				Integer parentNode = getMinVertex();
				
				//Removing above parent from map
				visitedVertexes.remove(parentNode);
				
				List<Integer> childNodes = getAllChildNodes(parentNode);
				for(Integer child : childNodes){
					if(!visitedVertexes.containsKey(child)){
						continue;
					}
					
					if(visitedVertexes.get(child) == Integer.MAX_VALUE - 1){
						parentVertexes.put(child, parentNode);
						
						Integer newDistance = ((distance[parentNode] == -1) ? 0 : distance[parentNode])
								+ 6;
						distance[child] = newDistance;
						visitedVertexes.put(child, newDistance);
					}else{
						Integer currentDistance = visitedVertexes.get(child);
						Integer newDistance = ((distance[parentNode] == -1) ? 0 : distance[parentNode])
												+ 6;
						
						if(newDistance < currentDistance){
							parentVertexes.put(child, parentNode);
							distance[child] = newDistance;
							visitedVertexes.put(child, newDistance);
						}
					}
				}
			}
			
			return distance;
		}
		
		private Integer getMinVertex(){
			int minDistance = Integer.MAX_VALUE; 
			Integer minVertex = null;
			for(Entry<Integer, Integer> entry : visitedVertexes.entrySet()){
				
				if(entry.getValue() < minDistance){
					minDistance = entry.getValue();
					minVertex = entry.getKey();
				}
			}
			return minVertex;
		}
		
		private List<Integer> getAllChildNodes(Integer source){
			List<Integer> childNodes = new ArrayList<>();
			
			for(int i = 0; i < adjancencyMatrix[0].length; i++){
				if(adjancencyMatrix[source][i] == 1){
					childNodes.add(i);
				}
			}
			
			return childNodes;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int queries = scanner.nextInt();

		for (int t = 0; t < queries; t++) {

			// Create a graph of size n where each edge weight is 6:
			Graph graph = new Graph(scanner.nextInt());
			int m = scanner.nextInt();

			// read and set edges
			for (int i = 0; i < m; i++) {
				int u = scanner.nextInt() - 1;
				int v = scanner.nextInt() - 1;

				// add each edge to the graph
				graph.addEdge(u, v);
			}

			// Find shortest reach from node s
			int startId = scanner.nextInt() - 1;
			int[] distances = graph.shortestReach(startId);

			for (int i = 0; i < distances.length; i++) {
				if (i != startId) {
					System.out.print(distances[i]);
					System.out.print(" ");
				}
			}
			System.out.println();
		}

		scanner.close();
	}
}
