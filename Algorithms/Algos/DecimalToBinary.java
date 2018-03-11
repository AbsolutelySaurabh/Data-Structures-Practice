package Algos;
import java.util.*;
public class DecimalToBinary {
	
	private static String convertToBinary(int n) {
		String str = "";
		while(n>0) {
			int rem = n%2;
			str+=rem;
			n/=2;
		}
		return reverse(0, str.length()-1, str, "");
	}
	
	private static String reverse(int begin, int end, String str, String newString) {
		if(begin > end) {
			return newString;
		}
		newString+=str.charAt(end);
		return reverse(begin, --end, str, newString);
	}
	
	private static String convertDecimallFractionToBinary(double decimal_fraction){
		
		// to fractional_part * 2 until we get it as 0;
		
		/**
		 * eg: 2.2
		 * for fraction:
			0.2 * 2 = 0.4 => integer = 0
			then 0.4*2 => integer = 0
			do this until we get fraction*2 = 0.0, with 0 in fraction;**/
		
		String decimal_binary = convertToBinary((int)decimal_fraction);
		decimal_binary+='.';
		
		double fraction = decimal_fraction - (int)decimal_fraction;
		
		while(fraction > 0) {
		
			fraction*=2;
			decimal_binary += (int)(fraction);
			fraction = (fraction) - (int)fraction;
		}
		return decimal_binary;
		
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
//		System.out.println("Enter the decimal no.: ");
//		int decimal = s.nextInt();
//		System.out.println(convertToBinary(decimal));
//		
		System.out.println("Enter the decimal fraction no.: ");
		double decimal_fraction = s.nextDouble();
		System.out.println(convertDecimallFractionToBinary(decimal_fraction));
		
		s.close();
	}
}
