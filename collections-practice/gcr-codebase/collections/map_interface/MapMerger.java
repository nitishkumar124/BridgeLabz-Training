package collections.map_interface;

import java.util.HashMap;
import java.util.Map;

public class MapMerger {

	public static void main(String[] args) {
		Map<String, Integer> map1 = new HashMap<>(Map.of("A", 1, "B", 2));
		Map<String, Integer> map2 = Map.of("B", 3, "C", 4);

		System.out.println("Map 1: " + map1);
		System.out.println("Map 2: " + map2);

		Map<String, Integer> mergedMap = mergeAndSum(map1, map2);

		System.out.println("Merged Map: " + mergedMap);
	}

	public static Map<String, Integer> mergeAndSum(Map<String, Integer> m1, Map<String, Integer> m2) {
		// Create a result map based on the first map
		Map<String, Integer> result = new HashMap<>(m1);

		m2.forEach((key, value) -> result.merge(key, value, (existingVal, newVal) -> existingVal + newVal));

		return result;
	}
}