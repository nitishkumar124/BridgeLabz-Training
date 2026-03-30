package level1;
import java.util.Scanner;
public class LargestOfThree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the first number: ");
		int n1 = sc.nextInt();
		System.out.print("Enter the second number: ");
		int n2 = sc.nextInt();
		System.out.print("Enter the third number: ");
		int n3 = sc.nextInt();
		boolean result1 = (n1>n2 && n1>n3);
		boolean result2 = (n2>n1 && n2>n3);
		boolean result3 = (n3>n1 && n3>n2);
		System.out.println("Is the first number the largest? " + result1);
		System.out.println("Is the second number the largest? " + result2);
		System.out.println("Is the third number the largest? " + result3);
	}
}