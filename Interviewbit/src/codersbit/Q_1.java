package codersbit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Q_1 {
	
    
    public static Boolean isPrime(int num){
        
        if(num < 2){
            return false;
        }
        if(num == 2 || num == 3 || num == 5){
        	return true;
        }
        
        if(num%2 == 0 || num%3 == 0 || num%5 == 0){
            return false;
        }
        
        //O(root(N)) solution
        for(int i =5; i*i <= num; i++){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }
    
    public static int countPrime(int num, HashMap<Integer, Integer> visited){
        
        int count = 0;
        if(num == 2 || num == 3 || num == 5){
        	if(visited.get(num) == null){
            	visited.put(num, 1);
                count++;
        	}
        }
        
        //the number can itself be prime
        if(isPrime(num)){
        	if(visited.get(num) == null){
            	visited.put(num, 1);
                count++;
        	}
        }
        for(int i = 2;i <= num/2; i++){
        	if(num%i == 0){
        		if(visited.get(i) == null){
    	            if(isPrime(i)){
    	            	visited.put(i, 1);
    	                count++;
    	            }
            	}
        	}
        }
        return count;
    }
    
    public static int solve(ArrayList<Integer> A) {
    	
    	long product = 1;
    	int count = 0;
        HashMap<Integer, Integer> visited = new HashMap<>();
    	for(int i = 0;i <A.size(); i++){
    		count+=countPrime(A.get(i), visited);
    	}
        return count;
    }

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 0;i <n; i++){
			int num = s.nextInt();
			arr.add(num);
		}
		System.out.println(solve(arr));
		
	}

}
