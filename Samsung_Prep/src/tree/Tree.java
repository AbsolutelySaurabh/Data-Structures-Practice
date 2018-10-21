package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;
class Node{
	
	int data;
	Node left, right;
	
	public Node(int data) {
		this.data = data;
		this.left = this.right = null;
	}
}

public class Tree {
	
	public static int _height(Node root) {
		
		if(root == null) {
			return -1;
		}
		if(root.left == null && root.right == null) {
			return 0;
		}
		return 1+ Math.max(_height(root.left), _height(root.right));
		
	}
	
	public static int diameter = 0;
 	public static int _diameter(Node root) {
 		
 		if(root == null) {
 			return -1;
 		}
 		if(root.left == null && root.right == null) {
 			return 0;
 		}
 		
 		int lh = _diameter(root.left);
 		int rh = _diameter(root.right);
 		
 		diameter = Math.max(diameter, 1+lh+rh);
 		return 1+lh+rh;
 	}
	
	public static Boolean isBinaryTree(Node root) {
		
		if(root == null) {
			return false;
		}
		
		int right_height = _height(root.right); 
		int left_height = _height(root.left);
		if(Math.abs(left_height-right_height) <= 1 && isBinaryTree(root.left) && isBinaryTree(root.right)) {
			return true;
		}
		return false;
	}
	
	public static Node buildTree() {
		
		System.out.println("Enter data: ");
		int n  = s.nextInt();
		Queue<Node> q = new LinkedList<>();
		Node root = null, node = null;
		node = new Node(n);
		q.add(node);
		while(!q.isEmpty()) {
			
			Node temp = q.poll();
			if(root == null) {
				root = temp;
			}
			System.out.println("Enter left: ");
			int left = s.nextInt();
			Node leftNode = null;
			if(left!=-1) {
				leftNode = new Node(left);
				q.add(leftNode);
				temp.left = leftNode;
			}
			
			System.out.println("Enter right: ");
			int right = s.nextInt();
			Node rightNode = null;;
			if(right!=-1) {
				rightNode = new Node(right);
				q.add(rightNode);
				temp.right = rightNode;
			}	
		}
		return root;
	}
	
	public static void printTree(Node root) {
		
		if(root == null) {
			return;
		}
		//doing pre-order
		System.out.println(root.data);
		printTree(root.left);
		printTree(root.right);
	}
	
	public static Node lca(Node root, int n1, int n2) {
		
		if(root == null) {
			return root;
		}
		
		if(root.data == n1 || root.data == n2) {
			return root;
		}
		
		Node left = lca(root.left, n1, n2);
		Node right = lca(root.right, n1, n2);
		
		if(left == null && right == null) {
			return null;
		}else
			if(left!=null && right == null) {
				return left;
			}else
				if(right!=null && left == null) {
					return right;
				}
		//now if left and right both != null
		return root;
	}
	
	//now, print top-view level-wise
	//for level-wise problems we need to maintian queue always
	public static void topViewLevelWise(Node root) {
		
		//TODO
		if(root == null) {
			//need to maintain pair of node and horizontal distance, to be store in Queue
		}
		
	}
	
	static HashMap<Integer, Integer> map;
    public static void printTop(Node root, int d){
        
        if(root == null){
            return;
        }
        
        if(map.get(d) == null){
            System.out.print(root.data+ " ");
            map.put(d, d);
        }
        printTop(root.left, d-1);
        printTop(root.right, d+1);
    }
    
    public static void printTopView(Node root)
    {
        if(root == null){
            return;
        }
        map = new HashMap<>();
        printTop(root, 0);
    }
	
	
	public static Node another_way_to_build_tree(int num_nodes) {
		
		Node root = null;
		HashMap<Integer, Node> map = new HashMap<>();
		while(num_nodes > 0) {
			
			int root_data = s.nextInt();
			int child_data = s.nextInt();
			s.nextLine();
			char rel = s.nextLine().charAt(0);
			
			Node parent = map.get(root_data);
			if(parent == null) {
				parent = new Node(root_data);
				map.put(root_data, parent);
				if(root == null) {
					root = parent;
				}
			}
			Node child = new Node(child_data);
			if(rel == 'L') {
				parent.left = child;
			}else {
				parent.right = child; 
			}
			map.put(child_data, child);
			
			num_nodes--;
		}
		return root;
	}
	
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		
//		Node root = buildTree();
//		printTree(root);
		
		System.out.println("Another way of building tree: ");
		int n = s.nextInt();
		Node another_root = another_way_to_build_tree(n);
		printTree(another_root);
		
		System.out.println("height: " + _height(another_root));
		System.out.println("diameter: " + diameter);
		
		System.out.println("lcs: ");
		int n1 = s.nextInt();
		int n2 = s.nextInt();
		System.out.println(lca(another_root, n1, n2).data);
		
	}
}