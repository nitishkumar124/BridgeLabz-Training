package week1;

import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses_20 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter string of brackets (e.g., ()[]{}): ");
		String s = scanner.nextLine();

		boolean result = isValid(s);
		System.out.println("Is the string valid? " + result);

		scanner.close();
	}

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) {

			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			}

			else {

				if (stack.isEmpty())
					return false;

				char top = stack.pop();
				if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}
}