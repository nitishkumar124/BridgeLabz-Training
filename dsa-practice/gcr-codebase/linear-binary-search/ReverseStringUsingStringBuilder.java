package linear_binary_search;

import java.util.*;

public class ReverseStringUsingStringBuilder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter some text: ");
		StringBuilder input = new StringBuilder(sc.nextLine());

		System.out.println("Reversed text: " + input.reverse().toString());
		sc.close();
	}
}
