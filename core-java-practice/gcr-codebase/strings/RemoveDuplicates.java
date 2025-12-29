package extras;
import java.util.*;
public class RemoveDuplicates {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the string: ");
		String s = sc.nextLine();
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			if (!result.contains(String.valueOf(s.charAt(i)))) {
				result += s.charAt(i);
			}
		}
		
		System.out.println("Resultant String without duplicates : " + result);

		sc.close();
	}
}

