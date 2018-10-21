package codevita18;
import java.util.Scanner;

public class Q_3 {
	
	public static String make_month(int arr[], int visited[], int digits_freq[]) {
		
		String month = "";
		//make month tenth place
		String tenth = "";
		if(digits_freq[1] > 0 && (digits_freq[1]!=1)) {
			tenth+="1";
			digits_freq[1]--;
		}else {
			tenth+="0";
			digits_freq[0]--;
		}
		if(tenth.equals("")) {
			return "";
		}
		String oneth = "";
		if(tenth.equals("1")) {
			
			if(digits_freq[2] > 0 && digits_freq[2]!=1) {
				oneth+="2";
				digits_freq[2]--;
			}else 
			if(digits_freq[1] > 0 && digits_freq[1]!=1){
				oneth+="1";
				digits_freq[1]--;
			}else
			if(digits_freq[0] > 0)
			{
				oneth+="0";
				digits_freq[0]--;
			}
		}else
			if(tenth.equals("0")) {
				
				if(digits_freq[9] > 0) {
					oneth+="9";
					digits_freq[9]--;
				}else 
				if(digits_freq[8] > 0){
					oneth+="8";
					digits_freq[8]--;
				}else
				if(digits_freq[7] > 0) {
					oneth+="7";
					digits_freq[7]--;
				}else 
				if(digits_freq[6] > 0){
					oneth+="6";
					digits_freq[6]--;
				}else 
					if(digits_freq[5] > 0){
						oneth+="5";
						digits_freq[5]--;
					}else 
						if(digits_freq[4] > 0){
							oneth+="4";
							digits_freq[4]--;
						}else 
							if(digits_freq[3] > 0){
								oneth+="3";
								digits_freq[3]--;
							}else 
								if(digits_freq[2] > 0){
									oneth+="2";
									digits_freq[2]--;
								}else 
									if(digits_freq[1] > 0){
										oneth+="1";
										digits_freq[1]--;
									}else 
										if(digits_freq[0] > 0){
											oneth+="0";
											digits_freq[0]--;
										}
			}
		
		if(oneth.equals("")) {
			return "";
		}
		
		month = tenth + oneth;
		return month;
		
	}
	
	public static String make_day(int arr[], int month, int digits_freq[]) {
		
		
		String day = "";
		String tenth = "";
		if(digits_freq[3] > 0 && month!=2 && (digits_freq[1] > 0 || digits_freq[0] > 0)) {
			tenth+="3";
			digits_freq[3]--;
		}else
			if(digits_freq[2] > 0) {
				tenth+="2";
				digits_freq[2]--;
			}else
				if(digits_freq[1] > 0 && digits_freq[1]!=2) {
					tenth+="1";
					digits_freq[1]--;
				}else
					if(digits_freq[0] > 0) {
						tenth+="0";
						digits_freq[0]--;
					}
		if(tenth.equals("")) {
			return "";
		}
		
		//System.out.println("day: tenth: "+ tenth);
		String oneth = "";
		
		if(tenth.equals("0") || tenth.equals("1") || tenth.equals("2")) {
			
			if(digits_freq[9] > 0 && month!=2) {
				oneth+="9";
				digits_freq[9]--;
			}else 
			if(digits_freq[8] > 0){
				oneth+="8";
				digits_freq[8]--;
			}else
			if(digits_freq[7] > 0) {
				oneth+="7";
				digits_freq[7]--;
			}else 
			if(digits_freq[6] > 0){
				oneth+="6";
				digits_freq[6]--;
			}else 
				if(digits_freq[5] > 0){
					oneth+="5";
					digits_freq[5]--;
				}else 
					if(digits_freq[4] > 0){
						oneth+="4";
						digits_freq[4]--;
					}else 
						if(digits_freq[3] > 0){
							oneth+="3";
							digits_freq[3]--;
						}else 
							if(digits_freq[2] > 0){
								oneth+="2";
								digits_freq[2]--;
							}else 
								if(digits_freq[1] > 0){
									oneth+="1";
									digits_freq[1]--;
								}else 
									if(digits_freq[0] > 0 && !tenth.equals("0")){
										oneth+="0";
										digits_freq[0]--;
									}
			
		}else
			if(tenth.equals("3")){
				
				if(digits_freq[1] > 0 && (month!=4 || month!=6 || month!=9 || month!=11)) {
					oneth+="1";
					digits_freq[1]--;
				}else
					if(digits_freq[0] > 0) {
						oneth+="0";
						digits_freq[0]--;
					}
				
			}
		
		if(oneth.equals("")) {
			return "";
		}
		
		day = tenth + oneth;
		return day;
		
	}
	
	public static String make_hour(int arr[], int freq[]) {
		
		String hour = "";
		String tenth = "";
		
		if(freq[2] > 0 && (freq[0] > 0 || freq[1] > 0 || freq[2] > 0 || freq[3] > 0 || freq[4] > 0)) {
			tenth+="2";
			freq[2]--;
		}else
			if(freq[1] > 0) {
				tenth+="1";
				freq[1]--;
			}else
				if(freq[0] > 0) {
					tenth+="0";
					freq[0]--;
				}
		
		if(tenth.equals("")) {
			return "";
		}
		
		String oneth = "";
		if(tenth.equals("0") || tenth.equals("1")){
			
			if(freq[9] > 0) {
				oneth+="9";
				freq[9]--;
			}else 
			if(freq[8] > 0){
				oneth+="8";
				freq[8]--;
			}else
			if(freq[7] > 0) {
				oneth+="7";
				freq[7]--;
			}else 
			if(freq[6] > 0){
				oneth+="6";
				freq[6]--;
			}else 
				if(freq[5] > 0){
					oneth+="5";
					freq[5]--;
				}else 
					if(freq[4] > 0){
						oneth+="4";
						freq[4]--;
					}else 
						if(freq[3] > 0){
							oneth+="3";
							freq[3]--;
						}else 
							if(freq[2] > 0){
								oneth+="2";
								freq[2]--;
							}else 
								if(freq[1] > 0){
									oneth+="1";
									freq[1]--;
								}else 
									if(freq[0] > 0){
										oneth+="0";
										freq[0]--;
									}
			
		}else
			if(tenth.equals("2")) {
				
				if(freq[4] > 0){
					oneth+="4";
					freq[4]--;
				}else 
					if(freq[3] > 0){
						oneth+="3";
						freq[3]--;
					}else 
						if(freq[2] > 0){
							oneth+="2";
							freq[2]--;
						}else 
							if(freq[1] > 0){
								oneth+="1";
								freq[1]--;
							}else 
								if(freq[0] > 0){
									oneth+="0";
									freq[0]--;
								}
			}
		if(oneth.equals("")) {
			return "";
		}
		hour = tenth + oneth;
		return hour;
		
	}
	
	public static String make_minutes(int arr[], int freq[]) {
		
		String minutes = "";
		String tenth = "";
		
		if(freq[5] > 0){
			tenth+="5";
			freq[5]--;
		}else 
			if(freq[4] > 0){
				tenth+="4";
				freq[4]--;
			}else 
				if(freq[3] > 0){
					tenth+="3";
					freq[3]--;
				}else 
					if(freq[2] > 0){
						tenth+="2";
						freq[2]--;
					}else 
						if(freq[1] > 0){
							tenth+="1";
							freq[1]--;
						}else 
							if(freq[0] > 0){
								tenth+="0";
								freq[0]--;
							}
		
		String oneth = "";
		if(tenth.equals("")) {
			return "";
		}
		
		if(freq[9] > 0) {
			oneth+="9";
			freq[9]--;
		}else 
		if(freq[8] > 0){
			oneth+="8";
			freq[8]--;
		}else
		if(freq[7] > 0) {
			oneth+="7";
			freq[7]--;
		}else 
		if(freq[6] > 0){
			oneth+="6";
			freq[6]--;
		}else 
			if(freq[5] > 0){
				oneth+="5";
				freq[5]--;
			}else 
				if(freq[4] > 0){
					oneth+="4";
					freq[4]--;
				}else 
					if(freq[3] > 0){
						oneth+="3";
						freq[3]--;
					}else 
						if(freq[2] > 0){
							oneth+="2";
							freq[2]--;
						}else 
							if(freq[1] > 0){
								oneth+="1";
								freq[1]--;
							}else 
								if(freq[0] > 0){
									oneth+="0";
									freq[0]--;
								}
		
		if(oneth.equals("")) {
			return "";
		}
		minutes = tenth + oneth;

		return minutes;
	}
	
	public static String solve(int arr[]) {
		
		//mark the visited
		int visited[] = new int[arr.length];
		for(int i = 0; i<visited.length; i++) {
			visited[i] = 0;
		}
		
		int digits_freq[] = new int[10];
		for(int i = 0;i <digits_freq.length; i++) {
			digits_freq[i] = 0;
		}
		
		int less_than_3 = 0, less_than_2 = 0, greater_than_0 = 0;
		
		for(int i = 0;i <arr.length; i++) {
			if(arr[i] > 0) {
				greater_than_0++;
			}
			if(arr[i] < 2) {
				less_than_2++;
			}
			if(arr[i] < 3) {
				less_than_3++;
			}
			digits_freq[arr[i]]++;
		}
		
		//System.out.println("greter then 0: " + greater_than_0);
		if(greater_than_0 < 2) {
			return "0";
		}
		
		if(less_than_2 < 1) {
			//System.out.println("ledss than 2");
			return "0";
		}
		
		if(less_than_3 < 3) {
			return "0";
		}
		
		
		//make month
		String month = make_month(arr, visited, digits_freq);
		if(month.equals("")) {
			return "0";
		}
		int num_month = Integer.parseInt(month);
		month+="/";
		//System.out.println("month: " + month);
		
		String day = make_day(arr, num_month, digits_freq);
		if(day.equals("")) {
			return "0";
		}
		
		//month + day
		String month_day = month + day + " ";
		//System.out.println("month_day: " + month_day);
		
		 	 	
		//now time
		String hours = make_hour(arr, digits_freq);
		if(hours.equals("")) {
			return "0";
		}
		String month_day_hour = month_day + hours + ":";
		//System.out.println("hours: " + month_day_hour);
		
		String minutes = make_minutes(arr, digits_freq);
		if(minutes.equals("")) {
			return "0";
		}
		String month_day_hour_min = month_day_hour + minutes;
		
		//System.out.println("month_day_hour_min: " + month_day_hour_min);

		return month_day_hour_min;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		String arr_str[] = str.split(",");
		int arr[] = new int[arr_str.length];
		for(int i = 0 ;i<arr.length; i++) {
			arr[i] = Integer.parseInt(arr_str[i]);
		}
		System.out.println(solve(arr));
	}

}
