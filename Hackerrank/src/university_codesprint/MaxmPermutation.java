package university_codesprint;

import java.util.*;

public class MaxmPermutation {
	
	static HashMap<String, Integer> map = new HashMap();
	static int flag = 0;
	static String max = null;
	
	public static void findSubs(String str) {
		
		for(int i=0;i<str.length();i++) {
			for(int j=i;j<str.length();j++) {
				String sub_str = str.substring(i,  j+1);
				System.out.println(sub_str + " ");
				if(map.containsKey(sub_str)) {
					flag = 1;
					map.put(sub_str, map.get(sub_str)+ 1);
					
					if(max == null) {
						max = sub_str;
					}else {
						if(map.get(sub_str) > map.get(max)) {
							max = sub_str;
						}else
							if(map.get(sub_str) == map.get(max)) {
								if(sub_str.compareTo(max) >= 0) {
									//get the lexicographically smallest one between the two
									max = sub_str;
								}
							}
					}	
				}
			}
		}
	}
	
	public static void findPermus(String str, String output){		
		if(str.length()==0){		
			map.put(output, 0);		
			return;
		}
		for(int i=0;i< str.length();i++){	
			findPermus((str.substring(0, i) + str.substring(i+1)), output + str.charAt(i) );
		}
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		while(t>0) {
			
			String s1 = s.next();
			String s2 = s.next();
			
			findPermus(s1,"");
			findSubs(s2);

			if(flag == 0) {
				System.out.println("-1");
			}else
				if(flag == 1) {
					System.out.println(max);
				}
			
			map.clear();
			flag=0;
			max = null;
			t--;
		}
	}

}
