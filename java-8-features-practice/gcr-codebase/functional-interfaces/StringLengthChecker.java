package functional_interfaces;
import java.util.function.Function;
public class StringLengthChecker {
	public static void main(String[] args) {
		Function<String, Integer> length = s -> s.length();
		System.out.println(length.apply("Hello World"));
	}
}
