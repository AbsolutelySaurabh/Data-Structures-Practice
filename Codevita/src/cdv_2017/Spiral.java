package cdv_2017;

import java.util.Scanner;

public class Spiral {

	public static Boolean found = false;
	public static int found_x = -1, found_y = -1;
	public static int d_x = 0, d_y = 0;
	
	public static Boolean checkPrime(int num){
		if(num == 2 || num == 3 || num == 5){
			return true;
		}
		for(int i = 2; i*i<=num; i++){
			if(num%i == 0){
				return false;
			}
		}
		return true;
	}
	
	public static int nextPrime_(int prevPrime){
		
		//left prevPrime = 7;
		for(int i =prevPrime+1;  ; i++){
			if(checkPrime(i)){
				return i;
			}
		}
	}
	
	public static void goRight(){
		d_x+=1;
	}
	
	public static void goUp(){
		d_y+=1;
	}	
	
	public static void goLeft(){
		d_x-=1;
	}
	
	public static void goDown(){
		d_y-=1;
	}
	public static void solve(int prime){
		
		//initial
		int nextPrime = 2;
		int rightIntensity = 1, upIntensity = 1;
		int leftIntensity = 2, downIntensity = 2;
		while(prime!=nextPrime){
			
			int prevPrime = 0;
			
			for(int i = 0; i<rightIntensity; i++){
				if(prime == nextPrime){
					break;
				}else{
					prevPrime = nextPrime;
					nextPrime = nextPrime_(prevPrime);
					goRight();	
				}
			}			

			for(int i = 0; i<upIntensity; i++){
				if(prime == nextPrime){
					break;
				}else{
					prevPrime = nextPrime;
					nextPrime = nextPrime_(prevPrime);
					goUp();	
				}
			}
			
			for(int i = 0;i <leftIntensity; i++){
				if(nextPrime!=prime){
					prevPrime  = nextPrime;
					nextPrime = nextPrime_(prevPrime);
					goLeft();
				}else{
					break;
				}
			}
			
			for(int i=0;i <downIntensity; i++){
				if(nextPrime!=prime){
					prevPrime  = nextPrime;
					nextPrime = nextPrime_(prevPrime);
					goDown();
				}else{
					break;
				}
			}
			
			rightIntensity+=2;
			upIntensity+=2;
			
			leftIntensity+=2;
			downIntensity+=2;
			
		}
		if(prime == nextPrime){
			System.out.println(d_x + " " + d_y);
		}
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		while(n > 0){
			found_x = -1;
			found_y = -1;
			found = false;
			d_x = 0;
			d_y = 0;
			int prime = s.nextInt();
			solve(prime);
			n--;
		}
		s.close();
	}

}
