package Arrays;
import java.util.*;
public class ReverseNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		String str="";
		for(int i= String.valueOf(n).length()-1;i >=0;i--) {
			str+=String.valueOf(n).charAt(i);
		}
		System.out.println(str);
		s.close();
	}

}
