package collections.list_interface;

import java.util.LinkedList;
import java.util.ListIterator;

public class NthElementFromEnd {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>(java.util.List.of("A", "B", "C", "D", "E"));
		int n = 2;

		String result = findNthFromEnd(list, n);

		System.out.println("List: " + list);
		System.out.println(n + "nd element from end: " + result);
	}

	public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
		if (list == null || n <= 0 || n > list.size()) {
			throw new IllegalArgumentException("Invalid value of N or empty list.");
		}

		ListIterator<T> fast = list.listIterator();
		ListIterator<T> slow = list.listIterator();

		for (int i = 0; i < n; i++) {
			if (fast.hasNext()) {
				fast.next();
			}
		}

		while (fast.hasNext()) {
			fast.next();
			slow.next();
		}

		return slow.next();
	}
}