package linear_binary_search;

import java.util.*;

public class ConcatenateStringsEfficientlyUsingStringBuffer {

	public static void main(String[] args) {
		String[] strings = { "Himanshu", " from", " Bareilly." };
		StringBuffer address = new StringBuffer("");
		for (String string : strings) {
			address.append(string);
		}
		System.out.println("Concatenated strings: " + address);
		
	}
}
