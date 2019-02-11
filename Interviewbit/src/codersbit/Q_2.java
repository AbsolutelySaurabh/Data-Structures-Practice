package codersbit;

import java.util.Scanner;

public class Q_2 {
	
	public static int min_count = 123;
	
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
	
	static void findCombinationsUtil(int arr[], int index, int num, int reducedNum, int min){
		// Base condition
		if (reducedNum < 0)
			return;
		
		if (reducedNum == 0)
		{
			int count = 0;
			int i = 0;
			for (i = 0; i < index; i++){
				
				if(isPrime(arr[i])){
					count++;
				}else{
					break;
				}
			}			
			if(i == index && count < min_count){
				min_count = count;
			}
			return;
		}
		
		int prev = (index == 0)? 1 : arr[index-1];
		
		for (int k = prev; k <= num ; k++){
			// next element of array is k
			arr[index] = k;
			
			findCombinationsUtil(arr, index + 1, num, reducedNum - k, min);
			}
		}
	
	
	static void solve(int n)
	{
		int arr[] = new int[n];
		
		//find all combinations
		int ans = 0;
		findCombinationsUtil(arr, 0, n, n, Integer.MAX_VALUE);
		ans = min_count;
	}	

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		solve(n);
		System.out.println("min_count: " + min_count);
	}

}
