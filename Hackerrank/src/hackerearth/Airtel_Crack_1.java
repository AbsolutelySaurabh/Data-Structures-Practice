package hackerearth;

import java.util.Scanner;

public class Airtel_Crack_1 {
	
	 private static int checkDiff(String s1, String s2, int[] A, int[] B){
	        
	        int diff_min = 0;
	        int l1 = 0, l2 = 0;
	        
	        while(l1<s1.length()){
	            A[s1.charAt(l1) - 'a']++;
	            ++l1;
	        }
	        while(l2<s2.length()){
	            B[s2.charAt(l2) - 'a']++;
	            ++l2;
	        }
	        
	        int diff_a = 0, diff_b = 0;
	             
	        //now see the diff
	        for(int i=0;i<A.length;i++){
	            int d = A[i] - B[i];
	            if(d>0) {
	            	diff_a+=d;
	            }
	        }
	        
	        for(int i=0;i<B.length;i++){
	        	int d = B[i] - A[i];
	            if(d>0) {
	            	diff_b+=d;
	            }
	        }
	        return Math.max(diff_a, diff_b);
	        
	    }
	    
		public static void main (String[] args) {
		    Scanner s = new Scanner(System.in);
		    int t  = s.nextInt();
		    while(t>0){
		        
		        int size1 = s.nextInt();
		        int size2 = s.nextInt();
		        
		        String s1, s2;
		        s1 = s.next();
		        s2 = s.next();
		        
		        int[] A = new int[26],  B = new int[26];
		        
		        System.out.println(checkDiff(s1, s2, A, B));
		        	        
		        --t;
		    }
		    
		}

}
