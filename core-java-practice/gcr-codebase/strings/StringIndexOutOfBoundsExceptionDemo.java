package level1;
import java.util.*;
public class StringIndexOutOfBoundsExceptionDemo {

	static void generateException(String str) {
		str.charAt(500);
	}
	
	static void handleException(String str) {
		try {
			generateException(str);
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("exception handleled");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("string : ");
		String text = sc.next();
		
		handleException(text);

	}

}
