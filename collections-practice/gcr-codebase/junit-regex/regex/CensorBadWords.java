package regex;

public class CensorBadWords {
	public static void main(String[] args) {
		String input = "This is a damn bad example with some stupid words.";
        String regex = "\\b(damn|stupid)\\b";

        String output = input.replaceAll(regex, "****");

        System.out.println(output);
	}
}
