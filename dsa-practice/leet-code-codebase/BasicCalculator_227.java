package week3;

import java.util.*;

public class BasicCalculator_227 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter some expression(eg: 3+2*2): ");
		String input = sc.nextLine();
		System.out.print("Result: " + calculate(input));
		sc.close();
	}

	public static int calculate(String s) {

		Stack<Integer> stack = new Stack<>();
		int num = 0;
		char sign = '+';
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (Character.isDigit(ch)) {
				num = num * 10 + ch - '0';
			}

			if (!Character.isDigit(ch) && ch != ' ' || i == s.length() - 1) {
				if (sign == '+') {
					stack.push(num);
				} else if (sign == '-') {
					stack.push(-num);
				} else if (sign == '*') {
					stack.push(stack.pop() * num);
				} else if (sign == '/') {
					stack.push(stack.pop() / num);
				}
				sign = ch;
				num = 0;
			}
		}
		int result = 0;
		while (!stack.isEmpty()) {
			result += stack.pop();
		}
		return result;
	}
}
