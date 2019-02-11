import java.util.*;
public class Dummy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		
		s.nextLine();//This will consume the next line, such prolem occurs when we use nextLine after nextInt() or next();
		
		String str1 = s.nextLine();
		String str2 = s.nextLine();
		
		System.out.println("str1: " + str1 +"  "+n);
		System.out.println("str2: " + str2);
		
		s.close();
	}
}
