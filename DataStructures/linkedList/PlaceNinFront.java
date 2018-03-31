package linkedList;

import java.util.Scanner;

public class PlaceNinFront {
	
	public static Node newTail = null, overallHead, newHead = null;
	public static void main(String[] args){
		
		Scanner s = new Scanner(System.in);
		
		overallHead = LinkedList.takeInput();
		Node tail = LinkedList.findTail(overallHead);
		
		int n = s.nextInt();
		placeNinfront(overallHead, tail, n, 0);
		
		LinkedList.printOutput(newHead);
						
	}
	
	public static void placeNinfront(Node head, Node tail, int n, int count){
				
		if(count == LinkedList.length(overallHead, 0 )-n-1){
			
			newHead = head.next;
			newTail = head;
			head.next = null;
			tail.next = overallHead;
			
			return;
		}else{
		
			placeNinfront(head.next, tail, n, ++count);
		}
	}
}
