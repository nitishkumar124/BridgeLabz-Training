package level1;

import java.util.*;

public class NumberFormatExceptionDemo {
	static void handleException(String str) {
		
		try {
			int num = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			System.out.println("exception handled");
		} catch (RuntimeException e) {
			System.out.println("exception handled using generic runtime error");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("string : ");
		String text = sc.next();
		handleException(text);
	}
}
