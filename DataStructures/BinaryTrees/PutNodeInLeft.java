package BinaryTrees;

public class PutNodeInLeft {
	
	public static void replaceNode(BinaryTreeNode<Integer> node) {
		
		if(node == null) {
			return;
		}
		
		replaceNode(node.left);
		
		//create a new node which has the data as the oldnode
		/**
		 * DO NOT DO THIS, IT'S A SHALOW COPY, i.e.
		 * 
		 * 			BinaryTreeNode<Integer> newNode = node;
		 * 
		 * By this, the newNode will point to the oldNode, and whatever there will the changes in the oldNode,
		 * that changes will also be reflected in the newNode.
		 * So do this,  
		 * 			
		 * 			BinaryTreeNode<Integer> newNode = new BinaryTreeNode(node.data);
		 *			newNode.left = node.left
		 * 
		 * The above is an example of deep copy.
		 */
		
		BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(node.data);
		newNode.left = node.left;
		newNode.right = null;
		node.left = newNode;
		replaceNode(node.right);
	}
	
	//Need to resolve this method
	public static void printBinaryTree(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " ");
		printBinaryTree(root.left);
		printBinaryTree(root.right);
	}
	
	public static void main(String[] args) {

		BinaryTreeNode<Integer> head = BinaryTreeUse.buildBinaryTree();
		replaceNode(head);
		printBinaryTree(head);
	}
}
