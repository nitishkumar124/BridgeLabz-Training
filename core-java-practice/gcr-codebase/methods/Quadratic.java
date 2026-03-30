package level2;

import java.util.*;

public class Quadratic {

	static int[] findQuadraticRoots(int a, int b, int c) {
		double delta = Math.pow(b, 2) - (4 * b * c);

		if (delta > 0) {
			int root1 = (int) ((-b + delta) / (2 * a));
			int root2 = (int) ((-b - delta) / (2 * a));
			return new int[] { root1, root2 };
		}

		else if (delta == 0) {
			int root = -b / (2 * a);
			return new int[] { root };
		}

		else
			return new int[] {};
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the value of a(coefficient of x^2) : ");
		int a = sc.nextInt();
		System.out.print("Enter the value of b(coefficient of x) : ");
		int b = sc.nextInt();
		System.out.print("Enter the value of c(constant) : ");
		int c = sc.nextInt();

		int[] roots = findQuadraticRoots(a, b, c);

		int len = roots.length;

		if (len == 2) {
			System.out.println("Root1 : " + roots[0] + ", Root2 : " + roots[1]);
		} else if (len == 1) {
			System.out.println("Root : " + roots[0]);
		} else {
			System.out.println("No roots exist.");
		}

		sc.close();
	}
}
