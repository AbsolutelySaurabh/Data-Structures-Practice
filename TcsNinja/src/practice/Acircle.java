package practice;

import java.util.Scanner;

public class Acircle {

	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		float area = (float) (3.14 *(n*n));
		System.out.printf("%.2f", area);
		
	}
	
}


//dnxom  oxd
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	    Scanner s = new Scanner(System.in);
	    int t = s.nextInt();
	    while(t > 0){
	        
	        int row = s.nextInt();
	        int col = s.nextInt();
	        
	        int maze[][] = new int[row+2][col+2];
	        
	        for(int i = 0; i<= maze.length; i++){
	            for(int j = 0; j<=maze[i].length; j++){
	                
	                if(i == 0 || j==0 || i == row+1 || j == col+1){
	                    maze[i][j] = Integer.MAX_VALUE;
	                }else{
	                    int 
	                }
	            }
	        }
	        
	        t--;
	    }
	 
	 }
}
