package hourrank24;

import java.util.Scanner;

public class Solution {
	
	private static boolean checkSorted(int[] arr) {
		int prev = Integer.MIN_VALUE, curr;
		for(int i=0;i<arr.length;i++) {
			curr = arr[i];
			if(curr < prev) {
				return false;
			}
			prev = curr;
		}
		return true;
	}

    static String canModify(int[] arr) {
    	
        int curr = 0, prev = 0, diff_negative=0;
        for(int i=0;i<arr.length;i++){
            curr = arr[i];
            if((prev>curr)){
            	
                if(i<=arr.length-1){
                    arr[i] = Math.max(arr[i-1], arr[i+1]);
                    if(!checkSorted(arr)) {
                        return "NO";
                    }
               }
            }
            
            prev = curr;
        }
        return "YES";
    }
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int t = s.nextInt();
		
		while(t>0) {
			
			int n = s.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++) {
				arr[i] = s.nextInt();
			}
			System.out.println(canModify(arr));
			t--;
		}
		
	}

}
