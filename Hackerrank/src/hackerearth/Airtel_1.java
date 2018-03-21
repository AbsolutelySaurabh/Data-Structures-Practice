package hackerearth;

import java.util.HashMap;
import java.util.Scanner;

public class Airtel_1 {
	
	private static HashMap<Integer, Integer> mp = new HashMap<>();
	private static int count = 0;
	private static int find_odd_even(int[] arr, String s) {
		
		//not a subsequence, we need substrings
		for(int i=0;i<s.length();i++) {
			
			String str = s.substring(i);
			System.out.println(str);
			
			//count odd-even:
			int num = Integer.parseInt(str);
			if(!mp.containsKey(num)) {
				int new_num = num, odd=0, even=0;
				while(new_num > 0) {
					if(new_num%2==0) {
						even++;
					}else {
						odd++;
					}
					new_num/=10;
				}
				if(odd == even) {
					count++;
					mp.put(num, 1);
				}else {
					mp.put(num, 0);
				}
			}else {
				
				//case when it contains key
				if(mp.get(num) == 1) {
					count++;
				}
			}
			
			if(i>0) {
				
			    str = s.substring(0, s.length()-i);
				System.out.println(str);
				
				//count odd-even:
			    num = Integer.parseInt(str);
				if(!mp.containsKey(num)) {
					int new_num = num, odd=0, even=0;
					while(new_num > 0) {
						if(new_num%2==0) {
							even++;
						}else {
							odd++;
						}
						new_num/=10;
					}
					if(odd == even) {
						count++;
						mp.put(num, 1);
					}else {
						mp.put(num, 0);
					}
				}else {
					
					//case when it contains key
					System.out.println("found : " + num);
					if(mp.get(num) == 1) {
						count++;
					}
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		String arr_to_str = "";
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = s.nextInt();
			arr_to_str+=arr[i];
		}
		
		System.out.println("ans: " + find_odd_even(arr, arr_to_str));
		s.close();
	}
}
