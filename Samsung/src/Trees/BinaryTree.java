package Trees;

import java.util.Scanner;
public class BinaryTree {
	
	class Node{
		int data;
		Node left, right;
		
		public Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	};
	
	class Queue<T>{
		
		int top, bottom;
		int capacity;
		int size;
		Node arr[];
		
		public Queue(){
			
			this.top = 0;
			this.bottom = 0;
			this.capacity = 5;
			this.size = 0;
			this.arr = new Node[capacity];
		}
		
		public void enq(Node node){
			
			if(top >= capacity){
				capacity+=5;
				Node new_arr[] = new Node[capacity];
				for(int i = 0; i<arr.length; i++){
					new_arr[i] = arr[i];
				}
				arr = new Node[capacity];
				arr = new_arr;
			}
			arr[top] = node;
			top++;
			size++;
		}
		
		public Node deq(){
			Node temp = arr[bottom];
			bottom++;
			size--;
			return temp;
		}
		
	};
	
	Node root;
	static Scanner s = new Scanner(System.in);

	public BinaryTree(){
		this.root = null;
	}
	
	public void buildBT(){
		
		System.out.println("Enter the root: ");
		int data = s.nextInt();
		
		if(data == -1){
			return;
		}
		if(root == null){
			root = new Node(data);
		}
		
		Queue<Node> queue = new Queue<Node>();
		queue.enq(root);
		while((queue.size != 0)){
			
			Node temp = queue.deq();

			//left
			System.out.println("Enter the left of " + temp.data);
			int left = s.nextInt();
			if(left!=-1){
				Node left_node = new Node(left);
				temp.left = left_node;
				queue.enq(left_node);
			}
			
			//right
			System.out.println("Enter the right of " + temp.data);
			int right = s.nextInt();
			if(right!=-1){
				Node right_node = new Node(right);
				temp.right = right_node;
				queue.enq(right_node);
			}
		}
	}
	
	Node rightmost_node_par;
	
	public Node find_right_most(Node node){
		
		if(node == null){
			return node;
		}
		
		if(node.right.left == null && node.right.right == null){
			return node;
		}
		return find_right_most(node.right);
	}
	
	public Node find_node_to_delete(Node node, int x){
		
		if(node == null){
			return null;
		}
		
		if(node.data == x){
			return node;
		}
		Node left = find_node_to_delete(node.left, x);
		if(left == null){
			Node right = find_node_to_delete(node.right, x);
			return right;
		}
		return left;
	}
	
	public void deleteNode(int data){
		
		if(data == -1){
			return;
		}
		
		//find the rightmost node
		Node right_most_par = find_right_most(root);
		
		//find the node to be dleeted
		Node to_delete = find_node_to_delete(root, data);
		
		//replace the two
		to_delete.data = right_most_par.right.data;
		
		//delete the rightmost node
		right_most_par.right = null;
	}
	
	public void print(Node root){
		
		if(root == null){
			return;
		}
		System.out.print(root.data + " ");
		print(root.left);
		print(root.right);
	}
	
	public int max(int left, int right){
		
		if(left > right){
			return left;
		}
		return right;
	}
	
	public int find_height(Node root){
		if(root == null){
			return -1;
		}
		if(root.left == null && root.right == null){
			return 0;
		}
		return 1 + (max(find_height(root.left), find_height(root.right)));
	}
	/*
	 * bfs using level_order height
	 */
	public void level_order_height(){
		
		//height given
		int height = find_height(root);
		System.out.println("height: " + height);
		for(int i = 0; i<=height; i++){
			level_order(root, i);
		}
	}
	
	public void level_order(Node node, int level){
		
		if(node == null){
			return;
		}
		
		if(level <= 0){
			System.out.print(node.data + " ");
			return;
		}
		level_order(node.left, level-1);
		level_order(node.right, level-1);
	}
	
	/*
	 * bfs using queue
	 */
	public void bfs(){
		
		Queue<Node> queue = new Queue<Node>();
		queue.enq(root);
		while(queue.size!=0){
			
			Node temp = queue.deq();
			System.out.print(temp.data + " ");
			if(temp.left!=null){
				queue.enq(temp.left);
			}
			if(temp.right!=null){
				queue.enq(temp.right);
			}
		}
	}
	
	/*
	 * LCA : lowest common ancestor
	 */
	public Node lca(Node node, int x, int y){
		
		if(node == null){
			return null;
		}
		
		if(node.data == x || node.data == y){
			return node;
		}
		
		Node left = lca(node.left, x, y);
		Node right = lca(node.right, x, y);
		
		if(left != null && right == null){
			return left;
		}
		
		if(right != null && left == null){
			return right;
		}
		if(left == null && right == null){
			return null;
		}
		return node;
	}
	
	/*
	 * Replace each node in a BT with sum of it's inorder preseccor and successor
	 * Algo : Find inorder trav in arr[], and then calc the sum replaces with predess, success..
	 */
	
	int arr[] = new int[1001];
	int index = 0;
	
	public void inorder(Node node){
		
		if(node == null){
			return;
		}
		inorder(node.left);
		arr[index] = node.data;
		index++;
		inorder(node.right);
	}
	
	public int find_pred(int data){
		for(int i = 0; i<index; i++){
			if(arr[i] == data){
				if(i!=0){
					return arr[i-1];
				}
			}
		}
		return 0;
	}
	
	public int find_succ(int data){
		for(int i = 0; i<index; i++){
			if(arr[i] == data){
				if(i!=index-1){
					return arr[i+1];
				}
			}
		}
		return 0;
	}
	
	public void replace_in(Node node){
		
		if(node == null){
			return;
		}
		node.data = find_pred(node.data) + find_succ(node.data);
		replace_in(node.left);
		replace_in(node.right);
	}

	public static void main(String[] args) {
		
		BinaryTree bt = new BinaryTree();
		bt.buildBT();
		bt.print(bt.root);
		System.out.println("height: " + bt.find_height(bt.root));
		bt.bfs();
		bt.level_order_height();		
		
		System.out.println();
		System.out.println("Enter data to delete: ");
		int d = s.nextInt();
		bt.deleteNode(d);
		bt.bfs();
		
		System.out.println("LCA: enter x, y");
		int x = s.nextInt();
		int y = s.nextInt();
		
		System.out.println(bt.lca(bt.root, x, y).data);
		
		System.out.println("replacing: ");
		bt.inorder(bt.root);
		bt.replace_in(bt.root);
		bt.bfs();
		s.close();
	}
}