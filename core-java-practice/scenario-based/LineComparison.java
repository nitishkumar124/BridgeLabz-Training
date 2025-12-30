package practice_problems;

import java.util.*;

public class LineComparison {

	static double useCase1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter coordinates(x y) for point 1: ");
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();

		System.out.print("Enter coordinates(x y) for point 2: ");
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();

		return Math.round(Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)));
	}

	static boolean useCase2(double l1, double l2) {
		return l1 == l2;
	}

	static int compareLine(double l1, double l2) {
		double diff = l1 - l2;
		if (diff > 0)
			return 1;
		else if (diff == 0)
			return 0;
		return -1;
	}

	static void useCase3(int n) {
		switch (n) {
		case -1:
			System.out.println("Line 2 is greater.");
			break;
		case 0:
			System.out.println("Line 1 is equal to Line 2.");
			break;
		case 1:
			System.out.println("Line 1 is greater");
			break;
		}
	}

	public static void main(String[] args) {

		System.out.println("Enter data for line 1 => ");
		double l1 = useCase1();
		System.out.println("Line 1 length : " + l1);
		System.out.println("\nEnter data for line 2 => ");
		double l2 = useCase1();
		System.out.println("Line 2 length : " + l2);

		System.out.println("\nis line 1 equal to line 2 : " + useCase2(l1, l2));
		System.out.println();
		int result = compareLine(l1, l2);
		useCase3(result);

	}
}
