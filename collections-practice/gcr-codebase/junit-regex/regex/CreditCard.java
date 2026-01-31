package regex;

import java.util.regex.Pattern;

public class CreditCard {
	public static void main(String[] args) {

		String card = "4123456789012345"; // Visa
		String regex = "^(4\\d{15}|5\\d{15})$";

		System.out.println(Pattern.matches(regex, card) ? "Valid Card" : "Invalid Card");
	}
}
