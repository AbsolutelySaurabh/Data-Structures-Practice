package BinaryTrees;

public class CountLeafNodes {

	//Time complexity is O(n)
	
	//We can also do it iteratively by using Queue, by traversing all and checking at all places of left&right both null 
	
	public static void main(String[] args) {
		System.out.println("ans: " + countleafs(BinaryTreeUse.buildBinaryTree(), 0));;	
	}

	private static int countleafs(BinaryTreeNode<Integer> root, int count) {
		if(root.left == null && root.right == null) {
			return (count+1);
		}
	
		//need to handle the skewed case
		
		if(root.left!=null) {
			count = countleafs(root.left, count);
		}
		
		if(root.right!=null) {
			count = countleafs(root.right, count);
		}
		return count;		
	}
}
