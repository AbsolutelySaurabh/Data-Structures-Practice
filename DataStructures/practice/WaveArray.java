package practice;

import java.util.*;

public class WaveArray {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<>();
		int n = s.nextInt();
		int index = 0;
		while(n!=-1) {
			arr.add(index, n);
			n = s.nextInt();
			index++;
		}
		Collections.sort(arr);
		
		//rotate
		for(int i=0;i <arr.size(); i++) {
			if(arr.size()%2!=0) {
				if(i<arr.size()-1) {
					int temp = arr.get(i);
					arr.set(i, arr.get(i+1));
					arr.set(i+1, temp);
					i++;
				}
			}else{
				int temp = arr.get(i);
				arr.set(i, arr.get(i+1));
				arr.set(i+1, temp);
				i++;
			}
		}
		
		//print
		for(int i=0;i <arr.size(); i++) {
			System.out.println(arr.get(i));
		}
		s.close();
	}

}
