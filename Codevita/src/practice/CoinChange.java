package practice;

import java.util.Scanner;

public class CoinChange {
	
	public static int optimalSubstructure(int money, int change[]){
		
		int memo[][] = new int[change.length+1][money+1];
		//initialize
		for(int i=0; i<memo.length; i++){
			for(int j = 0; j<memo[0].length; j++){
				memo[i][j] = 0;
			}
		}
		
		//now, go for solution
		for(int i=1; i<memo.length; i++){
			for(int j = 1;j <memo[0].length;j++){
				
				if(j < i){
					memo[i][j] = memo[i-1][j];
				}else
					if(i == j){
						memo[i][i] = 1 + memo[i-1][j];
						
					}else{
						memo[i][j] = memo[i-1][j] + memo[i][j-i];
					}
			}
		}
		
		//can also print ways
		return memo[change.length][money];
	}
	
	public static int normalSolution(int money, int change[], int index){
		
		if(money == 0){
			return 1;
		}
		
		if(money < 0){
			return 0;
		}
		
		if(index >= change.length){
			return 0;
		}
		
		int amountWithus = 0, ways = 0;
		while(amountWithus <= money){
			
			int remaining = money - amountWithus;
			ways+=normalSolution(remaining, change, index + 1);
			amountWithus+=change[index];
		}
		return ways;
	}
	
	public static void solve(int money, int[] change){
		
		System.out.println("optimal substructure soilution : " +  optimalSubstructure(money, change));
		System.out.println("normal solution : " +  normalSolution(money, change, 0));

	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int money = s.nextInt();
		int n = s.nextInt();
		int change[] = new int[n];
		for(int i=0; i<n; i++){
			change[i] = s.nextInt();
		}
		
		solve(money, change);
		
		s.close();
	}
}
