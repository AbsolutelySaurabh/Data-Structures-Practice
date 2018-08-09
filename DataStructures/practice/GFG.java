package practice;

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Nnode{
    
    int data;
    Nnode left, right;
    
    public Nnode(int data){
        
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BSTnode{
    
    public static Nnode root;
    
    public static Nnode input(int arr[], int start, int end){
        
        if(start >= end){
            return null;
        }
        //make BST from this array
        int mid = (start + end)/2;
        int rootData = arr[mid];
        Nnode node = new Nnode(rootData);
        
        node.left = input(arr, start, mid);
        node.right = input(arr, mid+1, end);
        return node;
    }
    
}

class GFG {
	
    public static void printBST(Nnode node){
        if(node == null){
            return;
        }
        
        System.out.print(node.data + " ");
        printBST(node.left);
        printBST(node.right);
    }
	
	public static void main (String[] args) {
	    
	    Scanner s = new Scanner(System.in);
	    int test = s.nextInt();
	    while(test > 0){
	        
	        int n = s.nextInt();
	        int arr[] = new int[n];
	        for(int i = 0;i <n;i ++){
	            arr[i]  =s.nextInt();
	        }
	        printBST(BSTnode.input(arr, 0, arr.length));
	        test--;
	    }
	    
	}
}