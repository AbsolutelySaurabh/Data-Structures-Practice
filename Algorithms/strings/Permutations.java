package strings;
import java.util.*;
public class Permutations {
	
	public static void permutationsHelper(String input, String output){
		
		if(input.length()==0){
			System.out.println(output);
			return;
		}
		for(int i=0;i< input.length();i++){	
			//input.substring(1) -> means, starting from index: 1
			permutationsHelper((input.substring(0, i) + input.substring(i+1)), output + input.charAt(i) );
		}
	}
	
	public static String swap(String str, int i, int j) {
		
		if(i == j) {
			return str;
		}
		
		char temp;
        char[] charArray = str.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
	        
		//return string.toString();
	}
	
	public static void permutations(String str, int l, int r) {
		
		if(l == r) {
			System.out.println(str);
		}
		
		for(int i = l; i<=r; i++) {
			
			str = swap(str, l, i);
			permutations(str, l+1, r);
			//retrive the original string
			str = swap(str, l, i);
		}
		
	}
	
	public static void main(String[] args){	
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		//permutationsHelper(input,"");
		permutations(input, 0, input.length()-1);
		s.close();
	}
}
