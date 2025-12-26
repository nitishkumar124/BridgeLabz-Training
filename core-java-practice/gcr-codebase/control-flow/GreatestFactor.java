package level2;
import java.util.*;
public class GreatestFactor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number: ");
		int number = sc.nextInt();

		int greatestFactor = 1;
		int i = number - 1;
		while (i > 0) {
			if (number % i == 0) {
				greatestFactor = i;
				break;
			}
			i--;
		}
		System.out.println("greatest factor : " + greatestFactor);
		sc.close();
	}
}

