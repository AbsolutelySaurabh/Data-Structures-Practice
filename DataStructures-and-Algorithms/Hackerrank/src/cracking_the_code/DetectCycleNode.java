package cracking_the_code;

public class DetectCycleNode<T> {
	
	T data;
	DetectCycleNode<T> next;
	int isChecked;
	
	public DetectCycleNode(T data){
		
		this.data = data;
		this.next = null;
		this.isChecked = 0;
		
	}
	
	public DetectCycleNode(){
		
		//Empty constructor
	}

}
