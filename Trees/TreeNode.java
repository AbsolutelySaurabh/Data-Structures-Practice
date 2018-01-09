package Trees;

public class TreeNode<T> {
	
	//the tree node will contain the methods
	//numberChild--> to calculate the number of children;
	//addChild--> an array to add child to the tree node.
	
	public T data;
	public TreeNode[] children;
	public int childcount;
	
	//constructor
	public TreeNode(T data) {
		this.data = data;
		this.childcount = 0;
		//initialising an array of children.
		children = new TreeNode[5];
		
	}
	
	public int numChild() {
		return childcount;
	}
	
	//method to add child to treenode
	public void addChild(TreeNode<T> child) {
		children[childcount] = child;
		childcount++;
	}
	
	//method to get the child
	public TreeNode getchild(int childindex) {
		return children[childindex];
	}
	
}

