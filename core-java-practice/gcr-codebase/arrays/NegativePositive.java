package level1;

import java.util.*;

public class NegativePositive {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] nums = new int[5];

		for (int i = 0; i < 5; i++) {
			System.out.print("number " + (i + 1) + " : ");
			nums[i] = sc.nextInt();
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				if (nums[i] % 2 == 0)
					System.out.println("Even : " + nums[i]);
				else
					System.out.println("Odd : " + nums[i]);

			} else
				System.out.println("Negative : " + nums[i]);
		}

		sc.close();
	}
}
