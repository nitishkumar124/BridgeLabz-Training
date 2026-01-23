package collections.map_interface;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MaxValueFinder {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("A", 10);
		map.put("B", 20);
		map.put("C", 15);

		String result = findMaxKey(map);

		System.out.println("Map: " + map);
		System.out.println("Key with highest value: " + result);
	}

	public static <K, V extends Comparable<V>> K findMaxKey(Map<K, V> map) {
		if (map == null || map.isEmpty()) {
			return null;
		}

		Map.Entry<K, V> maxEntry = null;

		for (Map.Entry<K, V> entry : map.entrySet()) {

			if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
				maxEntry = entry;
			}
		}

		return maxEntry.getKey();
	}
}