package regex;
import java.util.regex.Pattern;

public class HexColorValidation {
    public static void main(String[] args) {

        String colorCode = "#FFA500";
        String regex = "^#[0-9A-Fa-f]{6}$";

        if (Pattern.matches(regex, colorCode)) {
            System.out.println("Valid Hex Color Code");
        } else {
            System.out.println("Invalid Hex Color Code");
        }
    }
}

