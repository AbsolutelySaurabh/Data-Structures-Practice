package BinarySearchTree;

public class InsertDupl {
	
	public static void insertDupl(BstNode temp) {
		if(temp == null) {
			return;
		}
		temp.left = temp;
		insertDupl(temp.left);
		insertDupl(temp.right);
	}
	
	public static void main(String[] args) {
		
		BstUse.insert(70);
		BstUse.insert(30);
		BstUse.insert(80);
		BstUse.insert(20);
		BstUse.insert(40);
		BstUse.insert(100);

		insertDupl(BstUse.root);
		BstUse.printBst(BstUse.root);
    }

}
