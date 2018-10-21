package trees;

import java.util.Scanner;

import sun.misc.Queue;

public class TreeUse {
	
	//The logic is:
	//When we'll use a queue to take record of the latest nodes to find child of, and dequeu the consecutive nodes.
	public static Scanner s = new Scanner(System.in);
	
	public static TreeNode<Integer> treeData(){
		
		System.out.println("Enter the root data: ");
		int n = s.nextInt();
		//entered the root data
		TreeNode<Integer> root = new TreeNode(n);
		Queue<TreeNode<Integer>> queue = new Queue<TreeNode<Integer>>();
		queue.enqueue(root);
		while(!queue.isEmpty()) {
			
			TreeNode<Integer> node = null;
			try {
				node = queue.dequeue();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Enter the number of child of "+ node.data);
			int numchild = s.nextInt();
			
			for(int i=0;i<numchild;i++) {
				
				System.out.println("Enter the " + i + "th child of " + node.data);
				int ithchild = s.nextInt();
				TreeNode<Integer> childnode = new TreeNode<Integer>(ithchild);
				node.addChild(childnode);
				queue.enqueue(childnode);
			}
		}
		return root;
	}
	
	public static void printData(TreeNode<Integer> root) {
		
		System.out.println("root data: "+root.data);
		for(int i=0;i<root.numChild();i++) {
			System.out.println("data "+root.getchild(i).data);
		}
		
		for(int i=0;i<root.numChild();i++) {
			printData(root.getchild(i));
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode<Integer> root = treeData();
		printData(root);
		s.close();
	}

}
