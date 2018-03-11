/**
 * 
 */
package cracking_the_code;
import java.util.*;
/**
 * @author "AbsolutelySaurabh"
 */
public class DetectCycle {
	
	public static boolean detectCycle(DetectCycleNode<Integer> head) {
		
		if(head == null) {
			return false;
		}
		if(head.isChecked == 1) {
			return true;
		}else {
			head.isChecked = 1;
		}
		return detectCycle(head.next);
	}
		
	public static DetectCycleNode<Integer> takeInput() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the head: ");
		int n = s.nextInt();
		DetectCycleNode<Integer> head = null, temp = null;
		while(n!=-1){
			
			DetectCycleNode<Integer> newNode = new DetectCycleNode<Integer>(n);
			if(head == null){
				head = newNode;
				temp = head;
			}else{
				temp.next = newNode;
				temp = temp.next;
			}
			System.out.println("Enter next element: ");
			n = s.nextInt();	
		}
		return head;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static DetectCycleNode takeInputCyclic() {
		
		//dummy method where the  last element is pointing to the head;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the head: ");
		int n = s.nextInt();
		DetectCycleNode<Integer> head = null;
		DetectCycleNode<Integer> temp = null;
		//DetectCycleNode dummy = null;
		while(n!=-1){
			
			DetectCycleNode<Integer> newNode = new DetectCycleNode(n);
			if(head == null){
				head = newNode;
				temp = head;
			}else{
				temp.next = newNode;
				temp = temp.next;
			}
			System.out.println("Enter next element: ");
			n = s.nextInt();	
		}
		temp.next = head;
		s.close();
		return head;
	}



	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		DetectCycleNode<Integer> head = takeInputCyclic();
		if(detectCycle(head)) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
		
	}
}
