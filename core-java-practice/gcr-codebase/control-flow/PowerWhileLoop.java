package level2;
import java.util.*;
public class PowerWhileLoop {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number : ");
		int number = sc.nextInt();
		System.out.print("Enter power : ");
		int power = sc.nextInt();
		int result = 1;
		int i = power; 
		while (i > 0) {
			result *= number;
			i--;
		}
		System.out.println(number + " raised to power " + power + " is : " + result);
		sc.close();
	}
}

