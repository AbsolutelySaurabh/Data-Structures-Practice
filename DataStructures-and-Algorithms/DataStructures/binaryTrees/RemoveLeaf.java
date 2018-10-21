package binaryTrees;

public class RemoveLeaf {
	
	public static void removeLeaf(BinaryTreeNode<Integer> root) {
		
		if(root == null) {
			return;
		}
		if(root.left!=null) {
			if(root.left.left == null && root.left.right == null) {
				root.left = null;
			}
		}
		
		if(root.right!=null) {
			if(root.right.left == null && root.right.right == null) {
				root.right = null;
			}
		}
		removeLeaf(root.left);
		removeLeaf(root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode<Integer> root = BinaryTreeUse.buildBinaryTree();
		removeLeaf(root);
		BinaryTreeUse.printBinaryTree(root);
	}
}
