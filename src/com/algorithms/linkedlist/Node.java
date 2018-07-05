package com.algorithms.linkedlist;

/**
 * 
 * @author Sasi Jolla on 04-Jul-2018, 11:13:07 pm
 */
public class Node<T> {
	
	public T data;
	public Node<T> prev;
	public Node<T> next;
	
	public Node(T data) {
		this.data = data;
	}

	@Override
	public boolean equals(Object obj) {
		
		if(null == obj){
			return false;
		}
		
		return this.data == ((Node<?>)obj).data;
	}

	@Override
	public String toString() {
		return data.toString();
	}
}
