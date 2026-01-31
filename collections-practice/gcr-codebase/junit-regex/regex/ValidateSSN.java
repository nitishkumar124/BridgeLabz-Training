package regex;
import java.util.regex.Pattern;

public class ValidateSSN {
    public static void main(String[] args) {

        String ssn = "123-45-6789";
        String regex = "^\\d{3}-\\d{2}-\\d{4}$";

        System.out.println(Pattern.matches(regex, ssn) ? "Valid SSN" : "Invalid SSN");
    }
}

