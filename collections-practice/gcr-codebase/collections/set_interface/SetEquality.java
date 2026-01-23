package collections.set_interface;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class SetEquality {

	public static void main(String[] args) {
		Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
		Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 2, 1));
		Set<Integer> set3 = new HashSet<>(Arrays.asList(1, 2, 4));

		System.out.println("Set1: " + set1);
		System.out.println("Set2: " + set2);
		System.out.println("Set1 equals Set2? " + areSetsEqual(set1, set2)); // true
		System.out.println("Set1 equals Set3? " + areSetsEqual(set1, set3)); // false
	}

	public static <T> boolean areSetsEqual(Set<T> set1, Set<T> set2) {
		if (set1 == null || set2 == null) {
			return set1 == set2;
		}
		return set1.equals(set2);
	}
}