package Arrays;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class AllSubsequencesWithSumK {
	
	//public static int count = 0;
	
	private static long count(int[] coins, int money) {
		return count(coins, money, 0, new HashMap<>());
	}
	
	private static long count( int coins[], int money, int index )
	{
		if(money == 0) {
			return 1;
		}
		if(index>=coins.length) {
			return 0;
		}
		
		int amountWithSum = 0;
		long ways = 0;
		while(amountWithSum<=money) {
			
			int remaining = money - amountWithSum;
			ways += count(coins, remaining, ++index);
			amountWithSum+=remaining;
		}
		return ways;
	    
	}
	
	//solving the above using DP recursion:
	private static long count(int[] coins, int money, int index, HashMap<String, Long> memo) {

		if(money == 0) {
			return 1;
		}
		if(index>=coins.length) {
			return 0;
		}
		
		String str = money + "-" + index;
		if(memo.containsKey(str)) {
			return memo.get(str);
		}
		
		int amountWithSum = 0;
		long ways = 0;
		while(amountWithSum<=money) {
			
			int remaining = money - amountWithSum;
			ways += count(coins, remaining, ++index, memo);
			amountWithSum+=coins[index];
		}
		memo.put(str, ways);
		
		System.out.println(ways);
		return ways;
	}
	
//	public static int findSubSeq(int[] arr,Vector<Integer> v, int size, int sum, int index) {
//		
//		if(sum == 0) {
//			//count
//			printVector(v, index);
//			count++;
//		}
//		if(sum > 0) {
//			for(int i=0; i<arr.length;i++) {
//				
//				//new_arr[index] = arr[i];
//				v.add(index, arr[i]);
//				//sum-=arr[index];
//				findSubSeq(arr, v, size, sum-v.get(index), ++index);
//				
//				//sum+=arr[index];
//			}
//		}
//		return count;
//	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int sum = s.nextInt();
		int size = s.nextInt();
		
		int[] arr = new int[size];
		for(int i=0;i<size;i++) {
			arr[i] = s.nextInt();
		}
		
		System.out.println("ans: " + count(arr, sum));
		s.close();
	}

}
