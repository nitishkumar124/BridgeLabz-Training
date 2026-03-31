package collections.list_interface;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class DuplicateRemover {

	public static void main(String[] args) {
		List<Integer> input = new ArrayList<>(List.of(3, 1, 2, 2, 3, 4));

		System.out.println("Original List: " + input);
		List<Integer> result = removeDuplicates(input);
		System.out.println("After Removing Duplicates: " + result);
	}

	public static <T> List<T> removeDuplicates(List<T> list) {

		Set<T> set = new LinkedHashSet<>(list);

		return new ArrayList<>(set);
	}
}