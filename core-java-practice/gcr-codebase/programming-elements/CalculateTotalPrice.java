package level1;

import java.util.Scanner;

public class CalculateTotalPrice {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.err.println("enter per unit price of the item : ");
		int unitPrice = sc.nextInt();
		System.err.println("enter number of units of the item : ");
		double units = sc.nextDouble();
		double totalPrice = units * unitPrice;
		System.out.println("The total purchase is INR " + totalPrice + " for the quantity " + units + " and unit price " + unitPrice);
		
	}

}
