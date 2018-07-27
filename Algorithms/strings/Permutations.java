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
	
	public static void main(String[] args){	
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		permutationsHelper(input,"");
		s.close();
	}
}
