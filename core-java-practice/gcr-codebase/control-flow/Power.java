package level2;
import java.util.*;
public class Power {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number : ");
		int number = sc.nextInt();
		System.out.print("Enter power : ");
		int power = sc.nextInt();
		int result = 1;
		for (int i = power; i > 0; i--) {
			result *= number;
		}
		System.out.println(number + " raised to power " + power + " is : " + result);
		sc.close();
	}
}

