package trees;

import java.util.Scanner;

public class SumGreateThanX {
	public static int max = Integer.MIN_VALUE;
	
	public static int findMaxSum(TreeNode<Integer> root, int sum) {
		
		sum = root.data;
		if(sum>max) {
			max = sum;
		}
		for(int i=0;i<root.childcount;i++) {
			sum = sum + (Integer)root.getchild(i).data;
		}
		if(sum > max) {
			max = sum;
		}
		
		for(int i=0;i<root.childcount;i++) {
			max = findMaxSum(root.getchild(i), sum);
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		//find maximum
		System.out.println("maximum is : " + findMaxSum(new TreeUse().treeData(), 0));
	}
}
