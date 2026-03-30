package level3;

import java.util.*;

public class NumberChecker {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number: ");
		int n = sc.nextInt();
		print(n);

//		System.out.println("is Duck number : " + isDuckNumber(n));
//		System.out.println("is Armstrong number : " + isArmstrongNumber(n));
//
//		int[] largest = findLargestSecondLargest(n);
//		int[] smallest = findSmallestSecondSmallest(n);
//		System.out.println("largest : " + largest[0] + " second largest : " + largest[1]);
//		System.out.println("smallest : " + smallest[0] + " second smallest : " + smallest[1]);
//
//		printFrequency(digitFrequency(n));

//		System.out.println("is automorphic number : " + isAutomorphicNumber(n));
		System.out.println("is strong number : " + isStrongNumber(n));

		sc.close();
	}

	static int countDigits(int n) {
		int count = 0;
		while (n > 0) {
			count++;
			n /= 10;
		}
		return count;
	}

	static int digitSum(int n) {
		int[] digits = getDigits(n);
		int sum = 0;
		for (int d : digits)
			sum += d;
		return sum;
	}

	static int digitSquareSum(int n) {
		int[] digits = getDigits(n);
		int sum = 0;
		for (int d : digits)
			sum += Math.pow(d, 2);
		return sum;
	}

	static int[] getDigits(int n) {

		int[] digits = new int[countDigits(n)];
		int i = countDigits(n) - 1;
		while (n > 0) {
			digits[i--] = n % 10;
			n /= 10;
		}
		return digits;
	}

	static int[] getDigitsReverse(int n) {
		int[] digits = new int[countDigits(n)];
		int i = 0;
		while (n > 0) {
			digits[i++] = n % 10;
			n /= 10;
		}
		return digits;
	}

	static boolean compareDigitArrays(int[] digits, int[] reverseDigits) {

		for (int i = 0; i < digits.length; i++) {
			if (digits[i] != reverseDigits[i])
				return false;
		}

		return true;
	}

	static boolean isPalindromeNumber(int n) {
		int[] digits = getDigits(n);
		int[] reverseDigits = getDigitsReverse(n);
		return compareDigitArrays(digits, reverseDigits);
	}

	static boolean isPrime(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	static boolean isNeonNumber(int n) {
		int numSquare = n * n;
		int digitSum = digitSum(numSquare);
		return digitSum == n;
	}

	static boolean isSpyNumber(int n) {
		return digitProduct(n) == digitSum(n);
	}

	static boolean isAutomorphicNumber(int n) {
		int numSquare = n * n;

		int[] numDigits = getDigits(n);
		int[] numSquareDigits = getDigits(numSquare);
		int[] check = new int[countDigits(n)];
		int index = 0;
		for (int i = countDigits(numSquare) - countDigits(n); i < numSquareDigits.length; i++)
			check[index++] = numSquareDigits[i];
		return compareDigitArrays(check, numDigits);
	}

	static int digitProduct(int n) {
		int product = 1;
		int[] digits = getDigits(n);
		for (int d : digits)
			product *= d;
		return product;
	}

	static void print(int n) {
		int[] digits = getDigits(n);
		System.out.println();
		for (int d : digits) {
			System.out.print(d);
		}
		System.out.println();
	}

	static boolean isHarshadNumber(int n) {
		return n % (digitSum(n)) == 0;
	}

	static boolean isBuzzNumber(int n) {
		return n % 7 == 7 || (n % 7 == 0);
	}

	static int factorSum(int n) {
		int factorSum = 0;

		for (int i = 1; i <= n; i++) {
			if (n % i == 0)
				factorSum += i;
		}
		return factorSum;
	}

	static boolean isPerfectNumber(int n) {

		return factorSum(n) == n;
	}

	static boolean isAbundantNumber(int n) {
		return factorSum(n) > n;
	}

	static boolean isDeficientNumber(int n) {
		return factorSum(n) < n;
	}

	static boolean isStrongNumber(int n) {
		int[] digits = getDigits(n);

		int digitFactorialSum = 0;

		for (int d : digits)
			digitFactorialSum += factorial(d);

		return digitFactorialSum == n;

	}

	static int factorial(int n) {
		if (n <= 1)
			return 1;
		return n * factorial(n - 1);
	}

	static int[][] digitFrequency(int n) {

		int[] temp = new int[10];

		int[] digits = getDigits(n);

		for (int d : digits) {
			temp[d]++;
		}

		int size = 0;
		for (int t : temp) {
			if (t != 0)
				size++;
		}
		int[][] frequency = new int[size][2];
		int index = 0;
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != 0) {
				frequency[index][0] = i;
				frequency[index][1] = temp[i];
				index++;
			}
		}
		return frequency;

	}

	static void printFrequency(int[][] frequency) {
		System.out.println("\ndigit : frequency");
		for (int[] f : frequency) {
			System.out.println(f[0] + " : " + f[1]);
		}
	}

	static boolean isDuckNumber(int n) {
		int[] digits = getDigits(n);

		int start = 0, end = digits.length - 1;

		while (digits[start] == 0)
			start++;
		while (digits[end] == 0)
			end--;

		for (int i = start; i <= end; i++)
			if (digits[i] == 0)
				return true;

		return false;
	}

	static boolean isArmstrongNumber(int n) {
		int digitSum = 0;
		int[] digits = getDigits(n);
		int count = countDigits(n);

		for (int d : digits) {
			digitSum += Math.pow(d, count);
		}

		if (n == digitSum)
			return true;

		return false;
	}

	static int[] findLargestSecondLargest(int n) {
		int[] digits = getDigits(n);
		int largest = Integer.MIN_VALUE, secondLargest = 0;
		for (int i = 0; i < digits.length; i++) {
			if (largest < digits[i]) {
				secondLargest = largest;
				largest = digits[i];
			} else if (secondLargest < digits[i] && largest != digits[i]) {
				secondLargest = digits[i];
			}
		}

		return new int[] { largest, secondLargest };
	}

	static int[] findSmallestSecondSmallest(int n) {
		int[] digits = getDigits(n);
		int smallest = Integer.MAX_VALUE, secondSmallest = 0;
		for (int i = 0; i < digits.length; i++) {
			if (digits[i] < smallest) {
				secondSmallest = smallest;
				smallest = digits[i];
			} else if (secondSmallest > digits[i] && smallest != digits[i]) {
				secondSmallest = digits[i];
			}
		}

		return new int[] { smallest, secondSmallest };
	}
}
