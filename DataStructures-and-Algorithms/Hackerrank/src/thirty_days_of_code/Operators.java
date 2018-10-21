package thirty_days_of_code;

import java.util.Scanner;

public class Operators {
	
	 public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double meal_cost = in.nextDouble();
        int tip_percent = in.nextInt();
        int tax_percent = in.nextInt();
        

        int after_taxes =(int) Math.round(((tip_percent * meal_cost)/100 + (tax_percent * meal_cost)/100 + meal_cost));
        System.out.println("The total meal cost is " + (after_taxes) + " dollars.");
        
        in.close();
	 }
}
