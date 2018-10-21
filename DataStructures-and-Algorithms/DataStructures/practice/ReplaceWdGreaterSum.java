package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Node<T>{
	T data;
	Node<T> left;
	Node<T> right;
	
	public Node(T data) {
		this.data = data;
		this.left = this.right = null;
	}
}

public class ReplaceWdGreaterSum {

	public static Scanner s = new Scanner(System.in);
	
	public static int replaceGreater(Node<Integer> root, int data) {
		if(root == null) {
			return 0;
		}
		data = data + replaceGreater(root.right, data);
		root.data+=data;
		int new_data = replaceGreater(root.left, root.data);
		if(new_data == 0) {
			return root.data;
		}
		return new_data;
	}

	public static void printTree(Node<Integer> root) {
		
		if(root == null) {
			return;
		}
		System.out.println(root.data);
		printTree(root.left);
		printTree(root.right);
	}
	
	public static void main(String[] args) {

		int t;
		t = s.nextInt();
		
		while(t>0) {
			
			int edges = s.nextInt();
			Queue<Node> queue = new LinkedList<>();
			Node<Integer> root = null, temp_root = null;
			while(edges > 0) {
				
				int first = s.nextInt();
				Node<Integer> node_first = new Node<>(first);
				int second = s.nextInt();
				Node<Integer> node_second = new Node<>(second);
				
				//add first only during the first time
				if(root == null) {
					queue.add(node_first);
				}
				queue.add(node_second);
				
				if(root == null) {
					root = queue.peek();
					temp_root = root;
				}
				
				if(node_first.data != queue.peek().data) {
					while(node_first.data!=queue.peek().data) {
						queue.remove();
					}
					temp_root = queue.peek();
				}
				
				
				char c = s.next().charAt(0);
				
				if(c == 'L') {
					
					temp_root.left = node_second;					
				}else
					if(c == 'R') {
						
						temp_root.right = node_second;
					}
	
				edges--;
			}
			
			printTree(root);
			replaceGreater(root, 0);
			printTree(root);
			t--;
		}
		
	}

}
