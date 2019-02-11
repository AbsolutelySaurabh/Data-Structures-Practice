package mockvita;

import java.util.Scanner;

public class C {
	
	//wrapper class Long is better than BigInteger to store upto 18-19 digits in java with absolute precision;
	public static Long solve(long i, Long d, Long z){
		
		//check the impossible case
		if(i%2!=0 && d%2==0 && z%2==0){
			return new Long(-1);
		}
		
		//catch possible
		int caught = 0;
		Long current_pos = i;
		while(caught == 0){
			current_pos+=d;
			if(current_pos%z == 0){
				//caught
				caught = 1;
				System.out.println("current_pos: " + current_pos);
				return current_pos/z;
			}
		}
		return new Long(-1);
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int test = s.nextInt();
		while(test > 0){
			
			long i = s.nextLong();
			Long d = s.nextLong();
			Long z = s.nextLong();
			
			System.out.println(solve(i, d, z));
			
			test--;
		}
		s.close();
	}

}
