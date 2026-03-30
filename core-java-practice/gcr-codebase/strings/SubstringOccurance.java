package extras;
import java.util.*;
public class SubstringOccurance {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter string: ");
		String str = sc.nextLine();
		System.out.print("Enter sub-string: ");
		String subStr = sc.nextLine();
		
		int count = 0;
		
		for (int i = 0; i < str.length() - subStr.length(); i++) {
			if (str.substring(i, i+ subStr.length()).equals(subStr)) {
				count++;
			}
		}
		
		System.out.println("occurances count : " + count);

		sc.close();
	}
}

