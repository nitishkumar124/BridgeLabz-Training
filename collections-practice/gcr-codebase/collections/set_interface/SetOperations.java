package collections.set_interface;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class SetOperations {

	public static void main(String[] args) {
		Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
		Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

		System.out.println("Set 1: " + set1);
		System.out.println("Set 2: " + set2);

		System.out.println("Union: " + findUnion(set1, set2));
		System.out.println("Intersection: " + findIntersection(set1, set2));
	}

	public static <T> Set<T> findUnion(Set<T> s1, Set<T> s2) {
		Set<T> union = new HashSet<>(s1);
		union.addAll(s2);
		return union;
	}

	public static <T> Set<T> findIntersection(Set<T> s1, Set<T> s2) {
		Set<T> intersection = new HashSet<>(s1);
		intersection.retainAll(s2);
		return intersection;
	}
}