package Arrays;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
  
  	private static void calc_good_cars(int[][] arr, int n){
      //good car = 1, initially assuming all 1
      int[] good_cars = new int[n];
      for(int i=0;i<n;i++){
        good_cars[i] = 1;
      }
      
      for(int i=0;i<n;i++){
        
        for(int j=0;j<n;j++){
          
          if(arr[i][j] == 1){
           	if(good_cars[i] == 1) {
            	good_cars[i] = 0;	
            	
          	}
          }else
          	if(arr[i][j] == 2){
          		
          		if(good_cars[j] == 1){
                	good_cars[j] = 0;
                }
        	}else
          		if(arr[i][j] == 3){
          
          			if(good_cars[i] == 1){
                     	good_cars[i] = 0; 
                    }
          			
          			if(good_cars[j] == 1){
                     	good_cars[j] = 0; 
                    }
        		}
        } 
      }
      
      int count = 0;
      for(int i=0;i<n;i++) {
    	  if(good_cars[i] == 1) {
    		  count++;
    	  }
      }
      System.out.println(count);
      
      if(count>0) {
	      for(int i=0;i<n;i++) {
	    	  if(good_cars[i] == 1) {
	    		  System.out.print(i+1 + " ");
	    	  }
	      }
      }
    }

    public static void main(String[] args) {
      
      Scanner s = new Scanner(System.in);
      int n = s.nextInt();
      int[][] arr = new int[n][n];
      
      for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
       		arr[i][j] = s.nextInt();	
        }
      }
      
      calc_good_cars(arr, n);
      
    }
}