package regex;
import java.util.regex.*;

public class ExtractCurrency {
    public static void main(String[] args) {

        String text = "The price is $45.99, and the discount is 10.50.";
        String regex = "\\$?\\d+(\\.\\d{2})?";

        Matcher matcher = Pattern.compile(regex).matcher(text);

        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
    }
}

