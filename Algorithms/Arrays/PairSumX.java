package Arrays;

import java.util.*;

public class PairSumX {
	
	public static Scanner s;
	public static void main(String[] args){
		
		s = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<>();
		
		System.out.println("Enter the elements: ");
		int n = s.nextInt();
		while(n!=-1){
			
			arr.add(n);
			n = s.nextInt();
			
		}
		
		System.out.println("Enter x: ");
		int x = s.nextInt();
		
		ArrayList<Integer> pair = FindSum(arr, x);
		for(int i=0;i<pair.size();i++){
			
			if(i%2==0){
				System.out.print("(");
			}
			System.out.print(pair.get(i)+", ");
			
			if(i%2!=0){
				
				System.out.print(")");
			}
		
		}
		
	}
	

	public static ArrayList<Integer> FindSum(ArrayList<Integer> arr, int x){
		
		ArrayList<Integer> pair = new ArrayList<>();
		
		for(int i=0;i<arr.size();i++){
			
			for(int j=i+1; j<arr.size();j++){
				
				if((int)arr.get(i) + (int)arr.get(j) == x){
					
					pair.add(arr.get(i));
					pair.add(arr.get(j));
				}
			}
		}
		
		return pair;
	}

	
	
}
