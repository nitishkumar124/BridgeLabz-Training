package week6;

import java.util.*;

public class BaseballGame_682 {

	public static void main(String[] args) {
		String[] operations = { "5", "2", "C", "D", "+" };
		System.out.println("result: " + calPoints(operations));
	}

	public static int calPoints(String[] operations) {
		Stack<Integer> stack = new Stack<>();
		for (String s : operations) {
			switch (s) {
			case "C":
				stack.pop();
				break;
			case "D":
				stack.push(stack.peek() * 2);
				break;
			case "+":
				stack.push(stack.get(stack.size() - 1) + stack.get(stack.size() - 2));
				break;
			default:
				stack.push(Integer.parseInt(s));

			}
		}
		int sum = 0;
		while (stack.size() != 0)
			sum += stack.pop();

		return sum;
	}
}
