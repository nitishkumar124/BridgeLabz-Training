package collections.queue_interface;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

public class BinaryGenerator {

	public static void main(String[] args) {
		int n = 5;
		List<String> result = generateBinary(n);

		System.out.println("First " + n + " binary numbers:");
		System.out.println(result);
	}

	public static List<String> generateBinary(int n) {
		List<String> output = new ArrayList<>();
		if (n <= 0)
			return output;

		Queue<String> queue = new LinkedList<>();

		queue.add("1");

		for (int i = 0; i < n; i++) {

			String current = queue.remove();
			output.add(current);

			String s1 = current + "0";
			String s2 = current + "1";

			queue.add(s1);
			queue.add(s2);
		}

		return output;
	}
}