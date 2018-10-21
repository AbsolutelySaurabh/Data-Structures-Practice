//package codevita18;

import java.math.BigInteger;
import java.util.Scanner;

public class Q_1 {
		 
	static long gcd(long a, long b)
	{
	    if (a == 0)
	       return b;
	    return gcd(b%a,a);
	}

	static long reduceB(long a, char b[])
	{
	    long mod = 0;
	 
	    for (int i=0; i<b.length; i++)
	        mod = (mod*10 + b[i] - '0')%a;
	 
	    return mod; // return modulo
	}

	static long gcdLarge(long a, char b[])
	{
	    long num = reduceB(a, b);
	 
	    return gcd(a, num);
	}
	
	
	public static int m = 10000007;
	public static long _gcd(long a, long b) {
        if (a == 0 || b == 0)
           return 0;
      
        if (a == b)
            return a;
      
        if (a > b)
            return gcd(a-b, b);
        return gcd(a, b-a);
    }
	
//	public static long solve(String n) {
//		
//		long count = 0;
//		for(long i = 1; i< Long.parseLong(n); i++) {
//			
//			if(gcdLarge(i, n.toCharArray()) == 1) {
//				//System.out.print(i + " ");
//				count++;
//			}
//		}
//		//System.out.println();
//		return count;
//	}
	
	public static long solve(long n) {
		
		long count = 0;
		for(long i = 1; i< (n); i++) {
			
			if(_gcd(i, n) == 1) {
				//System.out.print(i + " ");
				count = (count%m + 1)%m;
			}
		}
		//System.out.println();
		return count%m;
	}


	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		//long n  =s.nextLong();
		long n = s.nextLong();
		//String str = s.next();
		//int n = Integer.parseInt(str);
		System.out.println(solve(n));
		
	}

}
