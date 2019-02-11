package dimentia;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t>0) {
			
			int n = s.nextInt();
			int freq = s.nextInt();
			int[] arr = new int[n];
			TreeMap<Integer, Integer> mp = new TreeMap<>();
			
			
			for(int i=0;i<n;i++) {
				arr[i] = s.nextInt();
				
				if(mp.containsKey(arr[i])) {
					mp.put(arr[i], mp.get(arr[i]) + 1);
				}else {
					
					mp.put(arr[i], 1);
				}
			}		
			
			int total_sum = 0;
			
			for(Map.Entry<Integer, Integer> entry : mp.entrySet()) {
				int key = entry.getKey();
				int value = entry.getValue();
				
				if(value == freq) {
					total_sum+=key;
				}
				
			}
			if(total_sum == 0) {
				System.out.println("-1");
			}else{
				System.out.println(total_sum);
			}
						
			t--;
		}
		
		
	}

}
