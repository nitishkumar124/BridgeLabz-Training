package level2;

import java.util.*;

public class OddEven {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter value : ");
		int n = sc.nextInt();
		if (n > 0) {
			for (int i = 1; i <= n; i++) {
				if (i % 2 == 0) {
					System.out.println(i + " : Even");
				} else {
					System.out.println(i + " : Odd");
				}
			}
		} else {
			System.out.println("value not a natural number.");
		}

		sc.close();
	}
}
