package binaryTrees;

import java.util.Scanner;

public class Pre_In_BT {

	public static int index = 0;
	public static Scanner s = new Scanner(System.in);
	
	public static BinaryTreeNode<Integer> constructTree(int[] pre, int[] in, int startIndex, int endIndex) {
		
		//THIS IS THE MOST IMPORTANT LINE
		if(startIndex > endIndex) {
			return null;
		}
		
		
		//we'll increment this index after every call, in preOrder
		int rootData = pre[index++];
		int rootIndex = searchRootIn(rootData, in, 0);
		//System.out.println(rootIndex);

		//THIS IS ALSO THE MOST IMPORTANT LINE
		if(startIndex == endIndex) {
			return new BinaryTreeNode(in[startIndex]);
		}
		
		//make the left subtree
		//In this call I also have to change the length of the preOrder.
		BinaryTreeNode<Integer> leftNode = constructTree(pre, in, startIndex, rootIndex-1);
		//construct right subtree
	    BinaryTreeNode<Integer> rightNode = constructTree(pre, in, rootIndex+1, endIndex);

	    BinaryTreeNode<Integer> rootNode = new BinaryTreeNode(rootData);
	    rootNode.left = leftNode;
	    rootNode.right = rightNode;
		
	    return rootNode;
	}
	
	private static int searchRootIn(int rootData, int[] in, int index) {
		for(int i=0;i<in.length;i++) {
			if(in[i] == rootData) {
				return i;
			}
		}
		return -1;
	}
	
	
	static int preIndex = 0;
	
    static BinaryTreeNode<Integer> buildTree(int in[], int pre[], int inStrt, int inEnd) 
    {
        if (inStrt > inEnd) 
            return null;
  
        /* Pick current node from Preorder traversal using preIndex
           and increment preIndex */
        BinaryTreeNode<Integer> tNode = new BinaryTreeNode<Integer>(pre[preIndex++]);
  
        /* If this node has no children then return */
        if (inStrt == inEnd)
            return tNode;
  
        /* Else find the index of this node in Inorder traversal */
        int inIndex = search(in, inStrt, inEnd, tNode.data);
  
        /* Using index in Inorder traversal, construct left and
           right subtress */
        tNode.left = buildTree(in, pre, inStrt, inIndex - 1);
        tNode.right = buildTree(in, pre, inIndex + 1, inEnd);
  
        return tNode;
    }
	
    static int search(int arr[], int strt, int end, int value) 
    {
        int i;
        for (i = strt; i <= end; i++) 
        {
            if (arr[i] == value)
                return i;
        }
        return i;
    }

	public static void main(String[] args) {
		
		//PreOrder
		System.out.println("Enter PreOrder: ");
		System.out.println("Enter the number of elements: ");
		int size = s.nextInt();
		//int pre[size], in[size];
		
		int pre[] = new int[size], in[] = new int[size];

		for(int i=0;i<size;i++) {
			pre[i] = s.nextInt();
		}
		
		//InOrder
		System.out.println("Enter InOrder: ");
		System.out.println("Enter the number of elements: ");
		for(int i=0;i<size;i++) {
			in[i] = s.nextInt();
		}
		
		BinaryTreeUse.printBinaryTree(constructTree(pre, in, 0, size-1));
		
	}

}
