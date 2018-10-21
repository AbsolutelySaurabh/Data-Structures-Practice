package codechef_practice;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		s.nextLine();
		while(t>0) {
			
			String str = s.nextLine();
			String[] arr = str.split(" ");
			
			HashMap<String, Integer> map = new HashMap<>();
			for(int i = 0;i <arr.length; i++) {
				
				if(map.containsKey(arr[i])) {
					map.put(arr[i], map.get(arr[i])+1);
				}else {
					
					map.put(arr[i], 1);
				}
			}
			
			int flag = 0;
			//args.traverse the hashmap to see the equality in freq
			int val = map.get(arr[0]);
			for(Integer v : map.values()) {
				if(v!=val) {
					flag = 1;
					break;
				}
			}
			if(flag == 1) {
				System.out.println("NO");
			}else {
				System.out.println("YES");
			}
			t--;
		}
		s.close();
		
	}

}
