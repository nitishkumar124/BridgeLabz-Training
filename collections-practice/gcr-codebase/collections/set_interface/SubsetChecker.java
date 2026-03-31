package collections.set_interface;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class SubsetChecker {

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> set3 = new HashSet<>(Arrays.asList(2, 5));

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);

		System.out.println("Is Set1 a subset of Set2? " + isSubset(set1, set2)); // true

        System.out.println("Is Set3 a subset of Set2? " + isSubset(set3, set2)); // false
    }

    public static <T> boolean isSubset(Set<T> potentialSubset, Set<T> fullSet) {
        if (potentialSubset == null || fullSet == null) {
            return false;
        }
        
        
        return fullSet.containsAll(potentialSubset);
    }
}