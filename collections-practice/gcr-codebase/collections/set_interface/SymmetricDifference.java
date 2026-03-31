package collections.set_interface;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class SymmetricDifference {

	public static void main(String[] args) {
		Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
		Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

		System.out.println("Set 1: " + set1);
		System.out.println("Set 2: " + set2);

		Set<Integer> result = findSymmetricDifference(set1, set2);
		System.out.println("Symmetric Difference: " + result);
	}

	public static <T> Set<T> findSymmetricDifference(Set<T> s1, Set<T> s2) {

		Set<T> leftUnique = new HashSet<>(s1);
		leftUnique.removeAll(s2);

		Set<T> rightUnique = new HashSet<>(s2);
		rightUnique.removeAll(s1);

		leftUnique.addAll(rightUnique);

		return leftUnique;
	}
}