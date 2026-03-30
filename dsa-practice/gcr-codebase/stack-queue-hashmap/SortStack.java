package stack_queue_hashmap;

import java.util.*;

public class SortStack {

	public static void sortStack(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}

		int top = stack.pop();

		sortStack(stack);

		insertInSortedOrder(stack, top);
	}

	private static void insertInSortedOrder(Stack<Integer> stack, int element) {
		if (stack.isEmpty() || element > stack.peek()) {
			stack.push(element);
			return;
		}

		int temp = stack.pop();
		insertInSortedOrder(stack, element);

		stack.push(temp);
	}

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(30);
		s.push(-5);
		s.push(18);
		s.push(14);
		s.push(-3);

		System.out.println("Stack before sorting: " + s);
		sortStack(s);
		System.out.println("Stack after sorting:  " + s);
	}
}
