package LinkedList;

public class Node<T> {
	
	T data;
	Node next;
	
	public Node(T data){
		
		this.data = data;
		this.next = null;
		
	}
	
	public Node(){
		
		//Empty constructor
	}

}
