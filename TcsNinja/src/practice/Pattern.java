package practice;
import java.util.Scanner;
public class Pattern {

	public static void solve(int n) {
		
		int blank = n-1;
		int start = 1, num = 1, last = 0, incr = 1;
		
		for(int i = 0;i <n; i++) {
			
			int b = blank;
			while(b>0) {
				System.out.print(" ");
				b--;
			}
			
			//start = num;
			for(int j=0; j<i+1; j++) {
				
				last = num;
				System.out.print(num+ " ");
				num+=last;
				//last = num;
			}
			//num-=last;			
			last = num;
			blank--;
			System.out.println();
			
		}
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		solve(n);
		s.close();
	}
}