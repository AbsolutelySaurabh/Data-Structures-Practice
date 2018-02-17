package BinarySearchTree;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BstUse {
	
	static Scanner s = new Scanner(System.in);
	public static BstNode root;
	
	public static void insert(int data) {
		root = buildBst(root, data);
	}
	
	public static BstNode buildBst(BstNode rootNode, int data){
		
		if(rootNode == null) {
			BstNode node = new BstNode(data);
			return node;
		}
		
		if(data >= rootNode.data) {
			rootNode.right = buildBst(rootNode.right, data);
		}else
		{
			rootNode.left = buildBst(rootNode.left, data);
		}
		
		return rootNode;
	}
	
	public static void printBst(BstNode temp) {
		if(temp == null) {
			return;
		}
		
		System.out.print(temp.data + " ");
		
		printBst(temp.left);
		printBst(temp.right);

	}
	
	public static String searchBst(int data, BstNode rootNode) {
		
		if(rootNode == null) {
			return "Not present";
		}
		
		if(rootNode.data == data) {
			return "Yes present";
		}
		
		if(data >= rootNode.data) {
			return searchBst(data, rootNode.right);
		}else {
			return searchBst(data, rootNode.left);
		}
	}

	public static void main(String[] args) {
		
		insert(70);
		insert(30);
		insert(80);
		insert(20);
		insert(40);
		
		BstNode temp = root;
		printBst(temp);
		System.out.println("Enter data to search: ");
		int data = s.nextInt();
		System.out.println(searchBst(data, temp));

	}

}
