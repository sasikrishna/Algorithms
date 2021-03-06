package com.algorithms.graph;

/**
 * 
 * @author Sasi
 */
public class Vertex {
	public Character label;
	public Integer weight;
	public Boolean isVisited = false;
	
	public Character sourceLabel;
	
	public Vertex(Character label) {
		super();
		this.label = label;
	}

	public Vertex(Character label, Integer weight) {
		super();
		this.label = label;
		this.weight = weight;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Vertex [label=");
		builder.append(label);
		builder.append(", weight=");
		builder.append(weight);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public boolean equals(Object obj) {
		
		if(null == obj){
			return false;
		}
		
		return this.label == ((Vertex)obj).label;
	}
}
