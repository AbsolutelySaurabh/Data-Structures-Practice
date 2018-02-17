package Queues;
import java.util.*;

public class Collection {
	
	public static void main(String[] args){
		
		Scanner s = new Scanner(System.in);
		
		// as Queue is an interface so LinkedList is a class which implements the queue
		Queue<Integer> q = new LinkedList();
		
		q.add(2);
		//returns 2
		q.remove();
		
	}
}
