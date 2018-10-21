package practice;

import java.util.*;

class bt_node{
	
	int data;
	bt_node left;
	bt_node right;
	
	public bt_node(int data) {
		this.data = data;
		this.left = this.right = null;
	}
}

public class Bt_Construct {

	public static int index = 0;
	private static bt_node pre_in(int[] pre, int[] in, int startIndex, int endIndex) {
		
		if(startIndex > endIndex) {
			return null;
		}
		
		int root = pre[index];
		bt_node root_node = new bt_node(root);

		if(startIndex == endIndex) {
			return new bt_node(root);
		}
		
		System.out.println("startIndex: " + startIndex + " endIndex: " + endIndex);
		System.out.println("root: " + root);
		int root_index = Arrays.binarySearch(in, startIndex, endIndex, root);
		System.out.println("root_index: " + root_index);
		
		
		index+=1;
		
		root_node.left = pre_in(pre, in, 0, root_index-1);
		root_node.right = pre_in(pre, in, root_index+1, endIndex);
		
		return root_node;
		
	}
	
	public static void print(bt_node node) {
		
		if(node == null) {
			return;
		}
		//pre-order
		System.out.println(node.data);
		print(node.left);
		print(node.right);
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int p = s.nextInt();
		int i = s.nextInt();
		
		int pre[] = new int[p];
		int in[] = new int[i];
		
		for(int i1=0; i1<p; i1++) {
			pre[i1] = s.nextInt();
		}
		
		for(int j=0; j<i; j++) {
			in[j] = s.nextInt();
		}
		
		bt_node root = pre_in(pre, in, 0, in.length-1);
		print(root);
		
	}

}
