package dummy;

import java.util.Scanner;

public class Sin {
	
	private static void func(long a, long b) {
		
		if(a==b || a==0 || b==0) {
			System.out.println(a+b);
		}
		
		if(a>b) {
			func(a-b, b);
		}
		else if(b>a){
			func(a, b-a);
		}
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int t  = s.nextInt();
		while(t>0) {
			
			long a = s.nextLong();
			long b = s.nextLong();
			
			func(a, b);
			
			t--;
		}
	}

}
