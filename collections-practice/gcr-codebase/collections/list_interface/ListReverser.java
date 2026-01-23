package collections.list_interface;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListReverser {

	public static void main(String[] args) {

		List<Integer> arrayList = new ArrayList<>(List.of(1, 2, 3, 4, 5));
		System.out.println("Original ArrayList:  " + arrayList);
		reverseArrayList(arrayList);
		System.out.println("Reversed ArrayList:  " + arrayList);

		System.out.println("---");

		LinkedList<Integer> linkedList = new LinkedList<>(List.of(10, 20, 30, 40, 50));
		System.out.println("Original LinkedList: " + linkedList);
		reverseLinkedList(linkedList);
		System.out.println("Reversed LinkedList: " + linkedList);
	}

	public static <T> void reverseArrayList(List<T> list) {
		int left = 0;
		int right = list.size() - 1;

		while (left < right) {
			T temp = list.get(left);
			list.set(left, list.get(right));
			list.set(right, temp);
			left++;
			right--;
		}
	}

	public static <T> void reverseLinkedList(LinkedList<T> list) {
		ListIterator<T> forward = list.listIterator();
		ListIterator<T> backward = list.listIterator(list.size());

		for (int i = 0; i < list.size() / 2; i++) {
			T leftVal = forward.next();
			T rightVal = backward.previous();

			forward.set(rightVal);
			backward.set(leftVal);
		}
	}
}