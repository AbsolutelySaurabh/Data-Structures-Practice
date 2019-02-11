package hourrank24;
import java.util.*;
public class q_2 {
	
	static long maximumProfit(int arr[],int n)
	{
	    long[] mpis = new long[n];
	 
	    /* Initialize MPIS values */
	    for (int i = 0; i < n; i++)
	        mpis[i] = arr[i];
	 
	    for (int i = 1; i < n; i++)
	        for (int j = 0; j < i; j++)
	            if (arr[i] > arr[j] && mpis[i] < (mpis[j] * arr[i]))
	                mpis[i] = mpis[j] * arr[i];
	 
	    /* Pick maximum of all product values */
	    long max = -1;
	    for(int i=0;i<mpis.length;i++) {
	    	if(mpis[i] > max) {
	    		max = mpis[i];
	    	}
	    }
	    return max;
	}
	 
	
	public static void main(String[] arg) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = s.nextInt();
		}
		
		System.out.println(maximumProfit(arr, n));
	}

}
