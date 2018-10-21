package arrays;

import java.util.Scanner;

public class RotateArray {

	   public static void rotate(int[] a, int k){
	        
	        for(int i=0;i<k;i++){
	            rotate_n(a, i);
	        }
	        print_array(a, 0);
	    }
	    
	    public static void print_array(int[] a, int index){
	        if(index == a.length){
	            return;
	        }
	        System.out.println(a[index]);
	        print_array(a, ++index);
	    }
	    
	    public static void rotate_n(int[] a, int d){
	        
	        int temp = a[0], i=0;
	        for(i=0;i<a.length-1;i++){
	            
	            a[i] = a[i+1];
	        }
	        a[i] = temp;
	        
	    }

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int k = in.nextInt();
	        int a[] = new int[n];
	        for(int a_i=0; a_i < n; a_i++){
	            a[a_i] = in.nextInt();
	        }
	        rotate(a, k);
	        in.close();
	    }

}
