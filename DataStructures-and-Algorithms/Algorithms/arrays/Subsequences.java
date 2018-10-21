package arrays;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.Vector;
public class Subsequences {

	public static int count = 0;
	public static void print(Vector<Integer> vector) {
		for(int i=0;i<vector.size(); i++) {
			System.out.print(vector.get(i) + " ");
		}
		System.out.println();
	}
	public static void subsequences(int input[], Vector<Integer> vector) {
		int size = (int) Math.pow(2, input.length);
		for(int counter = 1; counter<size; counter++) {
			for(int j=0;j<input.length;j++) {
				//now check the bit
				//It occurs as this
				//if count = 2, then it'll check for binary 2 i.e "10" , and indexing in bits start from "right->left"
				//the below condition is true if the bit at that j'th index = 1;
				if(BigInteger.valueOf(counter).testBit(j)) {
					vector.add(input[j]);
				}
			}
			print(vector);
			vector.clear();
		}
	}
	
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n  = s.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]  = s.nextInt();
		}
		
		Vector<Integer> vector = new Vector<>();
		subsequences(arr, vector);
		
		s.close();
	}

}
