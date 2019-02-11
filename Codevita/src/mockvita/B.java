//comment out package line for codevita submission
//package mockvita;

import java.util.Arrays;
import java.util.Scanner;

public class B {
	
	public static String minuteTenth(int freq[], String time){
		
		//check for minutes < 6 tenth digit
		if(freq[5] > 0){
			time+="5";   
			freq[5]--;
		}else
			if(freq[4] > 0){
				time+="4";
				freq[4]--;
			}else
				if(freq[3] > 0){
					time+="3";
					freq[3]--;
				}else
					if(freq[2] >0 ){
						time+="2";
						freq[2]--;
					}else
						if(freq[1] >0 ){
							time+="1";
							freq[1]--;
						}else
							if(freq[0] >0 ){
								time+="0";
								freq[0]--;
							}
		return time;
	}
	
	public static String minuteOneth(int freq[], String time){
		
		//check for minutes <=9 oneth digit
		
		if(freq[9] > 0){
			time+="9";
			freq[9]--;
		}else
		if(freq[8] > 0){
			time+="8";
			freq[8]--;
		}else
		if(freq[7] > 0){
			time+="7";
			freq[7]--;
		}else
		if(freq[6] > 0){
			time+="6";
			freq[6]--;
		}else
		if(freq[5] > 0){
			time+="5";
			freq[5]--;
		}else
			if(freq[4] > 0){
				time+="4";
				freq[4]--;
			}else
				if(freq[3] > 0){
					time+="3";
					freq[3]--;
				}else
					if(freq[2] >0 ){
						time+="2";
						freq[2]--;
					}else
						if(freq[1] >0 ){
							time+="1";
							freq[1]--;
						}else
							if(freq[0] >0 ){
								time+="0";
								freq[0]--;
							}
		return time;
	}
	
	public static String secondTenth(int freq[], String time){
		
		if(freq[5] > 0){
			time+="5";
			freq[5]--;
		}else
			if(freq[4] > 0){
				time+="4";
				freq[4]--;
			}else
				if(freq[3] > 0){
					time+="3";
					freq[3]--;
				}else
					if(freq[2] >0 ){
						time+="2";
						freq[2]--;
					}else
						if(freq[1] >0 ){
							time+="1";
							freq[1]--;
						}else
							if(freq[0] >0 ){
								time+="0";
								freq[0]--;
							}
		
		return time;
	}
	
	public static String secondOneth(int freq[], String time){
				
		if(freq[9] > 0){
			time+="9";
			freq[9]--;
		}else
		if(freq[8] > 0){
			time+="8";
			freq[8]--;
		}else
		if(freq[7] > 0){
			time+="7";
			freq[7]--;
		}else
		if(freq[6] > 0){
			time+="6";
			freq[6]--;
		}else
		if(freq[5] > 0){
			time+="5";
			freq[5]--;
		}else
			if(freq[4] > 0){
				time+="4";
				freq[4]--;
			}else
				if(freq[3] > 0){
					time+="3";
					freq[3]--;
				}else
					if(freq[2] >0 ){
						time+="2";
						freq[2]--;
					}else
						if(freq[1] >0 ){
							time+="1";
							freq[1]--;
						}else
							if(freq[0] >0 ){
								time+="0";
								freq[0]--;
							}
		
		return time;
	}
	
	public static String solve(int input[]){
		
		//search for 1 or 2 or 0 present or not
		if(Arrays.binarySearch(input, 1)==-1 && Arrays.binarySearch(input, 2) == -1 && Arrays.binarySearch(input, 0) == -1){
			return "Impossible";
		}
		
		String time = "";
		String hours = "";
		
		int visited[] = new int[input.length];
		int freq[] = new int[10];
		for(int i=0;i <10;i++){
			freq[i] = 0;
		}
		
		//check for 24:00:00
		int zero_count = 0;
		if(Arrays.binarySearch(input, 2)!=-1){
			if(Arrays.binarySearch(input, 4)!=-1){
				//not check for 4 0's
				if(freq[0] >= 4){
					return "24:00:00";
				}
			}
		}
		
		//calculate frequency of all
		for(int i=0; i<input.length; i++){
			freq[input[i]]++;
		}
		
		//check starting with 2
		if(freq[2]>0){
			time+="2";
			freq[2]--;
			
			//check for 23 , 22, 21, 20
			if(freq[3] > 0){
				time+="3";
				freq[3]--;
			}else
				if(freq[2] > 0){
					time+="2";
					freq[2]--;
				}else
					if(freq[1] > 0){
						time+="1";
						freq[1]--;
					}else
						if(freq[0] >0 ){
							time+="0";
							freq[0]--;
						}
			
			//till now hours done
			time+=":";
			
			time = minuteTenth(freq, time);
			time = minuteOneth(freq, time);
			//till now minutes done
			time+=":";
		
			time = secondTenth(freq, time);
			time = secondOneth(freq, time);
		
		}else
			//if 2 not present
			if(freq[1] > 0){
				time+="1";
				freq[1]--;
				
				//now, hour oneth has same condition like minute oneth
				time = minuteOneth(freq, time);
				
				time+=":";
				
				time = minuteTenth(freq, time);
				time = minuteOneth(freq, time);
				//till now minutes done
				time+=":";
			
				time = secondTenth(freq, time);
				time = secondOneth(freq, time);
			
			}else
				//2, 1 not present
				if(freq[0] > 0){
					time+="0";
					freq[0]--;
					
					//now, hour oneth has same condition like minute oneth
					time = minuteOneth(freq, time);
					
					time+=":";
					
					time = minuteTenth(freq, time);
					time = minuteOneth(freq, time);
					//till now minutes done
					time+=":";
				
					time = secondTenth(freq, time);
					time = secondOneth(freq, time);
					
				}
		
		return time;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		String line1 = s.nextLine();
        String[] lineVector1;

        //separate all values by comma
        lineVector1 = line1.split(",");
        
		int input[] = new int[lineVector1.length];
		for(int i=0;i <lineVector1.length; i++){
			input[i] = Integer.parseInt(lineVector1[i]);
		}
		
		System.out.print(solve(input));
		s.close();
	}

}
