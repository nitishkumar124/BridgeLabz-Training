package level2;
import java.util.*;
public class GreatestFactorWhileLoop {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number: ");
		int number = sc.nextInt();

		int greatestFactor = 1;
		for (int i = number - 1; i > 0; i--) {
			if (number % i == 0) {
				greatestFactor = i;
				break;
			}
		}
		System.out.println("greatest factor : " + greatestFactor);
		sc.close();
	}
}

