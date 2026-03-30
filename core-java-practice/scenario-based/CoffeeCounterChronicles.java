package practice_problems;

import java.util.*;

public class CoffeeCounterChronicles {
//	The Coffee Counter Chronicles ☕
//	Ravi runs a café. Each customer orders different coffee types with quantities. Write a program
//	that:
//	● Asks for coffee type (switch)
//	● Calculates total bill (price * quantity)
//	● Adds GST using arithmetic operators
//	Use while to continue for the next customer and break when "exit" is typed.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] menu = { "Espresso", "Latte", "Cappuccino", "Macchiato", "Americano" };
		int[] prices = { 100, 120, 125, 150, 130 };
		while (true) {
			System.out.println("Choose coffee :");
			for (int i = 0; i < menu.length; i++)
				System.out.println((i + 1) + ". " + menu[i]);
			System.out.print("enter item number : ");
			int c = sc.nextInt();
			System.out.print("quantity : ");
			int quantity = sc.nextInt();
			double bill = (prices[c - 1] * quantity) * 1.05;

			System.out.println("your bill : " + bill);
			System.out.println("\nto continue press 1.\nto exit press 0.");
			if (sc.nextInt() == 0) {
				System.out.println("thank you for visiting.");
				break;
			}
			sc.nextLine();
			System.out.println();
		}
//		sc.close();
	}
}
