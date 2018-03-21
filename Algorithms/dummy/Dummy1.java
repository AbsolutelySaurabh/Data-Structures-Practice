package dummy;

import java.util.*;
public class Dummy1 {

    static int equalizeArray(int[] arr) {
        
        int[] memo = new int[101];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            memo[arr[i]]++;
            if(memo[arr[i]] > max){
                max = memo[arr[i]];
            }
        }
        
        int del_count = 0, flag = 0;
        //now count which frequencies are smaller than max frequency
        for(int i=0;i<memo.length;i++){
            if(memo[i] <= max && memo[i]!=0){
                del_count+=memo[i];
            }
            if(memo[i] == max && memo[i]!=0) {
            	flag  = 1;
            }
        }
        
        //in case of flag = 1;
        // we need to handle handle the case when max frquecies are multiple, so in thi case
        //at last subtract the  max to the del_count;
        if(flag == 1) {
        	del_count-=max;
        }
        
        _print(memo);
        return del_count;
    }
    
    static void _print(int[] arr) {
    	for(int i=0;i<arr.length;i++) {
    		System.out.println(arr[i]);
    	}
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = equalizeArray(arr);
        System.out.println(result);
        in.close();
    }
}