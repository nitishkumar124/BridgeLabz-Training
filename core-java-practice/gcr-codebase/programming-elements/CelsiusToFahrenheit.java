package practice_problems;
import java.util.*;
public class CelsiusToFahrenheit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("What's the celsius reading : ");
		double celsius = sc.nextDouble();
		double fahrenheit = (celsius * 9/5) + 32;
		System.out.println("Fahrenheit Temperature : " + fahrenheit);
	}

}
