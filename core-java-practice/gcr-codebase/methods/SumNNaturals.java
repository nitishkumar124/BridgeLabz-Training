package level1;
import java.util.*;
public class SumNNaturals {

	static int getSumOfNNaturals(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number : ");
		int n = sc.nextInt();
		if (n < 1) {
			System.out.println("enter a natural number.");
			return;
		}
		int sum = getSumOfNNaturals(n);
		System.out.println("sum of " + n + " natural numbers : " + sum);
		sc.close();
	}
}

