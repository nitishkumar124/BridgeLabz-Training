package level1;

import java.util.Scanner;

public class SumInputNumbers {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double sum = 0;
		while (true) {
			System.out.print("Enter value: ");
			double input = scanner.nextDouble();
			if (input <= 0.0) {
				break;
			} else
				sum += input;
		}
		System.out.println("total sum : " + sum);

		scanner.close();
	}
}