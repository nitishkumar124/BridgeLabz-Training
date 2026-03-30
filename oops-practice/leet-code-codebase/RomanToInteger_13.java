package week2;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class RomanToInteger_13 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a Roman numeral (e.g., MCMXCIV): ");
		String s = scanner.nextLine().toUpperCase();

		int result = romanToInt(s);
		System.out.println("Integer value: " + result);

		scanner.close();
	}
	public static int romanToInt(String s) {
		Map<Character, Integer> romanMap = new HashMap<>();
		romanMap.put('I', 1);
		romanMap.put('V', 5);
		romanMap.put('X', 10);
		romanMap.put('L', 50);
		romanMap.put('C', 100);
		romanMap.put('D', 500);
		romanMap.put('M', 1000);

		int total = 0;
		int n = s.length();

		for (int i = 0; i < n; i++) {
			int currentVal = romanMap.get(s.charAt(i));


			if (i < n - 1 && currentVal < romanMap.get(s.charAt(i + 1))) {
				total -= currentVal;
			} else {
				total += currentVal;
			}
		}

		return total;
	}
}