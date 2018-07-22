package com.algorithms.binarytree;

/**
 * Problem statement: Inorder traversal in O(1) space using morris traversal technique.
 * 
 * @author Sasi Jolla on 22-Jul-2018, 1:28:59 pm
 */
public class MorrisInorderTraversal {
	
	/**
	 * The idea is to create a link between current node and its predecessor. So after traversing the left subtree we can easily come back to root using this predecessor's right.
	 * 
	 * Time complexity: O(n)
	 * Space complexity: O(1)
	 * 
	 * @param root
	 */
	public static void findInorder(Node<Integer> root){
		Node<Integer> current = root;
		
		while(null != current){
			/**Print current node and move to right subtree if left is null*/
			if(null == current.left){
				System.out.print(current.data + " ");
				current = current.right;
			}else{
				Node<Integer> predecessor = current.left;
				/**Traversing right most node in left subtree to find predecessor for current node*/
                while(current != predecessor.right && null != predecessor.right){
                    predecessor = predecessor.right;
                }
                
				if(null == predecessor.right){
					/**Creating link between current node and its predecessor*/
					predecessor.right = current;
					current = current.left;
				}else{
					System.out.print(current.data + " ");
					current = current.right;
					predecessor.right = null;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(10);
        root.left = new Node<Integer>(11);
        root.left.left = new Node<Integer>(7);
        root.right = new Node<Integer>(9);
        root.right.left = new Node<Integer>(15);
        root.right.right = new Node<Integer>(8);
        findInorder(root);
	}
}
