package com.algorithms.binarytree;

/**
 * 
 */
public class Node<T> {
	T data;
	Node<T> left;
	Node<T> right;

	/**To solve inorder successor problems*/
	Node<T> next, prev;
	
	public Node(T data) {
		super();
		this.data = data;
	}
	
	public static void preOrderTraversal(Node<?> root){
		if(null != root){
			System.out.print(root.data + " ");
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if(null == obj){
			return false;
		}
		Node<?> node = (Node<?>) obj;
		return this.data == node.data;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Node [data=");
		builder.append(data);
		builder.append(", left=");
		builder.append(left);
		builder.append(", right=");
		builder.append(right);
		builder.append("]");
		return builder.toString();
	}
}
