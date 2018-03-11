package BinarySearchTree;

public class CheckBst {
	
	//Follow the below link for edge case IMPORTANT
	
	/** https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/ **/
	
	 static Boolean checkBST(BstNode root) {
	       if(root == null){
	           return true;
	       }
	       if(root.left!=null){
	           if(root.left.data >= root.data){
	                return false;
	          }
	       }
	       if(root.right!=null){
	           if(root.right.data <= root.data){
	                return false;
	          }
	       }
	       return checkBST(root.left) && checkBST(root.right);   
	   }

	public static void main(String[] args) {
		
		BstNode<Integer> root = BstUse.buildBst(rootNode, data)
	}

}
