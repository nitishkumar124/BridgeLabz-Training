package collections.set_interface;

import java.util.*;

public class SetToListSorter {

	public static void main(String[] args) {
		Set<Integer> inputSet = new HashSet<>(Set.of(5, 3, 9, 1));

		System.out.println("Original Set: " + inputSet);

		List<Integer> sortedList = convertAndSort(inputSet);
		System.out.println("Sorted List:  " + sortedList);
	}

	public static <T extends Comparable<? super T>> List<T> convertAndSort(Set<T> set) {

		List<T> list = new ArrayList<>(set);

		Collections.sort(list);

		return list;
	}
}