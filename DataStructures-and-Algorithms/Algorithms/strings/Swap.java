package strings;
import java.util.Scanner;
public class Swap {
	
	private static String swap(char[] cs, int index1, int index2) {
		
		char temp = cs[index1];
		cs[index1] = cs[index2];
		cs[index2] = temp;
		
		return new String(cs);
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		System.out.println(swap(str.toCharArray(), 0, 1));
		s.close();
	}
}