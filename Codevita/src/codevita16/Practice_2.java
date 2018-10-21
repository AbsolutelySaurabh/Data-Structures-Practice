package codevita16;
import java.util.*;
public class Practice_2 {
    
    public static void _sort(int arr[]){
        

        //the goo t the half and swap the end elemtnts
        int half = arr.length/2;

        //sort the Arrray first half
        Arrays.sort(arr, 0, half);
        
        //then do the reverse sorting of the other half
        Arrays.sort(arr,half, arr.length);
        int start = half;
        int end = arr.length-1;
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            
            start++;
            end--;
        }
        
    }

    public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       int n = s.nextInt();
       int arr[] = new int[n];
       for(int i=0; i<n; i++){
           arr[i] = s.nextInt();
       }
       
       
       //short
       _sort(arr);
       //print   
       for(int i=0;i <arr.length; i++){
           System.out.print(arr[i] + " ");
       }
       s.close();
    }

}