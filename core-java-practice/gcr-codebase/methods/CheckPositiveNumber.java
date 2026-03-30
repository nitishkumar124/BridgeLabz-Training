package level1;

import java.util.*;

public class CheckPositiveNumber {

	static int isNumberPositive(int n) {
		if (n > 0)
			return 1;
		else if (n == 0)
			return 0;
		else
			return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number : ");
		int n = sc.nextInt();

		int check = isNumberPositive(n);

		System.out.println("result : " + check);

		sc.close();
	}
}
