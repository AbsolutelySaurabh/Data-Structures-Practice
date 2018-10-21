package april_long;
import java.math.BigInteger;
import java.util.*;
public class Q_2 {
	
	static BigInteger M = new BigInteger("1000000007");
	static BigInteger calc_power(BigInteger num, BigInteger n){

	    if(n.compareTo(new BigInteger("0")) == 0){
	        return new BigInteger("1");
	    }

	    if(n.compareTo(new BigInteger("1")) == 0){
	        return num;
	    }
	    return (calc_power(num, n.subtract(new BigInteger("1"))).multiply(new BigInteger("10"))).mod(M);
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		long t = s.nextLong();
		
		while(t > 0) {
			
			BigInteger n = s.nextBigInteger();
			BigInteger count = new BigInteger("0");
			
			System.out.println("n: " + n);
			
			int req_weight = s.nextInt();
			
			int k = 10;
			while(k<100) {
				
				int lsb = k%10;
				int msb = k/10;
				
				int weight = lsb - msb;
				if(weight == req_weight) {
					
					count = count.add(new BigInteger("1"));
					
					k+=10;
					
					//System.out.println("count: " + count);
					
				}else {
					k++;
				}
			}
						
			if(n.compareTo(new BigInteger("2")) > 0) {
				count = calc_power(new BigInteger("10"), n.subtract(new BigInteger("2"))).multiply(count.mod(M)).mod(M);
			}
			
			System.out.println("count: " + count);
			
			--t;
		}
		s.close();
	}
}
