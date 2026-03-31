package stream_api;

import java.util.*;

public class CustomerNameProcessor {

	public static void main(String[] args) {

		List<String> customers = Arrays.asList("Rahul", "anita", "Vikram", "sneha", "Karan");

		customers.stream().map(String::toUpperCase).sorted().forEach(System.out::println);
	}
}
