package level1;

import java.util.Scanner;

public class CountDownForLoop {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter input: ");
		int n = scanner.nextInt();
		for(int  i = n; i >= 0; i--) {
			System.out.println(i);
		}
		scanner.close();
	}
}