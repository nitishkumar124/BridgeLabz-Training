package collections.list_interface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyCounter {

	public static void main(String[] args) {
		List<String> input = List.of("apple", "banana", "apple", "orange", "banana", "apple");

		Map<String, Integer> frequencyMap = getFrequencyMap(input);

		System.out.println("Input List: " + input);
		System.out.println("Frequency Map: " + frequencyMap);
	}

	public static Map<String, Integer> getFrequencyMap(List<String> list) {
		Map<String, Integer> counts = new HashMap<>();

		for (String item : list) {
			counts.put(item, counts.getOrDefault(item, 0) + 1);
		}

		return counts;
	}
}