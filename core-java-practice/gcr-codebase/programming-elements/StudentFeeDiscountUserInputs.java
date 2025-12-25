package level1;

import java.util.Scanner;

public class StudentFeeDiscountUserInputs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter fee : ");
		double fee = sc.nextDouble();
		System.out.print("enter discount percent : ");
		double discountPercent = sc.nextDouble();
		double discount = fee * discountPercent / 100;
		double payableFee = fee - discount;
		System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + payableFee);

	}

}
