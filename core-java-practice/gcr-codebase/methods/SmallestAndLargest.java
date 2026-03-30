package level1;

import java.util.*;

public class SmallestAndLargest {

	public static int[] findSmallestAndLargest(int n1, int n2, int n3) {
		int[] nums = { n1, n2, n3 };
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int n : nums) {
			if (min > n)
				min = n;
			if (max < n)
				max = n;
		}

		return new int[] { min, max };
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first number: ");
		int n1 = sc.nextInt();
		System.out.print("Enter second number: ");
		int n2 = sc.nextInt();
		System.out.print("Enter third number: ");
		int n3 = sc.nextInt();
		
		int[] minAndMax = findSmallestAndLargest(n1, n2, n3);
		int min = minAndMax[0], max = minAndMax[1];
		System.out.println("minimum : " + min);
		System.out.println("maximum : " + max);

		sc.close();
	}
}
