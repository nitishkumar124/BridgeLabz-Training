package week2;

public class MathUtility {
	static int factorial(int n) {
		if (n < 0)
			return -1;
		int fact = 1;
		for (int i = 1; i <= n; i++) {
			fact *= i;
		}
		return fact;
	}

	static boolean isPrime(int n) {
		if (n <= 1)
			return false;

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	static int gcd(int a, int b) {
		if (a < 0 || b < 0)
			return -1;

		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	static int fibonacci(int n) {
		if (n < 0)
			return -1;
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;

		int a = 0, b = 1, c = 0;
		for (int i = 2; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}

	public static void main(String[] args) {
		System.out.println("Factorial of 5: " + factorial(5));
		System.out.println("Factorial of 0: " + factorial(0));
		System.out.println("Factorial of -3: " + factorial(-3));

		System.out.println("\nIs 7 Prime? " + isPrime(7));
		System.out.println("Is 1 Prime? " + isPrime(1));
		System.out.println("Is -5 Prime? " + isPrime(-5));

		System.out.println("\nGCD of 24 and 36: " + gcd(24, 36));
		System.out.println("GCD of 10 and 0: " + gcd(10, 0));

		System.out.println("\nFibonacci of 7: " + fibonacci(7));
		System.out.println("Fibonacci of 0: " + fibonacci(0));
		System.out.println("Fibonacci of -4: " + fibonacci(-4));
	}
}