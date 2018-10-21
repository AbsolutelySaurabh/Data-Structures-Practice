package trees;
import java.util.Scanner;
import sun.misc.Queue;

class Node<T>{
	
	T data;
	Node<T> left, right;
	
	public Node(T data) {
		this.data = data;
		this.left = this.right = null;
	}
	
}
public class TopView {
	
	
	public static void printLevelOrder(Node<Integer> root) throws InterruptedException {
		
		if(root == null) {
			return;
		}
		Queue<Node<Integer>> queue = new Queue<>();
		queue.enqueue(root);
		while(!queue.isEmpty()) {
			
			Node<Integer> node = queue.dequeue();
			System.out.println(node.data);
			if(node.left!=null) {
				queue.enqueue(node.left);
			}
			if(node.right!=null) {
				queue.enqueue(node.right);
			}
			
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter data in Root-Left-Right manner : ");
		int n = s.nextInt();
		
		Queue<Node<Integer>> queue = new Queue<Node<Integer>>();
		Node<Integer> root = null;
		while(!queue.isEmpty() || root==null) {
			
			 if(root == null) {
				 root = new Node<>(n);
				 queue.enqueue(root);
			 }
			 
			 Node<Integer> root_node = queue.dequeue();
			 
			 System.out.println("Enter left child of " + root_node.data + " : ");
			 int left = s.nextInt();
			 if(left!=-1) {
				 Node<Integer> leftNode = new Node<>(left);
				 root_node.left = leftNode;
				 queue.enqueue(leftNode); 
			 }
			 
			 System.out.println("Enter rught child of " + root_node.data + " : ");
			 int right = s.nextInt();
			 if(right!=-1) {
				 Node<Integer> rightNode = new Node<>(right);
				 root_node.right = rightNode;
				 queue.enqueue(rightNode);
			 }

		}
		
		printLevelOrder(root);
		
	}

}
