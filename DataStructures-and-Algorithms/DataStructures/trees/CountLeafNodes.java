package trees;

public class CountLeafNodes {

	//Time complexity is O(n)
	
	//We can also do it iteratively by using Queue, by traversing all and checking at all places of left&right both null 
	
	public static void main(String[] args) {
		System.out.println("ans: " + countleafs(TreeUse.treeData(), 0));;	
	}

	private static int countleafs(TreeNode<Integer> root, int count) {
		if(root.numChild() == 0) {
			return (count+1);
		}
		for(int i=0;i<root.numChild();i++) {
			count =  countleafs(root.getchild(i), count);
		}
		return count;		
	}
}
