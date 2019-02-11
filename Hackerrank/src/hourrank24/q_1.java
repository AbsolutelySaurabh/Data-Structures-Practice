package hourrank24;

import java.util.Scanner;

public class q_1 {

    static String canModify(int[] arr) {
        /*
         * Write your code here.
         */
        int curr = 0, prev = 0, decr_negative=0;
        for(int i=0;i<arr.length;i++){
            curr = arr[i];
            if(prev!=0){
                if((curr-prev) < 0 ){
                	//check next status then
                	if(i+1<=arr.length-1) {
                		int next = arr[i+1];
                		if(next>=prev) {
                			decr_negative++;
                		}else
                			{
                				decr_negative++;
                			}
                	}
                }
            }
            prev = curr;

        }
        
        if(decr_negative == 1){
            return "YES";
        }
        return "NO";

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
