package regex;
import java.util.regex.Pattern;
public class UsernameValidation {
	public static void main(String[] args) {
		String userName = "user_123";
		String regex = "^[A-Za-z][A-Za-z0-9_]{4,14}&";
		
		if(Pattern.matches(regex, userName)) {
			System.out.println("Valid Username");
		}else {
			System.out.println("Invalid Username");
		}
	}
}
