package university_codesprint;

import java.util.HashMap;
import java.util.Scanner;

public class SummerLesson {
	
    static int[] howManyStudents(int classes, int[] arr) {
        
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<classes;i++) {
			map.put(i, 0);
		}
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			}
		}
		return returnResults(map);
	}
	
	private static int[] returnResults(HashMap<Integer, Integer> map) {
        int[] results = new int[map.size()];
        int index = 0;
		for(Integer key : map.keySet()) {
            results[index] = map.get(key);
            index++;
        }
        return results;
	}

	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		int students = s.nextInt();
		int classes = s.nextInt();
		int arr[] = new int[students];
		for(int i=0;i<arr.length;i++) {
			arr[i] = s.nextInt();
		}
		int[] results = howManyStudents(classes, arr);
		for(int i=0;i<results.length;i++) {
			System.out.print(results[i] + " ");
		}
	}
	
}
