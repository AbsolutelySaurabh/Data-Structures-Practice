package tree;

import java.util.*;
public class Djks
 {
     
    public static int apply_djks(int memo[][], int n){
        
        int dis[] = new int[n+1];
        for(int i = 0; i<dis.length; i++){
            dis[i] = memo[1][i];
        }
        
        for(int i = 1; i<=n; i++){
            
            for(int j = 1; j<=n ;j++){
                
                if(memo[i][j] == 1){
                    if(dis[i] + 1 < dis[j]){
                        dis[j] = dis[i] + 1;
                    }
                }
            }
        }
        return dis[n];
    }
     
	public static void main (String[] args)
	 {
	    Scanner s = new Scanner(System.in);
	    int t = s.nextInt();
	    while(t > 0){
	        
	        int n = s.nextInt();
	        //vertices numbered 1 to n
	        int memo[][] = new int[n+1][n+1];
	        
	        //there's an edge from j = i+1 and j = 3*i
	        
	        for(int i =0; i<n+1; i++){
	            for(int j = 0; j<n+1; j++){
	                if(j == i+1 || j == 3*i){
	                    memo[i][j] = 1;
	                }else{
	                    if(i == j){
	                        memo[i][j] = 0;
	                    }else{
	                        memo[i][j] = Integer.MAX_VALUE;
	                    }
	                }
	            }
	        }
	        //graph completed, now to apply dijkstra
	        System.out.println(apply_djks(memo, n));
	        t--;
	    }
	 }
}