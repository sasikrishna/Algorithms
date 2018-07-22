package com.algorithms.binarytree;

/**
 * 
 * @author Sasi Jolla on 21-Jul-2018, 5:43:37 pm
 */
public class FoldableBinaryTree {
	
	/**
	 * 
	 * @param root
	 * @returns true if tree is foldable else false
	 */
	public static boolean isFoldable(Node<Integer> root){
		mirrorTree(root.left);
		Boolean isFoldable = isStrucutureSame(root.left, root.right);
		mirrorTree(root.left);
		return isFoldable;
	}
	
	/**
	 * 
	 * @param left
	 * @param right
	 * @returns true if left and right subtree both shares same structure 
	 */
	private static boolean isStrucutureSame(Node<Integer> left, Node<Integer> right){
		
		if(null == left && null == right){
			return true;
		}
		
		if(left != null && right == null || 
				left != null && right == null){
			return false;
		}
		
		return isStrucutureSame(left.left, right.left) && isStrucutureSame(left.right, right.right);
	}
	
	/**
	 * 
	 * @param root
	 */
	private static void mirrorTree(Node<Integer> root){
		if(null == root){
			return;
		}
		mirrorTree(root.left);
		mirrorTree(root.right);

		Node<Integer> temp = root.right;
		root.right = root.left;
		root.left = temp;
	}
	
	public static void main(String[] args) {
        /* The constructed binary tree is
             1
           /   \
          2     3
           \    /
            4  5
        */
        Node<Integer> root = new Node<Integer>(1);
        root.left = new Node<Integer>(2);
        root.right = new Node<Integer>(3);
        root.right.left = new Node<Integer>(4);
        root.left.right = new Node<Integer>(5);
        
        Node.preOrderTraversal(root);
        System.out.println(" is foldable " + isFoldable(root));
	}
}
