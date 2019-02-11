package trees;

import java.util.Scanner;

public class CheckTreeContainsX {
	public static Boolean ans= false;
	public static Scanner s = new Scanner(System.in);
	
	public static Boolean checkX(TreeNode<Integer> root, int x) {
		
		if(root.data.equals(x)) {
			return true;
		}else {
			for(int i=0;i<root.childcount;i++) {
				ans =  checkX(root.getchild(i), x);
			}
		}
		return ans;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the value of x: ");
		int x = s.nextInt();
		TreeUse tree = new TreeUse();
		if(checkX(tree.treeData(), x)) {

			System.out.println("Yes: ");
		}else {
			System.out.println("No: ");
		}
	}

}
