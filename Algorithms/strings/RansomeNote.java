package strings;

import java.util.HashMap;
import java.util.Scanner;

public class RansomeNote {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();
		
		String magazine = s.nextLine();
		System.out.println(magazine.length() + "...");
		String[] arr_m = magazine.split(" ");

		String note = s.nextLine();
		System.out.println(note.length()+ "...");
		String[] arr_n = note.split(" ");
		
		HashMap<String, Integer> map_magazine = new HashMap(), map_note = new HashMap();
		//input in hashmap
		for(int i=0;i<arr_m.length;i++) {
			if(map_magazine.containsKey(arr_m[i])) {
				map_magazine.put(arr_m[i], map_magazine.get(arr_m[i]) + 1);
				//System.out.print("map_magazine "+ arr_m[i]);
			}else {
				map_magazine.put(arr_m[i], 0);
			}
		}
		
		for(int i=0;i<arr_n.length;i++) {
			if(map_note.containsKey(arr_n[i])) {
				map_note.put(arr_n[i], map_note.get(arr_n[i]) + 1);
				//System.out.print("map_note "+ arr_n[i]);
			}else {
				map_note.put(arr_n[i], 0);
			}
		}
//		
		for(String key: map_magazine.keySet()) {
			
			System.out.print(key + "->" + map_magazine.get(key));
		}
		System.out.println(" ");

		for(String key: map_note.keySet()) {
			
			System.out.print(key + "->" + map_note.get(key));
		}
//		
		
		int flag = 1;
		
		//calculate the frequency of each word
		for(String key: map_note.keySet()) {
			
			if(map_magazine.containsKey(key)) {
				if(map_note.get(key)!=map_magazine.get(key)) {
					//flag = 0;
					flag = 0;
					break;
				}
			}else {
				flag = 0;
				break;
			}
		}
		
		if(flag == 1) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
			
	}

}
