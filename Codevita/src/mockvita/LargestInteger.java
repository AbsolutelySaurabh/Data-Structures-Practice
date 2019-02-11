package mockvita;

import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class LargestInteger {
	
	public static int findMax(Vector<Stack<Integer>> vector){
		
		int max = -1;
		for(int i = 0; i<vector.size(); i++){
			if(!vector.get(i).isEmpty()){
				if(vector.get(i).peek() > max){
					max = vector.get(i).peek();
				}
			}
		}
		
		//found the max
		//now pop the max
		for(int i = 0; i<vector.size(); i++){
			if(!vector.get(i).isEmpty()){
				if(vector.get(i).peek() == max){
					vector.get(i).pop();
					break;
				}
			}
		}
		return max;
	}
	
	public static String solve(Vector<Stack<Integer>> vector, int m, int n){
		
		String number = "";
		for(int i = 0;i <m*n; i++){
			
			int max = findMax(vector);
			number+=String.valueOf(max);
		}
		System.out.println("number: " + number);
		return number;
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		String mn = s.nextLine();
		String arr_mn[] = mn.split(",");
		
		int m = Integer.parseInt(arr_mn[0]);
		int n = Integer.parseInt(arr_mn[1]);
		
		String arr_chutes[] = new String[m];
		for(int i = 0;i <m; i++){
			arr_chutes[i] = s.nextLine();
		}
		
		//now find the chute values
		Vector<Stack<Integer>> v = new Vector<>();
		for(int i = 0; i<arr_chutes.length; i++){
			Stack<Integer> stack = new Stack<>();
			String ch_val[] = arr_chutes[i].split(",");
			for(int j = 0; j<ch_val.length; j++){
				stack.push(Integer.parseInt(ch_val[j]));
			}
			v.add(stack);
		}
		
		System.out.println(Long.parseLong(solve(v, m, n)));
		s.close();
	}

}
