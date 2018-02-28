package rookie_rank_4;

import java.util.Scanner;

public class ServerStack {
	
	static String solveStack(int[] position, int[] height) {
		int countRight = 0, countLeft = 0;
		for(int i=0, j=0; i<position.length-1 && j<height.length-1;i++, j++) {
			if(position[i] + height[j] >= position[i+1]) {
				countLeft++;
			}
		}
		
		for(int i=position.length-1, j=height.length-1; i>=1 && j>=1; i--, j--) {
			if(position[i] - height[j] <= position[i-1]) {
				countRight++;
			}
		}
		
		if(countRight == position.length-1  &&  countRight == countLeft) {
			return "BOTH";
		}
		
		if(countRight == position.length-1) {
			return "RIGHT";
		}else
			if(countLeft == position.length-1) {
				return "LEFT";
			}
		
		return "NONE";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int position[] = new int[n];
		int height[] = new int[n];
		
		for(int i=0;i<n;i++) {
			position[i] = s.nextInt();
		}
		for(int i=0;i<n;i++) {
			height[i] = s.nextInt();
		}
		System.out.println(solveStack(position, height));
		s.close();
	}
}
