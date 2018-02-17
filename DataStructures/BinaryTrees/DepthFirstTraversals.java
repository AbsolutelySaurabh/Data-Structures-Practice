package BinaryTrees;

public class DepthFirstTraversals {
	
	//The inorder, preorder, postorder traversals are examples of "Depth First Traversals" in a tree(binary tree).
	
	public static void inorder(BinaryTreeNode<Integer> root) {
		
		if(root == null) {
			return;
		}
		inorder(root.left);
		System.out.println(root.data);
		inorder(root.right);
	}

	public static void postorder(BinaryTreeNode<Integer> root) {
		
		if(root == null) {
			return;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.println(root.data);
	}
	
	public static void preorder(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		System.out.println(root.data);
		preorder(root.left);
		preorder(root.right);
	}

	
	public static void main(String[] args) {
		System.out.println("InorderTraversal: ");
		inorder(new BinaryTreeUse().buildBinaryTree());
		
		System.out.println("Preorder traversal: ");
		preorder(new BinaryTreeUse().buildBinaryTree());
		
		System.out.println("Postorder traversal: ");
		postorder(new BinaryTreeUse().buildBinaryTree());
		
		
	}

}
