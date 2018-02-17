package weekofcode;

import java.util.Scanner;

public class checkMate {
	
	public static int count = 0;
	
	public static void checkKnight(int i, int j, char[][] arr) {
		System.out.println("Knight j: " + j);
		if(j>2) {
			if(arr[i][j-2] == 'k') {
				count++;
			}
		}
		if(arr[i][j+2] == 'k') {
			count++;
		}
		System.out.println("Knight" + count);
	}
	
	public static void checkRook(int i, int j, char[][] arr) {
		//check straight in a line
		for(int k=0;k<8;k++) {
			if(arr[i][k] == 'k') {
				count++;
			}
		}	
		for(int k=0;k<8;k++) {
			if(arr[k][j] == 'k') {
				count++;
			}
		}
		System.out.println("Rook: " + count);

	}
	
	public static void checkQueen(int i, int j, char[][] arr) {
		//check straight in a line
			for(int k=0;k<8;k++) {
				if(arr[i][k] == 'k') {
				count++;
				}
			}	
			for(int k=0;k<8;k++) {
				if(arr[k][j] == 'k') {
					count++;
				}
			}
			
		//check the diagonal case
			for(int k=0;k<8;k++) {
				for(int l=0;l<8;l++) {
					
					if(arr[k][l] == 'k') {
						count++;
					}
				}
			}
			System.out.println("Queen: " + count);
	}
	
	public static void checkBishop(int i, int j, char[][] arr) {
		//check the diagonal
		for(int k=0;k<8;k++) {
			for(int l=0;l<8;l++) {
				
				if(arr[k][l] == 'k') {
					count++;
				}
			}
		}
		System.out.println("Bishop: " + count);

	}
	
	public static void checkMate(char[][] arr) {
		
		for(int i=1;i<2;i++) {
			//checking only for the 7th row
			for(int j=0;j<8;j++) {
				if(arr[i][j] == 'P') {
					if(arr[i-1][j] == '#') {
					     checkKnight(i-1, j-2, arr);
					     checkRook(i-1, j, arr);
					     checkBishop(i-1, j, arr);
					     checkQueen(i-1,j, arr);
					}
				}
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		char[][] arr = new char[8][8];
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				arr[i][j] = s.next().charAt(0);
			}
		}
		checkMate(arr);
		System.out.println("Total ways: " + count);
	}

}
