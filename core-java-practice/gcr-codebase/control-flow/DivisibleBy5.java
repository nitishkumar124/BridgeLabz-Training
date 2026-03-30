package level1;

import java.util.Scanner;

public class DivisibleBy5 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number : ");
		int n = sc.nextInt();
		boolean check= n % 5 == 0 ? true : false;
		System.out.println("Is " + n + " divisible by 5 : " + check);

		sc.close();
	}
}