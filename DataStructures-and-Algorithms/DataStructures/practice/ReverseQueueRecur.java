package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ReverseQueueRecur {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		while(n!=-1) {
			queue.add(n);
			n = s.nextInt();
		}
		queue = reverse(queue);
		printQueue(queue);
		s.close();
	}

	private static void printQueue(Queue<Integer> queue) {
		if(queue.size() == 0) {
			return;
		}
		System.out.println(queue.peek());
		queue.remove();
		printQueue(queue);
	}

	private static Queue<Integer> reverse(Queue<Integer> queue) {
		
		if(queue.size() == 0) {
			return queue;
		}
		
		int front = queue.peek();
		queue.remove();
		queue = reverse(queue);
		queue.add(front);
		return queue;
	}
}
