package regex;
import java.util.regex.*;

public class FindRepeatingWords {
    public static void main(String[] args) {

        String text = "This is is a repeated repeated word test.";
        String regex = "\\b(\\w+)\\s+\\1\\b";

        Matcher matcher = Pattern.compile(regex).matcher(text);

        while (matcher.find()) {
            System.out.print(matcher.group(1) + " ");
        }
    }
}

