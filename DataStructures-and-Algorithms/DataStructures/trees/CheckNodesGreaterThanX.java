package trees;
import java.util.*;
public class CheckNodesGreaterThanX {
	public static int count=0;
	public static int checkGreaterThanX(TreeNode<Integer> root, int x) {
		
		if(root.data > x) {
			++count;
		}

		for(int i=0;i<root.childcount;i++) {
			count = checkGreaterThanX(root.getchild(i), x);
		}
		return count;
	}

	public static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("Enter x: ");
		int x = s.nextInt();
		
		System.out.println("Greater than x: " + checkGreaterThanX(new TreeUse().treeData(), x));
		s.close();
	}
}
