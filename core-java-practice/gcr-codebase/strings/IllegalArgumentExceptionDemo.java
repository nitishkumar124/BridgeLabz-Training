package level1;
import java.util.*;
public class IllegalArgumentExceptionDemo {

	static void generateException(String str) {
		String s = str.substring(3, 0);
	}
	
	static void handleException(String str) {
		try {
			generateException(str);
		} catch (IllegalArgumentException e) {
			System.out.println("exception handleled");
		} catch (RuntimeException  e) {
			System.out.println("exception handled using generic runtime exception");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("string : ");
		String text = sc.next();
		
		handleException(text);

	}

}
