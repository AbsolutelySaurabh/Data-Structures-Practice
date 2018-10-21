package practice;

import java.util.*;

public class CoinChange {
	
	public static int max(int a, int b, int c) {
		if(a>b && a>c) {
			return a;
		}else
			if(b>a && b>c) {
				return b;
			}
		
		return c;
	}
	
	public static int findChanges(Vector<Integer> vector, int sum) {
		
		if(sum <= 0) {
			return 0;
		}
		return 1 + max(findChanges(vector, sum-vector.get(0)), findChanges(vector, sum-vector.get(1)), findChanges(vector, sum-vector.get(2)));
	}
	
	public static int findChangesUsingDp(Vector<Integer> vector, int sum, int change[], int index) {
		
		if(sum <= 0) {
			return 0;
		}
		if(change[sum]!=-1) {
			return change[sum];
		}
		if(index < vector.size()) {
			//sum-=vector.get(index);
			change[sum] = change[sum] + findChangesUsingDp(vector, sum-vector.get(index), change, index + 1);
		}
		return change[sum];
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n;
		n = s.nextInt();
		
		Vector<Integer> vector = new Vector<>();
		int data = s.nextInt();
		int index = 0;
		while(data!=-1) {
			vector.add(data);
			data = s.nextInt();
			index++;
		}
		
		System.out.println("ways: " + findChanges(vector, n));
		
		int change[] = new int[n+1];
		for(int i=0;i <change.length; i++) {
			change[i] = -1;
		}
		//System.out.println("using dp ways: " + findChangesUsingDp(vector, n, change, 0));

	}

}
