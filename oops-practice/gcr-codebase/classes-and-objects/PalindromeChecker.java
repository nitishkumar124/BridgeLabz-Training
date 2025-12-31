package level2;
import java.util.*;
public class PalindromeChecker {
	
	String text;
	
	public PalindromeChecker(String text) {
		this.text = text;
	}
	
	void isPalindrome() {
		String s = this.text;
		boolean palindrome_status = true;
		int start = 0, end = s.length() - 1;
		while (start <= end) {
			if (s.charAt(start) != s.charAt(end)) palindrome_status = false;
			start++;
			end--;
		}
		if (palindrome_status) {
			System.out.println("Palindrome.");
		} else {
			System.out.println("NOT Palindrome.");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter some text: ");
		String text = sc.nextLine();
		
		PalindromeChecker p = new PalindromeChecker(text);
		p.isPalindrome();

		sc.close();
	}
}

