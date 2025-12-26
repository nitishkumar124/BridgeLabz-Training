package level3;
import java.util.*;
public class CountDigits {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number : ");
		int n = sc.nextInt();
		int number = n;
		int digits = 0;
		
		while (n > 0) {
			digits++;
			n /= 10;
		}
		System.out.println("Digits in " + number + " : " + digits);

		sc.close();
	}
}

