package edgeCases;
public class CheckBst {

	//This code is in c++;
/**	 bool checkBST(Node* root) {
	       if(root == NULL){
	           return true;
	       }
	       if(root->left!=NULL){
	           if(root->left->data > root->data){
	                return false;
	          }
	       }
	       if(root->right!=NULL){
	           if(root->right->data < root->data){
	                return false;
	          }
	       }
	       return checkBST(root->left) && checkBST(root->right);   
	   }
	   
	   **/
	/**
	
	The above code does not covers the edge case:
	when,
			the left subtree has a sub-element, in the below, with value < root.data
	
	so, to perfectly solving it, do:
	
	 	1. store the inorder trversal of the tree in an array, and in the end, if the array is in increasing order or not
		 but, in above we r using extra space with a temp array
		2. do by inorder traversal and maintaing a prev value.
		
		**/
	
}
