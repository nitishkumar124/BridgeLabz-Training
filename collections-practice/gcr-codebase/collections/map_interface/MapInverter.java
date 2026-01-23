package collections.map_interface;

import java.util.*;

public class MapInverter {

	public static void main(String[] args) {
		Map<String, Integer> input = new HashMap<>();
		input.put("A", 1);
		input.put("B", 2);
		input.put("C", 1);
		input.put("D", 3);
		input.put("E", 2);

		System.out.println("Original Map: " + input);

		Map<Integer, List<String>> invertedMap = invertMap(input);

		System.out.println("Inverted Map: " + invertedMap);
	}

	public static <K, V> Map<V, List<K>> invertMap(Map<K, V> source) {
		Map<V, List<K>> target = new HashMap<>();

		for (Map.Entry<K, V> entry : source.entrySet()) {
			V newKey = entry.getValue();
			K newValue = entry.getKey();

			target.computeIfAbsent(newKey, k -> new ArrayList<>()).add(newValue);
		}

		return target;
	}
}