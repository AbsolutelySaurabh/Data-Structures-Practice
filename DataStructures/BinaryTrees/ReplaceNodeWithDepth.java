package BinaryTrees;

public class ReplaceNodeWithDepth {

	public static void main(String[] args) {
		
		//this method has time complexity O(n^2)
		replaceNodeWithDepth(BinaryTreeUse.buildBinaryTree());

		//this method has time complexity O(n)
		replaceNodeWithD(BinaryTreeUse.buildBinaryTree(), 0);
		
	}
	
	private static void replaceNodeWithD(BinaryTreeNode<Integer> root, int level) {
		
		//this method has time complexity of O(n)
		if(root == null) {
			return;
		}
		
		root.data = level;
		
		replaceNodeWithD(root.left,level+1);
		replaceNodeWithD(root.right,level+1);
		
	}
	
	private static void replaceNodeWithDepth(BinaryTreeNode<Integer> root) {
		
		int height = findHeight(root);
		for(int i=0;i<=height;i++) {
			//here we need 3 iterations if height = 2;
			replace(root, i, i);
		}
		BinaryTreeUse.printBinaryTree(root);
	}

	private static void replace(BinaryTreeNode<Integer> root, int i, int value) {
		
		if(root == null) {
			return;
		}
		
		if(i == 0) {
			//swap value, root.data
			root.data = value;
			
		}else
			if(i > 0) {
				replace(root.left, i-1, value);
				replace(root.right, i-1, value);
			}
		
	}

	private static int findHeight(BinaryTreeNode<Integer> root) {
		
		if(root == null) {
			return -1;
		}
		
		int left = findHeight(root.left);
		int right = findHeight(root.right);
		if(left > right) {
			return left+1;
		}else {
			return right+1;
		}
		
	}
}
