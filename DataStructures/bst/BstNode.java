package bst;

public class BstNode<T>{
	
	public T data;
	public BstNode<T> left, right;
	
	public BstNode(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

}
