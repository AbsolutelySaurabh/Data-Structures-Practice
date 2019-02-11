package linkedList;

import java.util.*;

public class ReverseK {
	
	public static Node overallHead;
	
	public static void main(String[] args){
		
		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		
		overallHead = LinkedList.takeInput();
		reverseK(overallHead, k);
		
		
	}
	
	public static void reverseK(Node node, int k){
		
		int num = LinkedList.length(overallHead, 0)/k;
		
		while(num!=0){
			
			Node nextHead = node;
			reverse(nextHead, k);
			nextHead = findNextHead(nextHead, k);
			num--;
		}
	}
	
	public static Node findNextHead(Node h, int k){
		
		if(k==0){
			return h;
		}
		
		return findNextHead(h.next, --k);
	}
	
	public static void reverse(Node head, int k){
		
		Node tail = findTail(head, k, 0);
		
		finallyReverse(head, tail, null, null, null);
		
		
	}
	
	public static void finallyReverse(Node head, Node tail, Node first, Node second, Node tempSecond){
		
		while(head.next!=null){
			
			second = head.next;
			tempSecond = head.next.next;
			second.next = first;
					
			Node tempHead = new Node();			
			tempHead = head;
				
			head = second;
			tempHead.next = null;
			second = tempSecond;
		}
						
	}
	
	public static Node findTail(Node n, int k, int count){
		
		if(count==k-1){
			
			return n;
		}
		
		return findTail(n.next, k, ++count);
	}
	

}
