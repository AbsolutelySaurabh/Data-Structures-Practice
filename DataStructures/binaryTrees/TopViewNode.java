package binaryTrees;

public class TopViewNode {

	//helper class to print topview of a binary tree
	
	BinaryTreeNode<Integer> node;
	//horizontal distance
	int hd;
	
	public TopViewNode(BinaryTreeNode<Integer> node, int hd) {
		this.hd = hd;
		this.node = node;
	}
}
