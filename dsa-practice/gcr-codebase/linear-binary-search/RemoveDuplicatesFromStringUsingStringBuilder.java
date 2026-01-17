package linear_binary_search;

import java.util.*;

public class RemoveDuplicatesFromStringUsingStringBuilder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter input: ");
		String input = sc.nextLine();
		StringBuilder uniqueCharString = new StringBuilder("");

		HashSet<Character> set = new HashSet<Character>();

		for (char ch : input.toCharArray()) {
			if (!set.contains(ch)) {
				uniqueCharString.append(ch);
				set.add(ch);
			}
		}

		System.out.println("String After Removing Duplicates From String Using StringBuilder: " + uniqueCharString);

		sc.close();
	}
}
