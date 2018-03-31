package binaryTrees;

import java.util.Scanner;

public class CnstTreePreIn {
	
	public static int preIndex = 0;
	
	public static BinaryTreeNode<Integer> buildTree(int[] pre, int[] in, int start, int end) {
		
		if(start > end) {
			return null;
		}
		
		BinaryTreeNode<Integer> tNode = new BinaryTreeNode(pre[preIndex++]);
		
		if(start == end) {
			return tNode;
		}
		
		//now search for pre[index] in in[]
		int index_in_in = searchIn(in, start, end, tNode.data);
		
		tNode.left = buildTree(pre, in, start, index_in_in-1);
		tNode.right = buildTree(pre, in, index_in_in+1, end);

		return tNode;
	}

	private static int searchIn(int[] in, int start, int end, int data) {
		
		for(int i=start;i<end;i++) {
			if(in[i] == data) {
				return i;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int pre[] = new int[6];
		int in[] = new int[6];
		int i=0;
		System.out.println("Enter the pre-order: ");
		while(i < pre.length) {
			pre[i] = s.nextInt();
			i++;
		}
		i=0;
		System.out.println("Enter the in-order: ");
		while(i<in.length) {
			in[i] = s.nextInt();
			i++;
		}
		BinaryTreeNode<Integer> root = buildTree(pre, in, 0, in.length-1);
		BinaryTreeUse.printBinaryTree(root);
	}

}
