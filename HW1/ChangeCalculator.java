import java.util.Scanner;

/**
 * 
 * @author Tam Doan
 * This is HW1, Problem 2.2: Change Calculator
 * This takes the amount a user inputed and outputs the 
 * fewest amount of bills/coins needed to represent it
 *
 */

public class ChangeCalculator {

	public static void main(String[] args) {

		// prompting user to input amount
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter amount: ");
		double money = scanner.nextDouble();
		
		// splitting amount into separate dollars and cents integers
		int dollars = (int)money;
		int cents = (int)(Math.round((money%dollars)*100));
		
		int twenty = 0;
		int ten= 0;
		int five= 0;
		int one= 0;
		int quarters= 0;
		int dimes= 0;
		int nickles= 0;
		int pennies= 0;
		
		System.out.printf("Amount $%.2f \n",money);

		// calculating the change for amount inputed
		while (dollars != 0 || cents != 0) {
			
			// dollar calculations
			if (dollars >= 20) {
				twenty = dollars/20;
				dollars = dollars % 20;		
			}
			else if (dollars >= 10) {
				ten = dollars/10;
				dollars = dollars %10;
			}
			else if (dollars >= 5) {
				five = dollars/5;
				dollars = dollars %5;
			}
			else if (dollars >= 1) {
				one = dollars/1;
				dollars = dollars %1;
			} // end of if

			// cents calculations
			if (cents >= 25) {
				quarters = cents/25;
				cents = cents %25;
			}
			else if (cents >= 10) {
				dimes = cents/10;
				cents = cents %10;
			}
			else if (cents >= 5) {
				nickles = cents/5;
				cents = cents %5;
			}
			else if (cents >= 1) {
				pennies = cents/1;
				cents = cents %1;
			} // end of if
			
			
		} // end of while
		
		System.out.println(twenty+" twenty dollar bills");
		System.out.println(ten+" ten dollar bills");
		System.out.println(five+" five dollar bills");
		System.out.println(one+" one dollar bills");
		System.out.println(quarters+" quarters");
		System.out.println(dimes+" dimes");
		System.out.println(nickles+" nickles");
		System.out.println(pennies+" pennies");

	} // end of main

}
