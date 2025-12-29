package level2;

import java.util.*;

public class Factors {

	static int findSumOfFactorSquares(int[] arr) {
		int squareSum = 0;
		for (int n : arr)
			squareSum += Math.pow(n, 2);
		return squareSum;
	}

	static int findSumOfFactors(int[] factors) {
		int sum = 0;
		for (int n : factors)
			sum += n;
		return sum;
	}

	static int[] findFactors(int n) {
		int count = 0, i = 1;

		while (i <= n) {
			if (n % i == 0)
				count++;
			i++;
		}

		int[] factors = new int[count];

		i = 1;
		count = 0;
		while (i <= n) {
			if (n % i == 0)
				factors[count++] = i;
			i++;
		}

		return factors;

	}

	static int findProductOfFactors(int[] factors) {
		int product = 1;
		for (int n : factors)
			product *= n;
		return product;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number : ");
		int n = sc.nextInt();

		int[] factors = findFactors(n);
		int squareSum = findSumOfFactorSquares(factors);
		int sum = findSumOfFactors(factors);
		int product = findProductOfFactors(factors);

		System.out.println("sum of factors : " + sum);
		System.out.println("sum of factor squares : " + squareSum);
		System.out.println("product of factors : " + product);

		sc.close();
	}
}
