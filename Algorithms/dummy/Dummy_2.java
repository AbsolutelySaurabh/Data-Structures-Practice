package dummy;

import java.util.*;
public class Dummy_2 {

    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        
        //change only the x- coordinates of the queen accn to the setup
        int new_r_q = (n-r_q);
        //making these start from 0 as index
        //new_r_q-=1;
        int new_c_q = c_q - 1;
        
        //changing the x-coordinates of the obstacles accn to the chess board setup
        for(int i=0;i<obstacles.length;i++){
            obstacles[i][0]  = (n - obstacles[i][0]) ;
            obstacles[i][1]-=1;
        }
        
       // _print_obs(obstacles);
        
        //make a chess with obstacles marked as = 1;
        int[][] chess = new int[n][n];
        for(int i = 0 ; i<obstacles.length;i++){
            chess[obstacles[i][0]][obstacles[i][1]] = 1;
        }
        
        chess[new_r_q][new_c_q] += 2;
        
        //_print(chess);
//        
        int paths = 0;
        
////        //going to the diagonal left-bottom
        for(int i = new_r_q + 1 , j = new_c_q - 1 ; i<=n-1 && j>=0; i++, j--){
            if(chess[i][j]==0){            
                paths+=1;                
            }else {
            	//exit
            	break;
            }
        }
        
        //System.out.println("paths: " + paths);
////        
////        //not, go to the diagonal right-bottom
        for(int i = new_r_q + 1, j = new_c_q + 1 ; i<=n-1 && j<=n-1; i++, j++){
            if(chess[i][j]==0){            
                paths+=1;                
            }else {
            	//exit after immediate 1 in that direction
                break;
            }
        }
       // System.out.println("paths: " + paths);

////        
////        //now, go to the top-left side
        for(int i = new_r_q - 1, j = new_c_q -1; i>=0 &&j>=0 ; i--, j--){
            if(chess[i][j]==0){            
                paths+=1;                
            }else {
            	//exit after immediate 1 in that direction
                break;
            }
        }
       // System.out.println("paths: " + paths);

////        
////        //now, going to the top-right side
        for(int i = new_r_q - 1, j = new_c_q + 1; i>=0 && j<=n-1; i--, j++){
            if(chess[i][j]==0){            
                paths+=1;                
            }else {
            	//exit after immediate 1 in that direction
                break;
            }
        }
       // System.out.println("paths: " + paths);

////        
////        //now, go in upward direction
        for(int i = new_r_q - 1, j = new_c_q; i>=0 ; i--){
            if(chess[i][j]==0){            
                paths+=1;                
            }else {
            	//exit after immediate 1 in that direction
                break;
            }
        }
       // System.out.println("paths: " + paths);

////        
////        //now, to the downward direction
        for(int i = new_r_q + 1, j = new_c_q ; i<=n-1; i++){
            if(chess[i][j]==0){            
                paths+=1;                
            }else {
            	//exit after immediate 1 in that direction
                break;
            }
        }
       // System.out.println("paths: " + paths);

////        
////        //now, to the right direction
        for(int i = new_r_q, j = new_c_q + 1; j<= n-1; j++){
            if(chess[i][j]==0){            
                paths+=1;                
            }else {
            	//exit after immediate 1 in that direction
                break;
            }
        }
        //System.out.println("paths: " + paths);

////        
////        //now, to the left direction
        for(int i = new_r_q, j = new_c_q -1; j>=0 ; j--){
            if(chess[i][j]==0){            
                paths+=1;                
            }else {
            	//exit after immediate 1 in that direction
                break;
            }
        }       
//        System.out.println("paths: " + paths);

        return paths;
        
    }

    private static void _print_obs(int[][] arr) {
    	
    	for(int i=0;i<arr.length;i++) {
    		for(int j=0;j<2;j++) {
    			System.out.print(arr[i][j]);
    		}
    		System.out.println(" ");
    	}
    	
	}
    
    private static void _print(int[][] arr) {
    	
    	for(int i=0;i<arr.length;i++) {
    		for(int j=0;j<arr.length;j++) {
    			System.out.print(arr[i][j]);
    		}
    		System.out.println(" ");
    	}
    	
	}

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int r_q = in.nextInt();
        int c_q = in.nextInt();
        int[][] obstacles = new int[k][2];
        for(int obstacles_i = 0; obstacles_i < k; obstacles_i++){
            for(int obstacles_j = 0; obstacles_j < 2; obstacles_j++){
                obstacles[obstacles_i][obstacles_j] = in.nextInt();
            }
        }
        int result = queensAttack(n, k, r_q, c_q, obstacles);
        System.out.println(result);
        in.close();
    }
}