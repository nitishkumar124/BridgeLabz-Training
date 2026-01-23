package collections.list_interface;

import java.util.ArrayList;
import java.util.List;

public class ListRotation {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(List.of(10, 20, 30, 40, 50));
		int k = 2;

		System.out.println("Original: " + list);
		rotateLeft(list, k);
		System.out.println("Rotated by " + k + ": " + list);
	}

	public static void rotateLeft(List<Integer> list, int k) {
		int n = list.size();
		if (n == 0)
			return;

		k = k % n;
		if (k == 0)
			return;

		reverse(list, 0, k - 1);

		reverse(list, k, n - 1);

		reverse(list, 0, n - 1);
	}

	private static void reverse(List<Integer> list, int start, int end) {
		while (start < end) {
			Integer temp = list.get(start);
			list.set(start, list.get(end));
			list.set(end, temp);
			start++;
			end--;
		}
	}
}