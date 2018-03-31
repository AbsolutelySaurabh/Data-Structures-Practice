package binaryTrees;

import binaryTrees.Height;

public class BalancedBT {

	//A balanced BT is a tree in which the height of the left and right subtree differ by 1 or less than 1.
	
	
	public static Boolean checkBalanced(BinaryTreeNode<Integer> root) {
		
		//THIS METHOS IS O(n^2).
		
		if(root == null) {
			return true;
		}
		
		int left = findHeight(root.left);
		int right = findHeight(root.right);
		
		if(Math.abs(left-right) <= 1 && checkBalanced(root.left) && checkBalanced(root.right)) {
			return true;
		}
		//if we reach till here, it's not balanced.
		return false;
	}
	
	private static int findHeight(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		int left = findHeight(root.left);
		int right = findHeight(root.right);
		
		if(left>right) {
			return left+1;
		}else {
			return right+1;
		}
	}
	
	public static Boolean checkBalanced_2(BinaryTreeNode<Integer> root, Height height) {
		
		//THIS METHOD IS OPTIMISED WITH COMPLEXITY O(N).
		
		if(root == null) {
			height.height = 0;
			return true;
		}
		
		//here we are calculating from the bottom, so we need a Height class for so.
		
		Height rightHeight = new Height();
		Height leftHeight = new Height();
		
		Boolean left = checkBalanced_2(root.left, leftHeight);
		Boolean right = checkBalanced_2(root.right, rightHeight);
				
		int lh = leftHeight.height;
		int rh = rightHeight.height;
				
		if(lh > rh) {
			height.height = lh+1;
		}else {
			height.height = rh+1;
		}
		
		if(Math.abs(lh - rh) > 1) {
			return false;
		}else {
			return left&&right;
		}
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.buildBinaryTree();
		
		if(checkBalanced_2(root, new Height())) {
			System.out.println("Balanced");
		}else {
			System.out.println("Not Balanced");
		}
	}
}